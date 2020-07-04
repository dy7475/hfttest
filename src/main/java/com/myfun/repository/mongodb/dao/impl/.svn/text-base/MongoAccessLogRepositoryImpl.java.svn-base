package com.myfun.repository.mongodb.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.myfun.repository.mongodb.dao.MongoAccessLogRepository;
import com.myfun.repository.mongodb.param.AccessLogParam;
import com.myfun.repository.mongodb.po.MongoAccessLogBean;
import com.myfun.repository.mongodb.support.repository.BaseMongoRepository;
import com.myfun.repository.mongodb.support.repository.MongoPageRequest;
import com.myfun.utils.StringUtil;

@Repository
public class MongoAccessLogRepositoryImpl extends BaseMongoRepository<MongoAccessLogBean, String>
		implements MongoAccessLogRepository {
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}

	@Override
	public List<MongoAccessLogBean> getAccessLogList(AccessLogParam param) {
		MongoPageRequest pageable = new MongoPageRequest(param.getPageNum(), param.getPageSize());
		Query query = new Query();
		query.with(pageable);
		query.with(new Sort(Direction.DESC, "createTime"));
		
		if (param.getIsError() != null) {
			query.addCriteria(Criteria.where("isError").is(param.getIsError()));
		}
		if (param.getProject() != null) {
			query.addCriteria(Criteria.where("project").is(param.getProject()));
		}
		if (StringUtil.isNotEmpty(param.getSessionId())) {
			query.addCriteria(Criteria.where("sessionId").is(param.getSessionId()));
		}
		if (StringUtil.isNotEmpty(param.getIfaceName())) {
			query.addCriteria(Criteria.where("ifaceName").is(param.getIfaceName()));
		}
		return super.findPage(query);
	}

}
