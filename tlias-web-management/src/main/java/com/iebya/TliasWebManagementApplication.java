package com.iebya;

import com.iebya.pojo.Stu;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class TliasWebManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(TliasWebManagementApplication.class, args);
    }

    @RequestMapping("/hello")
    public String hello(){
        return "Hello,world!";
    }
    @RequestMapping("/stu")
    public String stu(){
        Stu stu = new Stu("0001",99);
        return stu.toString();
    }

}
