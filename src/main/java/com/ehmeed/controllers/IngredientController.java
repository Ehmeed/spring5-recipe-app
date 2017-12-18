package com.ehmeed.controllers;

import com.ehmeed.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
public class IngredientController {

    RecipeService recipeService;

    public IngredientController(RecipeService recipeService){
        this.recipeService = recipeService;
    }
}
