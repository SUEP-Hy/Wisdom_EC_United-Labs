package edu.suep.smart.backup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 启动器
 * @author Louis
 * @date Oct 29, 2018
 */
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages={"edu.suep.smart"})
public class SmartBackupApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartBackupApplication.class, args);
    }

}
