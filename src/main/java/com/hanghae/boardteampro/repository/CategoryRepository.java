package com.hanghae.boardteampro.repository;

import com.hanghae.boardteampro.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
