package com.buianhdo.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buianhdo.server.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity,Long> {
    CategoryEntity findOneByCode(String code);
}
