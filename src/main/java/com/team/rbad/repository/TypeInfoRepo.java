package com.team.rbad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.team.rbad.entity.TypeInfo;

@Repository
public interface TypeInfoRepo extends JpaRepository<TypeInfo, String>{

}
