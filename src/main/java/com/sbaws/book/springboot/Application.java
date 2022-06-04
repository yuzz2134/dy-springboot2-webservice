package com.sbaws.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//@EnableJpaAuditing //Auditing 활성화
@SpringBootApplication
public class Application {
        public static void main(String[] args) {
            SpringApplication.run(Application.class, args);
            //내장 was실행
        }





}
