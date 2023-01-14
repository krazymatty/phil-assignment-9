package com.coderscampus.recipes.web;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderscampus.recipes.repository.RecipeRepository;

@RestController
public class RecipeController {

	@Autowired
	private RecipeRepository recipeRepository;

	@GetMapping("/gluten-free")
	public List<String> glutenFree() throws IOException {
		return recipeRepository.filterBy(recipe -> recipe.getGlutenFree());
	}

	@GetMapping("/vegan")
	public List<String> vegan() throws IOException {
		return recipeRepository.filterBy(recipe -> recipe.getVegan());
	}

	@GetMapping("/vegan-and-gluten-free")
	public List<String> veganAndGlutenFree() throws IOException {
		return recipeRepository.filterBy(recipe -> recipe.getVegan() && recipe.getGlutenFree());
	}

	@GetMapping("/vegetarian")
	public List<String> vegetarian() throws IOException {
		return recipeRepository.filterBy(recipe -> recipe.getVegetarian());
	}
	
	@GetMapping("/all-recipes")
	public List<String> allRecipes() throws IOException {
		return recipeRepository.allRecipes();
	}
	
	@GetMapping("/")
	public String home() {
		return "Recipe Home Page";
	}
}
