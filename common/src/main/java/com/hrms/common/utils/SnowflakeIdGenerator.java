package com.hrms.common.utils;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;

public class SnowflakeIdGenerator {
    private static final long datacenterId = 1L;
    private static final long workerId = 1L;

    private static final Snowflake snowflake = IdUtil.getSnowflake();

    public static long generateId() {
        return snowflake.nextId();
    }
}
