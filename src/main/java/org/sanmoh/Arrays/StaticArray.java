package org.sanmoh.Arrays;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/** A fixed-size array data structure. */
public class StaticArray {
  private static final int DEFAULT_CAPACITY = 10;
  private final Integer[] array;

  public StaticArray() {
    array = new Integer[DEFAULT_CAPACITY];
  }

  /**
   * Constructs a StaticArray with the specified capacity.
   *
   * @param capacity the capacity of the array
   */
  public StaticArray(Integer capacity) {
    array = new Integer[capacity];
  }

  /**
   * Inserts the specified element at the specified position in this array. Replaces any existing
   * element at the specified position.
   *
   * @param element the element to be inserted into the array
   * @param index the position at which the specified element is to be inserted
   * @throws IndexOutOfBoundsException if the index is out of bounds
   */
  public void insert(Integer element, Integer index) {
    if (isIndexValid(index)) array[index] = element;
    else throw new IndexOutOfBoundsException();
  }

  /**
   * Retrieves the element at the specified position in this array.
   *
   * @param index the position of the element to return
   * @return the element at the specified position in this array
   * @throws IndexOutOfBoundsException if the index is out of bounds
   */
  public Integer get(Integer index) {
    if (isIndexValid(index)) return array[index];
    else throw new IndexOutOfBoundsException();
  }

  /**
   * Returns the underlying array of this StaticArray.
   *
   * @return the underlying array of elements
   */
  public Integer[] list() {
    return array;
  }

  /**
   * Updates the element at the specified position in this array. Replaces the existing element at
   * the specified position with the provided element.
   *
   * @param element the new element to be stored at the specified position
   * @param index the position at which the specified element is to be updated
   * @throws IndexOutOfBoundsException if the index is out of bounds
   */
  public void update(Integer element, Integer index) {
    if (isIndexValid(index)) array[index] = element;
    else throw new IndexOutOfBoundsException();
  }

  /**
   * Deletes the element at the specified position in this array. Sets the position to null.
   *
   * @param index the position of the element to delete
   * @throws IndexOutOfBoundsException if the index is out of bounds
   */
  public void delete(Integer index) {
    if (isIndexValid(index)) array[index] = null;
    else throw new IndexOutOfBoundsException();
  }

  /**
   * Checks if the given index is within the bounds of the array.
   *
   * @param index the index to check
   * @return true if the index is valid, false otherwise
   */
  @Contract(pure = true)
  private @NotNull Boolean isIndexValid(Integer index) {
    return index >= 0 && index < array.length;
  }
}
