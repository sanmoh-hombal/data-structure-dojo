package org.sanmoh.Arrays;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

public class StaticArrayTest {
  @Test
  public void insert() {
    StaticArray<Integer> array = new StaticArray<>(10);
    array.insert(1, 0);
    assertArrayEquals(new Integer[] {1}, array.list());
  }
}
