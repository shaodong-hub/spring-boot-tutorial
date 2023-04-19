package com.github.spring.boot.jpa.s11_annotation.parent;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.Parent;

import java.io.Serializable;

/**
 * create in 2023/4/13 23:18
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Getter
@Setter
@Embeddable
public class Name implements Serializable {

    @Comment("first_name")
    @Column(name = "first_name", nullable = false, columnDefinition = "CHAR(20)")
    String firstName;

    @Comment("last_name")
    @Column(name = "last_name", nullable = false, columnDefinition = "CHAR(20)")
    String lastName;

    @Parent
    UserEntity user;
}
