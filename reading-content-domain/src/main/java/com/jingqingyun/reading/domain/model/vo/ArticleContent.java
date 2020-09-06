package com.jingqingyun.reading.domain.model.vo;

import ddd.DomainException;
import ddd.ValueObject;
import lombok.Getter;
import lombok.ToString;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * ArticleContent
 *
 * @author jingqingyun
 * @date 2020-09-08
 */
@ToString
@Getter
public class ArticleContent implements ValueObject {

    private String content;

    private List<ArticleAudio> audios;

    public ArticleContent(String content, List<ArticleAudio> audios) {
        if (StringUtils.isBlank(content)) {
            throw new DomainException("Article content must not be blank");
        }
        this.content = content;
        if (CollectionUtils.isEmpty(audios)) {
            throw new DomainException("Article audios must not be empty");
        }
        this.audios = audios;
    }

}
