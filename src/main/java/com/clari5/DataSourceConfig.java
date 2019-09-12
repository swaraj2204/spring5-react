package com.clari5;

import com.clari5.datasource.TenantDatasource;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DataSourceConfig {

    @Value("${tenants}")
    private String[] tenants;

    @Value("${db.host}")
    private String dbUrl;

    @Value("${db.port}")
    private int dbPort;

    @Value("${db.driver}")
    private String driver;

    @Autowired
    private Environment env;

    /**
     * Creates the default data source for the application
     *
     * @return
     */
    private DataSource defaultDataSource() {

        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setConnectionTimeout(env.getProperty("db.default.timeout", Long.class, 30000L));
        dataSource.setMaximumPoolSize(env.getProperty("db.default.max-pool", Integer.class, 5));
        dataSource.setDriverClassName(driver);
        String defaultSchema = env.getProperty("db.default.schema");
        dataSource.setJdbcUrl("jdbc:mysql://" + dbUrl + ":" + dbPort + "/" + defaultSchema);
        dataSource.setUsername(env.getProperty("db.default.user"));
        dataSource.setPassword(env.getProperty("db.default.password"));

        return dataSource;
    }

    @Bean
    @ConfigurationProperties(
            prefix = "spring.datasource"
    )
    public DataSource dataSource() {
        Map<Object, Object> dataSources = new HashMap<>();

        for (String tenant : tenants) {
            HikariDataSource dataSource = new HikariDataSource();
            dataSource.setConnectionTimeout(env.getProperty(tenant + ".db.timeout", Long.class, 30000L));
            dataSource.setMaximumPoolSize(env.getProperty(tenant + ".db.max-pool", Integer.class, 5));
            dataSource.setDriverClassName(driver);
            String defaultSchema = env.getProperty(tenant + ".db.schema");
            dataSource.setJdbcUrl("jdbc:mysql://" + dbUrl + ":" + dbPort + "/" + defaultSchema);
            dataSource.setUsername(env.getProperty(tenant + ".db.user"));
            dataSource.setPassword(env.getProperty(tenant + ".db.password"));

            dataSources.put(tenant, dataSource);
        }

        AbstractRoutingDataSource dataSource = new TenantDatasource();
        dataSource.setDefaultTargetDataSource(defaultDataSource());
        dataSource.setTargetDataSources(dataSources);
        dataSource.afterPropertiesSet();
        return dataSource;
    }
}
