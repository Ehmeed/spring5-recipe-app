package com.ehmeed.services;

import com.ehmeed.commands.IngredientCommand;
import com.ehmeed.converters.IngredientToIngredientCommand;
import com.ehmeed.domain.Ingredient;
import com.ehmeed.domain.Recipe;
import com.ehmeed.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class IngredientServiceImpl implements IngredientService {

    private final RecipeRepository recipeRepository;
    private final IngredientToIngredientCommand ingredientToIngredientCommand;

    public IngredientServiceImpl(RecipeRepository recipeRepository, IngredientToIngredientCommand ingredientToIngredientCommand) {
        this.recipeRepository = recipeRepository;
        this.ingredientToIngredientCommand = ingredientToIngredientCommand;
    }

    @Override
    public IngredientCommand findByRecipeIdAndId(long recipeId, long ingredientId) {

        Optional<Recipe> recipeOptional = recipeRepository.findById(recipeId);

        if(!recipeOptional.isPresent()){
            return null;
        }
        Recipe recipe = recipeOptional.get();
        log.debug("Recipe has " + recipe.getIngredients().size() + " ingredients");
        for(Ingredient i : recipe.getIngredients()){
            log.debug(i.getId()+"");
        }
        Optional<IngredientCommand> ingredientCommandOptional = Optional.empty();
        for (Ingredient ingredient : recipe.getIngredients()) {
            if (ingredient.getId().equals(ingredientId)) {
                IngredientCommand convert = ingredientToIngredientCommand.convert(ingredient);
                ingredientCommandOptional = Optional.of(convert);
                break;
            }
        }


        if(!ingredientCommandOptional.isPresent()){
            return null;
        }
        return ingredientCommandOptional.get();
    }
}
