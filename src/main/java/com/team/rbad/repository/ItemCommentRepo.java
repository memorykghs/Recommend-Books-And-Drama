package com.team.rbad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.team.rbad.entity.ItemComment;
import com.team.rbad.entity.ItemCommentPK;

@Repository
public interface ItemCommentRepo extends JpaRepository<ItemComment, ItemCommentPK>{

}
