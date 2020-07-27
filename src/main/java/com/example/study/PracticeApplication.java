package com.example.study;

import cn.hutool.core.io.FileUtil;
import java.io.File;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author lixiaoxiang
 */
@SpringBootApplication
public class PracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(PracticeApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner() {

        return (args) -> {
            String absolutePath = FileUtil.getAbsolutePath("static/temp/");
            System.out.println("abpath: " + absolutePath);
            File file = new File(absolutePath);

            File tempFile = FileUtil.createTempFile(FileUtil.mkdir(file));
            if (tempFile.exists()) {
                System.out.println("exist");
            }
        };
    }
}
