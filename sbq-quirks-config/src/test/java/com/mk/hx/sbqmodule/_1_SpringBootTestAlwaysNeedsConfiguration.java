package com.mk.hx.sbqmodule;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest//( classes = Object.class)
public class _1_SpringBootTestAlwaysNeedsConfiguration {

    //ERROR: `java.lang.IllegalStateException: Unable to find a @SpringBootConfiguration, you need to use @ContextConfiguration or @SpringBootTest(classes=...) with your test`

    @Test
    public void contextLoads() {
    }

    //@Configuration
    //public static class Conf{}
}
