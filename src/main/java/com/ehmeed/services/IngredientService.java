package com.ehmeed.services;


import com.ehmeed.commands.IngredientCommand;

public interface IngredientService {

    IngredientCommand findByRecipeIdAndId(long recipeId, long id);
}
