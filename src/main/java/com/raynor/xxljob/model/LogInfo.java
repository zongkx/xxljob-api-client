package com.raynor.xxljob.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zongkxc
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogInfo {

    private int fromLineNum; // 本次请求，日志开始行数
    private int toLineNum;       // 本次请求，日志结束行号
    private String logContent;     // 本次请求日志内容
    private boolean isEnd;        // 日志是否全部加载完

}
