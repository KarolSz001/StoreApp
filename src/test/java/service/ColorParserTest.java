package service;

import enums.Color;
import model.parser.ColorParser;
import org.junit.Test;

import java.util.EnumSet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ColorParserTest {
    private final EnumSet<Color> colors  = EnumSet.allOf(Color.class);
    private final String[] colorsArrPositive = {"BLACK","WHITE","RED","GREEN","BLUE","YELLOW"};
    private final String[] colorsArrNegative = {"black", "white", "red", "green", "blue", "yellow","extraColor"};

    @Test
    public void testParsreColors() {
        EnumSet<Color> colorsEnumSet = EnumSet.noneOf(Color.class);

        for (int i = 0; i < colorsArrPositive.length; i++){
            colorsEnumSet.add(ColorParser.convertStringToColor(colorsArrPositive[i]));
        }

        for(Color color : colorsEnumSet){
            assertEquals(color.name(),colorsArrPositive[color.ordinal()]);
        }
    }

    @Test
    public void testParserColorsNegative() {
        EnumSet<Color> colorsEnumSet = EnumSet.noneOf(Color.class);

        for(int i = 0; i < colorsArrNegative.length - 1; i++){
            colorsEnumSet.add(ColorParser.convertStringToColor(colorsArrNegative[i]));
        }

        for(Color color : colorsEnumSet){
            assertNotEquals(Color.DEFAULT, colorsArrNegative[color.ordinal()]);
        }
    }
}
