package com.raj.config;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class HikariConnectionPool {

    private static final HikariDataSource dataSource;

    static {
        HikariConfig config = new HikariConfig();

config.setJdbcUrl(
    "jdbc:mysql://localhost:3306/health_clinic_management_db?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true"
);

config.setUsername("Raj_Bahadur_Singh");
config.setPassword("RajPassword123!");
config.setDriverClassName("com.mysql.cj.jdbc.Driver");

config.setMaximumPoolSize(10);
config.setMinimumIdle(2);
config.setPoolName("HealthClinicPool");

        dataSource = new HikariDataSource(config);
    }

    private HikariConnectionPool() {
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static void shutdown() {
        if (dataSource != null && !dataSource.isClosed()) {
            dataSource.close();
        }
    }
}