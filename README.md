### xxl-job
 分布式任务调度平台 
`https://www.xuxueli.com/xxl-job`

优点: ha/lb,低侵入,轻量级

### 基础概括
1. executor
执行器,接入xxl-job的app
2. handler
处理者,具体job的执行内容

### demo
可参考文档,springboot集成核心在于两步,其一配置executor,其二实现job handler,有两种方式:
- 基于方法
```
@XxlJob("demoJobHandler")
public void demoJobHandler() throws Exception {
    XxlJobHelper.log("XXL-JOB, Hello World.");
}  
```
- 基于类(继承`IJobHandler`)

`XxlJobExecutor.registJobHandler("demoJobHandler", new DemoJobHandler());`

### 使用场景

- 数据订阅/推送,提供不同租户不同数据的定时推送功能(定时任务)
- 数据补偿(一次性任务)
以上场景需要代码实现具体的推送逻辑,可称之为`类`,并不会在xxl-job中创建对应的job handler,每个用户可以自行创建该类型的任务,称之为`实例`
另外下面封装了xxl-job界面中的rest api作为sdk使用.

``





