package com.myfun.repository.support.cat;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.druid.stat.DruidStatManagerFacade;
import com.dianping.cat.status.StatusExtension;
import com.dianping.cat.status.StatusExtensionRegister;
import com.myfun.repository.support.datasource.AtomikosDataSourceBeanExt;

/**
 * 定时发送数据库链接
 *
 * @author jsg
 *
 */
public class DatasourceMonitoryManager {
    private static boolean INITED = false;

    private DatasourceMonitoryManager() {

    }

    public static void init() {
        if (!INITED) {
            INITED = true;
            StatusExtensionRegister.getInstance().register(new DatasourceStatusExtension());
            DruidStatManagerFacade statManagerFacade = DruidStatManagerFacade.getInstance();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            Thread.sleep(1 * 1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        //获取druid连接监控情况
                        try {
                            List<Map<String, Object>> dataSourceStatDataList = statManagerFacade
                                    .getDataSourceStatDataList();
                            for (Map<String, Object> map : dataSourceStatDataList) {
                                DatasourceStatusExtension.setProperties(String.valueOf(map.get("URL")),
                                        String.valueOf(map.get("ActiveCount")), String.valueOf(map.get("PoolingCount")));
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        //获取automikos连接情况
                        try {
                            Map<String, Map<String, String>> map = AtomikosDataSourceBeanExt.CONNECTION_POOLS_METRICS;
                            Collection<Map<String, String>> connectionPoolMetrics = map.values();
                            for (Map<String, String> metrics : connectionPoolMetrics) {
                                DatasourceStatusExtension.setAutomikosPoolSize(metrics);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
    }

    public static class DatasourceStatusExtension implements StatusExtension {
        private static final Map<String, String> DATASOUECE_MAP = new HashMap<String, String>();

        @Override
        public String getId() {
            return "datasource info";
        }

        @Override
        public String getDescription() {
            return "datasource pool info";
        }

        @Override
        public Map<String, String> getProperties() {
            return DATASOUECE_MAP;
        }

        /**
         * 放值
         *
         * @param url
         * @param value
         */
        public static void setProperties(String url, String activeCount, String poolSize) {
            StringBuffer sb = new StringBuffer();
            try {
                String[] splitsArray = url.split(";");
                for (int i = 0; i < splitsArray.length; i++) {
                    String tStr = splitsArray[i].toUpperCase();
                    if (i == 0) {
                        sb.append(tStr.substring(tStr.lastIndexOf(".") + 1)).append(":");
                    } else if (tStr.startsWith("DATABASENAME")) {
                        sb.append(tStr.split("=")[1]);
                        break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (sb.length() > 0) {
                DATASOUECE_MAP.put(sb.append(":ACTIVE").toString(), activeCount);
                DATASOUECE_MAP.put(sb.append(":POOLSIZE").toString(), poolSize);
            }
        }

        /**
         * 存放连接池数据
         * @param metrics
         */
        public static void setAutomikosPoolSize(Map<String, String> metrics){
            if(metrics != null && metrics.size() > 0){
                DATASOUECE_MAP.putAll(metrics);
            }
        }

    }
}