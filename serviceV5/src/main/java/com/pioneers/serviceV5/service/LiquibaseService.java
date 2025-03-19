package com.pioneers.serviceV5.service;

import liquibase.Contexts;
import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.SQLException;

@Slf4j
@Service
@RequiredArgsConstructor
public class LiquibaseService {

   private static final String CLASS_NAME = LiquibaseService.class.getSimpleName();

    private final DataSource dataSource;
    /* as long as I write this annotation @RequiredArgsConstructor and set this attribute final or write @NonNull
     annotation, spring inject it in this class automatically. */

    public void rollback(int rollbackCount) throws SQLException, LiquibaseException {
        final String methodName = "rollback/ " + CLASS_NAME ;

        final ClassLoaderResourceAccessor resourceAccessor = new ClassLoaderResourceAccessor();

        final Database database = DatabaseFactory.getInstance()
                .findCorrectDatabaseImplementation(new JdbcConnection(dataSource.getConnection()));

        try{
            Liquibase liquibase = new Liquibase("db/changelog/db.changelog-master.xml", resourceAccessor
                    , database);
            liquibase.rollback(rollbackCount, String.valueOf(new Contexts()));
        } catch (Exception e) {
            log.error("{}, Error during rollback: {}", methodName, e.getMessage());
            throw new LiquibaseException("Error during rollback: " + e);
        }
    }
}
