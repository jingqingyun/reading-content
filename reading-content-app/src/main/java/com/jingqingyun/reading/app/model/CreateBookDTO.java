package com.jingqingyun.reading.app.model;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * CreateBookDto
 *
 * @author jingqingyun
 * @date 2020/11/26
 */
@Data
public class CreateBookDTO {

    @Pattern(regexp = "^[a-zA-Z0-9\\u4E00-\\u9FA5]+$")
    private String cnName;

    @NotNull
    private String engName;

    private String author;

    private String description;

    private String imgUrl;

    private Byte bookType;

    private String extInfo;

}
