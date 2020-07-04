package com.myfun.repository.admindb.param;

import java.util.ArrayList;
import java.util.List;

import com.myfun.repository.admindb.po.AdminFunApartmentPhoto;
import com.myfun.repository.admindb.po.AdminFunCooperateApartment;

/**
 * 公寓同步接口使用
 * 
 * @author jsg
 *
 */
public class AdminFunCooperateApartmentParam extends AdminFunCooperateApartment {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	List<AdminFunApartmentRoomParam> roomList = new ArrayList<AdminFunApartmentRoomParam>();

	List<AdminFunApartmentPhoto> photoList = new ArrayList<AdminFunApartmentPhoto>();

	public List<AdminFunApartmentRoomParam> getRoomList() {
		return roomList;
	}

	public void setRoomList(List<AdminFunApartmentRoomParam> roomList) {
		this.roomList = roomList;
	}

	public List<AdminFunApartmentPhoto> getPhotoList() {
		return photoList;
	}

	public void setPhotoList(List<AdminFunApartmentPhoto> photoList) {
		this.photoList = photoList;
	}

}
