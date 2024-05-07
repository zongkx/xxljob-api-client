package com.raynor.xxljob.conf;


import lombok.Getter;
import lombok.Setter;

import static com.raynor.xxljob.conf.XxlJobServerConf.constant.*;


public class XxlJobServerConf {
    public XxlJobServerConf(){}
    public XxlJobServerConf(String address,String name,String password){
        this.address = address;
        this.name = name;
        this.password = password;
    }
    @Setter
    @Getter
    private String address;//服务部署地址
    @Getter
    @Setter
    private String name;
    @Setter
    @Getter
    private String password;


    private String loginUrl ;
    private String jobAddUrl ;
    private String jobRemoveUrl ;
    private String jobUpdateUrl ;
    private String jobPageUrl;

    private String jobRunOnceUrl;
    private String jobStartUrl;
    private String jobStopUrl;
    private String jobBeatUrl;

    private String groupPageUrl;
    private String groupAddUrl;
    private String groupRemoveUrl;
    private String groupUpdateUrl;

    public String getLoginUrl() {
        return splicing(LOGIN_SUFFIX);
    }

    public String getJobAddUrl() {
        return splicing(JOB_ADD_SUFFIX);
    }
    public String getJobRemoveUrl() {
        return splicing(JOB_REMOVE_SUFFIX);
    }
    public String getJobUpdateUrl() {return splicing(JOB_UPDATE_SUFFIX);}
    public String getJobPageUrl() {return splicing(JOB_PAGE_SUFFIX);}

    public String getJobRunOnceUrl() {return splicing(JOB_RUN_ONCE_SUFFIX);}
    public String getJobStartUrl() {return splicing(JOB_START_SUFFIX);}
    public String getJobStopUrl() {return splicing(JOB_STOP_SUFFIX);}
    public String getJobBeatUrl() {return this.address+JOB_BEAT_SUFFIX;}


    public String getGroupPageUrl() {return splicing(GROUP_PAGE_SUFFIX);}
    public String getGroupAddUrl() {return splicing(GROUP_ADD_SUFFIX);}
    public String getGroupRemoveUrl() {return splicing(GROUP_REMOVE_SUFFIX);}
    public String getGroupUpdateUrl() {return splicing(GROUP_UPDATE_SUFFIX);}



    private String splicing(String suffix){
        return this.address + suffix;
    }

    static class constant {

        public static final String LOGIN_SUFFIX = "/login";
        public static final String JOB_ADD_SUFFIX = "/jobinfo/add";
        public static final String JOB_REMOVE_SUFFIX = "/jobinfo/remove";
        public static final String JOB_UPDATE_SUFFIX = "/jobinfo/update";
        public static final String JOB_PAGE_SUFFIX = "/jobinfo/pageList";

        public static final String JOB_RUN_ONCE_SUFFIX = "/jobinfo/trigger";
        public static final String JOB_START_SUFFIX = "/jobinfo/start";
        public static final String JOB_STOP_SUFFIX = "/jobinfo/stop";
        public static final String JOB_BEAT_SUFFIX = "/api/beat";


        public static final String GROUP_PAGE_SUFFIX = "/jobgroup/pageList";
        public static final String GROUP_ADD_SUFFIX = "/jobgroup/save";
        public static final String GROUP_REMOVE_SUFFIX = "/jobgroup/remove";
        public static final String GROUP_UPDATE_SUFFIX = "/jobgroup/update";


    }
}
