package ru_learning.util;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class BasicVideogame {

    private String name;
    private Double price;
    private Console console;
}
