// Tầng Repository, chịu trách nhiệm giao tiếp với Database. Chúng ta sử dụng Spring JPA.
package com.company.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.demo.model.Todo;

@Repository
public interface TodoReponsitory extends JpaRepository<Todo, Long>{

    
}