package com.gizmo.reactor.lib;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FirstLib {
    private final String param1;
    private final String param2;

    public String toString() {
        return String.format("FirstLib - param1 : %s param2 : %s", param1, param2);
    }
}
