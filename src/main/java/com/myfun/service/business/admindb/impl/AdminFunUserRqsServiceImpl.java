package com.myfun.service.business.admindb.impl;

import com.alibaba.fastjson.JSONObject;
import com.myfun.erpWeb.usercenter.param.NameAuthenticationParam;
import com.myfun.erpWeb.usercenter.param.QualificationCertificationParam;
import com.myfun.framework.exception.BusinessException;
import com.myfun.repository.admindb.dao.*;
import com.myfun.repository.admindb.po.*;
import com.myfun.repository.erpdb.dao.ErpFunLeaseMapper;
import com.myfun.repository.erpdb.dao.ErpFunSaleMapper;
import com.myfun.repository.erpdb.dao.ErpFunUsersMapper;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.admindb.AdminFunPaidService;
import com.myfun.service.business.admindb.AdminFunUserRqsService;
import com.myfun.utils.DateTimeHelper;
import com.myfun.utils.KafkaBizUtils;
import com.myfun.utils.StringUtil;
import com.myfun.utils.rest.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.Date;

/**
 * @author czq
 * @since 2018/12/30
 */
@Service
public class AdminFunUserRqsServiceImpl extends AbstractService<AdminFunUserRqs, Integer> implements AdminFunUserRqsService {

    @Autowired
    private AdminFunUserRqsMapper adminFunUserRqsMapper;
    @Autowired
    private AdminFunArchiveMapper adminFunArchiveMapper;
    @Autowired
    private AdminFunPaidMapper adminFunPaidMapper;
    @Autowired
    private AdminFunUserAccountMapper adminFunUserAccountMapper;
    @Autowired
    private AdminFunPaidService adminFunPaidService;
    @Autowired
    private AdminSysParaMapper adminSysParaMapper;
    @Autowired
    private AdminAppLoginMapper adminAppLoginMapper;
    @Autowired
    private ErpFunUsersMapper erpFunUsersMapper;

    @Override
    @PostConstruct
    public void setBaseMapper() {
        super.baseMapper = adminFunUserRqsMapper;
    }

    @Override
    @Transactional
    public void updateQualificationCertification(QualificationCertificationParam param) {
        Integer archiveId = param.getArchiveId();
        AdminFunUserRqs record = new AdminFunUserRqs();
        record.setRqsAptitudeStatus(100);
        record.setRqsAptitudeTime(new Date());
        record.setArchiveId(archiveId);
        // 查看用户认证请求状态
        AdminFunUserRqs selectByPrimaryKey = adminFunUserRqsMapper.selectByPrimaryKey(archiveId);
        if (selectByPrimaryKey != null) {
            adminFunUserRqsMapper.updateByPrimaryKeySelective(record);
        } else {
            adminFunUserRqsMapper.insertSelective(record);
        }
        AdminFunArchive adminFunArchive = new AdminFunArchive();
        adminFunArchive.setCardPhoto(param.getCardPhoto());
        adminFunArchive.setShopInnerPhoto(param.getShopInnerPhoto());
        adminFunArchive.setShopOuterPhoto(param.getShopOuterPhoto());
        adminFunArchive.setArchiveId(archiveId);
        // 更新用户名片图片,商铺内景图,商铺外景图
        adminFunArchiveMapper.updateByPrimaryKeySelective(adminFunArchive);
    }

