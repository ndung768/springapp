package com.company.demo.model;

import java.util.Optional;

import org.thymeleaf.util.StringUtils;

public class TodoValidator {
    /**
     * Kiểm tra một object Todo có hợp lệ không
     * @param todo
     * @return
     */

     public boolean isValid(Todo todo) {
         return Optional.ofNullable(todo)
                        .filter(t -> !StringUtils.isEmpty(t.getTitle())) // Kiểm tra title khác rỗng
                        .filter(t -> !StringUtils.isEmpty(t.getDetail())) // kiem tra detail khac rong
                        .isPresent(); // Tra ve true neu hop le, nguoc lai false
     }
}