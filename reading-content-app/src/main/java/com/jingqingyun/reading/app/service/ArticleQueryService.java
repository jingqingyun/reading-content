package com.jingqingyun.reading.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jingqingyun.common.utils.ModelUtils;
import com.jingqingyun.reading.app.model.ArticleDTO;
import com.jingqingyun.reading.domain.repository.ArticleRepository;

import java.util.Optional;

/**
 * ArticleService
 *
 * @author jingqingyun
 * @date 2020-09-07
 */
@Service
public class ArticleQueryService {

    @Autowired
    private ArticleRepository articleRepository;

    public Optional<ArticleDTO> getArticle(long id) {
        return articleRepository.findById(id).map(ModelUtils.convert(ArticleDTO.class));
    }

}
