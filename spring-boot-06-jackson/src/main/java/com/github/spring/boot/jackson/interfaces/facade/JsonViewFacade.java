package com.github.spring.boot.jackson.interfaces.facade;

import com.fasterxml.jackson.annotation.JsonView;
import com.github.spring.boot.jackson.infrastructure.common.UserInfoJsonView;
import com.github.spring.boot.jackson.infrastructure.common.view.UserDetailView;
import com.github.spring.boot.jackson.infrastructure.common.view.UserSimpleView;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * create in 2022/7/31 23:06
 *
 * @author shishaodong
 * @version 0.0.1
 */
@RestController
public class JsonViewFacade {

    @JsonView(UserSimpleView.class)
    @PostMapping("SimpleView")
    public UserInfoJsonView simpleView(@RequestBody UserInfoJsonView userInfoJsonView) {
        return userInfoJsonView;
    }

    @JsonView(UserDetailView.class)
    @PostMapping("DetailView")
    public UserInfoJsonView detailView(@RequestBody UserInfoJsonView userInfoJsonView) {
        return userInfoJsonView;
    }

}
