package com.itheima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
            //修改端口号 信息的三种办法:
//        1.在yml配置文件中配置
//        2.在idea右上角编辑配置中的程序实参
//        3.在启动类程序中自定义参数arg配置，并将对应参数传进启动方法中

        // 斩断以上修改项目临时配置的可能(提高安全性)
        //可以在启动boot程序时断开读取外部临时配置对应的入口，也就是去掉读取外部参数的形参
        SpringApplication.run(Application.class);
    }

}
