package com.g_util;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Random;

public class MyStringUtil {
    private static final Logger logger = LogManager.getLogger(MyStringUtil.class);
    public static String getVerifyCode(){
        //生成6位验证码，先使用random获取0~899999的数，在统一加上100000，保证肯定是六位
        String verifyCode = String
                .valueOf(new Random().nextInt(899999) + 100000);
        logger.info("短信验证码生成：" + verifyCode);
        return verifyCode;
    }
}