    @Override
    @Transactional
    public void updateMyNameAuthentication(NameAuthenticationParam param) {

            Byte userSex = null;
            Integer num = null;
            String iccode = param.getUserIccode();
            Integer archiveId = param.getArchiveId();
            if (iccode.length() == 18) {
                // 第17位是性别，单数是男，双数是女
                num = Integer.parseInt(iccode.substring(16, 17));
            } else {
                // 第15位是性别
                num = Integer.parseInt(iccode.substring(14, 15));
            }
            if (num % 2 == 0) {
                userSex = 0;
            } else {
                userSex = 1;
            }
            AdminFunArchive adminFunArchive = new AdminFunArchive();
            adminFunArchive.setArchiveId(archiveId);
            adminFunArchive.setUserIccode(iccode);
            adminFunArchive.setUserSex(userSex);
            adminFunArchive.setUserName(param.getUserName());
            String icPhoto = param.getIcPhoto();
            if(StringUtil.isNotBlank(icPhoto)){
                adminFunArchive.setIcPhoto1(param.getIcPhoto());
            }else{
                throw new BusinessException("您上传的照片有误，请重新上传");
            }
            adminFunArchive.setUserPhoto(param.getUserPhoto());
            adminFunArchive.setCompName(param.getCompName());
            if("0".equals(param.getArtificial())){//人脸识别
                adminFunArchive.setUserRight(1);
                if(!param.isPersonalVersion()){
                    adminFunArchive.setUserHonest(1);
                }

                // 赠送优优抢单条数
                Integer giftYyhfQiangdanNum = StringUtil.parseInteger(adminSysParaMapper.getAdminSysParas("GIFT_YYHF_QIANGDAN_NUM"));
                AdminAppLogin adminAppLogin = new AdminAppLogin();
                adminAppLogin.setArchiveId(param.getArchiveId());
                adminAppLogin.setYyhfQiangdanNum(giftYyhfQiangdanNum);
                adminAppLoginMapper.updateByPrimaryKeySelective(adminAppLogin);

                AdminFunUserRqs record = new AdminFunUserRqs();
                record.setArchiveId(archiveId);
                record.setUserName(param.getUserName());
                record.setUserIccode(iccode);
                record.setCompName(param.getCompName());
                record.setRqsActualStatus(1);
                record.setRqsActualTime(DateTimeHelper.getSystemDate());
                record.setRqsActualDesc("使用人脸识别程序");
                record.setActualSellId(param.getSellId());
                if(!param.isPersonalVersion()){
                    record.setRqsAptitudeStatus(1);
                    record.setRqsAptitudeTime(DateTimeHelper.getSystemDate());
                    record.setRqsAptitudeDesc("使用人脸识别程序");
                }
                record.setProcessBy("-10");//参考数据库表字段描述，代表采用人脸识别功能自动实名认证
                Integer count = adminFunUserRqsMapper.getCountByPrimaryKey(archiveId);
                if(count == 0){
                    adminFunUserRqsMapper.insertSelective(record);//这里只能采用写入规则
                }else{
                    adminFunUserRqsMapper.updateByPrimaryKeySelective(record);
                }
            }else{//人工审核
                adminFunArchive.setUserRight(0);
                String realNamePhoto = param.getRealNamePhoto();
                if(StringUtil.isNotBlank(realNamePhoto)){
                    adminFunArchive.setRealNamePhoto(realNamePhoto);
                }else{
                    throw new BusinessException("您上传的照片有误，请重新上传");
                }
                AdminFunUserRqs record=new AdminFunUserRqs();
                record.setRqsActualStatus(100);
                record.setRqsActualTime(new Date());
                record.setArchiveId(param.getArchiveId());
                record.setCompName(param.getCompName());
                Integer count=adminFunUserRqsMapper.getCountByPrimaryKey(archiveId);
                if (count == 0) {
                    adminFunUserRqsMapper.insertSelective(record);
                } else {
                    adminFunUserRqsMapper.updateByPrimaryKeySelective(record);
                }
            }
            ErpFunUsers oldUserPo = erpFunUsersMapper.getValidUserByArchiveId(param.getArchiveId());
            ErpFunUsers erpFunUsers = new ErpFunUsers();
            erpFunUsers.setShardCityId(oldUserPo.getCityId().intValue());
            erpFunUsers.setUserId(oldUserPo.getUserId());
            erpFunUsers.setUserName(param.getUserName());
            if(userSex == 1){
                erpFunUsers.setUserSex(true);
            }else{
                erpFunUsers.setUserSex(false);
            }
            erpFunUsersMapper.updateByPrimaryKeySelective(erpFunUsers);
            adminFunArchiveMapper.updateByPrimaryKeySelective(adminFunArchive);
            if("0".equals(param.getArtificial())){
                //赠送好房豆
                this.giftQuan(archiveId);
                //赠送奖励金
                this.giftShareMoney(archiveId);
            }
        }
    /**
     * 赠送好房豆和奖励金
     * @author 尹振兴
     * @since 2018年3月31日
     * @param archiveId
     */
    private void giftQuan(Integer archiveId){
        AdminFunArchive adminFunArchive = adminFunArchiveMapper.selectByPrimaryKey(archiveId);
        if(adminFunArchive.getUaId() == null){
            return;
        }
        Date nowDate = new Date();
        AdminFunPaidExample coAdminFunPaidExample = new AdminFunPaidExample();
        coAdminFunPaidExample.createCriteria().andPaidTypeEqualTo("DVALID_COIN").andCardnoEqualTo("valid4" + adminFunArchive.getUaId());
        if (adminFunPaidMapper.countByExample(coAdminFunPaidExample) < 1) {
            String effectiveTime = adminSysParaMapper.selectParamVlue("EFFECTIVE_TIME");
            AdminFunUserAccount adminFunUserAccount = adminFunUserAccountMapper.selectByPrimaryKey(adminFunArchive.getUaId());
            adminFunUserAccountMapper.updateHaoFangAmount(adminFunArchive.getUaId());
            //赠送好房豆
            AdminFunPaid inFunPaid = new AdminFunPaid();
            inFunPaid.setUaId(adminFunArchive.getUaId());
            inFunPaid.setArchiveId(adminFunArchive.getArchiveId());
            inFunPaid.setCityId(adminFunArchive.getCityId());
            inFunPaid.setPaidCatigory("GIFT");
            inFunPaid.setPaidType("DVALID_COIN");
            inFunPaid.setCardno("valid4" + adminFunArchive.getUaId());
            inFunPaid.setAmount((double) 10);
            inFunPaid.setAmountCoin((double) 10);
            inFunPaid.setAmountAfter(adminFunUserAccount.getAmount().doubleValue() + 10);
            inFunPaid.setAmountBefore(adminFunUserAccount.getAmount().doubleValue());
            inFunPaid.setPadiTime(new Date());
            String cionStr = "恭喜！您已通过实名，活动期间已赠送您10好房豆(好房豆有效期至:"
                    + DateUtil.DateToString(DateUtil.addDay(nowDate, StringUtil.parseInteger(effectiveTime))) + "，到期自动清零)。";
            inFunPaid.setDesc(cionStr);
            adminFunPaidMapper.insertSelective(inFunPaid);
        }
    }
    
