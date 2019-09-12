package com.clari5.controller;

import com.clari5.datasource.TenantDataSource;
import com.clari5.entity.DbInfo;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/config")
public class ConfigController {

    @Autowired
    private TenantDataSource tenantDataSource;

    @Value("${db.driver}")
    private String driver;

    @Value("${db.host}")
    private String dbUrl;

    @Value("${db.port}")
    private int dbPort;

    @PostMapping("/datasource/{tenant}")
    public boolean updateDataSource(@PathVariable String tenant, @RequestBody DbInfo dbInfo) {

        HikariDataSource ds = new HikariDataSource();
        ds.setConnectionTimeout(dbInfo.getTimeout());
        ds.setMaximumPoolSize(dbInfo.getMaxPool());
        ds.setDriverClassName(driver);
        ds.setJdbcUrl("jdbc:mysql://" + dbUrl + ":" + dbPort + "/" + dbInfo.getSchema());
        ds.setUsername(dbInfo.getUserName());
        ds.setPassword(dbInfo.getPassword());

        tenantDataSource.getTargetDataSources().put(tenant, ds);
        tenantDataSource.afterPropertiesSet();
        return true;
    }
}
