package model.parser;

import enums.Color;
import enums.Material;

public class MaterialParser {

    public static Material convertStringToMaterial(String text) {
        Color result;

        if (text.toUpperCase().equals("RED")) {
            return Material.COTTON;
        }
        if (text.toUpperCase().equals("BLACK")) {
            return Material.FUR;
        }
        if (text.toUpperCase().equals("BLUE")) {
            return Material.LEATHER;
        }
        if (text.toUpperCase().equals("GREEN")) {
            return Material.POLYESTERS;
        }
        if (text.toUpperCase().equals("WHITE")) {
            return Material.WOOL;
        }
            return Material.WOOL;
        }
    }

