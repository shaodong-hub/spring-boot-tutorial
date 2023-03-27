package com.github.mongo.domain;

import org.joda.time.DateTime;
import org.springframework.stereotype.Component;

/**
 * create in 2023/3/27 12:09
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Component("auto")
public class DocumentName {

    public String getName() {
        return DateTime.now().toString("yyyy-MM-dd_HH:mm");
    }

}
