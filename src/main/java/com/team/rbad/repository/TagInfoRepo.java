package com.team.rbad.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.team.rbad.entity.TagInfo;

@Repository
public interface TagInfoRepo extends JpaRepository<TagInfo, String>{

    /** 依標籤名稱查詢 */
    Optional<TagInfo> findByName(String tag);
    
    /** 查詢所有不重複標籤 */
    List<TagInfo> findAllByDistinct();
}
