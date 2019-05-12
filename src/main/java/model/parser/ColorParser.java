package model.parser;

import enums.Color;

public class ColorParser {

    public static Color convertStringToColor(String text) {

        if (text.toUpperCase().equals("RED")) {
            return Color.RED;
        }
        if (text.toUpperCase().equals("BLACK")) {
            return Color.BLACK;
        }
        if (text.toUpperCase().equals("BLUE")) {
            return Color.BLUE;
        }
        if (text.toUpperCase().equals("GREEN")) {
            return Color.GREEN;
        }
        if (text.toUpperCase().equals("WHITE")) {
            return Color.WHITE;
        }
        if (text.toUpperCase().equals("YELLOW")) {
            return Color.YELLOW;
        }

        return Color.DEFAULT;
    }

}
