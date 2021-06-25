package com.jingqingyun.reading.infra.repository;

import com.jingqingyun.common.utils.ModelUtils;
import com.jingqingyun.mybatis.reading.model.Book;
import com.jingqingyun.reading.domain.model.entity.BookEntity;
import com.jingqingyun.reading.domain.repository.BookRepository;
import com.jingqingyun.reading.infra.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * BookRepositoryImpl
 *
 * @author jingqingyun
 * @date 2020-09-07
 */
@Repository
public class BookRepositoryImpl implements BookRepository {

    @Autowired
    private BookDao bookDao;

    @Override
    public boolean save(BookEntity book) {
        Book record = ModelUtils.convert(book, Book.class);
        bookDao.save(record);
        return true;
    }

}
