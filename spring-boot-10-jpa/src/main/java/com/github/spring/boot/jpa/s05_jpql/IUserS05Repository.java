package com.github.spring.boot.jpa.s05_jpql;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * create in 2022/12/14 20:26
 *
 * @author shishaodong
 * @version 0.0.1
 */

public interface IUserS05Repository extends JpaRepository<UserS05Entity, Long> {

    /**
     * findAllByAvg
     *
     * @param pageable pageable
     * @param clz      Class
     * @param <T>      Class
     * @return Class
     */
    @Query("FROM UserS05Entity AS user WHERE user.age < (SELECT AVG(p.age) FROM UserS05Entity p)")
    <T> Page<T> findAllByAvg(Pageable pageable, Class<T> clz);

    /**
     * updateLastLoginDateByUserId
     *
     * @param id id
     * @return int
     */
    @Modifying
    @Transactional(rollbackFor = Exception.class)
    @Query("UPDATE UserS05Entity AS user SET user.lastLoginDate = CURRENT_TIMESTAMP WHERE user.id = :id")
    int updateLastLoginDateByUserId(@Param("id") long id);

    /**
     * updateLoginCountByUserId
     *
     * @param id id
     * @return int
     */
    @Modifying
    @Transactional(rollbackFor = Exception.class)
    @Query("UPDATE UserS05Entity AS user SET user.loginCount = (user.loginCount + 1) WHERE user.id = :id")
    int updateLoginCountByUserId(@Param("id") long id);

//    /**
//     * replace
//     *
//     * @param id   id
//     * @param path path
//     * @return int
//     */
//    @Modifying
//    @Transactional(rollbackFor = Exception.class)
//    @Query("UPDATE UserS05Entity AS user SET user.address = FUNCTION('JSON_REPLACE', user.address,'$.path', :path) WHERE user.id = :id")
//    int replace(@Param("id") long id, @Param("path") String path);
}
