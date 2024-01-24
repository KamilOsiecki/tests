package com.gitlab.rmarzec.framework.enums;

public enum Browsers {

    CHROME("chrome"),
    FIREFOX("firefox"),
    EDGE("edge");

    public String browserName;

    Browsers(String browserName) {
        this.browserName = browserName;
    }
}