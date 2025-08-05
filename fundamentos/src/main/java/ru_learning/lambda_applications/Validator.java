package ru_learning.lambda_applications;

import java.util.List;

@FunctionalInterface
interface Validator<T, E extends Exception> {
    void validate(T target) throws E;
    static <T, E extends Exception> void applyRules(List<Validator<T, E>> rules, T target) throws E {
        for(Validator<T, E> rule : rules) {
            rule.validate(target);
        }
        System.out.println("Valid videogame");
    }
}
