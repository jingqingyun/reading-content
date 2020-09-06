package com.jingqingyun.reading.domain.model.vo;

import ddd.ValueObject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * ArticleAudio
 *
 * @author jingqingyun
 * @date 2020/10/12
 */
@Getter
@ToString
@AllArgsConstructor
public class ArticleAudio implements ValueObject {

    private String url;

    private Integer length;

}
