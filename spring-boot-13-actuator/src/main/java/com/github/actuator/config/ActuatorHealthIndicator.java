package com.github.actuator.config;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 创建时间为 15:39-2019-03-21
 * 项目名称 SpringBootActuator
 * </p>
 *
 * @author shao
 * @version 0.0.1
 * @since 0.0.1
 */


@Component("ActHealth")
public class ActuatorHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        return Health.up().withDetail("up", "spring boot up").build();
    }
}
