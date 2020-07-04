package com.myfun.erpWeb.openApi;

import com.myfun.erpWeb.openApi.param.GenerateCaseMd5Param;
import com.myfun.repository.admindb.dao.AdminFunDeptsMapper;
import com.myfun.repository.erpdb.dao.ErpBuildingMarketingControlMapper;
import com.myfun.utils.Constants_DIC;
import com.myfun.utils.EnCodeHelper;
import com.myfun.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


@Controller
@RequestMapping("/openApi/initRoomMd5")
public class ErpBuildSetInitDataController {


    @Autowired
    AdminFunDeptsMapper adminFunDeptsMapper;
    @Autowired
    ErpBuildingMarketingControlMapper erpBuildingMarketingControlMapper;

    // 处理的队列
    public volatile BlockingQueue<GenerateCaseMd5Param> compWorkCuntDealTmpQueue = new ArrayBlockingQueue<>(3000);
    
    /** 成功条数 **/
    private static volatile Integer count = 0;
    /** 失败条数 **/
    private static volatile Integer exceptionCount = 0;
    /** 消费线程每次取数据条数 **/
    private static volatile Integer trehadFetchNum = 500;
    /** 初始化线程起始值 **/
    private static volatile Integer photoIdMin = -500;
    private static volatile String tbName = "GENERATE_MD5";
    
    @RequestMapping(value="/startInit")
    @ResponseBody
    public String excuteInnerDealDataOffLastDay() {

       new IntiDataProvider().start();

       new ConsumerThread().start();
       new ConsumerThread().start();
       new ConsumerThread().start();
       new ConsumerThread().start();
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
                    List<GenerateCaseMd5Param> dealTmpList = adminFunDeptsMapper.selectBuildingSetInitTmpByMaxMinId(minId, minId + trehadFetchNum);
                    if(dealTmpList.size() == 0) {
                        continue;
                    }
                    for (GenerateCaseMd5Param adminInitMarketingDataTmp : dealTmpList) {
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
                GenerateCaseMd5Param val = null;
                try{
                    val = compWorkCuntDealTmpQueue.take();
                    ++count;
                    if(null == val) {
                        continue;
                    }
                    String addrMd5 = "";
                    Integer infoType = val.getInfoType();
                    // 查询一下销控表
                    //  // 1:楼盘规则 2：核心信息
                    if(1 == infoType) {
                        addrMd5 = encodeToMD5(val.getBuildId(), val.getBuildRoof(), val.getBuildUnit(), val.getRoomFloor(), val.getRoomId());
                    }else{
                        addrMd5 = encodeToMD5(val.getBuildRoof(), val.getBuildUnit(), val.getRoomFloor(), val.getRoomId());
                    }
                    adminFunDeptsMapper.updateMd5(val.getId(), addrMd5);
                    adminFunDeptsMapper.saveDealRecord(val.getId(), 1);
                }catch (Exception e) {
                    adminFunDeptsMapper.saveDealRecord(val.getId(), 2);
                    e.printStackTrace();
                    ++exceptionCount;
                }
            }
        }
    }

    /**
     * @title 楼盘规则的
     * @author lcb
     * @date 2020/1/6
     *
     **/
    public String encodeToMD5(Integer buildId, String roof, String unit, String floor, String num) {
        // 自建房、厂房、仓库、车库、商铺直接用楼盘名+地址生成MD5
        String enCodeStr;
        roof = null == roof ? "": roof;
        unit = null == unit ? "": unit;
        floor = null == floor ? "": floor;
        num = null == num ? "": num;

        unit = EnCodeHelper.encode(unit);
        floor = EnCodeHelper.encode(floor);
        num = EnCodeHelper.encode(num);
        roof = EnCodeHelper.encode(roof);
        enCodeStr = EnCodeHelper.ecodeByMD5(buildId + roof + "_" + unit + "_" + floor + "_" + num);
        return enCodeStr;
    }

    /**
     * @title 核心信息生成MD5
     * @author lcb
     * @date 2020/1/6
     *
     **/
    public String  encodeToMD5( String roof, String unit, String floor, String num) {
        roof = roof == null ? "" : roof.toUpperCase();
        unit = unit == null ? "" : unit.toUpperCase();
        floor = floor == null ? "" : floor.toUpperCase();
        num = num == null ? "" : num.toUpperCase();

        roof = StringUtil.getBlankStr(roof, "").toUpperCase();
        unit = StringUtil.getBlankStr(unit, "").toUpperCase();
        floor = StringUtil.getBlankStr(floor, "").toUpperCase();
        num = StringUtil.getBlankStr(num, "").toUpperCase();
        String ecodeStr = EnCodeHelper.encode(StringUtil.convertStr(roof, Constants_DIC.DIC_ROOF_REPEAT_LENGTH_LIMIT))
                + "_" + EnCodeHelper.encode(StringUtil.convertStr(unit, Constants_DIC.DIC_UNIT_REPEAT_LENGTH_LIMIT))
                + "_" + EnCodeHelper.encode(StringUtil.convertStr(floor, Constants_DIC.DIC_FLOOR_REPEAT_LENGTH_LIMIT))
                + "_" + EnCodeHelper.encode(StringUtil.convertStr(num, Constants_DIC.DIC_NUM_REPEAT_LENGTH_LIMIT));
        ecodeStr = EnCodeHelper.ecodeByMD5(ecodeStr);
        return ecodeStr;
    }


}
