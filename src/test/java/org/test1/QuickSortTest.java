package org.test1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuickSortTest {
    @Test
    public void testSort() {
        QuickSort<Integer> quickSort = new QuickSort<>();
        List<Integer> list = Arrays.asList(3, 5, 1, 2, 4);
        quickSort.sort(list);
        assertEquals(Arrays.asList(1, 2, 3, 4, 5), list);

        QuickSort<String> quickSortStrings = new QuickSort<>();
        List<String> stringList = Arrays.asList("banana", "apple", "orange", "cherry", "lemon");
        quickSortStrings.sort(stringList);
        assertEquals(Arrays.asList("apple", "banana", "cherry", "lemon", "orange"), stringList);
    }

    @Test
    public void testSortWithComparator() {
        QuickSort<Integer> quickSort = new QuickSort<>(Comparator.reverseOrder());
        List<Integer> list = Arrays.asList(5, 3, 1, 4, 2);
        quickSort.sort(list);
        assertEquals(Arrays.asList(5, 4, 3, 2, 1), list);
    }
}


