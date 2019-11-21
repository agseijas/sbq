package com.mk.hx.sbqmodule;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest//( classes = Object.class)
public class _1_SpringBootTestAlwaysNeedsConfiguration {

    //ERROR: `java.lang.IllegalStateException: Unable to find a @SpringBootConfiguration, you need to use @ContextConfiguration or @SpringBootTest(classes=...) with your test`

    @Test
    public void contextLoads() {
    }

    //@Configuration
    //public static class Conf{}
}
