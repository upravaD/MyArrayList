package org.example;

import java.util.Comparator;

/**
 * Параметризированный интерфейс MyList определяет методы для работы с динамическим массивом.
 * @param <T> Коллекция принимает любой тип данных.
 */

public interface MyList<T> {

    /**
     * Добавить элемент в список.
     * @param item Элемент любого типа.
     */
    void add(T item);

    /**
     * Добавить элемент в список на конкретную позицию, используя индекс.
     * @param index Желаемая позиция элемента в списке.
     * @param item Элемент любого типа.
     */
    void insert(int index, T item);

    /**
     * Получить значение элемента.
     * @param index Позиция элемента в списке.
     * @return Значение элемента.
     */
    T get(int index);

    /**
     * Удалить элемент из списка.
     *
     * @param index Позиция элемента в списке.
     */
    void remove(int index);

    /**
     * Удалить все элементы из списка.
     */
    void removeAll();

    /**
     * Поиск индекса элемента в списке.
     * @param item Значение элемента.
     * @return Индекс элемента.
     */
    int indexOf(T item);

    /**
     * Сортировка списка.
     * @param comparator Объект класса Comparator для сравнения элементов списка.
     */
    void sort(Comparator<? super T> comparator);
}
