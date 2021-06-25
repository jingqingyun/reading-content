package com.jingqingyun.reading.infra.dao;

import com.jingqingyun.mybatis.reading.model.Article;
import com.jingqingyun.reading.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

/**
 * ArticleDaoTest
 *
 * @author jingqingyun
 * @date 2020-09-07
 */
public class ArticleDaoTest extends BaseTest {

    @Autowired
    private ArticleDao dao;

    @Test
    public void testFind() {
        Optional<Article> result = dao.findById(1L);
        Assert.assertTrue(result.isPresent());
        System.out.println(result);
    }

}
