package com.tests.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tests.exceptions.DatabaseAccessException;
import com.tests.models.modelsHive.Language;
import com.tests.utils.LanguageMapperImp;

import io.agroal.api.AgroalDataSource;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class LanguageRepository {

    @Inject
    AgroalDataSource dataSource;

    @Inject
    LanguageMapperImp languageMapperImp;

    public List<Language> listLanguages() throws SQLException {
        List<Language> entities = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM sakila.language",
                        ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Language entity = languageMapperImp.toEntity(resultSet);
                    entities.add(entity);
                }
            }
        } catch (DatabaseAccessException e) {
            throw new DatabaseAccessException("Language service failed", e);
        }
        return entities;
    }
}
