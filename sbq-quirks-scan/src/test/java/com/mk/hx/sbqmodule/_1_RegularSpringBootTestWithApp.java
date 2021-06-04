package com.mk.hx.sbqmodule;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.function.Predicate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;

@ExtendWith(OutputCaptureExtension.class)
@SpringBootTest
public class _1_RegularSpringBootTestWithApp {


    @Test
    public void loadsOnlyInnerClassApp(CapturedOutput output) {
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
