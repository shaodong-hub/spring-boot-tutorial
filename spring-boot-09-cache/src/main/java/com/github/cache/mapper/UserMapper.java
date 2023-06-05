package com.github.cache.mapper;

import com.github.cache.common.UserInfoVO;
import com.github.cache.entity.UserInfoEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * create in 2023/5/31 15:42
 *
 * @author shishaodong
 * @version 0.0.1
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class UserMapper {

    @Contract("_ -> new")
    public static @NotNull UserInfoVO map(@NotNull UserInfoEntity entity) {
        return new UserInfoVO(entity.getUsername(), entity.getPhone());
    }

}
