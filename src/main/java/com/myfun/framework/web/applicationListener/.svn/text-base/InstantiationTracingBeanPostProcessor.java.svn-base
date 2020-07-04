package com.myfun.framework.web.applicationListener;

import com.dianping.cat.Cat;
import com.myfun.framework.web.filter.CaptureFilter;
import com.myfun.repository.support.cat.DatasourceMonitoryManager;
import com.myfun.utils.KafkaBizUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * 图片识别自动启动
 *
 * @author 张卓
 * @ClassName: InstantiationTracingBeanPostProcessor
 * @Description: TODO
 */
@Component
public class InstantiationTracingBeanPostProcessor implements ApplicationListener<ContextRefreshedEvent> {

    private Boolean init = false;

    @Value(value = "${common.cat.monitor.server}")
    private String commonCatMonitorServer;

    @Autowired
    private CaptureFilter captureFilter;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (init == false) {
            init = true;
            captureFilter.initKafkaWriteAccessLogThread();
            Cat.initialize(commonCatMonitorServer);
            DatasourceMonitoryManager.init();
            new KafkaBizUtils().initKafkaThread();
//            KafkaManager.setApplicationName(AppConfig.getProperty("spring.application.name"));
        }
    }

}
