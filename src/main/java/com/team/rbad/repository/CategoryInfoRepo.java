package com.team.rbad.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.team.rbad.entity.CategoryInfo;

@Repository
public interface CategoryInfoRepo extends JpaRepository<CategoryInfo, String> {

    /** 依類別名稱查詢 */
    Optional<CategoryInfo> findByName(String category);

}
