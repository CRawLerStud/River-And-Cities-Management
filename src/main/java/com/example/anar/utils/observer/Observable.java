package com.example.anar.utils.observer;

import com.example.anar.utils.utils.Event;

public interface Observable<E extends Event> {

    void addObserver(Observer<E> observer);
    void removeObserver(Observer<E> observer);
    void notifyObserver(E event);

}
