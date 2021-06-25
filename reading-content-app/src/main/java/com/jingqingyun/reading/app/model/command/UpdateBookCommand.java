package com.jingqingyun.reading.app.model.command;

import com.jingqingyun.reading.app.CommandTags;
import cqrs.Command;
import lombok.Data;

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
