package com.lzh.firstboot.common.datasource;

/**
 * 作者： Jonathan
 * 创建时间： 2016/9/21 ${Time}.
 * DatabaseContextHolder的描述：${DESCRIPTION}
 */

public class DatabaseContextHolder {
    private static final ThreadLocal<DatabaseType> contextHolder = new ThreadLocal<DatabaseType>();

    public static void setDatabaseType(DatabaseType type) {
        contextHolder.set(type);

    }

    public static DatabaseType getDatabaseType() {
        return contextHolder.get();
    }
}
