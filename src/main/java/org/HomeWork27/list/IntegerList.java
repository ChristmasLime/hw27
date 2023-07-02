package org.HomeWork27.list;

public interface IntegerList {

    Integer add(Integer item);


    Integer add(int index, Integer item);


    Integer set(int index, Integer item);


    Integer remove(Integer item);


    Integer removeByIndex(Integer index);

    boolean contains(Integer item);

    Integer indexOf(Integer item);

    Integer lastIndexOf(Integer item);


    Integer get(int index);

    boolean equals(IntegerList otherList);


    int size();

    boolean isEmpty();


    void clear();

    Integer[] toArray();
}