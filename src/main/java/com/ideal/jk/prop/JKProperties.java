package com.ideal.jk.prop;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("jk")
@Data
public class JKProperties {

    private PropConfig propConfig;

    @Data
    public static class PropConfig {
        private String[] corsOrigins;
    }
}
