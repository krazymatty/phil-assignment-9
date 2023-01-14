package com.coderscampus.recipes.repository.impl;

import java.io.IOException;
import java.util.List;
import java.util.function.Predicate;

import com.coderscampus.recipes.domain.Recipe;

public interface RecipeRepositoryImpl {
    List<Recipe> returnRecipe(Predicate<Recipe> predicate) throws IOException;
    List<String> filterBy(Predicate<Recipe> predicate) throws IOException;
    List<Recipe> allRecipes() throws IOException;
    String home() throws IOException;
}

