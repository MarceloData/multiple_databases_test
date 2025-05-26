package com.tests.services;

import java.util.List;
import java.util.stream.Collectors;

import com.tests.dtos.LanguageDTO;
import com.tests.exceptions.LanguageServiceException;
import com.tests.exceptions.ResourceNotFoundException;
import com.tests.models.modelsHive.Language;
import com.tests.repositories.LanguageRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class LanguageService {

    @Inject
    LanguageRepository languageRepository;

    public List<LanguageDTO> listLanguages() {
        try {
            List<Language> result = languageRepository.listLanguages();
            if (result == null || result.isEmpty()) {
                throw new ResourceNotFoundException("No languages found in the database.");
            }
            return result.stream().map(lang -> new LanguageDTO(lang.getName(), lang.getLastUpdate()))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new LanguageServiceException("Failed to fetch languages", e);
        }
    }

    public Long countLanguages() {
        try {
            Long result = languageRepository.listLanguages().stream().count();
            return result;
        } catch (Exception e) {
            throw new LanguageServiceException("Failed to count languages", e);
        }
    }
}
