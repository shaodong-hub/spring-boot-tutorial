package com.github.mongo.domain.repository;

import com.github.mongo.domain.entity.CappedDataEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * create in 2023/3/27 14:32
 *
 * @author shishaodong
 * @version 0.0.1
 */
public interface ICappedDataRepository extends PagingAndSortingRepository<CappedDataEntity, String> {
}
