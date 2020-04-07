package edu.suep.smart.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class SmartZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartZuulApplication.class, args);
    }

}
