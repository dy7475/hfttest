package com.myfun.service.business.admindb;

import com.myfun.erpWeb.usercenter.param.NameAuthenticationParam;
import com.myfun.erpWeb.usercenter.param.QualificationCertificationParam;
import com.myfun.repository.admindb.po.AdminFunUserRqs;
import com.myfun.repository.support.mybatis.api.BaseMapper;

/**
 * @author czq
 * @since 2018/12/30
 */
public interface AdminFunUserRqsService extends BaseMapper<AdminFunUserRqs, Integer> {

    /**
     * 资质认证
     *
     * @author czq
     * @since 2017年12月30日
     * @param param QualificationCertificationParam
     */
    void updateQualificationCertification(QualificationCertificationParam param);

    /**
     *实名认证
     * @param  * @param param
     * @author 黄建海
     * @since 2018/12/30 0030
     */
    void updateMyNameAuthentication(NameAuthenticationParam param);

    /**
     *赠送奖励金
     * @param  * @param archiveId
     * @author 黄建海
     * @since 2018/12/30 0030
     */
    void giftShareMoney(Integer archiveId);

}
