package com.team.rbad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.team.rbad.entity.Recommend;
import com.team.rbad.entity.RecommendPK;

@Repository
public interface RecommendRepo extends JpaRepository<Recommend, RecommendPK>{

}
