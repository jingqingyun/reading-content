package com.jingqingyun.reading.domain.model.entity;

import com.jingqingyun.reading.domain.model.event.BookCreatedEvent;
import com.jingqingyun.reading.domain.model.event.BookUpdatedEvent;
import ddd.AggregateRoot;
import ddd.EventPublisher;
import ddd.EventPublisherDelegate;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Book
 *
 * @author jingqingyun
 * @date 2020-08-28
 */
@ToString
@Getter
public class BookEntity implements AggregateRoot<Long> {

    private Long id;

    private String cnName;

    private String engName;

    private String author;

    private String description;

    private String imgUrl;

    private Integer bookType;

    private String extInfo;

    private List<ArticleEntity> articles;

    private Integer wordAmount;

    private Map<Integer, ArticleEntity> chapterArticleMap;

    private final EventPublisher eventPublisher = EventPublisherDelegate.instance();

    public BookEntity(long id, String cnName, String engName, String author, String description, String imgUrl,
            int bookType, String extInfo, List<ArticleEntity> articles) {
        this.id = id;
        this.cnName = cnName;
        this.engName = engName;
        this.author = author;
        this.description = description;
        this.imgUrl = imgUrl;
        this.bookType = bookType;
        this.extInfo = extInfo;
        setArticles(articles);
    }

    public ArticleEntity getArticleOfChapter(int chapter) {
        return chapterArticleMap.get(chapter);
    }

    public void setArticles(List<ArticleEntity> articles) {
        this.articles = articles;
        this.chapterArticleMap = articles.stream()
                .collect(Collectors.toMap(ArticleEntity::getChapter, Function.identity()));
        this.wordAmount = articles.stream().mapToInt(ArticleEntity::getWordAmount).sum();
    }

    public void onCreated() {
        eventPublisher.publish(new BookCreatedEvent(id));
    }

    public void onUpdated() {
        eventPublisher.publish(new BookUpdatedEvent(id));
    }

}
