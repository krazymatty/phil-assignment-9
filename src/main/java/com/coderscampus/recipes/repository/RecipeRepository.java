package com.coderscampus.recipes.repository;

import java.io.IOException;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coderscampus.recipes.domain.Recipe;
import com.coderscampus.recipes.service.RecipeFileService;

@Repository
public class RecipeRepository {

	@Autowired
	private RecipeFileService fileService;
	
    public List<String> filterBy(Predicate<Recipe> filter) throws IOException {
        return fileService.readCSV().stream()
                .filter(filter)
                .map(Recipe::getTitle)
                .sorted()
                .peek(System.out::println)
                .collect(Collectors.toList());
    }
    
    public List<String> allRecipes() throws IOException {
        return fileService.readCSV().stream()
                .map(Recipe::getTitle)
                .sorted()
                .peek(System.out::println)
                .collect(Collectors.toList());
    }
}
