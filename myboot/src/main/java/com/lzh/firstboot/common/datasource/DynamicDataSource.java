package com.lzh.firstboot.common.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 作者： Jonathan
 * 创建时间： 2016/9/21 ${Time}.
 * * DynamicDataSource的描述：动态数据源
 */

public class DynamicDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return DatabaseContextHolder.getDatabaseType();
    }
}
