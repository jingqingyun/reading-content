package com.jingqingyun.reading.app.model;

import lombok.Data;

/**
 * ArticleDTO
 *
 * @author jingqingyun
 * @date 2020-09-07
 */
@Data
public class ArticleDTO {

    private Long id;

    private Long bookId;

    private String title;

    private String description;

    private Integer wordAmount;

}
