package com.example.anar.utils.utils;

import com.example.anar.domain.River;

public class ChangeEvent implements Event{

    private final ChangeEventType type;
    private final River river;

    public ChangeEvent(ChangeEventType type, River river) {
        this.type = type;
        this.river = river;
    }

    public ChangeEventType getType() {
        return type;
    }

    public River getRiver() {
        return river;
    }
}
