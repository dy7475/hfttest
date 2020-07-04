package com.myfun.service.business.searchdb.bean.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import com.myfun.repository.param.AbstractEncryParam;
import com.myfun.repository.support.param.DaoBaseParam;
@ApiModel
public class SoSoSaleDataInfoParam extends AbstractEncryParam implements DaoBaseParam{
	@ApiModelProperty(value = "搜搜ID")
	 private Integer sosoId;// 搜搜ID
	@ApiModelProperty(value = "时间")
	@NotBlank private String time;// 时间
	@ApiModelProperty(value = "城市id")
	private Integer cityId;// 城市id
	@ApiModelProperty(value = "所在省市")
	private Integer provinceId;// 所在省市
	@ApiModelProperty(value = "table名")
	private String tbName;// table名
	@ApiModelProperty(value = "详细信息表名")
	private String tbNameDetail;// 详细信息表名
	@ApiModelProperty(value = "档案id")
	private Integer archiveId;// 档案id
	@ApiModelProperty(value = "重复ID")
	private Integer repeatId;// 档案id
	@ApiModelProperty(value = "数据url")
	private String dataUrl;

	public String getDataUrl() {
		return dataUrl;
	}

	public void setDataUrl(String dataUrl) {
		this.dataUrl = dataUrl;
	}

	public Integer getRepeatId() {
		return repeatId;
	}
	public void setRepeatId(Integer repeatId) {
		this.repeatId = repeatId;
	}
	public Integer getSosoId() {
		return sosoId;
	}
	public void setSosoId(Integer sosoId) {
		this.sosoId = sosoId;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	public Integer getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}
	public String getTbName() {
		return tbName;
	}
	public void setTbName(String tbName) {
		this.tbName = tbName;
	}
	public String getTbNameDetail() {
		return tbNameDetail;
	}
	public void setTbNameDetail(String tbNameDetail) {
		this.tbNameDetail = tbNameDetail;
	}
	public Integer getArchiveId() {
		return archiveId;
	}
	public void setArchiveId(Integer archiveId) {
		this.archiveId = archiveId;
	}
	
	
}

