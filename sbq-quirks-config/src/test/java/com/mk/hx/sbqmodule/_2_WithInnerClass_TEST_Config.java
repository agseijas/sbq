package com.mk.hx.sbqmodule;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class _2_WithInnerClass_TEST_Config {

	//java.lang.IllegalStateException: UNABLE TO FIND A @SpringBootConfiguration, YOU NEED TO USE @ContextConfiguration OR @SpringBootTest(classes=...) WITH YOUR TEST

	@Test
	public void contextLoads() {
	}

	@TestConfiguration
	public static class Conf{}
}
