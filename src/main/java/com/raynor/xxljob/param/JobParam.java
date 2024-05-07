package com.raynor.xxljob.param;

import com.raynor.xxljob.enums.*;
import lombok.Builder;
import lombok.Data;

/**
 * @author zongkxc
 */
@Data
@Builder
public class JobParam {
    //基础配置
    private int jobGroup;		// 执行器主键ID
    private String jobDesc;     //任务描述
    private String author;		// 负责人
    private String alarmEmail;	// 报警邮件

    //调度配置
    private ScheduleTypeEnum scheduleType; //调度类型
    private String scheduleConf;//调度类型 配置
    private String cronGen_display;//
    private String schedule_conf_CRON;//
    //任务配置
    private GlueTypeEnum glueType;//运行模式*
    private String executorHandler;//执行器
    private String executorParam;//执行参数

    //高级配置
    private ExecutorRouteStrategyEnum executorRouteStrategy;//路由策略*
    private String childJobId;//子任务ID*
    private MisfireStrategyEnum misfireStrategy;//调度过期策略*
    private ExecutorBlockStrategyEnum executorBlockStrategy;// 阻塞处理策略*
    private int ExecutorTimeout; //任务超时时间*
    private int ExecutorFailRetryCount;//失败重试次数*
}
