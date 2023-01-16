package com.coderscampus.recipes.repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coderscampus.recipes.domain.Recipe;
import com.coderscampus.recipes.repository.impl.RecipeRepositoryImpl;
import com.coderscampus.recipes.service.RecipeFileService;

@Repository
public class RecipeRepository implements RecipeRepositoryImpl {

    @Autowired
    private RecipeFileService fileService;
    
    private List<Recipe> recipes = new ArrayList<>();
    
    private List<Recipe> loadRecipes() {
    	if (recipes.isEmpty()) {
    		try {
    		recipes.addAll(fileService.readCSV());
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
    	}
    	return recipes;
    }
    
    @Override
    public List<String> filterBy(Predicate<Recipe> predicate) throws IOException {
        return loadRecipes().stream()
                .filter(predicate)
                .map(Recipe::getTitle)
                .sorted()
                .collect(Collectors.toList());
    }
    @Override
    public List<Recipe> allRecipes() throws IOException {
        return loadRecipes().stream()
        		.sorted((r1, r2) -> r1.getTitle().compareTo(r2.getTitle()))
                .collect(Collectors.toList());
    }

	@Override
	public String home() throws IOException {
		return "Recipe Home Page";
	}
	@Override
	public List<Recipe> returnRecipe(Predicate<Recipe> predicate) throws IOException {
        return loadRecipes().stream()
                .filter(predicate)
                .sorted((r1, r2) -> r1.getTitle().compareTo(r2.getTitle()))
                .collect(Collectors.toList());

	}

}

