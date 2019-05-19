package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        try {
            JSONObject sandwichInfo = new JSONObject(json);
            JSONObject name = sandwichInfo.getJSONObject("name");
            JSONArray alsoKnownAs = sandwichInfo.getJSONArray("alsoKnownAs");
            JSONArray ingredients = sandwichInfo.getJSONArray("ingredients");

            String mainName = name.getString("mainName");
            String origin = sandwichInfo.getString("placeOfOrigin");
            String description = sandwichInfo.getString("description");
            String image = sandwichInfo.getString("image");

            List<String> alsoKnownAsList = null;
            List<String> ingredientsList = null;

            for (int i=0; i<alsoKnownAs.length(); i++) {
                String currentName = alsoKnownAs.getString(i);
                alsoKnownAsList.add(currentName);
            }

            for (int i=0; i<ingredients.length(); i++) {
                String currentIngredient = ingredients.getString(i);
                ingredientsList.add(currentIngredient);
            }

            return new Sandwich(mainName, alsoKnownAsList, origin, description, image, ingredientsList);


        } catch (JSONException e) {

        }

        return null;
    }
}
