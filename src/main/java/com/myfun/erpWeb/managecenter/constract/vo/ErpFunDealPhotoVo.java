package com.myfun.erpWeb.managecenter.constract.vo;

import com.myfun.repository.erpdb.dto.ErpFunDealPhotoDto;

import java.util.List;

/**
 * @author czq
 * @since 2019/3/13
 */
public class ErpFunDealPhotoVo {

    private List<ErpFunDealPhotoDto> dealPhotos;

    public List<ErpFunDealPhotoDto> getDealPhotos() {
        return dealPhotos;
    }

    public void setDealPhotos(List<ErpFunDealPhotoDto> dealPhotos) {
        this.dealPhotos = dealPhotos;
    }
}