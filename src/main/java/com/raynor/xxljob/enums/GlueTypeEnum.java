package com.raynor.xxljob.enums;

/**
 * @author zongkxc
 */
public enum GlueTypeEnum {
    BEAN("BEAN", false, (String)null, (String)null),
    GLUE_GROOVY("GLUE(Java)", false, (String)null, (String)null),
    GLUE_SHELL("GLUE(Shell)", true, "bash", ".sh"),
    GLUE_PYTHON("GLUE(Python)", true, "python", ".py"),
    GLUE_PHP("GLUE(PHP)", true, "php", ".php"),
    GLUE_NODEJS("GLUE(Nodejs)", true, "node", ".js"),
    GLUE_POWERSHELL("GLUE(PowerShell)", true, "powershell", ".ps1");

    private String desc;
    private boolean isScript;
    private String cmd;
    private String suffix;

    private GlueTypeEnum(String desc, boolean isScript, String cmd, String suffix) {
        this.desc = desc;
        this.isScript = isScript;
        this.cmd = cmd;
        this.suffix = suffix;
    }

    public String getDesc() {
        return this.desc;
    }

    public boolean isScript() {
        return this.isScript;
    }

    public String getCmd() {
        return this.cmd;
    }

    public String getSuffix() {
        return this.suffix;
    }


}