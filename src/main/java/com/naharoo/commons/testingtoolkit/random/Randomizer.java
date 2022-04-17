package com.naharoo.commons.testingtoolkit.random;

import static com.naharoo.commons.testingtoolkit.random.RandomizationSupport.podamFactory;

import com.naharoo.commons.testingtoolkit.random.podam.PodamAnnotationCustomizer;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

/**
 * Randomization Utilities.
 *
 * <p>For regular usage just get an instance of this class using {@link
 * RandomizationSupport#randomizer()} and call its methods. That's it.
 */
public final class Randomizer {

  private static final int RANDOM_STRING_LENGTH = 255;

  /** Only for internal use */
  Randomizer() {}

  /**
   * Creates random int
   *
   * @return created int
   */
  public int int_() {
    return RandomUtils.nextInt();
  }

  /**
   * Creates random int between provided boundaries
   *
   * @param startInclusive left boundary inclusively
   * @param endExclusive right boundary exclusively
   * @return created int
   */
  public int int_(final int startInclusive, final int endExclusive) {
    return RandomUtils.nextInt(startInclusive, endExclusive);
  }

  /**
   * Creates random long
   *
   * @return created long
   */
  public long long_() {
    return RandomUtils.nextLong();
  }

  /**
   * Creates random long between provided boundaries
   *
   * @param startInclusive left boundary inclusively
   * @param endExclusive right boundary exclusively
   * @return created long
   */
  public long long_(final Long startInclusive, final Long endExclusive) {
    return RandomUtils.nextLong(startInclusive, endExclusive);
  }

  /**
   * Creates random boolean
   *
   * @return created boolean
   */
  public boolean boolean_() {
    return RandomUtils.nextBoolean();
  }

  /**
   * Creates a random BigDecimal with provided scale and in between of provided boundaries
   *
   * @param startInclusive left boundary inclusively
   * @param endExclusive right boundary exclusively
   * @param scale results scale
   * @return created BigDecimal
   */
  public BigDecimal bigDecimal(
      final double startInclusive, final double endExclusive, final int scale) {
    return BigDecimal.valueOf(RandomUtils.nextDouble(startInclusive, endExclusive))
        .setScale(scale, RoundingMode.HALF_UP);
  }

  /**
   * Creates a random BigDecimal
   *
   * @return created BigDecimal
   */
  public BigDecimal bigDecimal() {
    return BigDecimal.valueOf(int_());
  }

  /**
   * Creates a random float
   *
   * @return created float
   */
  public float float_() {
    return RandomUtils.nextFloat();
  }

  /**
   * Creates a random double
   *
   * @return created double
   */
  public double double_() {
    return RandomUtils.nextDouble();
  }

  /**
   * Creates a random double between provided boundaries
   *
   * @param startInclusive left boundary inclusively
   * @param endExclusive right boundary exclusively
   * @return created double
   */
  public double double_(final int startInclusive, final int endExclusive) {
    return RandomUtils.nextDouble(startInclusive, endExclusive);
  }

  /**
   * Creates a random BigDecimal with percentage value
   *
   * @return created percentage BigDecimal
   */
  public BigDecimal percentage() {
    return BigDecimal.valueOf(RandomUtils.nextDouble(0, 100)).setScale(2, RoundingMode.HALF_UP);
  }

  /**
   * Creates a random BigDecimal with money value between 0 and 10_000
   *
   * @return created money BigDecimal
   */
  public BigDecimal money() {
    return BigDecimal.valueOf(RandomUtils.nextDouble(0, 10000)).setScale(2, RoundingMode.HALF_UP);
  }

  /**
   * Creates a random double with geo-latitude value
   *
   * @return created geo-latitude double
   */
  public double latitude() {
    return RandomUtils.nextDouble(0, 90) * negation();
  }

  /**
   * Creates a random double with geo-longitude value
   *
   * @return created geo-longitude double
   */
  public double longitude() {
    return RandomUtils.nextDouble(0, 180) * negation();
  }

  /**
   * Creates a random int with 1 or -1 value
   *
   * @return created int
   */
  public int negation() {
    if (boolean_()) {
      return 1;
    }
    return -1;
  }

  /**
   * Creates a random LocalDateTime
   *
   * @return created LocalDateTime
   */
  public LocalDateTime localDateTime() {
    return LocalDateTime.now()
        .plusSeconds(negation() * long_(0L, 3600 * 24 * 1000L))
        .truncatedTo(ChronoUnit.MILLIS);
  }

  /**
   * Creates a random LocalDate
   *
   * @return created LocalDate
   */
  public LocalDate localDate() {
    return localDateTime().toLocalDate();
  }

