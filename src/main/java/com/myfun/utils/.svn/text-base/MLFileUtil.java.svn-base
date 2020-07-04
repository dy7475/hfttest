package com.myfun.utils;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.rendering.PDFRenderer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MLFileUtil {

	/**
	 * 根据byte数组，生成文件
	 * @param bfile 文件数组
	 * @param filePath 文件存放路径
	 * @param fileName 文件名称
	 */
	public static void byte2File(byte[] bytes,String filePath,String fileName){
	    BufferedOutputStream bos=null;
	    FileOutputStream fos=null;
	    File file=null;
	    try{
	        File dir=new File(filePath);
	        if(!dir.exists() && !dir.isDirectory()){//判断文件目录是否存在
	            dir.mkdirs();
	        }
	        file=new File(filePath+fileName);
	        fos=new FileOutputStream(file);
	        bos=new BufferedOutputStream(fos);
	        bos.write(bytes);
	    }
	    catch(Exception e){
	        System.out.println(e.getMessage());
	        e.printStackTrace();
	    }
	    finally{
	        try{
	            if(bos != null){
	                bos.close();
	            }
	            if(fos != null){
	                fos.close();
	            }
	        }
	        catch(Exception e){
	            System.out.println(e.getMessage());
	            e.printStackTrace();
	        }
	    }
	}

	public static List<String> pdfToImagePath(File file, String fileDirectory, Float imageScale) throws IOException {
		List<String> list = new ArrayList<String>();
		String imagePath;
		PDDocument doc =null;
		try {
			File f = new File(fileDirectory);
			if (!f.exists()) {
				f.mkdir();
			}
			doc = PDDocument.load(file);
			PDFRenderer renderer = new PDFRenderer(doc);
			int pageCount = doc.getNumberOfPages();
			for (int i = 0; i < pageCount; i++) {
				// 方式1,第二个参数是设置缩放比(即像素)
				// BufferedImage image = renderer.renderImageWithDPI(i, 296);
				// 方式2,第二个参数是设置缩放比(即像素)
				BufferedImage image = renderer.renderImage(i, imageScale); // 第二个参数越大生成图片分辨率越高，转换时间也就越长
				imagePath = fileDirectory + "/" + i + ".jpg";
				ImageIO.write(image, "PNG", new File(imagePath));
				list.add(imagePath);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(doc!=null) {
				doc.close();
			}
		}
		return list;
	}

	public static byte[] fileToBytes(String imagePath) {
		byte[] buffer = null;
		try {
			FileInputStream fis = new FileInputStream(imagePath);
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			byte[] b = new byte[1024];
			int n;
			while ((n = fis.read(b)) != -1) {
				bos.write(b, 0, n);
			}
			fis.close();
			bos.close();
			buffer = bos.toByteArray();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return buffer;
	}

	/*  
	* @author 蔡春林 通过网络url  获取文件大小 kb 和 mb
	* @date 2020/1/20 0020
	* @param imgPath
	* @return java.lang.String
	*/
	
	public static String pathSize(String imgPath) {
		int length=0;
		URL url;
		try {
			url = new  URL(imgPath);
			HttpURLConnection urlcon=(HttpURLConnection)url.openConnection();
			//根据响应获取文件大小 
			length=urlcon.getContentLength();
			urlcon.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bytes2kb(length);
	}

	/**
	 * 将获取到的字节数转换为KB，MB模式
	 * @param bytes
	 * @return
	 */
	public static String bytes2kb(long bytes){
		BigDecimal filesize = new BigDecimal(bytes);
		BigDecimal megabyte = new BigDecimal(1024 * 1024);
		float returnValue = filesize.divide(megabyte, 2, BigDecimal.ROUND_UP).floatValue();
		if(returnValue > 1)
			return (returnValue + "MB");
		BigDecimal kilobyte = new BigDecimal(1024);
		returnValue = filesize.divide(kilobyte, 2, BigDecimal.ROUND_UP).floatValue();
		return (returnValue + "KB");
	}
	
   public static void main(String[] args) throws InvalidPasswordException, IOException {
	  /* PDDocument doc =null;
		File file = new File("C:\\Users\\v-wuzhengkang\\git\\erpWeb\\mlwy_mr_shenzhen\\images\\broker\\houseElectronicData\\2019\\201912157742030701000002.pdf");
		doc = PDDocument.load(file);
		PDFRenderer renderer = new PDFRenderer(doc);
		int pageCount = doc.getNumberOfPages();
		for (int i = 0; i < pageCount; i++) {
			// 方式1,第二个参数是设置缩放比(即像素)
			// BufferedImage image = renderer.renderImageWithDPI(i, 296);
			// 方式2,第二个参数是设置缩放比(即像素)
			BufferedImage image = renderer.renderImage(i, 2.5F); // 第二个参数越大生成图片分辨率越高，转换时间也就越长
			String imagePath = "C:\\Users\\v-wuzhengkang\\git\\erpWeb\\mlwy_mr_shenzhen\\images\\broker\\houseElectronicData\\2019\\201912157742030701000002.jpg";
			ImageIO.write(image, "PNG", new File(imagePath));
		}*/
	   System.out.println(pathSize("http://img01-uat.m1200.com.cn/oss/dev/tmp/2020/01/20/ddc2a12877af4b349479d450d44cee11.jpg"));
   }
}