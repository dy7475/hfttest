package com.myfun.repository.support.datasource;

import org.apache.commons.lang.StringUtils;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 增加连接池监控
 * 
 * @author jsg
 *
 */
public class AtomikosDataSourceBeanExt extends AtomikosDataSourceBean {
    private static final long serialVersionUID = 1L;
    /** 存放所有连接池 **/
    private static List<AtomikosDataSourceBeanExt> CONNECTION_POOLS = new ArrayList<AtomikosDataSourceBeanExt>();

    /** 存放所有连接池监控信息 **/
    public static Map<String, Map<String, String>> CONNECTION_POOLS_METRICS = new HashMap<String, Map<String, String>>();

    private static boolean INIT_MONITOR_FLAG = false;

    public AtomikosDataSourceBeanExt() {
        super();
        CONNECTION_POOLS.add(this);

        if (!INIT_MONITOR_FLAG) {
            INIT_MONITOR_FLAG = true;
            new Thread(new AtomikosMonitorThread()).start();
        }
    }

    /**
     * 监控连接池信息
     * 
     * @author jsg
     *
     */
    static class AtomikosMonitorThread implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {

                    for (AtomikosDataSourceBeanExt atomikosDataSourceBeanExt : CONNECTION_POOLS) {
                        if (atomikosDataSourceBeanExt.getXaDataSource() != null) {
                            try {
                                Map<String, String> metrics = CONNECTION_POOLS_METRICS
                                        .get(atomikosDataSourceBeanExt.getUniqueResourceName());
                                if (metrics == null) {
                                    metrics = new HashMap<>();
                                    CONNECTION_POOLS_METRICS.put(atomikosDataSourceBeanExt.getUniqueResourceName(),
                                            metrics);
                                }
                                metrics.put(atomikosDataSourceBeanExt.getUniqueResourceName() + ":ATOMIKOS:TOTALSIZE", String.valueOf(atomikosDataSourceBeanExt.poolTotalSize()));
                                metrics.put(atomikosDataSourceBeanExt.getUniqueResourceName() + ":ATOMIKOS:AVAILABLESIZE", String.valueOf(atomikosDataSourceBeanExt.poolAvailableSize()));
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    // 1秒取一次指标
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(String.valueOf(null));
    }
}
