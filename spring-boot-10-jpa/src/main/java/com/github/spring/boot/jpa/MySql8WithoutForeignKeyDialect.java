package com.github.spring.boot.jpa;

import org.hibernate.dialect.MySQL8Dialect;

/**
 * 取消外键
 * <p>
 * create in 2022/5/16 14:20
 *
 * @author shishaodong
 * @version 0.0.1
 */
@SuppressWarnings({"unused"})
public class MySql8WithoutForeignKeyDialect extends MySQL8Dialect {

    @Override
    public String getAddForeignKeyConstraintString(String constraintName, String[] foreignKey, String referencedTable, String[] primaryKey, boolean referencesPrimaryKey) {
        return "";
    }

}
