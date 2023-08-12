package org.example;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Класс MyArrayList реализует интерфейс MyList. Этот класс может работать с любым типом данных.
 * Также этот класс обладает свойствами динамического массива, автоматически расширяя свой размер
 * по мере добавления элементов в список. Класс MyArrayList обладает стандартным набором
 * возможностей:
 *
 * <pre>{@code
 *     add(T item);                            - добавление.
 *     insert(int index, T item);              - вставка.
 *     get(int index);                         - получение значения.
 *     remove(int index);                      - удаление элемента.
 *     removeAll();                            - очистка коллекции.
 *     indexOf(T item);                        - индекс элемента.
 *     sort(Comparator<? super T> comparator); - сортировка.
 *     toString();
 * }</pre>
 *
 * @param <T> Коллекция принимает любой тип данных.
 */

@SuppressWarnings("unchecked")
public class MyArrayList<T> implements MyList<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private T[] elementArray;
    private int size;

    /**
     * Конструктор класса MyArrayList инициализирует внутренний
     * динамический массив размером равным 10 элементов.
     */
    public MyArrayList() {
        this.elementArray = (T[]) new Object[DEFAULT_CAPACITY];
    }

    /**
     * Добавить элемент в список. Элемент добавляется в конец списка.
     *
     * @param item Элемент любого типа.
     */
    @Override
    public void add(T item) {
        resize();
        size++;
        elementArray[size - 1] = item;
    }

    /**
     * Добавить элемент в список на конкретную позицию, используя индекс.
     * После вставки элемента, происходит сдвиг индекса элементов на 1.
     *
     * @param index Желаемая позиция элемента в списке.
     * @param item  Элемент любого типа.
     */
    @Override
    public void insert(int index, T item) {

        T[] left = (T[]) new Object[index+1];
        System.arraycopy(elementArray, 0, left, 0, index);
        left[left.length-1] = item;
        resize();

        T[] right = (T[]) new Object[elementArray.length - index];
        System.arraycopy(elementArray, index, right, 0, right.length);

        System.arraycopy(left, 0, elementArray, 0, left.length);
        for (int i = 0; i < elementArray.length; i++) {
            if ((i + left.length) > elementArray.length) break;
            if (right[i] != null) {
                elementArray[i + left.length] = right[i];
            }
        }
        size++;
    }

    /**
     * Получить значение элемента.
     *
     * @param index Позиция элемента в списке.
     * @return Значение элемента.
     */
    @Override
    public T get(int index) {
        return elementArray[index];
    }

    /**
     * Удалить элемент из списка.
     *
     * @param index Позиция элемента в списке.
     */
    @Override
    public void remove(int index) {
        elementArray[index] = null;
        size--;
    }

    public T pop(int index) {
        T element = elementArray[index];
        elementArray[index] = null;
        size--;
        return element;
    }

    /**
     * Удалить все элементы из списка.
     */
    @Override
    public void removeAll() {
        elementArray = (T[]) new Object[DEFAULT_CAPACITY];
    }

    /**
     * Поиск индекса элемента в списке.
     *
     * @param item Значение элемента.
     * @return Индекс элемента.
     */
    @Override
    public int indexOf(T item) {
        return 0;
    }

    /**
     * Сортировка списка.
     *
     * @param comparator Объект класса Comparator для сравнения элементов списка.
     */
    @Override
    public void sort(Comparator<? super T> comparator) {

    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return Arrays.toString(elementArray);
    }

    private void resize() {
        if (size >= elementArray.length) {
            this.elementArray = Arrays.copyOf(this.elementArray, (int) (elementArray.length * 1.5));
        }
    }
}
