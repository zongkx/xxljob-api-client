package com.raynor.xxljob;

import com.raynor.xxljob.conf.XxlJobServerConf;
import com.raynor.xxljob.interceptor.AuthInterceptor;
import com.raynor.xxljob.param.GroupPageParam;
import com.raynor.xxljob.param.GroupParam;
import com.raynor.xxljob.param.JobPageParam;
import com.raynor.xxljob.param.JobParam;
import com.raynor.xxljob.result.GroupPageResult;
import com.raynor.xxljob.result.JobPageResult;
import com.raynor.xxljob.result.ReturnT;
import com.raynor.xxljob.util.HttpUtil;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;


public class XxlJobClient {
    private final OkHttpClient okHttpClient;
    private final XxlJobServerConf xxlJobServerConf;

    public XxlJobClient(XxlJobServerConf xxlJobServerConf) {
        this.xxlJobServerConf = xxlJobServerConf;
        OkHttpClient okHttpClientCookie = new OkHttpClient();
        this.okHttpClient = okHttpClientCookie.newBuilder().addInterceptor(new AuthInterceptor(okHttpClientCookie, xxlJobServerConf)).build();
    }


    public XxlJobClient(XxlJobServerConf xxlJobServerConf, OkHttpClient okHttpClient) {
        this.xxlJobServerConf = xxlJobServerConf;
        this.okHttpClient = okHttpClient.newBuilder().addInterceptor(new AuthInterceptor(okHttpClient, xxlJobServerConf)).build();
    }

    /**
     * 新增job
     */
    public ReturnT<String> addJob(JobParam jobParam) {
        FormBody.Builder builder = HttpUtil.toBuilder(jobParam);
        return HttpUtil.execute(okHttpClient,builder,xxlJobServerConf.getJobAddUrl(),ReturnT.class);
    }
    /**
     *  修改job
     */
    public ReturnT<String> updateJob(JobParam jobParam,String jobId){
        FormBody.Builder builder = HttpUtil.toBuilder(jobParam);
        builder.add("id",jobId);
        return HttpUtil.execute(okHttpClient,builder,xxlJobServerConf.getJobUpdateUrl(),ReturnT.class);
    }
    /**
     * 删除job
     */
    public ReturnT<String> removeJob(String jobId) {
        FormBody.Builder builder = new FormBody.Builder();
        builder.add("id",jobId);
        return HttpUtil.execute(okHttpClient,builder,xxlJobServerConf.getJobRemoveUrl(),ReturnT.class);
    }

    /**
     * job list
     */
    public ReturnT<JobPageResult> pageJobList(JobPageParam jobPageParam){
        FormBody.Builder builder = HttpUtil.toBuilder(jobPageParam);
        return HttpUtil.execute(okHttpClient,builder,xxlJobServerConf.getJobPageUrl(),JobPageResult.class);
    }

    /**
     * 运行一次(job)
     */
    public ReturnT<String> runOnceJob(String jobId,String executorParam,String addressList) {
        FormBody.Builder builder = new FormBody.Builder();
        builder.add("id",jobId);
        builder.add("executorParam",executorParam);
        builder.add("addressList",addressList);
        return HttpUtil.execute(okHttpClient,builder,xxlJobServerConf.getJobRunOnceUrl(),ReturnT.class);
    }
    /**
     * 启动(job)
     */
    public ReturnT<String> startJob(String jobId) {
        FormBody.Builder builder = new FormBody.Builder();
        builder.add("id",jobId);
        return HttpUtil.execute(okHttpClient,builder,xxlJobServerConf.getJobStartUrl(),ReturnT.class);
    }

    /**
     * 终止(job)
     */
    public ReturnT<String> stopJob(String jobId) {
        FormBody.Builder builder = new FormBody.Builder();
        builder.add("id",jobId);
        return HttpUtil.execute(okHttpClient,builder,xxlJobServerConf.getJobStopUrl(),ReturnT.class);
    }

    /**
     * executor List
     */
    public ReturnT<GroupPageResult> ExecutorList(GroupPageParam groupPageParam){
        FormBody.Builder builder = HttpUtil.toBuilder(groupPageParam);
        return HttpUtil.execute(okHttpClient,builder,xxlJobServerConf.getGroupPageUrl(),GroupPageResult.class);
    }

    /**
     * 新增(执行器)
     */
    public ReturnT<String> addExecutor(GroupParam groupParam) {
        FormBody.Builder builder = HttpUtil.toBuilder(groupParam);
        return HttpUtil.execute(okHttpClient,builder,xxlJobServerConf.getGroupAddUrl(),ReturnT.class);
    }
    /**
     *  修改(执行器)
     */
    public ReturnT<String> updateExecutor(GroupParam groupParam, String groupId) {
        FormBody.Builder builder = HttpUtil.toBuilder(groupParam);
        builder.add("id",groupId);
        return HttpUtil.execute(okHttpClient,builder,xxlJobServerConf.getGroupUpdateUrl(),ReturnT.class);

    }
    /**
     * 删除(执行器)
     */
    public ReturnT<String> removeExecutor(String groupId) {
        FormBody.Builder builder = new FormBody.Builder();
        builder.add("id",groupId);
        return HttpUtil.execute(okHttpClient,builder,xxlJobServerConf.getGroupRemoveUrl(),ReturnT.class);
    }

}
