package com.jingqingyun.reading.infra.dao;

import com.jingqingyun.reading.BaseTest;
import com.jingqingyun.reading.infra.model.CountAndSumDO;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * BookDaoTest
 *
 * @author jingqingyun
 * @date 2020/10/28
 */
public class BookDaoTest extends BaseTest {

    @Autowired
    private BookDao bookDao;

    @Test
    public void testSum() {
        int sum = bookDao.sumWordAmount(4);
        System.out.println(sum);
        Assert.assertTrue(sum > 0);
    }

    @Test
    public void countAndSum() {
        CountAndSumDO result = bookDao.countArticlesAndSumWordAmount(4L);
        System.out.println(result);
        Assert.assertNotNull(result);
    }

}
