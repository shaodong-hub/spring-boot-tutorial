package com.github.spring.boot.validation.s06_class;

import cn.hutool.core.lang.Pair;
import org.jetbrains.annotations.NotNull;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.HashMap;
import java.util.Map;

/**
 * 类级别的校验,更复杂的校验在这里做
 *
 * <p>
 * 创建时间为 下午6:20 2019/9/27
 * 项目名称 spring-boot-validated
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */
public class ClassValidValidator implements ConstraintValidator<ClassValid, UserCreateCommand> {

    private final Map<String, Pair<Integer, Integer>> map = new HashMap<>();

    {
        map.put("学士", new Pair<>(18, 25));
        map.put("硕士", new Pair<>(18, 30));
        map.put("博士", new Pair<>(18, 35));
    }

    @Override
    public boolean isValid(@NotNull UserCreateCommand value, ConstraintValidatorContext context) {
        Pair<Integer, Integer> ageRange = map.get(value.getEducation());
        return value.getAge() >= ageRange.getKey() && value.getAge() <= ageRange.getValue();
    }
}
