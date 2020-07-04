package com.myfun.erpWeb.openApi;

import com.extension.framework.web.response.ResponseJson;
import com.myfun.framework.config.AppConfig;
import com.myfun.utils.rijindael.AESHelper;
import com.myfun.utils.rijindael.AESUtf8Helper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/openApi/test")
public class ConstantTest {

    @RequestMapping("/constantTest")
    public ResponseJson constantTest() {
        Map<String, String> constantMap = new HashMap<>();
        constantMap.put("partner", AppConfig.getProperty("common.companyThatObtainedTheVerificationMark.path"));
        constantMap.put("merchantSPrivateKey", AppConfig.getProperty("common.verifyTheKeyOfTheLabel.path"));
        constantMap.put("appId", AppConfig.getProperty("common.verifyTheUrlOfTheLabel.path"));
        constantMap.put("AESUtf8Helper.strDefaultKey", AESUtf8Helper.getStrDefaultKey());
        constantMap.put("AESHelper.strDefaultKey", AESHelper.getStrDefaultKey());
        return ResponseJson.SUCCESS(constantMap);
    }
}
