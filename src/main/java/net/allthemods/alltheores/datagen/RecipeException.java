package net.allthemods.alltheores.datagen;

public class RecipeException extends IllegalStateException {
    public RecipeException(String id, String message) {
        super(String.format("recipe error: %s - %s", id, message));
    }
}
