package com.mk.hx.sbqmodule;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.function.Predicate;

import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.system.OutputCaptureRule;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class _1_RegularSpringBootTestWithApp {

    @ClassRule
    public static final OutputCaptureRule output = new OutputCaptureRule();

    @Test
    public void loadsOnlyInnerClassApp() {
        long loadedApps = output.getOut().lines()
                .filter(contains("Scanned class : ")).count();

        assertThat(loadedApps, is(1L));
    }

    // GETS LOADED AND THEN PERFORMS A @ComponentScan FINDING EVERYTHING ELSE LIKE ___PRODUCTION_APP___ AND ___RANDOM_CONFIGURATION___
    @SpringBootApplication
    public static class _____INNERAPP____ {
        public _____INNERAPP____() {
            System.out.println("Scanned class : " + this.getClass().getName());
        }
    }

    private Predicate<String> contains(String prefix) {
        return s -> s.startsWith(prefix);
    }
}
