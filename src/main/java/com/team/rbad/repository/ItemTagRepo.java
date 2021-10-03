package com.team.rbad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.team.rbad.entity.ItemTag;
import com.team.rbad.entity.ItemTagPK;

@Repository
public interface ItemTagRepo extends JpaRepository<ItemTag, ItemTagPK>{

}
