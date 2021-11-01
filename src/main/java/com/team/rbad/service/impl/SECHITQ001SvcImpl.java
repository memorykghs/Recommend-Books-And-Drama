package com.team.rbad.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.team.rbad.base.TranRequest;
import com.team.rbad.base.TranResponse;
import com.team.rbad.dto.SECHITQ001Tranrq;
import com.team.rbad.dto.SECHITQ001Tranrs;
import com.team.rbad.dto.SECHITQ001TranrsItemList;
import com.team.rbad.entity.SearchItemInfo;
import com.team.rbad.service.SECHITQ001Svc;
import com.team.rbad.util.TranResponseFactory;

/**
 * SECHITQ001列表查詢
 * @author lijiachi
 */
@Service
public class SECHITQ001SvcImpl implements SECHITQ001Svc {

	/** TranResponseFactory */
	@Autowired
	private TranResponseFactory tranResponseFactory;

	/** EntityManager */
	@PersistenceContext
	private EntityManager em;

	@Autowired
	private ObjectMapper mapper;

	@SuppressWarnings("unchecked")
	@Override
	public TranResponse<SECHITQ001Tranrs> searchItemList(TranRequest<SECHITQ001Tranrq> request) {

		SECHITQ001Tranrq tranrq = request.getReqData();

		Map<String, Object> args = new HashMap<>();
		StringBuilder sqlSb = new StringBuilder("SELECT IT.* ,AU.AUTHOR_NAME ,count(IT.ITEM_ID) OVER () as COUNT "
				+ "FROM ITEM_INFO IT  " + "LEFT JOIN AUTHOR_INFO AU ON IT.AUTHOR_ID = AU.AUTHOR_ID  "
				+ "LEFT JOIN TYPE_INFO TY ON IT.TYPE = TY.TYPE_ID  "
				+ "LEFT JOIN CATEGORY_INFO CA ON IT.CATEGORY = CA.CATEGORY_ID  "
				+ "LEFT JOIN ITEM_TAG TA ON IT.ITEM_ID = TA.ITEM_ID  "+ "where 1 = 1 ");

		if (StringUtils.isNotBlank(tranrq.getItemName())) {
			sqlSb.append(" and IT.ITEM_NAME like :ITEM_NAME "); // ITEM_NAME
			args.put("ITEM_NAME", "%" + tranrq.getItemName() + "%");
		}

		if (StringUtils.isNotBlank(tranrq.getAuthorName())) {
			sqlSb.append("and AU.AUTHOR_NAME like :AUTHOR_NAME "); // AUTHOR_NAME
			args.put("AUTHOR_NAME", "%" + tranrq.getAuthorName() + "%");
		}

		if (StringUtils.isNotBlank(tranrq.getCategory())) {
			sqlSb.append(" and IT.CATEGORY = :CATEGORY_ID "); // CATEGORY_ID
			args.put("CATEGORY_ID", tranrq.getCategory());
		}

		if (StringUtils.isNotBlank(tranrq.getRecommend())) {
			sqlSb.append(" and RE.RECOMMEND > :RECOMMEND "); // RECOMMEND
			args.put("RECOMMEND", Float.valueOf(tranrq.getRecommend()));
		}

		if (StringUtils.isNotBlank(tranrq.getType())) {
			sqlSb.append(" and IT.TYPE = :TYPE "); // TYPE
			args.put("TYPE", tranrq.getType());
		}

		List<String> tagList = tranrq.getTagList().stream().filter(x -> !x.isEmpty()).collect(Collectors.toList());
		if (tagList.size() > 0) {
			sqlSb.append(" and TA.TAG_ID in (:TAG_ID) "); // TAG_ID
			args.put("TAG_ID", tagList);
		}

		sqlSb.append("group by IT.ITEM_ID");
		Query query = em.createNativeQuery(sqlSb.toString(), SearchItemInfo.class);

		// 分頁
		query.setFirstResult((tranrq.getPageNumber() - 1) * tranrq.getPageSize());
		query.setMaxResults(tranrq.getPageSize());

		for (Entry<String, Object> entry : args.entrySet()) {
			query = query.setParameter(entry.getKey(), entry.getValue());
		}

		List<SearchItemInfo> queryList = query.getResultList();
		List<SECHITQ001TranrsItemList> itemInfoList = queryList.stream()
				.map(res -> mapper.convertValue(res, SECHITQ001TranrsItemList.class)).collect(Collectors.toList());

		SECHITQ001Tranrs tranrs = new SECHITQ001Tranrs();
		tranrs.setCount(queryList.get(0).getCount());
		tranrs.setItemList(itemInfoList);
		return tranResponseFactory.genSucessResponse(tranrs);
	}

}