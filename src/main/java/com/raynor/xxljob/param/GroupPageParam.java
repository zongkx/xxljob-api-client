package com.raynor.xxljob.param;

import lombok.Builder;
import lombok.Data;

/**
 * @author zongkxc
 */
@Data
@Builder
public class GroupPageParam {
    private String appname;
    private String title;
    private int start;
    private int length;
}
