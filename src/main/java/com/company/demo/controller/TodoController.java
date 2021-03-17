// Tầng Controller, nơi đón nhận các request từ phía người dùng, và chuyển tiếp xử lý xuống tầng Service.
package com.company.demo.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

import com.company.demo.model.TodoService;

@Controller
public class TodoController {

    @Autowired
    private TodoService todoService;

    /*
        @RequestParam dùng để đánh dấu một biến là request param trong request gửi lên server.
        Nó sẽ gán dữ liệu của param-name tương ứng vào biến
    */
    @GetMapping("/listTodo")
    public String index(Model model, @RequestParam(value = "limit", required = false) Integer limit){
        // Tra ve doi tuong todoList.
        model.addAttribute("todoList", todoService.findAll(limit));
        // Tra ve template "listTodo.html"
        return "listTodo";
    }

    @GetMapping("/addTodo")
    public String addTodo(Model model) {
        model.addAttribute("todo", new Todo());
        return "addTodo";

    }

    /*
        @ModelAttribute đánh dấu đối tượng Todo được gửi lên bởi Form Request
    */
    @PostMapping("/addTodo")
    public String addTodo(@ModelAttribute Todo todo) {
        return Optional.ofNullable(todoService.add(todo))
                    .map(t -> "success") // Tra ve success neu save thanh cong
                    .orElse("failed");   // Tra ve failed neu khong thanh cong
    }


}