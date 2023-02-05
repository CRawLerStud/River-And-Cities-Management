package com.example.anar.utils.observer;

import com.example.anar.utils.utils.Event;

public interface Observer<E extends Event> {

    void update(E event);
}
