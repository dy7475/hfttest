package com.myfun.service.business.report.impl;

import com.myfun.framework.exception.BusinessException;
import com.myfun.repository.erpdb.dao.ErpFunCompMapper;
import com.myfun.repository.erpdb.dao.ErpFunOrganizationMapper;
import com.myfun.repository.erpdb.dao.ErpFunPartnerConfigMapper;
import com.myfun.repository.erpdb.dto.CheckPartnerConfigDto;
import com.myfun.repository.erpdb.dto.PartnerConfigDto;
import com.myfun.repository.erpdb.po.ErpFunComp;
import com.myfun.repository.erpdb.po.ErpFunOrganization;
import com.myfun.repository.erpdb.po.ErpFunPartnerConfig;
import com.myfun.repository.reportdb.dao.ReportFunBuyCustomerMinMapper;
import com.myfun.repository.reportdb.dao.ReportFunLeaseMinMapper;
import com.myfun.repository.reportdb.dao.ReportFunRentCustomerMinMapper;
import com.myfun.repository.reportdb.dao.ReportFunSaleMinMapper;
import com.myfun.repository.reportdb.po.*;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpFunPartnerConfigService;
import com.myfun.service.business.report.ReportFunSaleMinService;
import com.myfun.utils.DateTimeHelper;
import com.myfun.utils.StringUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ReportFunSaleMinServiceImpl extends AbstractService<ReportFunSaleMin, Long> implements ReportFunSaleMinService {
    @Autowired
    private ReportFunSaleMinMapper reportFunSaleMinMapper;
    @Autowired
    private ReportFunLeaseMinMapper reportFunLeaseMinMapper;
    @Autowired
    private ReportFunBuyCustomerMinMapper reportFunBuyCustomerMinMapper;
    @Autowired
    ReportFunRentCustomerMinMapper reportFunRentCustomerMinMapper;
    @Autowired
	private ErpFunPartnerConfigService erpFunPartnerConfigService;
    @Autowired
    private ErpFunCompMapper erpFunCompMapper;
    @Autowired
    private ErpFunOrganizationMapper erpFunOrganizationMapper;

    @Override
    @PostConstruct
    public void setBaseMapper() {
        super.baseMapper = reportFunSaleMinMapper;
    }

    /**
     * @author 邓永洪
     * @tag descType->1=修改运行模式，2=修改策略参数，3=数据移交，4=调店
     * @since 2018/4/24
     */
    @Override
	public void judgeOperatorTransferShop(String compNo, Integer cityId, Integer compId, String userIds, Integer descType, Integer caseType, Integer partnerId) {
		// 不限制的公司
		if ("AA01".equals(compNo) || "DZ70".equals(compNo)) {
			return;
		}
		String descTypeStr = null;
		switch (descType) {
		case 1:
			descTypeStr = "修改运行模式";
			break;
		case 2:
			descTypeStr = "修改策略参数";
			break;
		case 3:
			descTypeStr = "数据移交";
			break;
		case 4:
			descTypeStr = "调店";
			break;
		case 5:
			descTypeStr = "修改门店运营模式";
			break;
		case 6:
			descTypeStr = "调组织";
			break;
		default:
			throw new BusinessException("指定类型错误");
		}
		String descStr = "由于数据处理量太大，为了确保您公司业务正常进行，请晚上20点以后再进行" + descTypeStr + "操作！";
		// 判断当前时间是否>=8点
		Calendar calendar = Calendar.getInstance();
		Date nowDate = calendar.getTime();
		calendar.set(Calendar.HOUR_OF_DAY, 20);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		boolean isUserFlag = false;
		List<Integer> userIdList = Collections.emptyList();
		if (StringUtil.isNotBlank(userIds) && !"public".equalsIgnoreCase(userIds) && !"share".equalsIgnoreCase(userIds)) {
			userIdList = Stream.of(userIds.split(",")).map(String::trim).map(Integer::parseInt).collect(Collectors.toList());
			if (!userIdList.isEmpty()) {
				isUserFlag = true;
			}
		}

		if (DateTimeHelper.compareTwoDate(nowDate, calendar.getTime()) > 0) {
			// 查询房，客源，数量的情况
			if (caseType == null || Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType)) {
				ReportFunSaleMinExample reportFunSaleMinExample = new ReportFunSaleMinExample();
				ReportFunSaleMinExample.Criteria example = reportFunSaleMinExample.createCriteria();
				example.andCityIdEqualTo(cityId).andCompIdEqualTo(compId);

				if (isUserFlag) {
					example.andUserIdIn(userIdList);
				}
				int countSale = reportFunSaleMinMapper.countByExample(reportFunSaleMinExample);
				if (countSale >= 3000) {
					throw new BusinessException(descStr, "-1");
				}
			}
			if (caseType == null || Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)) {
				ReportFunLeaseMinExample reportFunLeaseMinExample = new ReportFunLeaseMinExample();
				ReportFunLeaseMinExample.Criteria example = reportFunLeaseMinExample.createCriteria();
				example.andCityIdEqualTo(cityId).andCompIdEqualTo(compId);

				if (isUserFlag) {
					example.andUserIdIn(userIdList);
				}
				int countLease = reportFunLeaseMinMapper.countByExample(reportFunLeaseMinExample);
				if (countLease >= 3000) {
					throw new BusinessException(descStr, "-1");
				}
			}
			if (caseType == null || Const.DIC_CASE_TYPE_BUY_CUST.equals(caseType)) {
				ReportFunBuyCustomerMinExample reportFunBuyCustomerMinExample = new ReportFunBuyCustomerMinExample();
				ReportFunBuyCustomerMinExample.Criteria example = reportFunBuyCustomerMinExample.createCriteria();
				example.andCityIdEqualTo(cityId).andCompIdEqualTo(compId);

				if (isUserFlag) {
					example.andUserIdIn(userIdList);
				}
				int countBuyCustomer = reportFunBuyCustomerMinMapper.countByExample(reportFunBuyCustomerMinExample);
				if (countBuyCustomer >= 3000) {
					throw new BusinessException(descStr, "-1");
				}
			}
			if (caseType == null || Const.DIC_CASE_TYPE_RENT_CUST.equals(caseType)) {
				ReportFunRentCustomerMinExample reportFunRentCustomerMinExample = new ReportFunRentCustomerMinExample();
				ReportFunRentCustomerMinExample.Criteria example = reportFunRentCustomerMinExample.createCriteria();
                example.andCityIdEqualTo(cityId).andCompIdEqualTo(compId);

				if (isUserFlag) {
					example.andUserIdIn(userIdList);
				}
				int countRentCustomer = reportFunRentCustomerMinMapper.countByExample(reportFunRentCustomerMinExample);
				if (countRentCustomer >= 3000) {
					throw new BusinessException(descStr, "-1");
				}
			}
		}
	}
    
    
    //新版组织机构调动，数据量判断
    
	public boolean judgeOperatorTransferShop(String compNo, Integer cityId, Integer compId, Integer oldOrgId, Integer partnerId) {
		//判断出售房源
		ReportFunSaleMinExample reportFunSaleMinExample = new ReportFunSaleMinExample();
		ReportFunSaleMinExample.Criteria example = reportFunSaleMinExample.createCriteria();
		if (partnerId!=null) {
			  // 加盟商看加盟商的, 总部门店和直营门店互看
			example.andCityIdEqualTo(cityId).andCompIdEqualTo(compId).andPartnerIdEqualTo(partnerId);
			if (oldOrgId!=null) {
				example.andTissueLineLike(":"+oldOrgId+":");
			}
		} else {
			example.andCityIdEqualTo(cityId).andCompIdEqualTo(compId);
			example.andTissueLineLike(":"+oldOrgId+":");
			// 没有开通加盟商或者房客源数据不隔离
		}
		int countSale = reportFunSaleMinMapper.countByExample(reportFunSaleMinExample);
		if (countSale >= 3000) {
			return false;
		}
		//判断出租房源
		ReportFunLeaseMinExample reportFunLeaseMinExample = new ReportFunLeaseMinExample();
		ReportFunLeaseMinExample.Criteria leaseExample = reportFunLeaseMinExample.createCriteria();
        if (partnerId!=null) {
            // 加盟商看加盟商的, 总部门店和直营门店互看
        	leaseExample.andCityIdEqualTo(cityId).andCompIdEqualTo(compId).andPartnerIdEqualTo(partnerId);
        	if (oldOrgId!=null) {
        		leaseExample.andTissueLineLike(":"+oldOrgId+":");
			}
        } else {
        	// 没有开通加盟商或者房客源数据不隔离
        	leaseExample.andCityIdEqualTo(cityId).andCompIdEqualTo(compId);
        	if (oldOrgId!=null) {
        		leaseExample.andTissueLineLike(":"+oldOrgId+":");
			}
        }

		int countLease = reportFunLeaseMinMapper.countByExample(reportFunLeaseMinExample);
		if (countLease >= 3000) {
			return false;
		}
		
		//判断求购房源
		ReportFunBuyCustomerMinExample reportFunBuyCustomerMinExample = new ReportFunBuyCustomerMinExample();
		ReportFunBuyCustomerMinExample.Criteria reportExample = reportFunBuyCustomerMinExample.createCriteria();
        if (partnerId!=null) {
            // 加盟商看加盟商的, 总部门店和直营门店互看
        	reportExample.andCityIdEqualTo(cityId).andCompIdEqualTo(compId).andPartnerIdEqualTo(partnerId);
        	if (oldOrgId!=null) {
        		reportExample.andTissueLineLike(":"+oldOrgId+":");
			}
        } else {
        	// 没有开通加盟商或者房客源数据不隔离
        	reportExample.andCityIdEqualTo(cityId).andCompIdEqualTo(compId);
        	if (oldOrgId!=null) {
        		reportExample.andTissueLineLike(":"+oldOrgId+":");
			}
        }
		int countBuyCustomer = reportFunBuyCustomerMinMapper.countByExample(reportFunBuyCustomerMinExample);
		if (countBuyCustomer >= 3000) {
			return false;
		}
		
		ReportFunRentCustomerMinExample reportFunRentCustomerMinExample = new ReportFunRentCustomerMinExample();
		ReportFunRentCustomerMinExample.Criteria rentExample = reportFunRentCustomerMinExample.createCriteria();
		if (partnerId!=null) {
            // 加盟商看加盟商的, 总部门店和直营门店互看
			rentExample.andCityIdEqualTo(cityId).andCompIdEqualTo(compId).andPartnerIdEqualTo(partnerId);
        	if (oldOrgId!=null) {
        		rentExample.andTissueLineLike(":"+oldOrgId+":");
			}
	    } else {
        	// 没有开通加盟商或者房客源数据不隔离
    		rentExample.andCityIdEqualTo(cityId).andCompIdEqualTo(compId);
        	if (oldOrgId!=null) {
        		rentExample.andTissueLineLike(":"+oldOrgId+":");
			}
	    }
		int countRentCustomer = reportFunRentCustomerMinMapper.countByExample(reportFunRentCustomerMinExample);
		if (countRentCustomer >= 3000) {
			return false;
		}
		return true;
	}

	@Override
	public boolean canMoveOrgNow(String compNo, Integer cityId, Integer compId, Integer oldOrgId, Integer partnerId) {
		//判断出售房源
		ReportFunSaleMinExample reportFunSaleMinExample = new ReportFunSaleMinExample();
		ReportFunSaleMinExample.Criteria example = reportFunSaleMinExample.createCriteria();
		if (partnerId!=null) {
			  // 加盟商看加盟商的, 总部门店和直营门店互看
			example.andCityIdEqualTo(cityId).andCompIdEqualTo(compId).andPartnerIdEqualTo(partnerId);
			if (oldOrgId!=null) {
				example.andTissueLineLike(":"+oldOrgId+":");
			}
		} else {
			example.andCityIdEqualTo(cityId).andCompIdEqualTo(compId);
			example.andTissueLineLike(":"+oldOrgId+":");
			// 没有开通加盟商或者房客源数据不隔离
		}
		int countSale = reportFunSaleMinMapper.countByExample(reportFunSaleMinExample);
		if (countSale >= 3000) {
			return false;
		}
		//判断出租房源
		ReportFunLeaseMinExample reportFunLeaseMinExample = new ReportFunLeaseMinExample();
		ReportFunLeaseMinExample.Criteria leaseExample = reportFunLeaseMinExample.createCriteria();
        if (partnerId!=null) {
            // 加盟商看加盟商的, 总部门店和直营门店互看
        	leaseExample.andCityIdEqualTo(cityId).andCompIdEqualTo(compId).andPartnerIdEqualTo(partnerId);
        	if (oldOrgId!=null) {
        		leaseExample.andTissueLineLike(":"+oldOrgId+":");
			}
        } else {
        	// 没有开通加盟商或者房客源数据不隔离
        	leaseExample.andCityIdEqualTo(cityId).andCompIdEqualTo(compId);
        	if (oldOrgId!=null) {
        		leaseExample.andTissueLineLike(":"+oldOrgId+":");
			}
        }

		int countLease = reportFunLeaseMinMapper.countByExample(reportFunLeaseMinExample);
		if (countLease >= 3000) {
			return false;
		}
		
		//判断求购房源
		ReportFunBuyCustomerMinExample reportFunBuyCustomerMinExample = new ReportFunBuyCustomerMinExample();
		ReportFunBuyCustomerMinExample.Criteria reportExample = reportFunBuyCustomerMinExample.createCriteria();
        if (partnerId!=null) {
            // 加盟商看加盟商的, 总部门店和直营门店互看
        	reportExample.andCityIdEqualTo(cityId).andCompIdEqualTo(compId).andPartnerIdEqualTo(partnerId);
        	if (oldOrgId!=null) {
        		reportExample.andTissueLineLike(":"+oldOrgId+":");
			}
        } else {
        	// 没有开通加盟商或者房客源数据不隔离
        	reportExample.andCityIdEqualTo(cityId).andCompIdEqualTo(compId);
        	if (oldOrgId!=null) {
        		reportExample.andTissueLineLike(":"+oldOrgId+":");
			}
        }
		int countBuyCustomer = reportFunBuyCustomerMinMapper.countByExample(reportFunBuyCustomerMinExample);
		if (countBuyCustomer >= 3000) {
			return false;
		}
		
		ReportFunRentCustomerMinExample reportFunRentCustomerMinExample = new ReportFunRentCustomerMinExample();
		ReportFunRentCustomerMinExample.Criteria rentExample = reportFunRentCustomerMinExample.createCriteria();
		if (partnerId!=null) {
            // 加盟商看加盟商的, 总部门店和直营门店互看
			rentExample.andCityIdEqualTo(cityId).andCompIdEqualTo(compId).andPartnerIdEqualTo(partnerId);
        	if (oldOrgId!=null) {
        		rentExample.andTissueLineLike(":"+oldOrgId+":");
			}
	    } else {
        	// 没有开通加盟商或者房客源数据不隔离
    		rentExample.andCityIdEqualTo(cityId).andCompIdEqualTo(compId);
        	if (oldOrgId!=null) {
        		rentExample.andTissueLineLike(":"+oldOrgId+":");
			}
	    }
		int countRentCustomer = reportFunRentCustomerMinMapper.countByExample(reportFunRentCustomerMinExample);
		if (countRentCustomer >= 3000) {
			return false;
		}
		return true;
	}
    
}
