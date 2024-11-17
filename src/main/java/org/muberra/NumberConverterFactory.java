package org.muberra;

public class NumberConverterFactory {
    public static NumberConverter getNumberConverter(Language language) {
        return switch (language) {
            case ENGLISH -> new EnglishConverter();
            case TURKISH -> new TurkishConverter();
        };
    }
}
