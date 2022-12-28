package com.github.spring.boot.jpa.s02_converter;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * create in 2022/12/14 14:41
 *
 * @author shishaodong
 * @version 0.0.1
 */
public interface IUserS02Repository extends JpaRepository<UserS02Entity, Long> {

    Optional<UserS02Entity> findByContacts(ContactsRecord record);


}
