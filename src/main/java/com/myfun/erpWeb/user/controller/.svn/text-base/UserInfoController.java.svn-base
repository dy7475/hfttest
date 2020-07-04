package com.myfun.erpWeb.user.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myfun.erpWeb.user.api.UserInfoApi;
import com.myfun.erpWeb.user.param.UploadUserPhotoParam;
import com.myfun.erpWeb.user.vo.UserInfoPhotoVO;
import com.myfun.framework.session.Operator;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.admindb.dao.AdminFunArchiveMapper;
import com.myfun.repository.admindb.po.AdminFunArchive;
import com.myfun.repository.erpdb.dao.ErpFunUsersMapper;
import com.myfun.repository.erpdb.po.ErpFunUsers;

@RestController
public class UserInfoController extends BaseController implements UserInfoApi{
	@Autowired	
	private ErpFunUsersMapper erpFunUsersMapper;
	@Autowired
	private AdminFunArchiveMapper adminFunArchiveMapper;

	@Override
	@Transactional
	public ResponseJson uploadUserHeadPic(@RequestBody UploadUserPhotoParam uploadUserPhotoParam) throws Exception {
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		byte photoType = uploadUserPhotoParam.getPhotoType();
		String photoAddr = uploadUserPhotoParam.getPhotoAddr();
		
		AdminFunArchive adminFunArchive = new AdminFunArchive(); 
		adminFunArchive.setArchiveId(operator.getArchiveId());
		if (photoType == 1) { // 身份证正面
			adminFunArchive.setUserPhoto(photoAddr);
		} else if (photoType == 2) { // 标准照片
			adminFunArchive.setIcPhoto1(photoAddr);
		} else if (photoType == 3) { // 名片
			adminFunArchive.setCardPhoto(photoAddr);
		} else if (photoType == 4) { // 店铺内景图
			adminFunArchive.setShopInnerPhoto(photoAddr);
		} else if (photoType == 5) { // 店铺外景图
			adminFunArchive.setShopOuterPhoto(photoAddr);
		} else if (photoType == 6) { // 论坛头像
			adminFunArchive.setBbsPhoto(photoAddr);
		}else if(photoType == 7){
			adminFunArchive.setUserPhotoMin(photoAddr);
		}
		adminFunArchiveMapper.updateByPrimaryKeySelective(adminFunArchive);
		if(photoType == 6 || photoType == 7){
			ErpFunUsers erpFunUsers = new ErpFunUsers();
			erpFunUsers.setCityId(Short.valueOf(cityId.toString()));
			erpFunUsers.setShardCityId(cityId);
			erpFunUsers.setUserId(operator.getUserId());
			erpFunUsers.setUserWriteoff(false);
			erpFunUsersMapper.updateByPrimaryKeySelective(erpFunUsers);
		}
		UserInfoPhotoVO userInfoPhotoVO = new UserInfoPhotoVO(); 
		userInfoPhotoVO.setPhotoAddr(photoAddr);
		userInfoPhotoVO.setPhotoId(1);
		return ErpResponseJson.ok(userInfoPhotoVO);
	}
}
