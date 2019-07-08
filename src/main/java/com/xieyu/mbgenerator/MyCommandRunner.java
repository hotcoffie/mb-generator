package com.xieyu.mbgenerator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Description: 启动后打开指定（首页）页面
 *
 * @author 小谢
 * Date: 2019/07/08 下午 1:24
 */
@Component
public class MyCommandRunner implements CommandLineRunner {
    private static Logger logger = LoggerFactory.getLogger(MyCommandRunner.class);
    @Value("${spring.web.loginurl}")
    private String loginUrl;

    @Value("${spring.web.googleexcute}")
    private String googleExcutePath;

    @Value("${spring.auto.openurl}")
    private boolean isOpen;

    @Override
    public void run(String... args) throws Exception {
        if (isOpen) {
            String cmd = googleExcutePath + " " + loginUrl;
            Runtime run = Runtime.getRuntime();
            try {
                run.exec(cmd);
                logger.debug("启动浏览器打开项目成功");
            } catch (Exception e) {
                e.printStackTrace();
                logger.error(e.getMessage());
            }
        }
    }
}
