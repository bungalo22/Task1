package org.test1;

import java.util.Comparator;
/**
 * Реализация собственного динамического массива.
 */
class MyArrayList<T> {
    private static final int DEFAULT_CAPACITY = 10;
    public Object[] elements;
    private int size;
    /**
     * Создает пустой список с начальной емкостью по умолчанию.
     */
    public MyArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }
    /**
     * Создает пустой список с указанной начальной емкостью.
     *
     * @param initialCapacity начальная емкость списка
     */
    public MyArrayList(int initialCapacity) {
        elements = new Object[initialCapacity];
        size = 0;
    }
    /**
     * Добавляет элемент в конец списка.
     *
     * @param element элемент для добавления
     */
    public void add(T element) {
        ensureCapacity(size + 1);
        elements[size++] = element;
    }
    /**
     * Вставляет элемент по указанному индексу.
     *
     * @param index индекс, по которому нужно вставить элемент
     * @param element элемент для вставки
     */
    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        ensureCapacity(size + 1);
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
    }
    /**
     * Возвращает элемент по указанному индексу.
     *
     * @param index индекс элемента
     * @return элемент по указанному индексу
     */
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (T) elements[index];
    }
    /**
     * Удаляет элемент по указанному индексу.
     *
     * @param index индекс элемента для удаления
     * @return удаленный элемент
     */
    public Object remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Object removedElement = elements[index];
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[size - 1] = null;
        size--;
        return removedElement;
    }
    /**
     * Удаляет все элементы из списка.
     */
    public void clear() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }
    /**
     * Сортирует элементы списка в естественном порядке.
     */
    public void sort() {
        sort(null);
    }
    /**
     * Сортирует элементы списка с помощью указанного компаратора.
     *
     * @param comparator компаратор для сортировки элементов
     */
    public void sort(Comparator<? super T> comparator) {
        if (comparator == null) {
            comparator = (Comparator<T>) Comparator.naturalOrder();
        }
        quickSort(0, size - 1, comparator);
    }
    /**
     * Рекурсивный метод для быстрой сортировки.
     *
     * @param low  индекс нижней границы подмассива
     * @param high индекс верхней границы подмассива
     * @param comparator компаратор для сортировки элементов
     */
    private void quickSort(int low, int high, Comparator<? super T> comparator) {
        if (low < high) {
            int pivotIndex = partition(low, high, comparator);
            quickSort(low, pivotIndex - 1, comparator);
            quickSort(pivotIndex + 1, high, comparator);
        }
    }
    /**
     * Выбирает опорный элемент и разделяет список на две части.
     *
     * @param low  индекс нижней границы подмассива
     * @param high индекс верхней границы подмассива
     * @param comparator компаратор для сортировки элементов
     * @return индекс опорного элемента после разделения
     */
    private int partition(int low, int high, Comparator<? super T> comparator) {
        T pivot = get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (comparator.compare(get(j), pivot) <= 0) {
                i++;
                swap(i, j);
            }
        }
        swap(i + 1, high);
        return i + 1;
    }
    /**
     * Меняет местами два элемента в списке.
     *
     * @param i индекс первого элемента
     * @param j индекс второго элемента
     */
    private void swap(int i, int j) {
        Object temp = elements[i];
        elements[i] = elements[j];
        elements[j] = temp;
    }
    /**
     * Убеждается, что внутренний массив elements имеет достаточную емкость для хранения
     * указанного минимального количества элементов.
     * Если текущая емкость меньше минимальной, внутренний массив увеличивается вдвое
     * или устанавливается в указанную минимальную емкость, если она больше.
     *
     * @param minCapacity минимальная емкость, которую должен иметь внутренний массив
     */
    protected void ensureCapacity(int minCapacity) {
        if (minCapacity > elements.length) {
            int newCapacity = elements.length * 2;
            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }
            Object[] newElements = new Object[newCapacity];
            System.arraycopy(elements, 0, newElements, 0, size);
            elements = newElements;
        }
    }
    /**
     * Возвращает текущий размер списка, то есть количество элементов в списке.
     *
     * @return текущий размер списка
     */
    public int size() {
        return size;
    }
    /**
     * Проверяет, пуст ли список.
     *
     * @return true, если список пуст, в противном случае - false
     */
    public boolean isEmpty() {
        return size == 0;
    }
}
