package com.raynor.xxljob.result;

import com.raynor.xxljob.model.JobInfo;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author zongkxc
 */
@Data
@Builder
public class JobPageResult {
    private Integer recordsFiltered;
    private Integer recordsTotal;
    private List<JobInfo> data;
}
