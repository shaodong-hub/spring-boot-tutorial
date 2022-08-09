package com.github.spring.boot.validation.s15_script;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.ParameterScriptAssert;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

/**
 * create in 2022/8/6 16:15
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
@Service
@Validated
public class ScriptService {

    @ParameterScriptAssert(lang = "javascript", script = "list1.size() <= list2.size() * 2")
    public void check(List<String> list1, List<String> list2) {
        log.info("list1 size: {} list2 size: {}", list1.size(), list2.size());
    }

}
