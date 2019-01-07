package com.jyj.tt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.jyj.tt.dao")//对应项目中mapper（dao）所对应的包路径
public class TTApplication {
    public static void main(String[] args) {
        SpringApplication.run(TTApplication.class, args);
    }
}
