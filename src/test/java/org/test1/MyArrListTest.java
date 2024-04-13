package org.test1;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;


public class MyArrListTest {

    @Nested
    class MyArrayListTest {

        @Test
        void addAndGetElement() {
            MyArrayList<Integer> list = new MyArrayList<>();
            list.add(1);
            list.add(2);
            list.add(3);

            assertEquals(1, list.get(0));
            assertEquals(2, list.get(1));
            assertEquals(3, list.get(2));
        }
        @Test
        void testConstructorWithInitialCapacity() {
            int initialCapacity = 10;
            MyArrayList<Integer> list = new MyArrayList<>(initialCapacity);
            assertEquals(0, list.size());
            assertEquals(initialCapacity, list.elements.length);
        }
        @Test
        void addElementAtIndex() {
            MyArrayList<String> list = new MyArrayList<>();
            list.add("a");
            list.add("c");
            list.add("d");

            list.add(1, "b");

            assertEquals("a", list.get(0));
            assertEquals("b", list.get(1));
            assertEquals("c", list.get(2));
            assertEquals("d", list.get(3));
        }
        @Test
        void ensureCapacityTest() {
            MyArrayList<Integer> list = new MyArrayList<>(5); // Создаем список с начальной емкостью 5

            // Проверяем, что емкость списка увеличивается при необходимости
            list.ensureCapacity(10);
            assertTrue(list.elements.length >= 10);

            // Проверяем, что емкость списка не изменяется, если новая емкость меньше текущей
            list.ensureCapacity(8);
            assertEquals(10, list.elements.length);

            // Проверяем, что содержимое списка остается неизменным после увеличения емкости
            list.add(1);
            list.add(2);
            list.ensureCapacity(15);
            assertEquals(2, list.size());
            assertEquals(1, list.get(0));
            assertEquals(2, list.get(1));
        }

        @Test
        void testRemoveElement() {
            MyArrayList<Character> list = new MyArrayList<>();
            list.add('a');
            list.add('b');
            list.add('c');

            Object removed = list.remove(1);

            assertEquals('b', removed);
            assertEquals(2, list.size());
            assertEquals('a', list.get(0));
            assertEquals('c', list.get(1));
        }

        @Test
        void clearList() {
            MyArrayList<Integer> list = new MyArrayList<>();
            list.add(1);
            list.add(2);
            list.add(3);

            list.clear();

            assertEquals(0, list.size());
            assertTrue(list.isEmpty());
        }

        @Test
        void sortList() {
            MyArrayList<String> list = new MyArrayList<>();
            list.add("banana");
            list.add("apple");
            list.add("grape");

            list.sort();

            assertEquals("apple", list.get(0));
            assertEquals("banana", list.get(1));
            assertEquals("grape", list.get(2));
        }

        @Test
        void sortListWithComparator() {
            MyArrayList<Integer> list = new MyArrayList<>();
            list.add(3);
            list.add(1);
            list.add(2);

            Comparator<Integer> comparator = Comparator.reverseOrder();
            list.sort(comparator);

            assertEquals(3, list.get(0));
            assertEquals(2, list.get(1));
            assertEquals(1, list.get(2));
        }
    }

}
