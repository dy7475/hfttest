package com.myfun.erpWeb.openApi;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myfun.erpWeb.openApi.param.GeneratePositionxyParam;
import com.myfun.repository.admindb.dao.AdminFunDeptsMapper;
import com.myfun.utils.Constants_DIC;
import com.myfun.utils.EnCodeHelper;
import com.myfun.utils.StringUtil;

@Controller
@RequestMapping("/openApi/switchPosition")
public class ErpBuildingPositionController {


    @Autowired
    AdminFunDeptsMapper adminFunDeptsMapper;
//    @Autowired
//    ErpBuildingMarketingControlMapper erpBuildingMarketingControlMapper;

    // 处理的队列
    public volatile BlockingQueue<GeneratePositionxyParam> compWorkCuntDealTmpQueue = new ArrayBlockingQueue<>(3000);
    
    /** 成功条数 **/
    private static volatile Integer count = 0;
    /** 失败条数 **/
    private static volatile Integer exceptionCount = 0;
    /** 消费线程每次取数据条数 **/
    private static volatile Integer trehadFetchNum = 500;
    /** 初始化线程起始值 **/
    private static volatile Integer photoIdMin = -500;
    private static volatile String tbName = "GENERATE_POSITIONXY";
    
    @RequestMapping(value="/startInit")
    @ResponseBody
    public String excuteInnerDealDataOffLastDay() {

       new IntiDataProvider().start();

       new ConsumerThread().start();
       new ConsumerThread().start();
       new ConsumerThread().start();
       new ConsumerThread().start();
       new ConsumerThread().start();

       return "success";
    }

    @RequestMapping(value = "/addThread")
    @ResponseBody
    public String addThread() {
        new ConsumerThread().start();
        new ConsumerThread().start();
        new ConsumerThread().start();
        new ConsumerThread().start();
        new ConsumerThread().start();
        new ConsumerThread().start();
        return "add thread success";
    }

    @RequestMapping(value = "/getQueueSize")
    @ResponseBody
    public String getQueueSize() {
        int size = compWorkCuntDealTmpQueue.size();
        return "老规则处理队列Size：" + size +";count=" + count +";exceptionCount="+exceptionCount;
    }

    private synchronized Integer getPhotoIdMin() {
        photoIdMin += trehadFetchNum;
        adminFunDeptsMapper.updateAdminBuildingSetUnitTmpIdx(tbName, trehadFetchNum);
        return photoIdMin;
    }
    
    /**
     * @Title 取数据
     * @Author lcb
     * @Time 2019/1/9
     **/
    private class IntiDataProvider extends Thread {

        @Override
        public void run() {
            while (true) {
                try {
                    Integer minId = getPhotoIdMin();
                    List<GeneratePositionxyParam> dealTmpList = adminFunDeptsMapper.selectBuildingInfoSetInitTmpByMaxMinId(minId, minId + trehadFetchNum);
                    if(dealTmpList.size() == 0) {
                        Thread.interrupted();
                    }
                    for (GeneratePositionxyParam adminInitMarketingDataTmp : dealTmpList) {
                        compWorkCuntDealTmpQueue.put(adminInitMarketingDataTmp);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /** 处理任务 **/
    public class ConsumerThread extends Thread {

        @Override
        public void run() {
            while (true) {
                //GenerateCaseMd5Param val = null;
                GeneratePositionxyParam val = null;
                try{
                    val = compWorkCuntDealTmpQueue.take();
                    ++count;
                    if(null == val) {
                        continue;
                    }
                    switchPosition(val);
                    adminFunDeptsMapper.saveDealRecord(val.getId(), 1);
                }catch (Exception e) {
                    adminFunDeptsMapper.saveDealRecord(val.getId(), 2);
                    e.printStackTrace();
                    ++exceptionCount;
                }
            }
        }
    }

    private void switchPosition(GeneratePositionxyParam val) {
    	String px = val.getPositionX(); //座标X-纬度-lat
    	String py = val.getPositionY(); //座标Y-经度-lon
    	
    	if(StringUtil.isNotBlank(px) && StringUtil.isNotBlank(py)) {
    		mapBaidu2Tengxun(val, Double.parseDouble(px), Double.parseDouble(py));
    		adminFunDeptsMapper.updatePositionxy(val);
    	}
    }
    
    /**
     * @title 美联的百度地图数据 转 腾讯地图
     * @author lzg
     * @since 2020年1月20日
     */
    public void mapBaidu2Tengxun(GeneratePositionxyParam val, double lat, double lon){
	    double tx_lat;
	    double tx_lon;
	    double x_pi=3.14159265358979324;
	    double x = lon - 0.0065, y = lat - 0.006;
        double z = Math.sqrt(x * x + y * y) - 0.00002 * Math.sin(y * x_pi);
        double theta = Math.atan2(y, x) - 0.000003 * Math.cos(x * x_pi);
        tx_lon = z * Math.cos(theta);
        tx_lat = z * Math.sin(theta);
        val.setPositionX(tx_lat + "");
        val.setPositionY(tx_lon + "");
        //return tx_lat+","+tx_lon;
	}
	
}

