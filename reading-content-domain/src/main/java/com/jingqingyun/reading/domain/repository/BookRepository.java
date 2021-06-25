package com.jingqingyun.reading.domain.repository;

import com.jingqingyun.reading.domain.model.entity.BookEntity;
import ddd.Repository;

/**
 * BookRepository
 *
 * @author jingqingyun
 * @date 2020-09-06
 */
public interface BookRepository extends Repository<BookEntity> {

    boolean save(BookEntity book);

}
