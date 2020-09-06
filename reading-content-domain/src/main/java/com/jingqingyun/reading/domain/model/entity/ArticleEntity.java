package com.jingqingyun.reading.domain.model.entity;

import ddd.DomainException;
import ddd.Entity;
import lombok.Data;
import org.apache.commons.collections.CollectionUtils;
import com.jingqingyun.reading.domain.model.vo.ArticleAudio;
import com.jingqingyun.reading.domain.model.vo.ArticleContent;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Article
 *
 * @author jingqingyun
 * @date 2020-09-06
 */
@Data
public class ArticleEntity implements Entity<Long> {

    private Long id;

    private Long bookId;

    private Integer chapter;

    private String title;

    private String description;

    private List<ParagraphEntity> paragraphs;

    private ArticleContent articleContent;

    private Integer wordAmount;

    private LocalDateTime createAt;

    private LocalDateTime updateAt;

    public void setParagraphs(List<ParagraphEntity> paragraphs) {
        if (CollectionUtils.isEmpty(paragraphs)) {
            throw new DomainException("Article paragraphs must not be empty");
        }
        this.paragraphs = paragraphs;
        this.wordAmount = paragraphs.stream().mapToInt(ParagraphEntity::getWordAmount).sum();
        buildArticleContent();
    }

    private void buildArticleContent() {
        this.articleContent = getArticleContent();
        StringBuilder stringBuilder = new StringBuilder();
        List<ArticleAudio> audios = new ArrayList<>(this.paragraphs.size());
        for (ParagraphEntity paragraph : this.paragraphs) {
            stringBuilder.append(paragraph.getContent());
            audios.add(new ArticleAudio(paragraph.getMaleAudioUrl(), paragraph.getMaleDuration()));
        }
        this.articleContent = new ArticleContent(stringBuilder.toString(), audios);
    }

}
