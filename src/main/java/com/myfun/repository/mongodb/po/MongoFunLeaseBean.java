package com.myfun.repository.mongodb.po;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.solr.core.mapping.SolrDocument;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.myfun.repository.erpdb.po.ErpFunLease;

@Document(collection = "funLease")
@SolrDocument(solrCoreName = "fun_lease")
@JsonInclude(value = Include.NON_NULL)
public class MongoFunLeaseBean extends ErpFunLease {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Field("ID")
	private String id;

	@JsonProperty("RESOURCE")
	@Field("RESOURCE")
	private Byte resource;

	@JsonProperty("HAS_PHOTO")
	@Field("HAS_PHOTO")
	private Boolean hasPhoto;

	@JsonProperty("HAS_VIDEO")
	@Field("HAS_VIDEO")
	private Boolean hasVideo;

	@Field("IS_VIP")
	private int isVip;

	@Field("WX_ID")
	private int wxId;
	
	private Long order;
	
	public Long getOrder() {
		return order;
	}

	public void setOrder(Long order) {
		this.order = order;
	}

	public int getIsVip() {
		return isVip;
	}

	public void setIsVip(int isVip) {
		this.isVip = isVip;
	}

	public int getWxId() {
		return wxId;
	}

	public void setWxId(int wxId) {
		this.wxId = wxId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Byte getResource() {
		return resource;
	}

	public void setResource(Byte resource) {
		this.resource = resource;
	}

	public Boolean getHasVideo() {
		return hasVideo;
	}

	public void setHasVideo(Boolean hasVideo) {
		this.hasVideo = hasVideo;
	}

	public Boolean getHasPhoto() {
		return hasPhoto;
	}

	public void setHasPhoto(Boolean hasPhoto) {
		this.hasPhoto = hasPhoto;
	}

}
