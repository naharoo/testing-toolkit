package com.naharoo.commons.testingtoolkit.random;

import java.util.Objects;

class DummyClass {
  private final int a;
  private final String b;

  DummyClass(int a, String b) {
    this.a = a;
    this.b = b;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DummyClass that = (DummyClass) o;
    return a == that.a && Objects.equals(b, that.b);
  }

  @Override
  public int hashCode() {
    return Objects.hash(a, b);
  }
}
