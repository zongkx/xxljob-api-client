package com.raynor.xxljob.result;

import com.raynor.xxljob.model.GroupInfo;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author zongkxc
 */
@Data
@Builder
public class GroupPageResult {
    private Integer recordsFiltered;
    private Integer recordsTotal;
    private List<GroupInfo> data;
}
