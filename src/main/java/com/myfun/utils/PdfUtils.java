package com.myfun.utils;

import com.itextpdf.awt.geom.Rectangle2D;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.*;

public class PdfUtils {


    /**
     * 获取pdf坐标点
     *
     * @param pdfPath pdf地址
     * @param set     key=1 业主签名 2 客户签名 3 业主签约日期 4 客户签约日期 5 印章
     * @return
     * @throws IOException
     */
    public static CoordinateInfoModel getPdfXy(String pdfPath, Map<Integer, String> set) throws IOException {
        if (Objects.equals(set.get(PdfType.OWNER_SING_DATE), set.get(PdfType.CUSTOMER_SING_DATE)))
            set.remove(PdfType.OWNER_SING_DATE);
        CoordinateInfoModel coordinateInfoModel = new CoordinateInfoModel();
        PdfReader reader = new PdfReader(pdfPath);
        coordinateInfoModel.setPAGE(reader.getNumberOfPages());
        if (coordinateInfoModel.getPAGE() <= 0)
            return coordinateInfoModel;
        float pdfHeight = 0;
        float pdfWidth = 0;
        Rectangle rectangle = reader.getPageSize(1);
        if (rectangle != null) {
            pdfHeight = rectangle.getHeight();// pdf高度
            pdfWidth = rectangle.getWidth();
        }
        coordinateInfoModel.setA4_WIDTH(pdfWidth);
        coordinateInfoModel.setA4_HIGHT(pdfHeight);
        //新建一个PDF解析对象
        PdfReaderContentParser parser = new PdfReaderContentParser(reader);
        PdfRenderListener listener = new PdfRenderListener();
        // 匹配的文字索引地址
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 1; i <= coordinateInfoModel.getPAGE(); i++) {
            // 解析PDF，并处理里面的文字 pdf 从0开始
            parser.processContent(i, listener);
            if (i >= coordinateInfoModel.getPAGE() - 2) {
                for (Map.Entry<Integer, String> entry : set.entrySet()) {
                    String str = entry.getValue();
                    int index = listener.getAllText().lastIndexOf(str);
                    if (index >= 0 && index + str.length() - 1 < listener.getAllTextRect().size()) {
                        List<Integer> list = map.get(str);
                        if (list == null)
                            list = new ArrayList<>();
                        list.add(index);
                        map.put(entry.getKey(), list);
                    }
                }
            }
        }
        // 匹配的印章区域索引地址
        List<Rectangle2D.Float> addressList = new ArrayList<>();
        Map<String, Rectangle2D.Float> floatMap = listener.getAllTextRect().get(listener.getAllTextRect().size() - 1);
        addressList.addAll(new ArrayList<>(floatMap.values()));
        // 处理坐标点
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            String str = set.get(entry.getKey());
            int index = entry.getValue().get(entry.getValue().size() - 1);
            List<Rectangle2D.Float> floats = new ArrayList<>(listener.getAllTextRect().get(index + str.length() - 1).values());
            if (floats.isEmpty())
                continue;
            getField(entry.getKey(), floats.get(0), coordinateInfoModel, addressList.get(0));
            if (PdfType.CUSTOMER_SING_DATE == entry.getKey()
                    && !set.containsKey(PdfType.OWNER_SING_DATE)) {
                // 客户签约时间计算坐标时 一起计算业主签约时间坐标  因为上面过滤的业主签约时间的
                Map<String, Rectangle2D.Float> stringFloatMap = listener.getAllTextRect().get(index - 1);
                if (stringFloatMap != null && !stringFloatMap.isEmpty()) {
                    List<Rectangle2D.Float> f = new ArrayList<>(stringFloatMap.values());
                    getField(PdfType.OWNER_SING_DATE, f.get(0), coordinateInfoModel, addressList.get(floats.size() - 1));
                }
            }
        }

        return coordinateInfoModel;
    }

    /**
     * 设置值
     *
     * @param type
     * @param rect                要设置的坐标
     * @param coordinateInfoModel
     * @param addressRect         最后一行的位置  印章的坐标用于判断签字去的页数
     * @return
     */
    private static CoordinateInfoModel getField(@PdfType int type, Rectangle2D.Float rect,
                                                CoordinateInfoModel coordinateInfoModel, Rectangle2D.Float addressRect) {
        if (coordinateInfoModel == null)
            return null;
        float x = (rect.x + 10) / coordinateInfoModel.getA4_WIDTH();
        float y = 1 - (rect.y + rect.height + 8) / coordinateInfoModel.getA4_HIGHT();
        int page = coordinateInfoModel.getPAGE();
        switch (type) {
            case PdfType.OWNER:
                if (addressRect.y > rect.y)// 说明最后一个字在另外一页  也就是最后一页
                    page--;
                if (StringUtils.isEmpty(coordinateInfoModel.getPARTY_A_INFO()))
                    coordinateInfoModel.setPARTY_A_INFO(String.format("%s,%s,%s", x, y, page));
                break;
            case PdfType.CUSTOMER:
                if (addressRect.y > rect.y)
                    page--;
                if (StringUtils.isEmpty(coordinateInfoModel.getPARTY_B_INFO()))
                    coordinateInfoModel.setPARTY_B_INFO(String.format("%s,%s,%s", x, y, page));
                break;
            case PdfType.OWNER_SING_DATE:
                if (addressRect.y > rect.y)
                    page--;
                if (StringUtils.isEmpty(coordinateInfoModel.getPARTY_A_DATE()))
                    coordinateInfoModel.setPARTY_A_DATE(String.format("%s,%s,%s", x, y, page));
                break;
            case PdfType.CUSTOMER_SING_DATE:
                if (addressRect.y > rect.y)
                    page--;
                if (StringUtils.isEmpty(coordinateInfoModel.getPARTY_B_DATE()))
                    coordinateInfoModel.setPARTY_B_DATE(String.format("%s,%s,%s", x, y, page));
                break;
            case PdfType.SIGN:
//                float yzHeight = (130.0f / 72) * 96;// 印章大小默认为130磅  磅转px=(磅/72)x96;
                float yzHeight = 124;
                float yzY = 1 - (yzHeight + 10) / coordinateInfoModel.getA4_HIGHT();// 计算印章完全显示出来的位置
                y = 1 - (rect.y + rect.height + 30) / coordinateInfoModel.getA4_HIGHT();
                if (y > yzY) {
                    if (page < coordinateInfoModel.getPAGE()) {
                        page++;
                        y = 0.02f;
                    } else {
                        if (addressRect.y > rect.y)
                            page--;
                        float distance = y - yzY;// 计算差值
                        y -= distance;
                    }
                }
                if (StringUtils.isEmpty(coordinateInfoModel.getPARTY_C_INFO()))
                    coordinateInfoModel.setPARTY_C_INFO(String.format("%s,%s,%s", x, y, page));
                break;

        }
        return coordinateInfoModel;
    }
}
