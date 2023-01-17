package com.example.demo.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 服务器启动时,参数配置读取
 */

@Component
public class ParamInit implements ApplicationRunner {

    // 15:25提交,李四新增 分支名:fuq_test02
    private String fuq02;

    // 15:36提交,张三新增 分支名:fuq_test01
    private String fuq01;

    @Autowired
    private Environment environment;

    public static Map<String, String> CACHE = new HashMap<>();

    @Override
    public void run(ApplicationArguments args) throws Exception {
        CACHE.put("driver-class-name",environment.getProperty("spring.datasource.driver-class-name"));
        CACHE.put("url",environment.getProperty("spring.datasource.url"));
        CACHE.put("username",environment.getProperty("spring.datasource.username"));
        CACHE.put("password",environment.getProperty("spring.password"));
    }

    public Map<String,String> getCACHE(){
        return CACHE;
    }
}
