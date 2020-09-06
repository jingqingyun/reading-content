package com.jingqingyun.reading.app.model.command;

import cqrs.Command;
import lombok.Data;
import com.jingqingyun.reading.app.CommandTags;

/**
 * BookCreateDTO
 *
 * @author jingqingyun
 * @date 2020/10/9
 */
@Data
public class CreateBookCommand implements Command {

    private String cnName;

    private String engName;

    private String author;

    private String description;

    private String imgUrl;

    private Byte bookType;

    private String extInfo;

    @Override
    public String tag() {
        return CommandTags.CREATE_BOOK;
    }

}
