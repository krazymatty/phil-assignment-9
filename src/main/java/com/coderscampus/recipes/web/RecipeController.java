package com.coderscampus.recipes.web;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderscampus.recipes.domain.Recipe;
import com.coderscampus.recipes.repository.RecipeRepository;

@RestController
public class RecipeController {

	@Autowired
	private RecipeRepository recipeRepository;

	@GetMapping("/gluten-free")
	public List<Recipe> glutenFree() throws IOException {
		return recipeRepository.returnRecipe(recipe -> recipe.getVegan());
	}

	@GetMapping("/vegan")
	public List<Recipe> vegan() throws IOException {
		return recipeRepository.returnRecipe(recipe -> recipe.getVegan());
	}

	@GetMapping("/vegan-and-gluten-free")
	public List<Recipe> veganAndGlutenFree() throws IOException {
		return recipeRepository.returnRecipe(recipe -> recipe.getVegan() && recipe.getGlutenFree());
	}

	@GetMapping("/vegetarian")
	public List<Recipe> vegetarian() throws IOException {
		return recipeRepository.returnRecipe(recipe -> recipe.getVegetarian());
	}

	@GetMapping("/all-recipes")
	public List<Recipe> allRecipes() throws IOException {
		return recipeRepository.allRecipes();
	}

	@GetMapping("/")
	public String home() {
		return "Recipe Home Page";
	}
}
