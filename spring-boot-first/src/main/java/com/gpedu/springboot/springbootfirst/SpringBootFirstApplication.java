package com.gpedu.springboot.springbootfirst;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootFirstApplication {

    public static void main(String[] args) {
//        SpringApplication.run(SpringBootFirstApplication.class, args);

        for (int i = 20; i <= 40; ++ i) {
            System.out.println("svnadmin dump /data/export/svn/project/lucis -r "+i+"001:"+(i+1)+"000 --incremental | gzip > /data/backup/lucis_bak_"+i+"001_"+(i+1)+"000");
        }
    }

}
