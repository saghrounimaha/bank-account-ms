package net.maha.customerservice.Config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@RefreshScope
@ConfigurationProperties(prefix = "global.params")
@Getter @Setter @AllArgsConstructor  @NoArgsConstructor
public class GlobalConfig {
    private int p1;
    private int p2;
}
