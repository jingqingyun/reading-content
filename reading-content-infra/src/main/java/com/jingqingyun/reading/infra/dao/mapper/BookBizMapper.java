package com.jingqingyun.reading.infra.dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.jingqingyun.mybatis.reading.mapper.BookMapper;
import com.jingqingyun.reading.infra.model.CountAndSumDO;

/**
 * BookBizMapper
 *
 * @author jingqingyun
 * @date 2020/10/28
 */
@Mapper
public interface BookBizMapper extends BookMapper {

    int sumWordAmount(long bookId);

    CountAndSumDO countArticlesAndSumWordAmount(long bookId);

}
