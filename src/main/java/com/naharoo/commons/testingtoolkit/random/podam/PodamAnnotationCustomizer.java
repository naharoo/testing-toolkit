package com.naharoo.commons.testingtoolkit.random.podam;

import java.lang.annotation.Annotation;
import uk.co.jemos.podam.common.AttributeStrategy;

public interface PodamAnnotationCustomizer<A extends Annotation, T> {

  Class<A> getAnnotation();

  AttributeStrategy<T> getAttributeStrategy();
}
