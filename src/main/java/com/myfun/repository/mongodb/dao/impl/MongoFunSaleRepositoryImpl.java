package com.myfun.repository.mongodb.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.myfun.repository.mongodb.dao.MongoFunSaleRepository;
import com.myfun.repository.mongodb.param.EsfListParam;
import com.myfun.repository.mongodb.po.MongoFunLeaseBean;
import com.myfun.repository.mongodb.po.MongoFunSaleBean;
import com.myfun.repository.mongodb.support.repository.BaseMongoRepository;
import com.myfun.repository.mongodb.support.repository.MongoPageRequest;
import com.myfun.repository.support.constant.Const;
import com.myfun.utils.StringUtil;

@Repository
public class MongoFunSaleRepositoryImpl extends BaseMongoRepository<MongoFunSaleBean, String>
		implements MongoFunSaleRepository {
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}

	@Override
	public List<MongoFunSaleBean> getEsfList(EsfListParam esfListParam) {
		MongoPageRequest pageable = new MongoPageRequest(esfListParam.getPageNum(), esfListParam.getPageSize());
		Query query = new Query();
		query.with(pageable);

		/** 排序 1 价格升序 2 价格降序 3 面积升序 4 面积降序 **/
		if (esfListParam.getOrder() != null) {
			if (esfListParam.getOrder() == 1) {
				query.with(new Sort(Direction.ASC, "saleTotalPrice"));
			} else if (esfListParam.getOrder() == 2) {
				query.with(new Sort(Direction.DESC, "saleTotalPrice"));
			} else if (esfListParam.getOrder() == 3) {
				query.with(new Sort(Direction.ASC, "saleArea"));
			} else if (esfListParam.getOrder() == 4) {
				query.with(new Sort(Direction.DESC, "saleArea"));
			}
		} else {
			Order hasPanorama = new Order(Direction.DESC, "hasPanorama");
			Order trueFlag = new Order(Direction.DESC, "trueFlag");
			Order hasVideo = new Order(Direction.DESC, "hasVideo");
			Order trackTime = new Order(Direction.DESC, "trackTime");
			query.with(new Sort(hasPanorama, trueFlag, hasVideo, trackTime));
		}

		query.addCriteria(Criteria.where("saleStatus").is(1));
		query.addCriteria(Criteria.where("salePublish").is(true));
		if (esfListParam.getCityId() != null) {
			query.addCriteria(Criteria.where("cityId").is(esfListParam.getCityId()));
		}
		if (esfListParam.getArchiveId() != null) {
			query.addCriteria(Criteria.where("archiveId").is(esfListParam.getArchiveId()));
		}
		if (esfListParam.getArea() != null) {
			String[] areaArray = esfListParam.getArea().split("-");
			if (areaArray.length > 1) {
				query.addCriteria(Criteria.where("saleArea").mod(StringUtil.parseDouble(areaArray[0]),
						StringUtil.parseDouble(areaArray[1])));
			}
		}
		if (esfListParam.getBuildId() != null) {
			query.addCriteria(Criteria.where("buildId").is(esfListParam.getBuildId()));
		}
		if (esfListParam.getDirect() != null) {
			query.addCriteria(Criteria.where("saleDirect").is(esfListParam.getDirect()));
		}
		if (esfListParam.getFitment() != null) {
			query.addCriteria(Criteria.where("saleFitment").is(esfListParam.getFitment()));
		}
		if (esfListParam.getHasVideo() != null) {
			query.addCriteria(Criteria.where("hasVideo").is(esfListParam.getHasVideo()));
		}
		if (esfListParam.getRealAuth() != null) {
			query.addCriteria(Criteria.where("trueFlag").is(esfListParam.getRealAuth()));
		}
		if (esfListParam.getRegionId() != null) {
			query.addCriteria(Criteria.where("saleReg").is(esfListParam.getRegionId()));
		}
		if (esfListParam.getResource() != null) {
			query.addCriteria(Criteria.where("resource").in(esfListParam.getResource()));
		} else {
			query.addCriteria(Criteria.where("resource").is(1));
		}
		if (esfListParam.getRoom() != null) {
			String[] roomArray = esfListParam.getRoom().split("-");
			if (roomArray.length > 1) {
				query.addCriteria(Criteria.where("saleRoom").mod(StringUtil.parseInteger(roomArray[0]),
						StringUtil.parseInteger(roomArray[1])));
			}
		}
		if (esfListParam.getSectionId() != null) {
			query.addCriteria(Criteria.where("sectionId").is(esfListParam.getSectionId()));
		}
		if (esfListParam.getTotalPrice() != null) {
			String[] totalPriceArray = esfListParam.getTotalPrice().split("-");
			if (totalPriceArray.length > 0) {
				query.addCriteria(Criteria.where("saleTotalPrice").mod(StringUtil.parseInteger(totalPriceArray[0]),
						StringUtil.parseInteger(totalPriceArray[1])));
			}
		}
		if (esfListParam.getUseage() != null) {
			query.addCriteria(Criteria.where("saleUseage").is(esfListParam.getUseage()));
		}
		System.out.println(query);
		return super.findPage(query);
	}

	@Override
	public void deleteList(Date date) {
	}

}
