package com.github.cache.common;

/**
 * create in 2023/5/31 14:53
 *
 * @author shishaodong
 * @version 0.0.1
 */

public record UserInfoUpdateCommand(Long id, String username, String phone) {
}
