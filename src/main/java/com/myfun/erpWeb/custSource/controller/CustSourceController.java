package com.myfun.erpWeb.custSource.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.erpWeb.custSource.api.CustSourceApi;
import com.myfun.erpWeb.custSource.param.*;
import com.myfun.erpWeb.custSource.vo.CustSourceEditVO;
import com.myfun.erpWeb.custSource.vo.CustSourceListVO;
import com.myfun.erpWeb.custSource.vo.GetCodeVO;
import com.myfun.erpWeb.custSource.vo.GetOneCustSoureVO;
import com.myfun.framework.exception.BusinessException;
import com.myfun.framework.session.Operator;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.erpdb.dao.ErpDicDefinitionsMapper;
import com.myfun.repository.erpdb.dao.ErpFunCustSourceMapper;
import com.myfun.repository.erpdb.po.ErpDicDefinitions;
import com.myfun.repository.erpdb.po.ErpDicDefinitionsExample;
import com.myfun.repository.erpdb.po.ErpFunCustSource;
import com.myfun.repository.erpdb.po.ErpFunCustSourceExample;
import com.myfun.utils.DateUtil;
import com.myfun.utils.Pinyin4jUtil;
import com.myfun.utils.StringUtil;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class CustSourceController extends BaseController implements CustSourceApi {
    @Resource
    ErpFunCustSourceMapper erpFunCustSourceMapper;
    @Resource
    ErpDicDefinitionsMapper erpDicDefinitionsMapper;
    @Override
    public ResponseJson custSourceAdd(@RequestBody CustSourceAddParam custSourceAddParam) throws Exception {
        Operator operator = getOperator();
        Integer cityId = operator.getCityId();
        Integer userId = operator.getUserId();
        Integer compId = operator.getCompId();
        ErpFunCustSourceExample example = new ErpFunCustSourceExample();
        example.setShardCityId(cityId);
        example.createCriteria().andSourceNameEqualTo(custSourceAddParam.getSourceName()).andDelStatusEqualTo(Byte.valueOf("0"));
        Integer custSourceCount = erpFunCustSourceMapper.countByExample(example);
        if (custSourceCount>0) {
        	throw new BusinessException("来源名称重复,不可再提交!");
        }
        example = new ErpFunCustSourceExample();
        example.setShardCityId(cityId);
        example.createCriteria().andDelStatusEqualTo(Byte.valueOf("0"));
        custSourceCount = erpFunCustSourceMapper.countByExample(example);
        if (custSourceCount>=100) {
        	throw new BusinessException("有效来源不可超过100个!");
        }
        ErpFunCustSource source = new ErpFunCustSource();
        BeanUtils.copyProperties(custSourceAddParam, source);
        source.setCreatedTime(new Date());
        source.setDelStatus((byte)0);// 没删除
        source.setCompId(compId);
        source.setCreatedUserId(userId);
        source.setUpdatedTime(new Date());
        source.setUpdatedUserId(userId+"");
        source.setShardCityId(cityId);
        erpFunCustSourceMapper.insertSelective(source);
        Integer custSourceId = source.getCustSourceId();

        // 维护字典的客源来源
        ErpDicDefinitions erpDicDefinitions = new ErpDicDefinitions();
        erpDicDefinitions.setShardCityId(cityId);
        erpDicDefinitions.setDicGroupType("SYSTEM");
        erpDicDefinitions.setDicType("CUST_SOURCE");
        erpDicDefinitions.setProvinceId((short)0);
        erpDicDefinitions.setCityId((short)0);
        erpDicDefinitions.setSeqNo(Byte.valueOf(custSourceId+""));
        erpDicDefinitions.setDicValue(custSourceId+"");
        erpDicDefinitions.setDicValue1("SYSTEM");
        erpDicDefinitions.setDicEnMsg(custSourceId+"");
        erpDicDefinitions.setDicCnMsg(source.getSourceName());
        erpDicDefinitions.setUpdateTime(DateUtil.DateToString(new Date(), DateUtil.DateStyle.YYYY_MM_DD_HH_MM_SS));
        erpDicDefinitions.setIsDel(source.getForbidStatus());
        erpDicDefinitionsMapper.insertSelective(erpDicDefinitions);
        return ErpResponseJson.ok();
    }

    @Override
    public ResponseJson custSourceEdit(@RequestBody CustSourceEditParam custSourceEditParam) throws Exception {
        Operator operator = getOperator();
        Integer cityId = operator.getCityId();
        Integer userId = operator.getUserId();
        //Integer compId = operator.getCompId();
        if (StringUtils.isNotBlank(custSourceEditParam.getSourceName())) {
        	ErpFunCustSourceExample example = new ErpFunCustSourceExample();
        	example.setShardCityId(cityId);
        	example.createCriteria().andSourceNameEqualTo(custSourceEditParam.getSourceName()).andDelStatusEqualTo(Byte.valueOf("0")).andCustSourceIdNotEqualTo(custSourceEditParam.getCustSourceId());
        	Integer custSourceCount = erpFunCustSourceMapper.countByExample(example);
        	if (custSourceCount>0) {
        		throw new BusinessException("来源名称重复!");
        	}
        }
        ErpFunCustSource source = new ErpFunCustSource();
        BeanUtils.copyProperties(custSourceEditParam,source);
        source.setShardCityId(cityId);
        source.setUpdatedUserId(userId+"");
        source.setUpdatedTime(new Date());
        erpFunCustSourceMapper.updateByPrimaryKeySelective(source);
        CustSourceEditVO vo = new CustSourceEditVO();
        ErpFunCustSource erpFunCustSource = erpFunCustSourceMapper.selectByPrimaryKey(source);
        BeanUtils.copyProperties(erpFunCustSource,vo);
        // 维护dic表
        ErpDicDefinitions erpDicDefinitions = new ErpDicDefinitions();
        erpDicDefinitions.setUpdateTime(DateUtil.DateToString(new Date(), DateUtil.DateStyle.YYYY_MM_DD_HH_MM_SS));
        erpDicDefinitions.setIsDel(source.getForbidStatus());
        erpDicDefinitions.setDicCnMsg(source.getSourceName());
        ErpDicDefinitionsExample erpDicDefinitionsExample = new ErpDicDefinitionsExample();
        erpDicDefinitionsExample.setShardCityId(cityId);
        erpDicDefinitionsExample.createCriteria().andDicTypeEqualTo("CUST_SOURCE").andDicValueEqualTo(source.getCustSourceId()+"");
        erpDicDefinitionsMapper.updateByExampleSelective(erpDicDefinitions,erpDicDefinitionsExample);
        return ErpResponseJson.ok(vo);
    }

    @Override
    public ResponseJson custSourceList(@RequestBody CustSourceListParam custSourceListParam) throws Exception {
        Operator operator = getOperator();
        Integer cityId = operator.getCityId();
        String keyWords = custSourceListParam.getKeyWords();
        ErpFunCustSourceExample erpFunCustSourceExample = new ErpFunCustSourceExample();
        erpFunCustSourceExample.setShardCityId(cityId);
        erpFunCustSourceExample.setOrderByClause(" (case WHEN SERIAL_NUMBER is null then 1000 else SERIAL_NUMBER end ),\n" +
                "  CREATED_TIME  asc,CUST_SOURCE_ID asc");
        ErpFunCustSourceExample.Criteria criteria1 = erpFunCustSourceExample.createCriteria();
        ErpFunCustSourceExample.Criteria criteria = erpFunCustSourceExample.createCriteria();
//        criteria.andCompIdEqualTo(compId);
//        criteria1.andCompIdEqualTo(compId);
        if(StringUtil.isNotEmpty(keyWords)){
            criteria1.andSourceNameLike("%"+keyWords+"%");
            criteria.andCodeLike("%"+keyWords+"%");
        }

        erpFunCustSourceExample.or(criteria);
        PageHelper.startPage(custSourceListParam.getPageOffset(),custSourceListParam.getPageRows());
        List<ErpFunCustSource> erpFunCustSources = erpFunCustSourceMapper.selectByExample(erpFunCustSourceExample);
        List<CustSourceListVO> vo = new ArrayList<>();
        if(erpFunCustSources!=null&&erpFunCustSources.size()!=0){
            for (ErpFunCustSource erpFunCustSource : erpFunCustSources) {
                CustSourceListVO custSourceListVO = new CustSourceListVO();
                org.springframework.beans.BeanUtils.copyProperties(erpFunCustSource,custSourceListVO);
                vo.add(custSourceListVO);
            }
        }
        PageInfo pageInfo = new PageInfo(erpFunCustSources);
        PageInfo pageInfo1 = new PageInfo(vo);
        pageInfo1.setTotal(pageInfo.getTotal());
        pageInfo1.setPageSize(pageInfo.getPageSize());
        pageInfo1.setPageNum(pageInfo.getPageNum());
        pageInfo1.setPages(pageInfo.getPages());
        return ErpResponseJson.ok(pageInfo1);
    }

    @Override
    public ResponseJson getCode(@RequestBody GetCodeParam getCodeParam) throws Exception {
        Operator operator = getOperator();
        String sourceName = getCodeParam.getSourceName();
        String repet = getNotRepetCode(operator, sourceName,0);
        GetCodeVO vo = new GetCodeVO();
        vo.setCode(repet);
        return ErpResponseJson.ok(vo);
    }

    @Override
    public ResponseJson getOneCustSoure(@RequestBody GetOneCustSoureParam getCodeParam) throws Exception {
        Operator operator = getOperator();
        Integer cityId = operator.getCityId();
        ErpFunCustSource erpFunCustSource = new ErpFunCustSource();
        erpFunCustSource.setShardCityId(cityId);
        erpFunCustSource.setCustSourceId(getCodeParam.getCustSourceId());
        ErpFunCustSource erpFunCustSource1 = erpFunCustSourceMapper.selectByPrimaryKey(erpFunCustSource);
        GetOneCustSoureVO vo = new GetOneCustSoureVO();
        BeanUtils.copyProperties(erpFunCustSource1,vo);
        return ErpResponseJson.ok(vo);
    }

    /**
     * 获取不重复的编码
     */

    public String getNotRepetCode(Operator operator,String sourceName,int count){

        Integer cityId = operator.getCityId();
        Integer compId = operator.getCompId();
        ErpFunCustSourceExample erpFunCustSourceExample = new ErpFunCustSourceExample();
        erpFunCustSourceExample.setShardCityId(cityId);
        String topPinyin = Pinyin4jUtil.converterToFirstSpell(sourceName);
        if(count>0){
            topPinyin=topPinyin+code[count-1];
        }
        erpFunCustSourceExample.createCriteria().andCodeEqualTo(topPinyin).andCompIdEqualTo(compId);
        List<ErpFunCustSource> erpFunCustSources = erpFunCustSourceMapper.selectByExample(erpFunCustSourceExample);
        if(erpFunCustSources!=null&&erpFunCustSources.size()>0){
            count++;
            return getNotRepetCode(operator,sourceName,count);

        }else {
           return topPinyin;
        }
    }
    String [] code ={"01","02","03","04","05","06","07","08","09","10",
                     "11","12","13","14","15","16","17","18","19","20",
                     "21","22","23","24","25","26","27","28","29","30",
                     "31","32","33","34","35","36","37","38","39","40",
                     "41","42","43","44","45","46","47","48","49","50",
    };
}
