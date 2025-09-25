package kr.co.ch09.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //cors 설정: API 요청을 하는 외부 요청 origin 설정
        registry
                .addMapping("/**") //모든 엔드포인트에 대해 허용
                .allowedOriginPatterns("http://192.168.56.1:5500") //서버의 요청을 허용할 Origin
                .allowedHeaders("*") //모든 헤더 허용
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") //허용할 메서드
                .allowCredentials(true) //자격증명 허용
                .maxAge(3600); //3.6초 요청 유효시간
    }
}
