package edu.suep.smart.monitor;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 启动器
 * @author Louis
 * @date Oct 29, 2018
 */
@EnableAdminServer
@EnableDiscoveryClient
@SpringBootApplication
public class SmartMonitorApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartMonitorApplication.class, args);
    }

}
