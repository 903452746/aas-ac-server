package com.apexsoft;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.thymeleaf.spring4.context.SpringWebContext;

/**
 * @Author: Dinglei
 * @Description:
 * @Date: Created in 上午10:41 2018/3/30
        * @MODIFIED BY:
        */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class TestApplication {
    public static void main(String[] args){
        SpringApplication.run(TestApplication.class, args);
    }
}
