package com.ict.finalspringboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ResourceConfig implements WebMvcConfigurer {
   @Override
   public void addResourceHandlers(ResourceHandlerRegistry registry) {
       registry.addResourceHandler("/upload/**") // URL 경로
               .addResourceLocations("file:C:/upload/") // 실제 경로
               .setCachePeriod(3600); // 캐시 기간(초)
   }

   @Override
   public void addCorsMappings(CorsRegistry registry) {
      registry.addMapping("/**") // 모든 경로 허용
               .allowedOrigins("http://localhost:3000") // 허용할 도메인
               .allowedMethods("GET", "POST", "PUT", "DELETE") // 허용할 HTTP 메서드
               .allowedHeaders("*") // 모든 헤더 허용
               .allowCredentials(true); // 인증 정보 허용
   }
}