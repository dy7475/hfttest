package com.myfun.service.business.admindb;

import com.myfun.erpWeb.deal.param.AccountInfoParam;

public interface AdminOnlineService {
     void openOnlineContract(AccountInfoParam accountInfoParam);
     
     void updateOnlineContract(String account);
     
     void updateCertId(String account,String certId);
}
