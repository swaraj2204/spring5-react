package com.clari5.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.util.Assert;

import javax.sql.DataSource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class TenantDataSource extends AbstractRoutingDataSource {

    private Map<Object, Object> targetDataSources;
    private Object defaultTargetDataSource;
    private ConcurrentMap<Object, DataSource> resolvedDataSources;
    private DataSource resolvedDefaultDataSource;


    @Override
    public void setTargetDataSources(Map<Object, Object> targetDataSources) {
        this.targetDataSources = targetDataSources;
    }

    public Map<Object, Object> getTargetDataSources() {
        return targetDataSources;
    }

    @Override
    public void setDefaultTargetDataSource(Object defaultTargetDataSource) {
        this.defaultTargetDataSource = defaultTargetDataSource;
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return CurrentTenantCtx.getCurrentTenant();
    }

    @Override
    public void afterPropertiesSet() {
        if (this.targetDataSources == null) {
            throw new IllegalArgumentException("Property 'targetDataSources' is required");
        }
        if (this.resolvedDataSources == null) {
            this.resolvedDataSources = new ConcurrentHashMap<>(this.targetDataSources.size());
        }
        this.targetDataSources.forEach((key, value) -> {
            Object lookupKey = resolveSpecifiedLookupKey(key);
            DataSource dataSource = resolveSpecifiedDataSource(value);
            this.resolvedDataSources.put(lookupKey, dataSource);
        });
        if (this.defaultTargetDataSource != null && resolvedDefaultDataSource == null) {
            this.resolvedDefaultDataSource = resolveSpecifiedDataSource(this.defaultTargetDataSource);
        }
    }

    @Override
    protected DataSource determineTargetDataSource() {
        Assert.notNull(this.resolvedDataSources, "DataSource router not initialized");
        Object lookupKey = determineCurrentLookupKey();
        if (lookupKey == null) {
         return this.resolvedDefaultDataSource;
        }
        DataSource dataSource = this.resolvedDataSources.get(lookupKey);
        if (dataSource == null) {
            throw new IllegalStateException("Cannot determine target DataSource for lookup key [" + lookupKey + "]");
        }
        return dataSource;
    }
}
