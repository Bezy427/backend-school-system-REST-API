package com.bezy.school_system.entities;

public enum Role {
    STUDENT,
    PRINCIPAL,
    TEACHER,
    ;

    public String toArray(String[] strings) {
        return strings[this.ordinal()];
    }
}
