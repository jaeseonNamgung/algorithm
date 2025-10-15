package list;

import java.util.Arrays;

public class MyArrayList<E> {
  private static int DEFAULT_CAPACITY = 10;
  private int size = 0;
  private Object[] data;

  public MyArrayList(int initialCapacity) {
    data = new Object[initialCapacity];
  }

  public MyArrayList() {
    this(DEFAULT_CAPACITY);
  }

  public void add(E element) {
    if(size == data.length) growCapacity();

    data[size++] = element;
  }

  private void growCapacity() {
    int newCapacity = data.length + (data.length >> 1);
    data = Arrays.copyOf(data, newCapacity);
  }

  public E get(int idx) {
    if(idx < 0 || idx >= size) {
      throw new IndexOutOfBoundsException("Index: " + idx + ", Size: " + size);
    }
    return (E) data[idx];
  }

  public void set(E element, int idx) {
    if(idx < 0 || idx >= size) {
      throw new IndexOutOfBoundsException("Index: " + idx + ", Size: " + size);
    }
    data[idx] = element;
  }

  public void insert(E element, int idx) {
    if(idx < 0 || idx >= size) {
      throw new IndexOutOfBoundsException("Index: " + idx + ", Size: " + size);
    }
    int copyLength = data.length - idx;
    System.arraycopy(data, idx, data, idx+1, copyLength);
    data[idx] = element;
    size++;
  }

  public void remove(int idx) {
    if(idx < 0 || idx >= size) {
      throw new IndexOutOfBoundsException("Index: " + idx + ", Size: " + size);
    }
    int copyLength = data.length - idx-1;
    System.arraycopy(data, idx + 1, data, idx, copyLength);
    size--;
  }

  public int size() {
    return size;
  }
}


