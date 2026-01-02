package de.neomin.ben10.sandbox.enums;

import java.util.Locale;

public enum AnimationType {
    IDLE_RIGHT,
    IDLE_LEFT,
    RUN_RIGHT,
    RUN_LEFT;

    public String getName() {
        return "_" + this.name().toLowerCase();
    }
}
