// Tầng Service, chị trách nhiệm thực hiện các xử lý logic, business, hỗ trợ cho tầng Controller.
package com.company.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.PageRequest;

import java.util.Optional;
import java.util.List;

import com.company.demo.model.TodoValidator;
import com.company.demo.model.Todo;
import com.company.demo.repository.TodoRepository;

@Service 
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private TodoValidator validator;

     /**
     * Lấy ra danh sách List<Todo>
     *
     * @param limit - Giới hạn số lượng lấy ra
     *
     * @return Trả về danh sách List<Todo> dựa theo limit, nếu limit == null thì trả findAll()
     */

     public List<Todo> findAll(Integer limit) {
         return Optional.ofNullable(limit)
                        .map(value -> todoRepository.findAll(PageRequest.of(0, value)).getContent())
                        .orElseGet(() -> todoRepository.findAll());
     }

     /**
     * Thêm một Todo mới vào danh sách công việc cần làm
     *
     * @return Trả về đối tượng Todo sau khi lưu vào DB, trả về null nếu không thành công
     */

     public Todo add(Todo todo){
         if(validator.isValid(todo)){
             return todoRepository.save(todo);
         }
         return null;
     }
}
