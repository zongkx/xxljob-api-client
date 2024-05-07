package com.raynor.xxljob.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author zongkxc
 */
@AllArgsConstructor
public enum ScheduleTypeEnum {
    NONE("NONE"),CORN("CORN"),FIX_RATE("FIX_RATE");
    @Getter
    private String name;
}
