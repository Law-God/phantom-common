package com;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * Created by Administrator on 2017-05-02.
 */
public class Log4jTest {
    Logger log = Logger.getLogger(Log4jTest.class);
    @Test
    public void test(){
        for(int i=0;i<100;i++){
            log.debug("debug");
        }
    }
}
