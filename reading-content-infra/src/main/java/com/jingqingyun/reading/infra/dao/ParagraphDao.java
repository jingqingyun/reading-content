package com.jingqingyun.reading.infra.dao;

import com.jingqingyun.mybatis.reading.model.Paragraph;
import com.jingqingyun.mybatis.reading.model.ParagraphExample;
import com.jingqingyun.reading.infra.dao.mapper.ParagraphBizMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ParagraphDao
 *
 * @author jingqingyun
 * @date 2020-09-07
 */
@Component
public class ParagraphDao {

    @Autowired
    private ParagraphBizMapper mapper;

    public List<Paragraph> findByArticleId(long articleId) {
        ParagraphExample example = new ParagraphExample();
        example.createCriteria()
                .andArticleIdEqualTo(articleId)
                .andIsDelEqualTo(0);
        return mapper.selectByExampleWithBLOBs(example);
    }

}
