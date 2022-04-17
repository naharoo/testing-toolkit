package com.naharoo.commons.testingtoolkit.random;

import com.naharoo.commons.testingtoolkit.random.podam.PodamAnnotationCustomizer;
import java.util.ServiceLoader;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;
import uk.co.jemos.podam.api.RandomDataProviderStrategy;

public final class RandomizationSupport {

  private static final Randomizer RANDOMIZER = new Randomizer();
  private static final PodamFactory PODAM_FACTORY = constructPodamFactory();

  private RandomizationSupport() {
    throw new IllegalAccessError("You will not pass!");
  }

  public static Randomizer randomizer() {
    return RANDOMIZER;
  }

  public static PodamFactory podamFactory() {
    return PODAM_FACTORY;
  }

  @SuppressWarnings({"rawtypes", "unchecked"})
  public static PodamFactory constructPodamFactory() {
    final PodamFactoryImpl podamFactory = new PodamFactoryImpl();
    final RandomDataProviderStrategy mainStrategy =
        (RandomDataProviderStrategy) podamFactory.getStrategy();

    final ServiceLoader<PodamAnnotationCustomizer> loadedAnnotationCustomizers =
        ServiceLoader.load(PodamAnnotationCustomizer.class);
    for (final PodamAnnotationCustomizer loadedAnnotationCustomizer : loadedAnnotationCustomizers) {
      mainStrategy.addOrReplaceAttributeStrategy(
          loadedAnnotationCustomizer.getAnnotation(),
          loadedAnnotationCustomizer.getAttributeStrategy());
    }

    return podamFactory;
  }
}
