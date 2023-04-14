package com.github.mongo.domain.repository;

import com.github.mongo.domain.entity.AutoCreateEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * create in 2023/3/27 14:22
 *
 * @author shishaodong
 * @version 0.0.1
 */
public interface IAutoCreateRepository extends PagingAndSortingRepository<AutoCreateEntity, String> {

}
