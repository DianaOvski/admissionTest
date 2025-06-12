package com.sprint3.admission_test.application.ports.out;

import com.sprint3.admission_test.domain.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ICategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findByName(String name);
}
