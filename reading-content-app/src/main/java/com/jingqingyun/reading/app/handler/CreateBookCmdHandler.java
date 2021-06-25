package com.jingqingyun.reading.app.handler;

import com.jingqingyun.common.utils.IdUtils;
import com.jingqingyun.reading.app.CommandTags;
import com.jingqingyun.reading.app.model.command.CreateBookCommand;
import com.jingqingyun.reading.domain.model.entity.BookEntity;
import com.jingqingyun.reading.domain.repository.BookRepository;
import cqrs.CommandHandler;
import ddd.EventPublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;

/**
 * CreateBookCmdHandler
 *
 * @author jingqingyun
 * @date 2020/10/10
 */
@Slf4j
@Component
public class CreateBookCmdHandler implements CommandHandler<CreateBookCommand, Long> {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private EventPublisher eventPublisher;

    @Override
    public Long handle(CreateBookCommand command) {
        long bookId = IdUtils.next();
        BookEntity book = new BookEntity(bookId, command.getCnName(), command.getEngName(), command.getAuthor(),
                command.getDescription(), command.getImgUrl(), command.getBookType(), command.getExtInfo(),
                Collections.emptyList());
        if (bookRepository.save(book)) {
            book.onCreated();
        }
        return bookId;
    }

    @Override
    public String tag() {
        return CommandTags.CREATE_BOOK;
    }

}
