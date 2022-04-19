package com.naharoo.commons.testingtoolkit.random.podam;

import static com.naharoo.commons.testingtoolkit.random.RandomizationSupport.randomizer;
import static java.util.regex.Pattern.CASE_INSENSITIVE;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.regex.Pattern;
import javax.validation.constraints.Email;
import org.junit.jupiter.api.Test;

class JavaxValidationEmailAnnotationPodamCustomizerTest {

  public static final Pattern PATTERN =
      Pattern.compile("^\\w+([.-]?\\w+)*@\\w+([.-]?\\w+)*(\\.\\w{2,3})+$", CASE_INSENSITIVE);
  private final JavaxValidationEmailAnnotationPodamCustomizer customizer =
      new JavaxValidationEmailAnnotationPodamCustomizer();

  @Test
  void getAnnotation() {
    assertThat(customizer.getAnnotation()).isEqualTo(Email.class);
  }

  @Test
  void test() {
    final DummyClass instance = randomizer().instance(DummyClass.class);
    assertThat(instance).isNotNull();
    assertThat(instance.value).isNotNull().matches(PATTERN);
  }

  public static class DummyClass {
    final String value;

    public DummyClass(@Email String value) {
      this.value = value;
    }
  }
}
