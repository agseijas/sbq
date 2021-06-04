package com.mk.hx.sbqmodule;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.function.Predicate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;

@ExtendWith(OutputCaptureExtension.class)
@SpringBootTest
public class _2_WithInnerClass_TEST_Config {

	@Test
	public void loadsOnlyInnerClassApp(CapturedOutput output) {
		long loadedApps = output.getOut().lines()
				.filter(contains("Scanned class : ")).count();

		assertThat(loadedApps, is(3L));
	}

	//THIS ANNOTATION BEHAVIOUR IS THE EVIDENCE OF COMPONENT SCAN MESSES (HINT: SKIPPED ON COMPONENTSCAN)
	@TestConfiguration
	public static class _____TEST_CONFIG____{
		public _____TEST_CONFIG____() {
			System.out.println("Scanned class : " + this.getClass().getName());
		}
	}

	@SpringBootApplication
	public static class _____INNERAPP____{
		public _____INNERAPP____() {
			System.out.println("Scanned class : " + this.getClass().getName());
		}
	}

	private Predicate<String> contains(String prefix) {
		return s -> s.startsWith(prefix);
	}
}
