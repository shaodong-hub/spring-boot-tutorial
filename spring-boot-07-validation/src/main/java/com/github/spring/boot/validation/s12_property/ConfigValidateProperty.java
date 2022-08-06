package com.github.spring.boot.validation.s12_property;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

/**
 * <p>
 * 创建时间为 上午10:05 2019/9/17
 * 项目名称 spring-boot-validated
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */
@Getter
@Setter
@Validated
@Component
@Profile("junit")
@ConfigurationProperties(prefix = "spring.validate")
public class ConfigValidateProperty {

    @NotBlank
    private String name;

    @NotBlank
    private String pass;

    /**
     * valid 除了能对 Controller 层参数校验外还可以对 application.properties 里面的数据进行校验
     */
    @Range(min = 11, max = 18)
    private Integer age;

}
