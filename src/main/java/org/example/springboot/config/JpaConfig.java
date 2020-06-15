package org.example.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing  //JPA Auditing 활성화 (Application.java에선 제거함)
public class JpaConfig {
}
