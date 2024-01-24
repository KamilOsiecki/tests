package com.gitlab.rmarzec.framework.enums;

import lombok.Getter;

@Getter
public enum Cars {

    VOLVO("volvo"),
    SAAB("saab"),
    OPEL("opel"),
    AUDI("audi");

    String name;

    Cars(String name) {
        this.name = name;
    }

    public String getValue() {
        return name;
    }
}