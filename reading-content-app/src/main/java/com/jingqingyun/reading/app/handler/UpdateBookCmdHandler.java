package com.jingqingyun.reading.app.handler;

import cqrs.CommandHandler;
import org.springframework.stereotype.Component;
import com.jingqingyun.reading.app.model.command.UpdateBookCommand;

/**
 * UpdateBookCmdHandler
 *
 * @author jingqingyun
 * @date 2020/10/14
 */
@Component
public class UpdateBookCmdHandler implements CommandHandler<UpdateBookCommand, Void> {

    @Override
    public Void handle(UpdateBookCommand command) {
        return null;
    }

    @Override
    public String tag() {
        return null;
    }

}
