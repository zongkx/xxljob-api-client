package com.raynor.xxljob.param;

import com.raynor.xxljob.enums.ExecutorBlockStrategyEnum;
import com.raynor.xxljob.enums.GlueTypeEnum;
import lombok.Builder;
import lombok.Data;

/**
 * @author zongkxc
 */
@Data
@Builder
public class ExecutorParam {
    //基础配置
    private int jobId;		// 执行器主键ID
    private String executorHandler;     //任务描述
    private String executorParams;		// 负责人
    private ExecutorBlockStrategyEnum executorBlockStrategy;// 阻塞处理策略*
    private int executorTimeout;
    private int logId;
    private int logDateTime;
    private GlueTypeEnum glueType;//运行模式*
    private String glueSource;
    private int glueUpdatetime;
    private int broadcastIndex;
    private int broadcastTotal;

}
