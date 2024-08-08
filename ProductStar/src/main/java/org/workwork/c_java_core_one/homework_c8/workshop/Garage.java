package org.workwork.c_java_core_one.homework_c8.workshop;

import java.util.ArrayList;
import java.util.List;

public class Garage<T> {

    List<T> assets = new ArrayList<>();

    public void add(T t){
        assets.add(t);
    }

    public void addAll(List<? extends T> items){
        assets.addAll(items);
    }
}
