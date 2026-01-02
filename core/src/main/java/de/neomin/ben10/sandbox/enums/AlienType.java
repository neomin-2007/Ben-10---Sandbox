package de.neomin.ben10.sandbox.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AlienType {
    BLITZWOLF("blitzwolf", 5.0f),
    ULTRA_T("ultrat", 4.0f),
    XLR8("xlr8", 7.0f),
    HEATBLAST("heatblast", 3.0f),
    GHOSTFREAK("ghostfreak", 3.0f),
    CANNONBOLT("cannonbolt", 5.0f);

    private final String path;
    private final float speed;
}
