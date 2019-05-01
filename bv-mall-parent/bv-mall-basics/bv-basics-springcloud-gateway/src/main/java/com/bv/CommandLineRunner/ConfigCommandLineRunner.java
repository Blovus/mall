package com.bv.CommandLineRunner;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigChangeListener;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @ProjectName: mall
 * @Package: com.bv.CommandLineRunner
 * @ClassName: ConfigCommandLineRunner
 * @Author: blovus
 * @Description: 配置监听
 * @Date: 2019/5/1 21:38
 * @Version: 1.0
 */
@Component
@Slf4j
public class ConfigCommandLineRunner implements CommandLineRunner {
    @ApolloConfig
    private Config config;

    @Override
    public void run(String... args) throws Exception {
        config.addChangeListener(new ConfigChangeListener() {

            @Override
            public void onChange(ConfigChangeEvent changeEvent) {
                log.info("####分布式配置中心监听#####" + changeEvent.changedKeys().toString());
            }
        });
    }

}
