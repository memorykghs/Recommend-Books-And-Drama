package com.team.rbad.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.team.rbad.entity.TypeInfo;

@Repository
public interface TypeInfoRepo extends JpaRepository<TypeInfo, String>{

    /** 依類別名稱模糊查詢 */
    Optional<TypeInfo> findByNameContaining(String place);
}
