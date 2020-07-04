package com.myfun.utils;

import com.myfun.utils.bean.ImageAttribute;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 图片工具类
 * @author huangwen
 *
 */
public class ImageUtil {
	private final static Logger logger = Logger.getLogger(ImageUtil.class);
	
	/**
	 * L尺寸的宽度
	 */
	public final static Integer L_WIDTH = 900;
	/**
	 * L尺寸的高度
	 */
	public final static Integer L_HEIGHT = 600;
	/**
	 * M尺寸的宽度
	 */
	public final static Integer M_WIDTH = 450;
	/**
	 * M尺寸的高度
	 */
	public final static Integer M_HEIGHT = 300;
	/**
	 * S尺寸的宽度
	 */
	public final static Integer S_WIDTH = 150;
	/**
	 * S尺寸的高度
	 */
	public final static Integer S_HEIGHT = 100;
	
	public final static String L = "_"+L_WIDTH+"X"+L_HEIGHT;
	public final static String M = "_"+M_WIDTH+"X"+M_HEIGHT;
	public final static String S = "_"+S_WIDTH+"X"+S_HEIGHT;
	public final static String ORIGIN = "_origin";
	
	public final static String IMG_WIDTH="width";
	public final static String IMG_HEIGHT="height";
	

	static {
		System.setProperty("java.awt.headless", "true");
	}
	
	/**
	 * 得到压缩的尺寸
	 * @return
	 */
	public static List<ImageAttribute> getCompreeSizeList(){
		List<ImageAttribute> compresslist = new ArrayList<ImageAttribute>();	
		//width 或  height 属性为空则原图保存  原图
		ImageAttribute imgattr = new ImageAttribute(null,null,true);
		compresslist.add(imgattr);
		compresslist.addAll(getExceptOriginSizeList());
		return compresslist;
	}
	
	public static List<ImageAttribute> getExceptOriginSizeList(){
		List<ImageAttribute> compresslist = new ArrayList<ImageAttribute>();	
		/**
		 * 900*600 
		 */
		ImageAttribute imgattr = new ImageAttribute(ImageUtil.L_WIDTH,ImageUtil.L_HEIGHT,true);
		compresslist.add(imgattr);
		/**
		 * 450*300
		 */
		imgattr = new ImageAttribute(ImageUtil.M_WIDTH,ImageUtil.M_HEIGHT,true);
		compresslist.add(imgattr);
		/**
		 * 150*100
		 */
		imgattr = new ImageAttribute(ImageUtil.S_WIDTH,ImageUtil.S_HEIGHT,true);
		compresslist.add(imgattr);
		return compresslist;
	}

	public static String compressSave(String contractId, byte[] bytes, String path, String suffix,List<ImageAttribute> list) {
		final String fileId = UUID.randomUUID().toString();
		for(ImageAttribute imgattr : list) {
			
			byte[] compressedImage = ImageUtil.resize(bytes, imgattr.getWidth(), imgattr.getHeight(), imgattr.isEqualRatio());
			String nameSuffix = 
				imgattr.isNoShowSuffix()?"":((null==imgattr.getWidth()||null==imgattr.getHeight())?"_origin":("_"+imgattr.getWidth()+"X"+imgattr.getHeight()));
			String tmpname = fileId+nameSuffix+suffix;
			
			try {
				saveImage(compressedImage, path+"//"+tmpname);  
			} catch (IOException e) {					
				e.printStackTrace();
			}
			
		}
		return fileId;
	}

	private static void saveImage(byte[] bytes, String path) throws IOException{
		File img = new File(path);
		FileOutputStream fos = new FileOutputStream(img);
		ByteArrayInputStream bi = new ByteArrayInputStream(bytes);		
		byte[] buff = new byte[4096];//缓存4k 
		int len = 0;
		while((len=bi.read(buff))>0){
			fos.write(buff, 0, len);
		}		
		fos.write(bytes);
		fos.flush();
		fos.close();
	}

	private static byte[] resize(byte[] sourceImage, Integer width, Integer height, boolean isEqualRatio) {
		try {
			if(width == null || height == null) return sourceImage;
			String tempDir = System.getProperty("java.io.tmpdir");
			String imageName = UUID.randomUUID().toString();
			File sourceFile = new File(tempDir + "/" + imageName);  
			FileUtils.writeByteArrayToFile(sourceFile, sourceImage);
			String sourcePath = sourceFile.getAbsolutePath();
			String targetPath = sourcePath + "_target";
			resize(sourcePath, targetPath, width, height, isEqualRatio);
			File targetFile = new File(targetPath);
			byte[] result = FileUtils.readFileToByteArray(targetFile);
			FileUtils.deleteQuietly(sourceFile);
			FileUtils.deleteQuietly(targetFile);
			return result;
		} catch (IOException e) {
			logger.error(e.toString(), e);
		}
		return null;
	}

	private static void resize(String sourcePath, String targetPath, Integer width, Integer height,boolean isEqualRatio) {
		Float quality = 1.0f;
		File srcFile = new File(sourcePath);
		File distFile = new File(targetPath);
		try {
			Image srcImageFile = ImageIO.read(new File(sourcePath));
			int new_w = width;
			int new_h = height;
			int o_width = srcImageFile.getWidth(null);
			int o_height = srcImageFile.getHeight(null);
			if (quality >= 1.0f && o_width <= width && o_height <= height) {
				FileUtils.copyFile(srcFile, distFile);
			} else {
				if (isEqualRatio) {
					// 为等比缩放计算输出的图片宽度及高度
					double rate1 = ((double) o_width) / (double) width;
					double rate2 = ((double) o_height) / (double) height;
					double rate = rate1 > rate2 ? rate1 : rate2;
					new_w = (int) (((double) o_width) / rate);
					new_h = (int) (((double) o_height) / rate);
				}

				BufferedImage tag = new BufferedImage(new_w, new_h, BufferedImage.TYPE_INT_RGB);
				tag.getGraphics().drawImage(srcImageFile.getScaledInstance(new_w, new_h, Image.SCALE_SMOOTH), 0, 0,
						null);

				FileOutputStream out = new FileOutputStream(distFile);
				com.sun.image.codec.jpeg.JPEGImageEncoder encoder = com.sun.image.codec.jpeg.JPEGCodec.createJPEGEncoder(out);
				com.sun.image.codec.jpeg.JPEGEncodeParam jep = com.sun.image.codec.jpeg.JPEGCodec.getDefaultJPEGEncodeParam(tag);

				jep.setQuality(quality, true);
				encoder.encode(tag, jep);

				out.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
