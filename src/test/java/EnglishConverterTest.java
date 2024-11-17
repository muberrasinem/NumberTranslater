import org.muberra.Language;
import org.muberra.NumberConverter;
import org.muberra.NumberConverterFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class EnglishConverterTest {
    @Test
    public void testEnglishConverter() {
        NumberConverter en = NumberConverterFactory.getNumberConverter(Language.ENGLISH);
        var actual = en.convert(10);
        assertEquals(actual, "ten");
    }

    @Test
    public void testConvertZero() {
        NumberConverter en = NumberConverterFactory.getNumberConverter(Language.ENGLISH);
        assertEquals("zero", en.convert(0));
    }

    @Test
    public void testConvertOne() {
        NumberConverter en = NumberConverterFactory.getNumberConverter(Language.ENGLISH);
        assertEquals("one", en.convert(1));
    }

    @Test
    public void testConvertTwelve() {
        NumberConverter en = NumberConverterFactory.getNumberConverter(Language.ENGLISH);
        assertEquals("twelve", en.convert(12));
    }

    @Test
    public void testConvertTwentyOne() {
        NumberConverter en = NumberConverterFactory.getNumberConverter(Language.ENGLISH);
        assertEquals("twenty one", en.convert(21));
    }

    @Test
    public void testConvertOneHundred() {
        NumberConverter en = NumberConverterFactory.getNumberConverter(Language.ENGLISH);
        assertEquals("one hundred", en.convert(100));
    }

    @Test
    public void testConvertOneHundredTwentyThree() {
        NumberConverter en = NumberConverterFactory.getNumberConverter(Language.ENGLISH);
        assertEquals("one hundred twenty three", en.convert(123));
    }

    @Test
    public void testConvertTwobillion() {
        NumberConverter en = NumberConverterFactory.getNumberConverter(Language.ENGLISH);
        assertEquals("two billions one hundred forty seven millions four hundred eighty three thousands six hundred forty seven", en.convert(2147483647));
    }


    @Test
    public void testConvertOneThousandTwoHundredThirtyFour() {
        NumberConverter en = NumberConverterFactory.getNumberConverter(Language.ENGLISH);
        assertEquals("one thousand two hundred thirty four", en.convert(1234));
    }

}