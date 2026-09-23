package kz.iitu.springlab.config;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.validation.annotation.Validated;

@Validated
@ConfigurationProperties(prefix = "app")
public record AppProperties(

        @Valid Pagination pagination,

        String owner,
        String group,
        @Valid Mail mail) {

    public record Pagination(
            @Min(1)
            @Max(100)
            @DefaultValue("10")
            int defaultSize,

            @Min(1)
            @Max(500)
            @DefaultValue("100")
            int maxSize) {
    }

    public record Mail(
            String from,
            int retryCount,
            java.time.Duration timeout,
            boolean enabled) {
    }
}