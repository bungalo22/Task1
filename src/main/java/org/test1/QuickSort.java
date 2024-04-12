package org.test1;

import java.util.Comparator;
import java.util.List;

public class QuickSort<T> {
    private final Comparator<? super T> comparator;

    public QuickSort() {
        this(null);
    }

    public QuickSort(Comparator<? super T> comparator) {
        this.comparator = comparator;
    }

    public void sort(List<T> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        quickSort(list, 0, list.size() - 1);
    }

    private void quickSort(List<T> list, int low, int high) {
        if (low < high) {
            int pi = partition(list, low, high);
            quickSort(list, low, pi - 1);
            quickSort(list, pi + 1, high);
        }
    }

    private int partition(List<T> list, int low, int high) {
        T pivot = list.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (compare(list.get(j), pivot) < 0) {
                i++;
                swap(list, i, j);
            }
        }
        swap(list, i + 1, high);
        return i + 1;
    }

    private void swap(List<T> list, int i, int j) {
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    private int compare(T a, T b) {
        if (comparator != null) {
            return comparator.compare(a, b);
        } else {
            @SuppressWarnings("unchecked")
            Comparable<? super T> comparable = (Comparable<? super T>) a;
            return comparable.compareTo(b);
        }
    }
}


