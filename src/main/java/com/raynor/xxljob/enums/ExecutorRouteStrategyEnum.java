package com.raynor.xxljob.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
public enum ExecutorRouteStrategyEnum {
    FIRST("jobconf_route_first"),
    LAST("jobconf_route_last"),
    ROUND("jobconf_route_round"),
    RANDOM("jobconf_route_random"),
    CONSISTENT_HASH("jobconf_route_consistenthash"),
    LEAST_FREQUENTLY_USED("jobconf_route_lfu"),
    LEAST_RECENTLY_USED("jobconf_route_lru"),
    FAILOVER("jobconf_route_failover"),
    BUSYOVER("jobconf_route_busyover"),
    SHARDING_BROADCAST("jobconf_route_shard");
    @Getter
    private String name;
}
