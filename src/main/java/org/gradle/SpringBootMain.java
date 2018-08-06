package org.gradle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @SpringBootApplication 注解可以让SpringBoot为我们按照默认约定进行所有的应用初始化配置，
 * 本类是在项目中唯一一个包含main方法的类，通常我们将该类创建在项目包的根目录下，
 * 在测试过程中，我们可以通过运行此类来运行SpringBoot应用
 */
@SpringBootApplication
public class SpringBootMain {
      public static void main(String[] args) {
		SpringApplication.run(SpringBootMain.class, args);
	}
}
