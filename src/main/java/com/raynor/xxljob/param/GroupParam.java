package com.raynor.xxljob.param;

import lombok.Builder;
import lombok.Data;

/**
 * @author zongkxc
 */
@Data
@Builder
public class GroupParam {
    private String appname;
    private String title;
    private int addressType;
    private String addressList;
}
