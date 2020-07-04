package com.myfun.utils;

import com.itextpdf.awt.geom.Rectangle2D;
import com.itextpdf.awt.geom.RectangularShape;
import com.itextpdf.text.pdf.parser.ImageRenderInfo;
import com.itextpdf.text.pdf.parser.RenderListener;
import com.itextpdf.text.pdf.parser.TextRenderInfo;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PdfRenderListener implements RenderListener {
    /**
     * 用来存放每一个文字的坐标位置
     */
    private List<Map<String, Rectangle2D.Float>> allTextRect = new ArrayList<>();

    /**
     * 所有文本
     */
    private String allText = "";

    public PdfRenderListener() {
    }

    @Override
    public void beginTextBlock() {
    }

    /**
     * 文字主要处理方法
     */
    @Override
    public void renderText(TextRenderInfo renderInfo) {
        //获取文字的下面的矩形
        //Rectangle2D.Float rectBase = renderInfo.getBaseline().getBoundingRectange();
        String text = renderInfo.getText().replaceAll(" ","").trim();
        if(StringUtils.isEmpty(text))
            return;
        allText += text;
        if (text.length() > 0) {
            RectangularShape rectBase = renderInfo.getBaseline().getBoundingRectange();
            //获取文字下面的矩形
            Rectangle2D.Float rectAscen = renderInfo.getAscentLine().getBoundingRectange();
            float leftX = (float) rectBase.getMinX();
            float leftY = (float) rectBase.getMinY() - 1;
            float rightX = (float) rectAscen.getMaxX();
            float rightY = (float) rectAscen.getMaxY() + 1;
            Rectangle2D.Float rect = new Rectangle2D.Float(leftX, leftY, rightX - leftX, rightY - leftY);
            Map<String, Rectangle2D.Float> map = new HashMap<>();
            map.put(text, rect);
            allTextRect.add(map);
        }
    }

    @Override
    public void endTextBlock() {
    }

    @Override
    public void renderImage(ImageRenderInfo renderInfo) {

    }

    public List<Map<String, Rectangle2D.Float>> getAllTextRect() {
        return allTextRect;
    }

    public String getAllText() {
        return allText;
    }
}
