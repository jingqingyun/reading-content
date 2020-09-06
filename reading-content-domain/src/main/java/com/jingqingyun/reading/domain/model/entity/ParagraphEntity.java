package com.jingqingyun.reading.domain.model.entity;

import ddd.Entity;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * Paragraph
 *
 * @author jingqingyun
 * @date 2020-09-06
 */
@Data
public class ParagraphEntity implements Entity<Long> {

    private Long id;

    private Long articleId;

    private Integer no;

    private Integer type;

    private String content;

    private String maleAudioUrl;

    private String femaleAudioUrl;

    private Integer maleDuration;

    private Integer femaleDuration;

    private String illustrationUrl;

    private Integer wordAmount;

    public void setContent(String content) {
        this.content = content;
        this.wordAmount = 0;
        if (StringUtils.isBlank(content)) {
            return;
        }
        for (char ch : content.toCharArray()) {
            if (ch == ' ') {
                wordAmount++;
            }
        }
    }

}
