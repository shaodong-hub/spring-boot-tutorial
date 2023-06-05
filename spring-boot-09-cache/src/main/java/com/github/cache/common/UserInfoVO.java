package com.github.cache.common;

import java.io.Serializable;

/**
 * create in 2023/5/31 14:53
 *
 * @author shishaodong
 * @version 0.0.1
 */

public record UserInfoVO(String username, String phone) implements Serializable {
}
