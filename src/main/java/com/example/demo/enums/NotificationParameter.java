/**
 * 
 */
package com.example.demo.enums;

/**
 * @since Nov 30, 2022
 *
 */
public enum NotificationParameter {

    COLOR("some color"),
    SOUND("some sound");

    private final String value;

    NotificationParameter(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
