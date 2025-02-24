package edu.kit.calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class FormulaTest {
    @Test
    public void hardCodedCases() {
        Assertions.assertEquals("", Formula.calculate(""));
        Assertions.assertEquals("10", Formula.calculate("10"));

        Assertions.assertEquals("500,0", Formula.calculate("50*10"));
        Assertions.assertEquals("5,0", Formula.calculate("50/10"));
        Assertions.assertEquals("60,0", Formula.calculate("50+10"));
        Assertions.assertEquals("40,0", Formula.calculate("50-10"));

        Assertions.assertEquals("5000,0", Formula.calculate("50*10*10"));
        Assertions.assertEquals("50,0", Formula.calculate("50/10*10"));
        Assertions.assertEquals("150,0", Formula.calculate("50+10*10"));
        Assertions.assertEquals("-50,0", Formula.calculate("50-10*10"));

        Assertions.assertEquals("50,0", Formula.calculate("50*10/10"));
        Assertions.assertEquals("0,5", Formula.calculate("50/10/10"));
        Assertions.assertEquals("51,0", Formula.calculate("50+10/10"));
        Assertions.assertEquals("49,0", Formula.calculate("50-10/10"));

        Assertions.assertEquals("5000,0", Formula.calculate("50*(10*10)"));
        Assertions.assertEquals("0,5", Formula.calculate("50/(10*10)"));
        Assertions.assertEquals("600,0", Formula.calculate("(50+10)*10"));
        Assertions.assertEquals("400,0", Formula.calculate("(50-10)*10"));

        Assertions.assertEquals("50,0", Formula.calculate("50*(10/10)"));
        Assertions.assertEquals("50,0", Formula.calculate("50/(10/10)"));
        Assertions.assertEquals("6,0", Formula.calculate("(50+10)/10"));
        Assertions.assertEquals("4,0", Formula.calculate("(50-10)/10"));
    }
}
