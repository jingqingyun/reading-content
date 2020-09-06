package com.jingqingyun.reading.app.model.command;

import cqrs.Command;
import lombok.Data;
import com.jingqingyun.reading.app.CommandTags;

/**
 * UpdateBookCommand
 *
 * @author jingqingyun
 * @date 2020/10/14
 */
@Data
public class UpdateBookCommand implements Command {

    @Override
    public String tag() {
        return CommandTags.UPDATE_BOOK;
    }

}
