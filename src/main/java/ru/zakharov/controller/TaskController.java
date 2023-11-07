package ru.zakharov.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.zakharov.domain.Filter;
import ru.zakharov.domain.Task;
import ru.zakharov.service.TaskService;

import java.util.Objects;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class TaskController {

    private final TaskService service;

    @GetMapping
    public String getHomePage(Model model){
        return getPage(new Filter(1, 5, "id", "asc"), model);
    }

    @PostMapping
    public String create(@ModelAttribute Filter filter,
                         @ModelAttribute Task newTask,
                         Model model){
        service.create(newTask);
        return pageModel(filter, model);
    }
    @PostMapping("/update")
    public String update(@ModelAttribute Filter filter,
                         @ModelAttribute Task task,
                         Model model){
        service.update(task);
        return pageModel(filter, model);
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute Filter filter,
                         @RequestParam Long id,
                         Model model){
        service.delete(Objects.requireNonNull(id));
        return pageModel(filter, model);
    }
    @GetMapping("/page")
    public String getPage(@ModelAttribute Filter filter,
                          Model model){
        return pageModel(filter, model);
    }


    public String pageModel(@ModelAttribute Filter filter,
                          Model model){
        Page<Task> page = service.findPaginated(filter);
        model.addAttribute("filter", filter);
        model.addAttribute("page", page);
        model.addAttribute("newTask", new Task());
        model.addAttribute("expand", filter.sortDirection().equalsIgnoreCase("DESC") ?
                "ASC" : "DESC");
        return "index";
    }
}
