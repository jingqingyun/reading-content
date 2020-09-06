package com.jingqingyun.reading.domain.model.event;

import ddd.Event;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * CreateBookEvent
 *
 * @author jingqingyun
 * @date 2020/10/13
 */
@Data
@NoArgsConstructor
public class BookCreatedEvent implements Event {

    private final String tag = "com.jingqingyun.reading.content.book.created";

    private Long bookId;

    public BookCreatedEvent(Long bookId) {
        this.bookId = bookId;
    }

    @Override
    public String tag() {
        return tag;
    }

}
