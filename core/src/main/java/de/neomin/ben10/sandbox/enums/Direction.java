package de.neomin.ben10.sandbox.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Direction {
    LEFT(false),
    RIGHT(true);

    private final boolean positive;
}
