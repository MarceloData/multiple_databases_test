package com.tests.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.tests.interfaces.LanguageMapper;
import com.tests.models.modelsHive.Language;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LanguageMapperImp implements LanguageMapper {

    @Override
    public Language toEntity(ResultSet resultSet) throws SQLException {
        Language language = new Language();

        language.setLanguageId(resultSet.getLong("LANGUAGE_ID"));
        language.setName(resultSet.getString("NAME"));
        language.setLastUpdate(resultSet.getString("LAST_UPDATE"));
        return language;
    }
}
