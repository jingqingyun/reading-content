package com.jingqingyun.reading.infra.dao;

import com.jingqingyun.common.utils.CommonUtils;
import com.jingqingyun.mybatis.reading.model.Article;
import com.jingqingyun.mybatis.reading.model.ArticleExample;
import com.jingqingyun.reading.infra.dao.mapper.ArticleBizMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * ArticleDao
 *
 * @author jingqingyun
 * @date 2020-09-07
 */
@Component
public class ArticleDao {

    @Autowired
    private ArticleBizMapper mapper;

    public Optional<Article> findById(long id) {
        ArticleExample example = new ArticleExample();
        example.createCriteria()
                .andIdEqualTo(id);
        return CommonUtils.unpackOneItemList(mapper.selectByExample(example));
    }

}
