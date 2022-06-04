package com.sbaws.book.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing //Jpa Adapting 활성화 Application.java 에서 분리해옴
public class JpaConfig {
}
