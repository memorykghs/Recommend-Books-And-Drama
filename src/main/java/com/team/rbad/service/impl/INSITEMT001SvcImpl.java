package com.team.rbad.service.impl;

import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.team.rbad.base.TranRequest;
import com.team.rbad.base.TranResponse;
import com.team.rbad.dto.INSITEMT001Tranrq;
import com.team.rbad.dto.INSITEMT001TranrqTagInfo;
import com.team.rbad.dto.INSITEMT001Tranrs;
import com.team.rbad.entity.AuthorInfo;
import com.team.rbad.entity.ItemInfo;
import com.team.rbad.entity.ItemTag;
import com.team.rbad.entity.TagInfo;
import com.team.rbad.repository.AuthorInfoRepo;
import com.team.rbad.repository.ItemInfoRepo;
import com.team.rbad.repository.ItemTagRepo;
import com.team.rbad.repository.TagInfoRepo;
import com.team.rbad.service.INSITEMT001Svc;
import com.team.rbad.util.TranResponseFactory;

/**
 * RBADINSIT001 新增作品
 * @author memorykghs
 */
public class INSITEMT001SvcImpl implements INSITEMT001Svc {

	/** ItemInfoRepo */
	@Autowired
	private ItemInfoRepo itemInfoRepo;

	/** AuthorInfoRepo */
	@Autowired
	private AuthorInfoRepo authorInfoRepo;
	
	/** ItemTagRepo */
	@Autowired
	private ItemTagRepo itemTagRepo;
	
	/** TagInfoRepo */
	@Autowired
	private TagInfoRepo tagInfoRepo;
	
	/** TranResponseFactory */
	@Autowired
	private TranResponseFactory tranResponseFactory;
	
	/** ObjectMapper */
	@Autowired
	private ObjectMapper mapper;

	@Override
	public TranResponse<INSITEMT001Tranrs> insertItem(TranRequest<INSITEMT001Tranrq> req) {

		INSITEMT001Tranrq tranrq = req.getReqData();

		// 處理作者資訊
		String authorId = handleAuthorInfo(tranrq);
		
		// 處理 Tag 資訊
		Set<INSITEMT001TranrqTagInfo> tagSet = tranrq.getTagSet();
		tagSet.stream().forEach(tag -> {
			
			String tagId = tag.getTagId();
			if(StringUtils.isBlank(tagId)) {
				TagInfo tagInfo = new TagInfo();
				tagInfo.setName(tag.getTagName());
				tagInfoRepo.saveAndFlush(tagInfo);
				
				tagId = tagInfo.getTagId();
			}
			
			ItemTag itemTag = new ItemTag();
			itemTag.setTagId(tagId);
			itemTagRepo.save(itemTag);
		});

		// 處理作品資訊
		ItemInfo itemInfo = mapper.convertValue(tranrq, ItemInfo.class);
		itemInfo.setAuthorId(authorId);
		itemInfoRepo.saveAndFlush(itemInfo);
		
		return tranResponseFactory.genSucessResponse(new INSITEMT001Tranrs());
	}

	/**
	 * 處理作者資訊
	 * @param tranrq
	 * @return
	 */
	private String handleAuthorInfo(INSITEMT001Tranrq tranrq) {

		String authorId = tranrq.getAuthorId();
		if (StringUtils.isBlank(authorId)) {

			AuthorInfo authorInfo = new AuthorInfo();
			authorInfo.setAuthorName(tranrq.getAuthorName());
			authorInfoRepo.saveAndFlush(authorInfo);

			authorId = authorInfo.getAuthorId();
		}

		return authorId;
	}
}
