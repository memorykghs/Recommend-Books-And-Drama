package com.team.rbad.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.team.rbad.entity.AuthorInfo;

@Repository
public interface AuthorInfoRepo extends JpaRepository<AuthorInfo, String>{
    
    /** 依作者名稱查詢 */
    Optional<AuthorInfo> findByAuthorName(String authorName);
}
