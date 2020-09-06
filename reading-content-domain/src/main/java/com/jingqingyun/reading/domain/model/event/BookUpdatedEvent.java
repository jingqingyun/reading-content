package com.jingqingyun.reading.domain.model.event;

import ddd.Event;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * UpdateBookEvent
 *
 * @author jingqingyun
 * @date 2020/10/14
 */
@Data
@NoArgsConstructor
public class BookUpdatedEvent implements Event {

    private final String tag = "com.jingqingyun.reading.content.book.updated";

    private Long bookId;

    public BookUpdatedEvent(long bookId) {
        this.bookId = bookId;
    }

    @Override
    public String tag() {
        return tag;
    }

}
