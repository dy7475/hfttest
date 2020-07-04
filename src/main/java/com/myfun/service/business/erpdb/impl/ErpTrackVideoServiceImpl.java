package com.myfun.service.business.erpdb.impl;


import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myfun.repository.erpdb.dao.ErpTrackVideoMapper;
import com.myfun.repository.erpdb.po.ErpTrackVideo;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpTrackVideoService;

@Service
public class ErpTrackVideoServiceImpl extends AbstractService<ErpTrackVideo, ErpTrackVideo> implements ErpTrackVideoService{
	@Autowired ErpTrackVideoMapper erpTrackVideoMapper;
	@Override
	public void setBaseMapper() {
		// TODO Auto-generated method stub
		
	}
	
	/***
	 * 添加视频
	 */
	@Override
	public void addTrackVideos(Integer cityId, Integer targetId, String videoUrl, Integer caseId, Integer caseType, Integer trackId, Integer userId, String videoLocation, String videoTimes) {
		if (StringUtils.isBlank(videoUrl)) {
			return;
		}
		ErpTrackVideo erpTrackVideo = new ErpTrackVideo();
		erpTrackVideo.setShardCityId(cityId);
		erpTrackVideo.setCaseId(caseId);
		erpTrackVideo.setCaseType(caseType.byteValue());
		erpTrackVideo.setHouseId(targetId);
		erpTrackVideo.setTrackId(trackId);
		erpTrackVideo.setVideoAddr(videoUrl);
		erpTrackVideo.setUploadUser(userId);
		erpTrackVideo.setUploadDate(new Date());
		erpTrackVideo.setVideoStatus(0);
		erpTrackVideo.setLocations(videoLocation);
		erpTrackVideo.setVideoShootingTime(videoTimes);
		erpTrackVideoMapper.insertSelective(erpTrackVideo);
	}
	
}
