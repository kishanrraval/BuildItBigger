package com.example;

import java.util.Random;

public class JokeLibrary
{
    private static String jokes[] = {
            "Joke no 1 - bla bla bla",
            "Joke no 2 - bla bla bla",
            "Joke no 3 - bla bla bla",
            "Joke no 4 - bla bla bla",
            "Joke no 5 - bla bla bla"
    };
    public static String getJoke()
    {
        Random random = new Random();
        int index;
        index = random.nextInt(jokes.length);
        return jokes[index];
    }
}
