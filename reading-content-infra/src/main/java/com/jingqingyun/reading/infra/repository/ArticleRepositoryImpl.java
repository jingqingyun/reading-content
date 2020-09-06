package com.jingqingyun.reading.infra.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.jingqingyun.common.utils.ModelUtils;
import com.jingqingyun.reading.domain.model.entity.ArticleEntity;
import com.jingqingyun.reading.domain.model.entity.ParagraphEntity;
import com.jingqingyun.reading.domain.repository.ArticleRepository;
import com.jingqingyun.reading.infra.dao.ArticleDao;
import com.jingqingyun.reading.infra.dao.ParagraphDao;

import java.util.List;
import java.util.Optional;

/**
 * ArticleRepositoryImpl
 *
 * @author jingqingyun
 * @date 2020-09-07
 */
@Repository
public class ArticleRepositoryImpl implements ArticleRepository {

    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private ParagraphDao paragraphDao;

    @Override
    public Optional<ArticleEntity> findById(long id) {
        return articleDao.findById(id).map(input -> {
            ArticleEntity entity = ModelUtils.convert(input, ArticleEntity.class);
            List<ParagraphEntity> paragraphList = ModelUtils.convert(
                    paragraphDao.findByArticleId(input.getId()), ParagraphEntity.class);
            entity.setParagraphs(paragraphList);
            return entity;
        });
    }

}
