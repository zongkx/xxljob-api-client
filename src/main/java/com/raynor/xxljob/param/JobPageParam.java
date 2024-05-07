package com.raynor.xxljob.param;

import lombok.Builder;
import lombok.Data;

/**
 * @author zongkxc
 */
@Data
@Builder
public class JobPageParam {
    private int jobGroup;		// 执行器主键ID
    private int triggerStatus; //-1
    private String jobDesc;
    private String executorHandler;
    private String author;
    private int start;
    private int length;
}
