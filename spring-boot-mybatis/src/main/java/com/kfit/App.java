package com.kfit;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * spring boot启动类.
 * @author Angel -- 守护天使
 * @version v.0.1
 * @date 2017年8月16日
 */
@SpringBootApplication
@MapperScan("com.kfit.*.mapper") //需要指定包名。
//@MapperScan({"com.kfit.*.mapper","org.kfit.*.mapper"})
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
