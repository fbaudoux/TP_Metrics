package com.systel.dojoservice;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;

/**
 *
 */
@SpringBootApplication
@EnableSwagger2
public class DojoServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DojoServiceApplication.class, args);
    }


    @Bean
    public Docket api10() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("dojo-api-1.0")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.systel.dojoservice.infrastructure.rest"))
                .paths(PathSelectors.regex("/.*"))
                .build()
                .apiInfo(new ApiInfoBuilder().version("1").title("Dojo API").description("Documentation Dojo API v1").build());
    }

    @Configuration
    @EnableWebSecurity
    @EnableGlobalMethodSecurity(prePostEnabled = true)
    private static class WebSecurityConfig extends WebSecurityConfigurerAdapter {

        public WebSecurityConfig() {

        }


        @Override
        protected void configure(HttpSecurity httpSecurity) throws Exception {
            httpSecurity.cors().and().csrf().disable().authorizeRequests().antMatchers(HttpMethod.GET, "/",
                                                                                       "/favicon.ico", "/**/*.css", "/**/*.js", "/auth", "/index.html", "/**/login.html", "/**/*.svg"

            ).permitAll().anyRequest().permitAll();

            // disable page caching
            httpSecurity.headers().cacheControl();
            //httpSecurity.addFilterBefore(new JwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        }

        @Bean
        CorsConfigurationSource corsConfigurationSource() {
            CorsConfiguration configuration = new CorsConfiguration();
            configuration.setAllowedOrigins(Arrays.asList("*"));
            configuration.setAllowedMethods(Arrays.asList("GET", "POST", "OPTIONS", "PUT", "DELETE", "PATCH"));
            configuration.addAllowedHeader("*");
            UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
            source.registerCorsConfiguration("/**", configuration);
            return source;
        }
    }
}
