package com.raynor.xxljob.param;

import lombok.Builder;
import lombok.Data;

/**
 * @author zongkxc
 */
@Data
@Builder
public class LogParam {
    private int logDateTim;		// 本次调度日志时间
    private int logId;     //本次调度日志ID
    private int fromLineNum;		// 日志开始行号，滚动加载日志
}
