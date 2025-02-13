package com.example.todo.controller.task;

import com.example.todo.service.task.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
//import org.slf4j.Logger; // 問題なしのため、コメントアウト
//import org.slf4j.LoggerFactory; // 問題なしのため、コメントアウト

@Controller
@RequiredArgsConstructor
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;
//    private static final Logger logger = LoggerFactory.getLogger(TaskController.class); // デバッグ確認用

    @GetMapping
    public String list(TaskSearchForm searchForm, Model model) {
        var taskList = taskService.find(searchForm.toEntity()) // List<TaskEntity> -> List<TaskDTO>
                .stream()
                .map(TaskDTO::toDTO)
                .toList();
            model.addAttribute("taskList", taskList);
            model.addAttribute("searchDTO", searchForm.toDTO());
        return "tasks/list";
    }

//    // セクション6-46 パスが〜〜/tasks/detail固定なら問題なく表示できる
//    @GetMapping("/tasks/detail") // GET /tasks/detail
//    public String showDetail() {
//        return "tasks/detail";
//    }

    @GetMapping("/{id}") // GET /tasks/2
    public String showDetail(@PathVariable("id") long taskId, Model model) {
//        logger.info("Received taskId: {}", taskId); // デバッグ用
        model.addAttribute("taskId", taskId);
        // taskId -> TaskEntity
        var taskDTO = taskService.findById(taskId)
                .map(TaskDTO::toDTO)
                .orElseThrow(TaskNotFoundException::new);
        model.addAttribute("task", taskDTO);
        return "tasks/detail";
    }

    // GET /tasks/creationForm
    @GetMapping("/creationForm")
    public String showCreationForm(@ModelAttribute TaskForm form, Model model) {
        model.addAttribute("mode", "CREATE");
        return "tasks/form";
    }

    // POST /tasks
    @PostMapping
    public String create(@Validated TaskForm form, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return showCreationForm(form, model);
        }
        taskService.create(form.toEntity());
        return "redirect:/tasks";
    }

    // GET /tasks/{taskId}/editForm
    @GetMapping("/{id}/editForm")
    public String showEditForm(@PathVariable("id") long id, Model model) {
        var form = taskService.findById(id)
                .map(TaskForm::fromEntity)
                .orElseThrow(TaskNotFoundException::new);
        model.addAttribute("taskForm", form);
        model.addAttribute("mode", "EDIT");
        return "tasks/form";
    }

    @PutMapping("{id}") // PUT /tasks/{id}
    public String update(
            @PathVariable("id") long id,
            @Validated @ModelAttribute TaskForm form,
            BindingResult bindingResult,
            Model model
    ) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("mode", "EDIT");
            return "tasks/form";
        }
        var entity = form.toEntity(id);
        taskService.update(entity);
        return "redirect:/tasks/{id}";
    }

//    POST /tasks/1 (hidden: _method: delete)
//    -> DELETE /tasks/1
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id) {
        taskService.delete(id);
        return "redirect:/tasks";
    }
}
