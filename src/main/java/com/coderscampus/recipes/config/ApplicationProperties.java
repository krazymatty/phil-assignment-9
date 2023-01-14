package com.coderscampus.recipes.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "file")
public class ApplicationProperties {
  
  private String recipesFilename;
  
  public String getRecipesFilename() {
    return recipesFilename;
  }
  
  public void setRecipesFilename(String recipesFilename) {
    this.recipesFilename = recipesFilename;
  }
}

