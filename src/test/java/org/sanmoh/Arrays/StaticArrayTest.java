package org.sanmoh.Arrays;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

public class StaticArrayTest {
  @Test
  public void insert() {
    StaticArray array = new StaticArray();
    array.insert(1, 0);
    array.insert(2, 1);
    array.insert(3, 2);
    array.insert(4, 3);
    array.insert(5, 4);
    array.insert(6, 5);
    array.insert(7, 6);
    array.insert(8, 7);
    array.insert(9, 8);
    array.insert(10, 9);
    assertArrayEquals(new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, array.list());
    assertThrows(IndexOutOfBoundsException.class, () -> array.insert(11, 10));
  }

  @Test
  public void get() {
    StaticArray array = new StaticArray(5);
    array.insert(1, 0);
    assertEquals(1, array.get(0));
    assertThrows(IndexOutOfBoundsException.class, () -> array.get(6));
  }

  @Test
  public void list() {
    StaticArray array = new StaticArray(5);
    array.insert(1, 0);
    array.insert(2, 1);
    array.insert(3, 2);
    array.insert(4, 3);
    array.insert(5, 4);
    assertArrayEquals(new Integer[] {1, 2, 3, 4, 5}, array.list());
  }

  @Test
  public void update() {
    StaticArray array = new StaticArray(5);
    array.insert(1, 0);
    array.insert(2, 1);
    array.insert(3, 2);
    array.insert(4, 3);
    array.insert(5, 4);
    array.update(6, 0);
    assertArrayEquals(new Integer[] {6, 2, 3, 4, 5}, array.list());
    assertThrows(IndexOutOfBoundsException.class, () -> array.update(6, 6));
  }

  @Test
  public void delete() {
    StaticArray array = new StaticArray(5);
    array.insert(1, 0);
    array.insert(2, 1);
    array.insert(3, 2);
    array.insert(4, 3);
    array.insert(5, 4);
    array.delete(0);
    assertArrayEquals(new Integer[] {null, 2, 3, 4, 5}, array.list());
    assertThrows(IndexOutOfBoundsException.class, () -> array.delete(6));
  }
}
