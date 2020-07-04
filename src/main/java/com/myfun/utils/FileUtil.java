package com.myfun.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.myfun.framework.config.AppConfig;
import com.myfun.framework.exception.BusinessException;
import com.myfun.utils.bean.FileUploadResult;
import com.myfun.utils.bean.FileUploadResult.FileInfo;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.kafka.common.config.ConfigException;
import org.csource.FastdfsManager;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.math.BigDecimal;
import java.net.URL;
import java.util.List;
import java.util.*;

/**
 * 文件操作工具类
 * 
 * @ClassName: FileUtil
 * @Description: TODO
 * @author jiangsonggui
 * @date 2015年12月29日 下午5:28:14
 *
 */
public class FileUtil {
	public static final String SP = File.separator;

	public static String convertFileSize(double bytes) {
		if (bytes == 0) return "0B";
		String[] sizes = new String[]{"B", "KB", "MB", "GB", "TB", "PB", "EB", "ZB", "YB"};
		int i = (int) Math.floor(Math.log(bytes) / Math.log(1024));
		BigDecimal b = new BigDecimal(bytes / Math.pow(1024, i));
		return b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue() + sizes[i];
	}
	
	/**
	 * 生成图片缩略图
	 * 
	 * @param src
	 *            源路径
	 * @param dist
	 *            目标路径
	 * @throws Exception
	 */
	@SuppressWarnings("restriction")
	public static boolean createThumb(String src, String dist, Integer witdh, Integer height) {
		FileOutputStream out = null;
		try {
			File filePath = new File(dist);
			File pFilePath = new File(filePath.getParent());
			if (!pFilePath.exists()) {
				pFilePath.mkdirs();
			}

			// 构造Image对象;
			Image srcImg = ImageIO.read(new File(src));
			BufferedImage tag = new BufferedImage(witdh, height, BufferedImage.TYPE_INT_RGB);
			Graphics2D grap = tag.createGraphics();
			grap.drawImage(srcImg, 0, 0, witdh, height, null);
			grap.dispose();

			out = FileUtils.openOutputStream(filePath);
			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
			encoder.encode(tag);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}

	public static boolean createThumb(String src, String dist) {
		return createThumb(src, dist, 114, 85);
	}

	/**
	 * 获取文件后缀名
	 * 
	 * @param fileName
	 * @return
	 */
	public static String getFileSub(String fileName) {
		String result = "";
		if (StringUtil.isNotEmpty(fileName)) {
			int index = fileName.lastIndexOf(".");
			if (index >= 0) {
				result = fileName.substring(index + 1, fileName.length());
			}
		}
		return result;
	}
	
	public static boolean isRealDiskFile(String path) {
		File file = new File(path);
		return (file.exists() && !file.isDirectory());// 存在，而且不是文件夹
	}
	
	public static byte[] getDiskFile(String path) {
		try{
			File file = new File(path);
			BufferedInputStream stream = new BufferedInputStream(new FileInputStream(file));
			byte result[] = new byte[(int) file.length()];
			stream.read(result);
			stream.close();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new byte[]{};
	}
	
	/**
	 * 上传文件
	 * @param fileAddr 文件地址
	 * @return 上传到fastdfs上的地址
	 */
	public static String uploadFileToFastdfs(String diskPath, String fileAddr) {
		byte[] fileByte = new byte[] {};
		if (fileAddr.startsWith("http://")) {
			fileByte = HttpUtil.getFileByUrl(fileAddr);
		} else {
			fileAddr = fileAddr.replaceAll("\\\\", "/");
			fileAddr = diskPath + fileAddr;
			fileByte = FileUtil.getDiskFile(fileAddr);
		}
		if (fileByte.length > 0) {
			String fileVideoExt = fileAddr.substring(fileAddr.lastIndexOf(".") + 1).toLowerCase();
			String uploadVideoFile = FastdfsManager.uploadFile(fileByte, fileVideoExt);
			return uploadVideoFile;
		}
		return null;
	}
	
	/**
	 * 读取文件倒数多少行数据
	 * @author 张宏利
	 * @since 2017年5月19日
	 * @param filePath 文件地址
	 * @param lineCount 读取行数
	 * @return
	 */
	public static String readLastLines(String filePath, long lineCount, String br) {
		try {
			if(StringUtils.isBlank(filePath) || lineCount == 0) {
				return "";
			}
			if(StringUtils.isBlank(br)) {
				br = "\n";
			}
			RandomAccessFile raf = new RandomAccessFile(filePath, "r");
			long len = raf.length();
			StringBuilder sbTemp = new StringBuilder();
			if (len != 0L) {
				long lineCountNow = 0;
				while (len-- > 0) {
					raf.seek(len);
					byte readByte = raf.readByte();
					if(readByte == '\n') {
						String readLine = raf.readLine();
						if(readLine != null) {
							sbTemp.insert(0, br).insert(0, new String(readLine.getBytes("ISO-8859-1"),"utf-8"));
							if (++lineCountNow >= lineCount) {
								break;
							}
						}
					}
				}
			}
			raf.close();
			return sbTemp.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	/**
    *
    * 远程获取一张图片
    * **/
  public final static InputStream getRemoteImage(String imgUrl) {
        ByteArrayOutputStream baos = null;
        InputStream inputStream = null;
        try {
            URL u = new URL(imgUrl);
            inputStream = u.openStream();
        }
        catch (Exception e){
        }
        finally{
            if(baos != null)
            {
                try {
                    baos.close();
                } catch (IOException e) {
                }
            }
        }
        return inputStream;
    }
	
	public static void main(String[] args) {
		String addr = "\\dasd\\dasd\\dasd";
		System.out.println(addr.replaceAll("\\\\", "/"));
		
		byte[] remoteImage = FileUtil.getDiskFile("d:/1/1.jpg");
		String uploadFile = FastdfsManager.uploadFile(remoteImage, "jpg");
		System.out.println(uploadFile);
	}

	/**
	 * fileWeb 文件上传
	 * lcb
	 * 2017-08-17
	 * @return domain:文件服务器
	 * @return filePath 文件名 列表
	 * **/
	public static FileUploadResult fileUpload(InputStream in, String url, String extion,String watermarkFlag) {
		try{
			byte[] bytes = toByteArray(in);
			return commonUploadFile(url, bytes, extion, watermarkFlag);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * fileWeb 文件上传
	 * lcb
	 * 2017-08-17
	 * @return domain:文件服务器
	 * @return filePath 文件名 列表
	 * **/
	public static FileUploadResult fileUpload(String remoteUrl, String url,String watermarkFlag) {
		try{
			if (StringUtils.isNotBlank(remoteUrl)) {
				String prefix = remoteUrl.substring(remoteUrl.lastIndexOf("/") + 1);
				InputStream remoteImage = getRemoteImage(remoteUrl);
				return fileUpload(remoteImage, url, prefix, watermarkFlag);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * fileWeb 文件上传
	 * @author lcb
	 * @since 2017年8月21日
	 * @param files
	 * @return
	 */
	public static FileUploadResult fileUpload(String url, MultipartFile files, String watermarkFlag) throws Exception{
		return commonUploadFile(url, files.getBytes(), files.getOriginalFilename(),watermarkFlag);
	}

	/**
	 * fileWeb 文件上传
	 * @author lcb
	 * @since 2017年8月21日
	 * @param files
	 * @return
	 */
	public static FileUploadResult fileUpload(String url, MultipartFile[] files, String watermarkFlag) throws Exception{
		List<byte[]> dataByteList = new ArrayList<>(files.length);
		List<String> fileNameList = new ArrayList<>(files.length);
		for (Integer i = 0; i < files.length; i++) {
			dataByteList.add(files[i].getBytes());
			fileNameList.add(files[i].getOriginalFilename());
		}
		return commonUploadFile(url, dataByteList, fileNameList, watermarkFlag);
	}


	/**
	 * 通用上传
	 * @author lcb
	 * @since 2017年8月21日
	 * @param extion
	 * @param bytes
	 * @return
	 */
	public static FileUploadResult commonUploadFile(String url, List<byte[]> bytes, List<String> fileNames, String watermarkFlag) throws Exception{
		FileUploadResult uploadResult = new FileUploadResult();
		String resultStr = HttpUtil.postFileToFastdfs(url + "uploadFile", "1", fileNames, bytes, watermarkFlag);
		JSONObject jsonObject = JSON.parseObject(resultStr);
		if (jsonObject != null) {
			uploadResult.setDomain(jsonObject.getString("domain"));
			JSONObject dataJSONObject = jsonObject.getJSONObject("data");
			List<FileInfo> pathList = new ArrayList<>();
			List<FileInfo> failPathList = new ArrayList<>();
			/*Set<String> strings = dataJSONObject.keySet();
			List<String> dataList = new ArrayList<String>(strings);
			for (Integer i = 0; i < dataList.size(); i++) {
				FileInfo fileInfo = new FileInfo();
				fileInfo.setFileName(dataList.get(i));
				fileInfo.setFileSize(bytes.size());
				fileInfo.setFileSizeStr(convertFileSize(bytes.size()));
				fileInfo.setFilePath(dataJSONObject.getString(dataList.get(i)));
				pathList.add(fileInfo);
			}*/
			
			for(String fileName : fileNames) {
				FileInfo fileInfo = new FileInfo();
				fileInfo.setFileName(fileName);
				fileInfo.setFileSize(bytes.size());
				fileInfo.setFileSizeStr(convertFileSize(bytes.size()));
				if(StringUtil.isNotBlank(dataJSONObject.getString(fileName))) {
					fileInfo.setFilePath(dataJSONObject.getString(fileName));
					pathList.add(fileInfo);
				}else {
					failPathList.add(fileInfo);
				}
			}
			uploadResult.setFileList(pathList);
			uploadResult.setFailFileList(failPathList);
		}
		if(uploadResult.getFilePath() == null) {
			throw new ConfigException("图片上传失败，请联系在线客服");
		}
		return uploadResult;
	}

	/**
	 * 通用上传
	 * @author lcb
	 * @since 2017年8月21日
	 * @param extion
	 * @param bytes
	 * @return
	 */
	public static FileUploadResult commonUploadFile(String url, byte[] bytes, String fileNames,String watermarkFlag) throws Exception{
		FileUploadResult uploadResult = new FileUploadResult();
		try {
			String resultStr = HttpUtil.postFileToFastdfs(url + "uploadFile", "1", fileNames, bytes,watermarkFlag);
			JSONObject jsonObject = JSON.parseObject(resultStr);
			if (jsonObject != null) {
				uploadResult.setDomain(jsonObject.getString("domain"));
				JSONObject dataJSONObject = jsonObject.getJSONObject("data");
				List<FileInfo> pathList = new ArrayList<>();
				Set<String> strings = dataJSONObject.keySet();
				List<String> dataList = new ArrayList<>(strings);
				List<String> orgFileName = Arrays.asList(fileNames.split(","));
				for (Integer i = 0; i < dataList.size(); i++) {
					FileInfo fileInfo = new FileInfo();
					fileInfo.setFileOldName(orgFileName.get(i));
					fileInfo.setFileName(dataList.get(i));
					fileInfo.setFileSize(bytes.length);
					fileInfo.setFileSizeStr(convertFileSize(bytes.length));
					fileInfo.setFilePath(dataJSONObject.getString(dataList.get(i)));
					pathList.add(fileInfo);
				}
				uploadResult.setFileList(pathList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(uploadResult.getFilePath() == null) {
			throw new ConfigException("图片上传失败，请联系在线客服");
		}
		return uploadResult;
	}

	public static byte[] toByteArray(InputStream input) throws IOException {
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		byte[] buffer = new byte[4096];
		int n = 0;
		while (-1 != (n = input.read(buffer))) {
			output.write(buffer, 0, n);
		}
		return output.toByteArray();
	}

	/**
	 * title ：得到远程图片的Byte[]
	 * athor：lcb
	 * date  : 2017/10/23
	 */
	public static byte[] getFileByte(String remoteUrl) {
		try{
			InputStream remoteImage = getRemoteImage(remoteUrl);
			return toByteArray(remoteImage);
		}catch (Exception e) {

		}
		return new byte[]{};
	}

	public static Map<String, Object> commonUploadFile(String extion, byte[] bytes, String watermarkFlag) {
		String domain = "";
		List<String> pathList = new ArrayList<>();
		try {
			String resultStr = HttpUtil.postFileToFastdfs(AppConfig.getUploadFileServerUrl(), "1", extion, bytes, watermarkFlag);
			JSONObject jsonObject = JSON.parseObject(resultStr);
			if (jsonObject != null) {
				JSONObject dataJSONObject = jsonObject.getJSONObject("data");
				domain = jsonObject.getString("domain");
				Iterator<String> iterator = dataJSONObject.keySet().iterator();
				while (iterator.hasNext()) {
					String next = iterator.next();
					pathList.add(dataJSONObject.getString(next));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> uploadResult = new HashMap<>();
		uploadResult.put("domain", domain);
		uploadResult.put("filePath", pathList);
		return uploadResult;
	}

	public static String commonUploadOneFile(String extion, byte[] bytes,String watermarkFlag) {
		Map<String, Object> commonUploadFile = commonUploadFile(extion, bytes, watermarkFlag);
		if(commonUploadFile != null) {
			List<String> pathList = (List<String>) commonUploadFile.get("filePath");
			if(pathList != null) {
				return pathList.get(0);
			}
		}
		return null;
	}
	
	/**
	 * 上传文件, fileName主要是用于识别文件类型,如: *.mp4, *.jpg ...
	 *
	 * @param fileName 原生文件名
	 * @param fileByte 文件二进制
	 * @return http://test.haofang.net:11013/group1/M00/00/F1/wKgLq1nE6P-ANDWcAHujVwFhk0c325.mp4
	 * @throws Exception
	 */
	public static String uploadFile(String fileName, byte[] fileByte) throws Exception {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(AppConfig.getUploadFileServerUrl());
		HttpEntity entity = MultipartEntityBuilder.create()
				.addTextBody("source", "5") //掌通固定传5
				.addBinaryBody("sdf", fileByte, ContentType.MULTIPART_FORM_DATA, fileName)//传sdf，后面就取sdf
				.build();
		httpPost.setEntity(entity);

		try (CloseableHttpResponse response = httpClient.execute(httpPost)) {
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode == 200) {
				HttpEntity resEntity = response.getEntity();
				if (resEntity != null) {
					String resBody = EntityUtils.toString(resEntity, "UTF-8");
					JSONObject jsonObject = JSON.parseObject(resBody);
					if ("200".equals(jsonObject.getString("code"))) {
						JSONObject data = jsonObject.getJSONObject("data");
						if (data != null) {
							return data.getString("sdf");
						}
					}
				}
			} else {
				throw new BusinessException("上传失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException("上传失败，请重试。");
		} finally {
			httpClient.close();
		}
		return "";
	}
}
