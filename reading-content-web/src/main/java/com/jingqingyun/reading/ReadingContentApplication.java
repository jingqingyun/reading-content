package com.jingqingyun.reading;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * ReadingApplication
 *
 * @author jingqingyun
 * @date 2020-09-06
 */
@SpringBootApplication
@MapperScan("com.jingqingyun.reading.infra.dao.mapper")  // 扫描mapper接口类位置
public class ReadingContentApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReadingContentApplication.class);
    }

}
