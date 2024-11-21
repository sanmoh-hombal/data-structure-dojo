package org.sanmoh.Arrays;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class StaticArray<T> {
  private final T[] array;

  @SuppressWarnings("unchecked")
  public StaticArray(Integer capacity) {
    array = (T[]) new Object[capacity];
  }

  public void insert(T element, Integer index) {
    if (isIndexValid(index)) array[index] = element;
    else throw new IndexOutOfBoundsException();
  }

  public T get(Integer index) {
    if (isIndexValid(index)) return array[index];
    else throw new IndexOutOfBoundsException();
  }

  public T[] list() {
    return array;
  }

  public void update(T element, Integer index) {
    if (isIndexValid(index)) array[index] = element;
    else throw new IndexOutOfBoundsException();
  }

  public void delete(Integer index) {
    if (isIndexValid(index)) array[index] = null;
    else throw new IndexOutOfBoundsException();
  }

  @Contract(pure = true)
  private @NotNull Boolean isIndexValid(Integer index) {
    return index >= 0 && index < array.length;
  }
}
