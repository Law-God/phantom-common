package com;

import com.phantom.common.SpringContextUtil;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;

/**
 * Created by Administrator on 2017-05-08.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-common.xml"})
public class SrpingContextUtilTest {

    @Test
    public void construct(){
        SpringContextUtil scu = new SpringContextUtil();
    }

    @Test
    public void test(){
        DataSource dataSource = (DataSource)SpringContextUtil.getBean("dataSource");
        Assert.assertNotNull(dataSource);

        Object dataSource2 = SpringContextUtil.getBean("dataSource",DataSource.class);
        Assert.assertTrue(dataSource2 instanceof DataSource);
        Assert.assertFalse(dataSource2 instanceof SrpingContextUtilTest);

        Assert.assertTrue(SpringContextUtil.containsBean("dataSource"));
        Assert.assertFalse(SpringContextUtil.containsBean("srpingContextUtilTest"));

        boolean isSingleton = SpringContextUtil.isSingleton("dataSource");
        Assert.assertTrue(isSingleton);

        String[] aliases = SpringContextUtil.getAliases("dataSource");
        Assert.assertEquals("dataSourceAlias",aliases[0]);
    }


}
