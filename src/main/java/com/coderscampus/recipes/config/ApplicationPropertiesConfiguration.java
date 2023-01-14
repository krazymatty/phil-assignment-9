package com.coderscampus.recipes.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "file")
public class ApplicationPropertiesConfiguration {
  
  private String recipesFilename;
  
  public String getRecipesFilename() {
    return recipesFilename;
  }
  
  public void setRecipesFilename(String recipesFilename) {
    this.recipesFilename = recipesFilename;
  }
}

