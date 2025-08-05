package ru_learning.lambda_applications;

import ru_learning.util.Console;
import ru_learning.util.Database;
import ru_learning.util.InvalidVideogameException;
import ru_learning.util.Videogame;

import java.util.List;
import java.util.Objects;

public class ValidatorApp {

    public static void main(String[] args) {

        var videogame1 = Database.videogames.get(0);
        var videogame2 = Database.videogames.get(2);
        var videogame3 = Database.videogames.get(3);
        var videogame4 = Database.videogames.get(4);

        isValidVideogame(videogame1);

        Validator.applyRules(ValidationRules.rules, videogame1);
        Validator.applyRules(ValidationRules.rules, videogame2);
        Validator.applyRules(ValidationRules.rules, videogame3);
        Validator.applyRules(ValidationRules.rules, videogame4);

    }

    private static void isValidVideogame(Videogame videogame) {

        if(Objects.isNull(videogame)) {
            throw new IllegalArgumentException("Cant be null");
        } else {
            if(videogame.getPrice() < 20) {
                throw new InvalidVideogameException("Price must be greater than 20");
            } else if (!videogame.getConsole().equals(Console.XBOX)) {
                throw new InvalidVideogameException("Console must be for XBOX");
            } else if (videogame.getReviews().isEmpty()) {
                throw new InvalidVideogameException("Reviews cannot be empty");
            } else if (videogame.getTotalSold() < 10) {
                throw new InvalidVideogameException("Total sold must be greater than 10");
            } else if(videogame.getIsDiscount()) {
                throw new InvalidVideogameException("Videogame dont have discount");
            }
        }
        System.out.println("Valid videogame");
    }



}







