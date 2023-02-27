package com.github.spring.boot.jpa.s08_one_to_many;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

/**
 * create in 2022/12/14 13:04
 *
 * @author shishaodong
 * @version 0.0.1
 */
public interface IUserS08Repository extends JpaRepository<UserS08Entity, Long> {

    @Query("FROM UserS08Entity AS user WHERE user.id IN (SELECT DISTINCT image.userId FROM ImageS08Entity AS image WHERE image.id = 1)")
    List<UserS08Entity> findByBannersContains();

    @Query("SELECT new com.github.spring.boot.jpa.s08_one_to_many.UserS08VO(user.id,user.username) " +
            "FROM UserS08Entity AS user WHERE user.id IN " +
            "(SELECT DISTINCT image.userId FROM ImageS08Entity AS image WHERE image.id = 1)")
    List<UserS08VO> findByBannersByImages();

    @Query("FROM ImageS08Entity AS image WHERE image.id = 1")
    Optional<ImageS08Entity> findImage();

}
