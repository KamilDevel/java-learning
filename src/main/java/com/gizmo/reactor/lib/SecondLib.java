package com.gizmo.reactor.lib;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SecondLib {
    private final String param1;
    private final String param2;
    private final String param3;

    public String toString() {
        return String.format("SecondLib - param1 : %s param2 : %s param3 : %s", param1, param2, param3);
    }
}
