package org.sanmoh.linear.arrays;

/**
 * A generic dynamic array implementation that automatically resizes itself when the capacity is
 * exceeded. It supports basic operations such as adding, retrieving, updating, and deleting
 * elements.
 *
 * @param <T> the type of elements stored in this dynamic array
 */
public class DynamicArray<T> {
  private static final int DEFAULT_CAPACITY = 10;
  private int size;
  private T[] data;

  /**
   * Constructs a new instance of the DynamicArray with the default initial capacity. This
   * constructor initializes the internal array to a predefined default size to store elements and
   * sets the initial size of the dynamic array to zero.
   */
  public DynamicArray() {
    this(DEFAULT_CAPACITY);
  }

  /**
   * Constructs a new instance of the DynamicArray with the specified initial capacity. This
   * constructor initializes the internal array to the given size to store elements and sets the
   * initial size of the dynamic array to zero.
   *
   * @param capacity the initial capacity of the dynamic array. Must be greater than or equal to
   *     zero.
   * @throws IllegalArgumentException if the specified capacity is negative.
   */
  @SuppressWarnings("unchecked")
  public DynamicArray(int capacity) {
    if (capacity < 0)
      throw new IllegalArgumentException("capacity must be greater than or equal to zero");

    data = (T[]) new Object[capacity];
    size = 0;
  }

  /**
   * Adds a specified item to the dynamic array. If the internal storage is full, the array is
   * resized to accommodate the new item.
   *
   * @param item the element to be added to the dynamic array
   */
  public void add(T item) {
    if (size == data.length) resize();
    data[size++] = item;
  }

  /**
   * Retrieves the element at the specified position in this dynamic array.
   *
   * @param index the position of the element to retrieve. Must be between 0 (inclusive) and size
   *     (exclusive).
   * @return the element at the specified position in this array.
   * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size).
   */
  public T get(int index) {
    if (index < 0 || index >= size)
      throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    return data[index];
  }

  /**
   * Returns the internal array used by the dynamic array. This includes all elements in the
   * underlying array, including unused slots.
   *
   * @return the internal array containing the elements of the dynamic array.
   */
  public T[] list() {
    return data;
  }

  /**
   * Updates the element at the specified index in the dynamic array with the given item. This
   * operation replaces the existing element at the specified position.
   *
   * @param index the position of the element to update. Must be between 0 (inclusive) and size
   *     (exclusive).
   * @param item the new element to replace the existing element at the specified index.
   * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size).
   */
  public void update(int index, T item) {
    if (index < 0 || index >= size)
      throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    data[index] = item;
  }

  /**
   * Removes the element at the specified position in the dynamic array and shifts any subsequent
   * elements to the left. The size of the array is decreased by one.
   *
   * @param index the position of the element to be removed. Must be between 0 (inclusive) and size
   *     (exclusive).
   * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size).
   */
  public void delete(int index) {
    if (index < 0 || index >= size)
      throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    System.arraycopy(data, index + 1, data, index, size - index - 1);
    size--;
  }

  /**
   * Resizes the internal storage array to double its current capacity. This method is called
   * internally when the current capacity is reached to accommodate the addition of more elements.
   *
   * <p>The resizing process involves:
   *
   * <ul>
   *   <li>Doubling the capacity of the internal array.
   *   <li>Creating a new array with the increased capacity.
   *   <li>Copying all existing elements from the current array to the new array.
   *   <li>After the resizing operation, the internal storage array is replaced with the newly
   *       created array
   */
  @SuppressWarnings("unchecked")
  private void resize() {
    int newCapacity = data.length * 2;
    T[] newData = (T[]) new Object[newCapacity];
    System.arraycopy(data, 0, newData, 0, size);
    data = newData;
  }
}
