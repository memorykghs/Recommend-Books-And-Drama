package com.team.rbad.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.team.rbad.entity.ItemInfo;

@Repository
public interface ItemInfoRepo extends JpaRepository<ItemInfo, String>{

	/** 查詢更新時間最新2筆 */
	List<ItemInfo> findTop2ByOrderByUpdTimeDesc();
	
	List<ItemInfo> findAll();
}
