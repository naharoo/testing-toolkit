package com.naharoo.commons.testingtoolkit.random;

import static com.naharoo.commons.testingtoolkit.random.RandomizationSupport.randomizer;
import static org.assertj.core.api.Assertions.assertThat;

import io.github.artsok.RepeatedIfExceptionsTest;
import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class RandomizerTest {

  @RepeatedIfExceptionsTest(repeats = 10)
  void int_() {
    final int tries = randomizer().int_(1, 20);
    final Set<Integer> set = new HashSet<>();

    for (int i = 0; i < tries; i++) {
      assertThat(set.add(randomizer().int_())).isTrue();
    }
  }

  @RepeatedIfExceptionsTest(repeats = 10)
  void int__withBoundaries() {
    final int tries = randomizer().int_(1, 20);
    final Set<Integer> set = new HashSet<>(Arrays.asList(0, 1, 2, 3, 4));

    for (int i = 0; i < tries; i++) {
      assertThat(set.contains(randomizer().int_(0, 5))).isTrue();
    }
  }

  @RepeatedIfExceptionsTest(repeats = 10)
  void long_() {
    final int tries = randomizer().int_(1, 20);
    final Set<Long> set = new HashSet<>();

    for (int i = 0; i < tries; i++) {
      assertThat(set.add(randomizer().long_())).isTrue();
    }
  }

  @RepeatedIfExceptionsTest(repeats = 10)
  void long__withBoundaries() {
    final int tries = randomizer().int_(1, 20);
    final Set<Long> set = new HashSet<>(Arrays.asList(0L, 1L, 2L, 3L, 4L));

    for (int i = 0; i < tries; i++) {
      assertThat(set.contains(randomizer().long_(0L, 5L))).isTrue();
    }
  }

  @RepeatedIfExceptionsTest(repeats = 10)
  void boolean_() {
    final int tries = randomizer().int_(1, 20);
    final Set<Boolean> set = new HashSet<>();

    for (int i = 0; i < tries; i++) {
      set.add(randomizer().boolean_());
    }

    assertThat(set).contains(true).contains(false);
  }

  @RepeatedIfExceptionsTest(repeats = 10)
  void bigDecimal() {
    final int tries = randomizer().int_(1, 20);
    final Set<BigDecimal> set = new HashSet<>();

    for (int i = 0; i < tries; i++) {
      assertThat(set.add(randomizer().bigDecimal())).isTrue();
    }
  }

  @RepeatedIfExceptionsTest(repeats = 10)
  void bigDecimal_withBoundaries() {
    final int tries = randomizer().int_(1, 20);
    final Set<BigDecimal> set = new HashSet<>();

    for (int i = 0; i < tries; i++) {
      assertThat(set.add(randomizer().bigDecimal(0.0, 100.0, 2))).isTrue();
    }
  }

  @RepeatedIfExceptionsTest(repeats = 10)
  void float_() {
    final int tries = randomizer().int_(1, 20);
    final Set<Float> set = new HashSet<>();

    for (int i = 0; i < tries; i++) {
      assertThat(set.add(randomizer().float_())).isTrue();
    }
  }

  @RepeatedIfExceptionsTest(repeats = 10)
  void double_() {
    final int tries = randomizer().int_(1, 20);
    final Set<Double> set = new HashSet<>();

    for (int i = 0; i < tries; i++) {
      assertThat(set.add(randomizer().double_())).isTrue();
    }
  }

  @RepeatedIfExceptionsTest(repeats = 10)
  void double__withBoundaries() {
    final int tries = randomizer().int_(1, 20);
    final Set<Double> set = new HashSet<>();

    for (int i = 0; i < tries; i++) {
      assertThat(set.add(randomizer().double_(0, 100))).isTrue();
    }
  }

  @RepeatedIfExceptionsTest(repeats = 10)
  void percentage() {
    final int tries = randomizer().int_(1, 20);
    final Set<BigDecimal> set = new HashSet<>();

    for (int i = 0; i < tries; i++) {
      assertThat(set.add(randomizer().percentage())).isTrue();
    }
  }

  @RepeatedIfExceptionsTest(repeats = 10)
  void money() {
    final int tries = randomizer().int_(1, 20);
    final Set<BigDecimal> set = new HashSet<>();

    for (int i = 0; i < tries; i++) {
      assertThat(set.add(randomizer().money())).isTrue();
    }
  }

  @RepeatedIfExceptionsTest(repeats = 10)
  void latitude() {
    final int tries = randomizer().int_(1, 20);
    final Set<Double> set = new HashSet<>();

    for (int i = 0; i < tries; i++) {
      final double latitude = randomizer().latitude();
      assertThat(set.add(latitude)).isTrue();
      assertThat(latitude).isBetween(-90.0, 90.0);
    }
  }

  @RepeatedIfExceptionsTest(repeats = 10)
  void longitude() {
    final int tries = randomizer().int_(1, 20);
    final Set<Double> set = new HashSet<>();

    for (int i = 0; i < tries; i++) {
      final double longitude = randomizer().longitude();
      assertThat(set.add(longitude)).isTrue();
      assertThat(longitude).isBetween(-180.0, 180.0);
    }
  }

  @RepeatedIfExceptionsTest(repeats = 10)
  void negation() {
    final int tries = randomizer().int_(1, 20);
    final Set<Integer> set = new HashSet<>();

    for (int i = 0; i < tries; i++) {
      set.add(randomizer().negation());
    }

    assertThat(set).contains(1).contains(-1).hasSize(2);
  }

  @RepeatedIfExceptionsTest(repeats = 10)
  void localDateTime() {
    final int tries = randomizer().int_(1, 20);
    final Set<LocalDateTime> set = new HashSet<>();

    for (int i = 0; i < tries; i++) {
      assertThat(set.add(randomizer().localDateTime())).isTrue();
    }
  }

  @RepeatedIfExceptionsTest(repeats = 10)
  void localDate() {
    final int tries = randomizer().int_(1, 20);
    final Set<LocalDate> set = new HashSet<>();

    for (int i = 0; i < tries; i++) {
      assertThat(set.add(randomizer().localDate())).isTrue();
    }
  }

  @RepeatedIfExceptionsTest(repeats = 10)
  void zoneId() {
    final int tries = randomizer().int_(1, 20);
    final Set<ZoneId> set = new HashSet<>();

    for (int i = 0; i < tries; i++) {
      assertThat(set.add(randomizer().zoneId())).isTrue();
    }
  }

  @RepeatedIfExceptionsTest(repeats = 10)
  void zonedDateTime() {
    final int tries = randomizer().int_(1, 20);
    final Set<ZonedDateTime> set = new HashSet<>();

    for (int i = 0; i < tries; i++) {
      assertThat(set.add(randomizer().zonedDateTime())).isTrue();
    }
  }

  @RepeatedIfExceptionsTest(repeats = 10)
  void string() {}

  @RepeatedIfExceptionsTest(repeats = 10)
  void testString() {}

  @RepeatedIfExceptionsTest(repeats = 10)
  void alphanumericString() {}

  @RepeatedIfExceptionsTest(repeats = 10)
  void alphabeticString() {}

  @RepeatedIfExceptionsTest(repeats = 10)
  void numericString() {}

  @RepeatedIfExceptionsTest(repeats = 10)
  void stringWithOnlySymbols() {}

  @RepeatedIfExceptionsTest(repeats = 10)
  void email() {}

  @RepeatedIfExceptionsTest(repeats = 10)
  void enum_() {}

  @RepeatedIfExceptionsTest(repeats = 10)
  void elementFrom_array() {
    final int tries = randomizer().int_(1, 20);
    final Set<DayOfWeek> values = new HashSet<>(Arrays.asList(DayOfWeek.values()));

    for (int i = 0; i < tries; i++) {
      final DayOfWeek instance = randomizer().elementFrom(DayOfWeek.values());
      assertThat(values.contains(instance)).isTrue();
    }
  }

  @RepeatedIfExceptionsTest(repeats = 10)
  void elementFrom_list() {
    final int tries = randomizer().int_(1, 20);
    final List<DayOfWeek> daysOfWeek = Arrays.asList(DayOfWeek.values());
    final Set<DayOfWeek> values = new HashSet<>(daysOfWeek);

    for (int i = 0; i < tries; i++) {
      final DayOfWeek instance = randomizer().elementFrom(daysOfWeek);
      assertThat(values.contains(instance)).isTrue();
    }
  }

  @RepeatedIfExceptionsTest(repeats = 10)
  void instance() {
    final int tries = randomizer().int_(1, 20);
    final Set<DummyClass> set = new HashSet<>();

    for (int i = 0; i < tries; i++) {
      final DummyClass instance = randomizer().instance(DummyClass.class);
      assertThat(instance).isNotNull();
      assertThat(set.add(instance)).isTrue();
    }
  }

  @RepeatedIfExceptionsTest(repeats = 10)
  void instances() {
    final int tries = randomizer().int_(1, 20);
    final Set<DummyClass> set = new HashSet<>();

    for (int i = 0; i < tries; i++) {
      final List<DummyClass> instances =
          randomizer().instances(DummyClass.class, randomizer().int_(1, 6));
      assertThat(instances).isNotNull();
      assertThat(set.addAll(instances)).isTrue();
    }
  }

  @RepeatedIfExceptionsTest(repeats = 10)
  void instanceOrNull() {
    final int tries = randomizer().int_(50, 80);
    final Set<DummyClass> set = new HashSet<>();

    for (int i = 0; i < tries; i++) {
      final DummyClass instance = randomizer().instanceOrNull(DummyClass.class);
      final boolean isUnique = set.add(instance);
      assertThat(instance == null || isUnique).isTrue();
    }

    assertThat(set).containsNull();
  }
}
