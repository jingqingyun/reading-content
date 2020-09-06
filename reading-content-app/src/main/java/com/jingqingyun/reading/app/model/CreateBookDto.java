package com.jingqingyun.reading.app.model;

import jakarta.validation.constraints.NotNull;

/**
 * CreateBookDto
 *
 * @author jingqingyun
 * @date 2020/11/26
 */
public class CreateBookDto {

    @NotNull
    private String cnName;

    @NotNull
    private String engName;

    @NotNull
    private String author;

    private String description;

    private String imgUrl;

    private Byte bookType;

    private String extInfo;

}