  /**
   * Create a random ZoneId
   *
   * @return created ZoneId
   */
  public ZoneId zoneId() {
    final List<ZoneId> zoneIds =
        ZoneId.getAvailableZoneIds().stream().map(ZoneId::of).collect(Collectors.toList());
    return elementFrom(zoneIds);
  }

  /**
   * Creates a random ZonedDateTime
   *
   * @return created ZonedDateTime
   */
  public ZonedDateTime zonedDateTime() {
    return ZonedDateTime.of(localDateTime(), zoneId());
  }

  /**
   * Creates a random String.
   *
   * @return created string
   */
  public String string() {
    return string(RANDOM_STRING_LENGTH);
  }

  /**
   * Creates a random String with a provided length.
   *
   * @param length length of the resulting string
   * @return created string
   */
  public String string(final int length) {
    return RandomStringUtils.randomAscii(length);
  }

  /**
   * Creates a random String containing only letters and numbers.
   *
   * @param length length of the resulting string
   * @return created alphanumeric string
   */
  public String alphanumericString(final int length) {
    return RandomStringUtils.randomAlphanumeric(length);
  }

  /**
   * Creates a random String containing only letters.
   *
   * @param length length of the resulting string
   * @return created alphabetic string
   */
  public String alphabeticString(final int length) {
    return RandomStringUtils.randomAlphabetic(length);
  }

  /**
   * Creates a random String containing only numbers.
   *
   * @param length length of the resulting string
   * @return created numeric string
   */
  public String numericString(final int length) {
    return RandomStringUtils.randomNumeric(length);
  }

  /**
   * Creates a random String.
   *
   * @param length length of the resulting string
   * @return created string with only symbols
   */
  public String stringWithOnlySymbols(final int length) {
    return RandomStringUtils.random(length, false, false);
  }

  /**
   * Creates a random String with valid email value.
   *
   * @return created string with email value
   */
  public String email() {
    return String.format(
        "%s@%s.com", RandomStringUtils.randomAlphabetic(10), RandomStringUtils.randomAlphabetic(5));
  }

  /**
   * Randomly gets an Enum instance from provided Enum Class' universe excluding provided values.
   *
   * @param enumClass enum class to get element from
   * @return random enum instance
   */
  @SuppressWarnings("unchecked")
  public <T extends Enum<T>> T enum_(final Class<T> enumClass, final T... excluding) {
    final List<T> excludedValues = Arrays.asList(excluding);
    final List<T> valuesList = new ArrayList<>(Arrays.asList(enumClass.getEnumConstants()));
    valuesList.removeIf(excludedValues::contains);
    return valuesList.get(int_(0, valuesList.size()));
  }

  /**
   * Randomly gets an element from provided Array.
   *
   * @param values an array to get value from
   * @return random array member
   */
  public <T> T elementFrom(final T[] values) {
    if (values.length == 0) {
      return null;
    }
    return values[int_(0, values.length)];
  }

  /**
   * Randomly gets an element from provided List.
   *
   * @param values a list to get value from
   * @return random list member
   */
  public <T> T elementFrom(final List<T> values) {
    if (values.isEmpty()) {
      return null;
    }
    return values.get(int_(0, values.size()));
  }

  /**
   * Creates a random instance of the provided class. Internally uses PodamFactory which can be
   * customized using {@link PodamAnnotationCustomizer}s.
   *
   * @param clazz provided class to be used to create its instance
   * @param <T> instance type to be created
   * @return created instance
   */
  public <T> T instance(final Class<T> clazz) {
    return podamFactory().manufacturePojo(clazz);
  }

  /**
   * Creates a list of random instances of the provided class. Internally uses PodamFactory which
   * can be customized using {@link PodamAnnotationCustomizer}s.
   *
   * @param clazz provided class to be used to create its instance
   * @param count count of instances to be created
   * @param <T> instance type to be created
   * @return created instances list
   */
  public <T> List<T> instances(final Class<T> clazz, final int count) {
    return Stream.generate(() -> podamFactory().manufacturePojo(clazz))
        .limit(count)
        .collect(Collectors.toList());
  }

  /**
   * Creates a random instance of the provided class or simply returns null with 12.5% probability.
   * Internally uses PodamFactory which can be customized using {@link PodamAnnotationCustomizer}s.
   *
   * @param clazz provided class to be used to create its instance
   * @param <T> instance type to be created
   * @return created instance or null
   */
  public <T> T instanceOrNull(final Class<T> clazz) {
    // 12.5% chance to return null
    if (boolean_() && boolean_() && boolean_()) {
      return null;
    }
    return podamFactory().manufacturePojo(clazz);
  }
}
