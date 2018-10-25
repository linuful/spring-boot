package demo.example;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(DemoService.class)
@EnableConfigurationProperties(DemoService.class)
public class DemoAutoConfiguration {


    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = "amazon",value = "enabled",havingValue = "true")
    //当配置文件中 amazon.enabled=true 时
    DemoService demoService (){
        return  new DemoService();
    }


    @Bean
    DemoRunner demoRunner(){
        return new DemoRunner();
    }



}
