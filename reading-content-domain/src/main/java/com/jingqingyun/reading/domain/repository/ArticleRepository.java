package com.jingqingyun.reading.domain.repository;

import com.jingqingyun.reading.domain.model.entity.ArticleEntity;
import ddd.Repository;

import java.util.Optional;

/**
 * ArticleRepository
 *
 * @author jingqingyun
 * @date 2020-09-07
 */
public interface ArticleRepository extends Repository<ArticleEntity> {

    Optional<ArticleEntity> findById(long id);

}
