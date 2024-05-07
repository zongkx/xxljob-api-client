package com.raynor.xxljob.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author zongkxc
 */
@AllArgsConstructor
public enum ExecutorBlockStrategyEnum {
    SERIAL_EXECUTION("Serial execution"),
    DISCARD_LATER("Discard Later"),
    COVER_EARLY("Cover Early");
    @Getter
    private String name;

}

