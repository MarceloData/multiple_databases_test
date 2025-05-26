package com.tests.interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.tests.models.modelsHive.Language;

public interface LanguageMapper {
    Language toEntity(ResultSet resultSet) throws SQLException;
}
