package com.raynor.xxljob.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author zongkxc
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupInfo {

    private int id;
    private String appname;
    private String title;
    private int addressType;
    private String addressList;
    private String updateTime;
    private List<String> registryList;


}
