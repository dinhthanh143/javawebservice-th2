package com.example.project_base_spring_mvc.controller;

import com.example.project_base_spring_mvc.model.entity.TaskItem;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    private final List<TaskItem> taskList = new ArrayList<>();

    public TaskController() {
        taskList.add(new TaskItem("T001", "Hoan thanh bai tap MVC", LocalDate.now().plusDays(2), "HIGH"));
        taskList.add(new TaskItem("T002", "Chuan bi slide bao cao", LocalDate.now().plusDays(4), "MEDIUM"));
        taskList.add(new TaskItem("T003", "On tap validation", LocalDate.now().plusDays(1), "LOW"));
    }

    @GetMapping
    public String showTaskList(Model model) {
        model.addAttribute("tasks", taskList);
        return "task-list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("taskItem", new TaskItem());
        return "task-form";
    }

    @PostMapping
    public String createTask(@Valid @ModelAttribute("taskItem") TaskItem taskItem,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "task-form";
        }

        if (taskItem.getId() == null || taskItem.getId().isBlank()) {
            taskItem.setId("T" + UUID.randomUUID().toString().substring(0, 6).toUpperCase());
        }

        taskList.add(taskItem);
        return "redirect:/tasks";
    }
}
