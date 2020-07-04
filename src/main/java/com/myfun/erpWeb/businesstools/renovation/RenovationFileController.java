package com.myfun.erpWeb.businesstools.renovation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.framework.session.Operator;
import com.myfun.framework.utils.CommonUtil;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.erpdb.dao.ErpRenovationCustomerFileMapper;
import com.myfun.repository.erpdb.dao.ErpRenovationCustomerTrackMapper;
import com.myfun.repository.erpdb.dto.ErpRenovationCustomerFileDto;
import com.myfun.repository.erpdb.po.ErpRenovationCustomerFile;
import com.myfun.repository.erpdb.po.ErpRenovationCustomerFileExample;
import com.myfun.repository.erpdb.po.ErpRenovationCustomerTrack;
import com.myfun.service.business.erpdb.ErpRenovationFileService;
import com.myfun.utils.StringUtil;

/**
 * 装修客户相关附件操作
 * @author 张宏利
 * @since 2018年2月26日
 */
@RestController
@RequestMapping("/renovation")
public class RenovationFileController extends BaseController{

	@Autowired
	private ErpRenovationCustomerFileMapper erpRenovationCustomerFileMapper;
	@Autowired
	private ErpRenovationCustomerTrackMapper erpRenovationCustomerTrackMapper;
	@Autowired
	private ErpRenovationFileService erpRenovationFileService;
	/**
	 * 保存装修客户附件资料
	 * @author 张宏利
	 * @since 2018年2月26日
	 * @param param
	 * @return
	 */
	@RequestMapping("/addRenovationFile")
	public ResponseJson addRenovationFile(@RequestBody BaseMapParam param) {
		Operator operator = getOperator();
		Integer compId = operator.getCompId();
		Integer userId = operator.getUserId();
		Integer cityId = operator.getCityId();
		Integer archiveId = operator.getArchiveId();
		String userName = operator.getUserName();
		String custPhotos = param.getString("custPhotos");
		String otherPhotos = param.getString("otherPhotos");
		Integer renovationCustomerId = param.getInteger("id");
		erpRenovationFileService.addRenovationFile(cityId, compId, userId, archiveId, renovationCustomerId, custPhotos, otherPhotos, userName);
		return ErpResponseJson.ok();
	}
	
	/**
	 * 删除装修客户附件资料
	 * @author 张宏利
	 * @since 2018年2月26日
	 * @param param
	 * @return
	 */
	@RequestMapping("/deleteRenovationFile")
	public ResponseJson deleteRenovationFile(@RequestBody BaseMapParam param) {
		Operator operator = getOperator();
		Integer id = param.getInteger("id"); // 装修客户主键Id
		String custPhotos = param.getString("custPhotos"); // 客户资料
		String otherPhotos = param.getString("otherPhotos"); // 其他资料
		deleteFileByUrl(operator.getCityId(), operator.getCompId(), id, 1, custPhotos, operator.getUserId(), operator.getArchiveId(), operator.getUserName());
		deleteFileByUrl(operator.getCityId(), operator.getCompId(), id, 2, otherPhotos, operator.getUserId(), operator.getArchiveId(), operator.getUserName());
		return ErpResponseJson.ok();
	}
	
	private void deleteFileByUrl(Integer cityId, Integer compId, Integer id, Integer fileType, String fileStr, Integer userId, Integer archiveId, String userName){
		if(StringUtil.isBlank(fileStr)){
			return;
		}
		String[] fileArr = fileStr.split(";");
		List<String> fileList = new ArrayList<>();
		for(String fileUrl:fileArr){
			if(StringUtil.isNotBlank(fileUrl)){
				fileList.add(fileUrl);
			}
		}
		ErpRenovationCustomerFile erpRenovationCustomerFile = new ErpRenovationCustomerFile();
		erpRenovationCustomerFile.setIsDel(1);
		erpRenovationCustomerFile.setShardCityId(cityId);
		ErpRenovationCustomerFileExample exmaple = new ErpRenovationCustomerFileExample();
		exmaple.createCriteria().andCompIdEqualTo(compId).andFileTypeEqualTo(fileType).andFileAddrIn(fileList).andRenovationCustomerIdEqualTo(id);
		exmaple.setShardCityId(cityId);
		erpRenovationCustomerFileMapper.updateByExampleSelective(erpRenovationCustomerFile, exmaple);
		
		String tempStr = null;
		if(fileType == 1){
			tempStr = "客户资料";
		}else if(fileType == 2){
			tempStr = "其他资料";
		}
		String trackContent = userName + "删除了" + fileList.size() + "张" + tempStr;
		ErpRenovationCustomerTrack erpRenovationCustomerTrack = new ErpRenovationCustomerTrack();
		erpRenovationCustomerTrack.setRenovationCustomerId(id);
		erpRenovationCustomerTrack.setCompId(compId);
		erpRenovationCustomerTrack.setUserId(userId);
		erpRenovationCustomerTrack.setArchiveId(archiveId);
		erpRenovationCustomerTrack.setCreationTime(new Date());
		erpRenovationCustomerTrack.setShardCityId(cityId);
		erpRenovationCustomerTrack.setTrackContent(trackContent);
		erpRenovationCustomerTrack.setTrackType((byte)0);
		erpRenovationCustomerTrackMapper.insertSelective(erpRenovationCustomerTrack);
		
	}
	
	/**
	 * 获取装修客户附件资料列表
	 * @author 张宏利
	 * @since 2018年2月26日
	 * @param param
	 * @return
	 */
	@RequestMapping("/getRenovationFileList")
	public ResponseJson getRenovationFileList(@RequestBody BaseMapParam param) {
		Operator operator = getOperator();
		Integer renovationCustomerId = param.getInteger("id");
		List<ErpRenovationCustomerFileDto> dtoList = erpRenovationCustomerFileMapper.getFileList(operator.getCityId(), operator.getCompId(), renovationCustomerId);
		if(null != dtoList && dtoList.size() > 0){
			for(ErpRenovationCustomerFileDto result:dtoList){
				result.setOnlineUrl(CommonUtil.getPhotoUrl(result.getFileAddr()));
			}
		}
		return ErpResponseJson.ok(dtoList);
	}
	
}