    @Transactional
    @Override
    public void giftShareMoney(Integer archiveId) {
        AdminFunArchive adminFunArchive = adminFunArchiveMapper.selectByPrimaryKey(archiveId);
        if(adminFunArchive.getUaId() == null){
            return;
        }

        AdminFunPaidExample adminFunPaidExample = new AdminFunPaidExample();
        adminFunPaidExample.createCriteria().andPaidTypeEqualTo("BROKER_RIGHT_PRIZE").andCardnoEqualTo("valid4" + adminFunArchive.getUaId());

        if (adminFunPaidMapper.countByExample(adminFunPaidExample) < 1) {
            AdminFunUserAccount adminFunUserAccount = adminFunUserAccountMapper.selectByPrimaryKey(adminFunArchive.getUaId());
            adminFunUserAccountMapper.updateShareMoney(adminFunArchive.getUaId());

            //赠送奖励金
            AdminFunPaid shareMoneyPaid = new AdminFunPaid();
            shareMoneyPaid.setUaId(adminFunArchive.getUaId());
            shareMoneyPaid.setArchiveId(adminFunArchive.getArchiveId());
            shareMoneyPaid.setCityId(adminFunArchive.getCityId());
            shareMoneyPaid.setPaidCatigory("GIFT");
            shareMoneyPaid.setPaidType("BROKER_RIGHT_PRIZE");
            shareMoneyPaid.setCardno("valid4" + adminFunArchive.getUaId());
            shareMoneyPaid.setAmount((double) 10);
            shareMoneyPaid.setAmountShareMoney((double) 10);
            shareMoneyPaid.setAmountShareMoneyAfter(adminFunUserAccount.getShareMoney().doubleValue() + 10);
            shareMoneyPaid.setPadiTime(new Date());
            shareMoneyPaid.setDesc("成功完成实名认证，平台送您10元现金");
            adminFunPaidMapper.insertSelective(shareMoneyPaid);

            //推送消息
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("templateId", "11");
            jsonObject.put("title", "成功实名认证获10元现金");
            jsonObject.put("receiver", adminFunArchive.getArchiveId());
            jsonObject.put("content", "恭喜成功完成实名认证，平台送您10元现金，赶紧参与分享真房源活动，每分享1位好友获10元现金，可直接在个人中心提现哦！");
            KafkaBizUtils.pushMsgByTemplate(jsonObject);

        }
        //实名奖励
        adminFunPaidService.peopleSaleGiftUserRight(archiveId);
    }
}
