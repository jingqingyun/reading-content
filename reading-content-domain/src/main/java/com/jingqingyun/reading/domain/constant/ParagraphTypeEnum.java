package com.jingqingyun.reading.domain.constant;

/**
 * ParagraphTypeEnum
 *
 * @author jingqingyun
 * @date 2019-09-04
 */

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

/**
 * 段落类型枚举
 * 空段落和空段落不计算单词数
 */
@Getter
@AllArgsConstructor
public enum ParagraphTypeEnum {
    /**
     * 普通段落
     */
    NORMAL(0),
    /**
     * 对话
     */
    DIALOG(1),
    /**
     * 标题
     */
    TITLE(2),
    /**
     * 空白
     */
    BLANK(3),
    /**
     * 信件
     */
    LETTER(4),
    /**
     * 落款
     */
    SIGN(5),
    /**
     * 金句
     */
    GOLD(6);

    private int index;

    public static ParagraphTypeEnum valueOf(int index) {
        return Stream.of(values()).filter(e -> e.index == index).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No such ParagraphTypeEnum index"));
    }

}