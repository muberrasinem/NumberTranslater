import org.muberra.Language;
import org.muberra.NumberConverter;
import org.muberra.NumberConverterFactory;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TurkishConvertTest {
    @Test
    public void testConvertbindokuzyuz() {
        NumberConverter tr = NumberConverterFactory.getNumberConverter(Language.TURKISH);
        assertEquals("bin dokuz yüz ", tr.convert(1900));
    }
    @Test
    public void testConvertbesyuzotuzyedimilyon() {
        NumberConverter tr = NumberConverterFactory.getNumberConverter(Language.TURKISH);
        assertEquals("beş yüz otuz yedi milyon iki yüz kırk dokuz bin sekiz yüz altmış bir ", tr.convert(537249861));
    }
    @Test
    public void testConvertbesyuzotuzyedimilyonn() {
        NumberConverter tr = NumberConverterFactory.getNumberConverter(Language.TURKISH);
        assertEquals("yüz ", tr.convert(100));
    }

}
