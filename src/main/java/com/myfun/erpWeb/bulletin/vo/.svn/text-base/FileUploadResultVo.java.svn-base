package com.myfun.erpWeb.bulletin.vo;

import com.myfun.utils.bean.FileUploadResult;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.List;

@ApiModel(description = "上传附件VO")
public class FileUploadResultVo implements Serializable {

	private String domain;
	private List<FileUploadResult.FileInfo> fileList;

	public static class FileInfo{
		private String filePath;
		private String fileName;
		private Integer fileSize;
		private String fileSizeStr;
		private String fileType;
		private String fileOldName;

		public String getFileOldName() {
			return fileOldName;
		}

		public void setFileOldName(String fileOldName) {
			this.fileOldName = fileOldName;
		}

		public String getFilePath() {
			return filePath;
		}
		public void setFilePath(String filePath) {
			this.filePath = filePath;
		}
		public Integer getFileSize() {
			return fileSize;
		}
		public void setFileSize(Integer length) {
			this.fileSize = length;
		}
		public String getFileName() {
			return fileName;
		}
		public void setFileName(String fileName) {
			this.fileName = fileName;
		}
		public String getFileSizeStr() {
			return fileSizeStr;
		}
		public void setFileSizeStr(String fileSizeStr) {
			this.fileSizeStr = fileSizeStr;
		}
		public String getFileType() {
			return fileType;
		}
		public void setFileType(String fileType) {
			this.fileType = fileType;
		}
	}

	/**
	 * 获取单个文件
	 * @author 张宏利
	 * @since 2017年8月21日
	 * @return
	 */
	public String getFilePath() {
		if(fileList == null || fileList.size() <= 0) {
			return null;
		}
		return fileList.get(0).getFilePath();
	}

	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}

	public List<FileUploadResult.FileInfo> getFileList() {
		return fileList;
	}

	public void setFileList(List<FileUploadResult.FileInfo> fileList) {
		this.fileList = fileList;
	}
}
