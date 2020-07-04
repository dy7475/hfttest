package com.myfun.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.apache.commons.lang.StringUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 二维码生成工具
 * **/
public class QRCodeUtil {
    private static final int QRCOLOR = 0xFF000000; // 默认是黑色
    private static final int BGWHITE = 0xFFFFFFFF; // 背景颜色

    private static final int WIDTH = 270; // 二维码宽
    private static final int HEIGHT = 320; // 二维码高

    // 用于设置QR二维码参数
    private static Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>() {
        private static final long serialVersionUID = 1L;
        {
            put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);// 设置QR二维码的纠错级别（H为最高级别）具体级别信息
            put(EncodeHintType.CHARACTER_SET, "utf-8");// 设置编码方式
            put(EncodeHintType.MARGIN, 0);
        }
    };

    public static void main(String[] args) throws WriterException {
        File logoFile = new File("D://QrCode/checkCodeLogo.png");
        File QrCodeFile = new File("D://QrCode/05.png");
        String url = "https://www.baidu.com/";
        String note = "访问百度连接";
//        drawLogoQRCode(logoFile, QrCodeFile, url);
    }


    // 生成带logo的二维码图片
    public static void  drawLogoQRCode(File logoFile, String qrUrl, OutputStream outputStream) {
        try {
            MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
            // 参数顺序分别为：编码内容，编码类型，生成图片宽度，生成图片高度，设置参数
            BitMatrix bm = multiFormatWriter.encode(qrUrl, BarcodeFormat.QR_CODE, WIDTH, HEIGHT, hints);
            BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

//            // 开始利用二维码数据创建Bitmap图片，分别设为黑（0xFFFFFFFF）白（0xFF000000）两色
            for (int x = 0; x < WIDTH; x++) {
                for (int y = 0; y < HEIGHT; y++) {
                    image.setRGB(x, y, bm.get(x, y) ? QRCOLOR : BGWHITE);
                }
            }

            int width = image.getWidth();
            int height = image.getHeight();
            if (Objects.nonNull(logoFile) && logoFile.exists()) {
                // 构建绘图对象
                Graphics2D g = image.createGraphics();
                // 读取Logo图片
                BufferedImage logo = ImageIO.read(logoFile);
                // 开始绘制logo图片
                g.drawImage(logo, 12, 5, width-24 , height, null);
                g.dispose();
                logo.flush();
            }

            image.flush();
            ImageIO.write(image, "png", outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 通用获取核验房源展示地址，用于不同公司的分发访问
     * @param funSalePO
     * @return
     * @throws Exception
     */
    public static String getHouseCertificateUrl(String compNo, String checkCodeFun) throws Exception {
        String checkCodeUrl = null;
        // 鸿基
        if("ACXA".equals(compNo)) {
            if(StringUtils.isNotBlank(checkCodeFun)) {
                checkCodeUrl = "http://appfyyz.ncfdc.com.cn/certificate_"+checkCodeFun+".html";
            }
        }
        return checkCodeUrl;
    }
}
