package com.github.spring.boot.jpa.s12_json;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * create in 2023/4/19 15:09
 *
 * @author shishaodong
 * @version 0.0.1
 */
public interface IUserBookRepository extends JpaRepository<UserS12Entity, Long> {

//    @Query("SELECT user FROM UserS12Entity AS user WHERE FUNCTION('JSON_CONTAINS', user.books, :book, '$')")
//    List<UserS12Entity> findAllByData(@Param("book") String book);

//    @Query("SELECT user FROM UserS12Entity AS user WHERE :book MEMBER OF user.books")

//    @Query("FROM UserS12Entity AS user WHERE JSON_CONTAINS(user.books, :book)")

//    @Query("SELECT user  FROM UserS12Entity AS user WHERE FUNCTION('JSON_CONTAINS', user.books, '[\"data_11\"]')")
//    @Query("SELECT user  FROM UserS12Entity AS user WHERE FUNCTION('JSON_CONTAINS', user.books, CONCAT('[', :book, ']'))")
//    @Query(value = "SELECT * FROM s12_json AS user WHERE JSON_CONTAINS(user.books, '[\"?book\"]')", nativeQuery = true)
//    @Query("FROM UserS12Entity AS user WHERE JSON_CONTAINS(user.books, CONCAT('[', :book, ']'))")
//    @Query("SELECT user  FROM UserS12Entity AS user WHERE FUNCTION('JSON_CONTAINS', user.books, CONCAT('[', :book, ']'))")
//    @Query("SELECT user  FROM UserS12Entity AS user WHERE FUNCTION('JSON_CONTAINS', user.books, :book)")
//    @Query(value = "SELECT *  FROM s12_json AS user WHERE JSON_CONTAINS(user.books,  '[\"?book\"]')", nativeQuery = true)


    //    @Query(value = "SELECT * FROM s12_json AS user WHERE JSON_CONTAINS(user.books, JSON_ARRAY(:book))", nativeQuery = true)
    @Query("FROM UserS12Entity AS user WHERE FUNCTION('JSON_CONTAINS', user.books, JSON_ARRAY(:book)) = '1' ")
    List<UserS12Entity> findAllByData(@Param("book") String book);


//    @Query(value = "SELECT DISTINCT user.username FROM s12_json AS user", nativeQuery = true)
//    List<UserS12Entity> find();

}
