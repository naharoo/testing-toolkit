package com.naharoo.commons.testingtoolkit.random.podam;

import static com.naharoo.commons.testingtoolkit.random.RandomizationSupport.randomizer;

import javax.validation.constraints.Email;
import uk.co.jemos.podam.common.AttributeStrategy;

public class JavaxValidationEmailAnnotationPodamCustomizer
    implements PodamAnnotationCustomizer<Email, String> {

  @Override
  public Class<Email> getAnnotation() {
    return Email.class;
  }

  @Override
  public AttributeStrategy<String> getAttributeStrategy() {
    return (type, annotations) -> randomizer().email();
  }
}
