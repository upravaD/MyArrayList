package org.example;

public class Main {

    public static void main(String[] args) {

        MyArrayList<Integer> integerMyArrayList = new MyArrayList<>();
        for (int i = 0; i < 15; i++) {
            integerMyArrayList.add(i);
        }

        integerMyArrayList.insert(0, 20);
        integerMyArrayList.insert(5, 200);
        integerMyArrayList.insert(7, 2000);
        integerMyArrayList.insert(3, 20000);
        integerMyArrayList.insert(4, 20000);
        integerMyArrayList.insert(2, 20000);
        integerMyArrayList.insert(8, 20000);
        integerMyArrayList.insert(11, 20000);

//        integerMyArrayList.remove(2);

//        integerMyArrayList.removeAll();

        System.out.println(integerMyArrayList);
    }
}