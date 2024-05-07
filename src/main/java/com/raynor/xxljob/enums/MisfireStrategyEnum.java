package com.raynor.xxljob.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author zongkxc
 */
@AllArgsConstructor
public enum MisfireStrategyEnum {
    FIRE_ONCE_NOW("FIRE_ONCE_NOW"),
    DO_NOTHING("DO_NOTHING");
    @Getter
    private String name;
}
