package com.company.demo.config;

import com.company.demo.model.TodoValidator;

@configuration
public class TodoConfig {

    /**
     * Tạo ra Bean TodoValidator để sử dụng sau này
     * @return
     */
    @Bean
    public TodoValidator validator() {
        return new TodoValidator();
    }
}