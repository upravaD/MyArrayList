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
    private final int DEFAULT_CAPACITY = 10;
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
     * Метод добавляет элемент в конец списка.
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
     * Метод добавляет элемент в список на конкретную позицию, используя индекс.
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
     * Метод возвращает значение элемента по индексу.
     *
     * @param index Позиция элемента в списке.
     * @return Значение элемента любого типа.
     */
    @Override
    public T get(int index) {
        return elementArray[index];
    }

    /**
     * Метод удаляет элемент из списка, при этом размер списка уменьшается на 1.
     * При удалении элемента пустое значение заменяется следующим по индексу.
     *
     * @param index Позиция элемента в списке.
     */
    @Override
    public void remove(int index) {
        elementArray[index] = null;
        size--;
        T[] tempArray = elementArray;

        for (int i = 0; i < size; i++) {
            if (tempArray[i] != null) {
                elementArray[i] = tempArray[i];
            } else {
                elementArray[i] = tempArray[i+1];
                elementArray[i+1] = null;
            }
        }
    }

    /**
     * Метод удаляет все элементы из списка,
     * инициализируя список дефолтными значеними коллекции.
     */
    @Override
    public void removeAll() {
        elementArray = (T[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    /**
     * Метод поиска индекса элемента в списке.
     * Если элемента нет в списке, то метод возвращает "-1".
     *
     * @param item Значение элемента.
     * @return Индекс элемента.
     */
    @Override
    public int indexOf(T item) {
        if (item != null) {
            for (int i = 0; i < elementArray.length; i++) {
                if (elementArray[i] == null) return -1;
                if (elementArray[i].equals(item)) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * Метод производит быструю сортировку списка.
     * При выполнении сортировки коллекции из одного элемента, метод не выполняет никаких операций,
     * если элементов больше 1, то вызывается внутренний метод "quicksort", который принимает в качестве
     * параметров массив любого типа, индекс начального значения, индекс конечного значения и объект класса Comparator
     * для сравнения элементов. Метод "quicksort" определяет опорный элемент, с помощью которого
     * разделяет список на подмассивы и сохраняет в одном из них значения больше опорного элемента,
     * а в другом меньше опорного элемента. С помощью рекурсии подмассивы делятся до тех пор,
     * пока не останется один элемент. Сортировка производится по возрастанию.
     * В результате алгоритм "quicksort" имеет сложность O(n log n).
     *
     * @param comparator Объект класса Comparator для сравнения элементов списка любого типа.
     * @see <a href="https://www.baeldung.com/java-quicksort"/>baeldung.com</href>
     */
    @Override
    public void sort(Comparator<? super T> comparator) {
        if (size == 0) {
            return;
        }
        quickSort(elementArray, 0, size - 1, comparator);
    }

    /**
     * Метод возвращает размер коллекции.
     * @return Целое число.
     */
    public int size() {
        return size;
    }

    /**
     * Метод возвращает строковое представление значений коллекции без вспомогательных элементов (null).
     * @return Строковое представление коллекции.
     */
    @Override
    public String toString() {
        T[] tempArray = (T[]) new Object[size];
        System.arraycopy(elementArray, 0, tempArray, 0, size);
        return Arrays.toString(tempArray);
    }

    private void resize() {
        if (size >= elementArray.length) {
            this.elementArray = Arrays.copyOf(this.elementArray, (int) (elementArray.length * 1.5));
        }
    }

    private void quickSort(T[] array, int left, int right, Comparator<? super T> comparator) {
        if (left >= right) { //Если индекс начального значения меньше конечного выполняется поиск индекса опорного элемента.
            return;
        }
        int pivotIndex = partition(array, left, right, comparator); //поиск индекса опорного элемента
        quickSort(array, left, pivotIndex - 1, comparator); //элементы меньше опорного
        quickSort(array, pivotIndex + 1, right, comparator); //элементы больше опорного
    }

    private int partition(T[] array, int left, int right, Comparator<? super T> comparator) {
        T pivot = array[left]; //Опорный элемент
        int i = left + 1; //Индекс начального элемента
        int j = right; //Индекс конечного элемента
        while (i <= j) { //Пока индекс начального меньше или равен конечному
            while (i <= j && comparator.compare(array[i], pivot) <= 0) { //Сравнение начальных элементов с опорным
                i++; //Увеличиваем индекс начального
            }
            while (i <= j && comparator.compare(array[j], pivot) > 0) { //Сравнение конечных элементов с опорным
                j--; //Уменьшаем индекс конечного
            }
            if (i < j) { //Если индекс начального меньше конечного меняем значения местами
                T temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        } //Меняем значения в коллекции местами
        T temp = array[left];
        array[left] = array[j];
        array[j] = temp;
        return j;
    }
}
