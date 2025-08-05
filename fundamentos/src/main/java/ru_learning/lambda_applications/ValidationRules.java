package ru_learning.lambda_applications;

import lombok.NoArgsConstructor;
import ru_learning.util.Console;
import ru_learning.util.Videogame;

import java.util.List;

@NoArgsConstructor
public class ValidationRules {

    private final static Validator<Videogame, RuntimeException> isNull = videogame -> {
        if(videogame == null)
            throw new RuntimeException("Videogame is null");
    };

    private final static Validator<Videogame, RuntimeException> priceGreaterThan20 = videogame -> {
        if(videogame.getPrice() < 20)
            throw new RuntimeException("Price must be greater than 20");
    };

    private final static Validator<Videogame, RuntimeException> consoleForXbox = videogame -> {
        if(!videogame.getConsole().equals(Console.XBOX))
            throw new RuntimeException("Console must be for XBOX");
    };

    private final static Validator<Videogame, RuntimeException> reviewsNotEmpty = videogame -> {
        if(videogame.getReviews().isEmpty())
            throw new RuntimeException("Reviews cannot be empty");
    };

    private final static Validator<Videogame, RuntimeException> totalSoldGreaterThan10 = videogame -> {
        if(videogame.getTotalSold() < 10)
            throw new RuntimeException("Total sold must be greater than 10");
    };

    private final static Validator<Videogame, RuntimeException> videogameNotDiscount = videogame -> {
        if(videogame.getIsDiscount())
            throw new RuntimeException("Videogame dont have discount");
    };

    public static List<Validator<Videogame, RuntimeException>> rules = List.of(
            isNull,
            priceGreaterThan20,
            consoleForXbox,
            reviewsNotEmpty,
            totalSoldGreaterThan10,
            videogameNotDiscount
    );
}
