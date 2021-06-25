package com.jingqingyun.reading.infra.dao;

import com.jingqingyun.mybatis.reading.model.Book;
import com.jingqingyun.reading.infra.dao.mapper.BookBizMapper;
import com.jingqingyun.reading.infra.model.CountAndSumDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * BookDao
 *
 * @author jingqingyun
 * @date 2020/10/13
 */
@Component
public class BookDao {

    @Autowired
    private BookBizMapper mapper;

    public void save(Book bookDO) {

    }

    public int sumWordAmount(int bookId) {
        return mapper.sumWordAmount(bookId);
    }

    public CountAndSumDO countArticlesAndSumWordAmount(long bookId) {
        return mapper.countArticlesAndSumWordAmount(bookId);
    }

}
