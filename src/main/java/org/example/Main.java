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
        integerMyArrayList.insert(3, 20001);
        integerMyArrayList.insert(4, 20002);
        integerMyArrayList.insert(2, 20003);
        integerMyArrayList.insert(8, 20004);
        integerMyArrayList.insert(11, 20005);

        integerMyArrayList.sort(Integer::compareTo);

        integerMyArrayList.remove(11);
        integerMyArrayList.remove(1);
        integerMyArrayList.remove(10);
        integerMyArrayList.remove(14);
        integerMyArrayList.remove(8);

        System.out.println(integerMyArrayList);
        System.out.println(integerMyArrayList.size());
        System.out.println(integerMyArrayList.get(2));
        System.out.println(integerMyArrayList.indexOf(20000));
    }
}