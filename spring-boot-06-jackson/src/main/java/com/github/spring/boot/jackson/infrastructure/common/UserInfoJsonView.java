package com.github.spring.boot.jackson.infrastructure.common;

import com.fasterxml.jackson.annotation.JsonView;
import com.github.spring.boot.jackson.infrastructure.common.view.UserDetailView;
import com.github.spring.boot.jackson.infrastructure.common.view.UserSimpleView;
import lombok.Data;

/**
 * create in 2022/7/31 22:36
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Data
public class UserInfoJsonView {

    @JsonView({UserSimpleView.class, UserDetailView.class})
    private String username;

    @JsonView({UserSimpleView.class, UserDetailView.class})
    private Integer age;

    @JsonView({UserDetailView.class})
    private String note;
}
