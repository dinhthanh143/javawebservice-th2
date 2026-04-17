package com.example.project_base_spring_mvc.model.entity;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

public class TaskItem {
    private String id;

    @NotBlank(message = "Ten cong viec khong duoc de trong")
    @Size(min = 5, message = "Ten cong viec phai co it nhat 5 ky tu")
    private String title;

    @NotNull(message = "Han hoan thanh la bat buoc")
    @Future(message = "Han hoan thanh phai la mot ngay trong tuong lai")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate deadline;

    @NotBlank(message = "Muc do uu tien la bat buoc")
    @Pattern(regexp = "HIGH|MEDIUM|LOW", message = "Muc do uu tien chi duoc la HIGH, MEDIUM hoac LOW")
    private String priority;

    public TaskItem() {
    }

    public TaskItem(String id, String title, LocalDate deadline, String priority) {
        this.id = id;
        this.title = title;
        this.deadline = deadline;
        this.priority = priority;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
}
