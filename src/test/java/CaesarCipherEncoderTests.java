import org.junit.Assert;
import org.junit.Test;

import java.util.Locale;


public class CaesarCipherEncoderTests {

    @Test
    public void getAlterationArray()
    {
        CaesarCipherEncoder cse = new CaesarCipherEncoder();

        Assert.assertEquals("ЗАЭЁЫЪ ВИМЛВЫ".toUpperCase(Locale.ROOT),
                cse.encode(
                        "пивная кружка", 5,
                        "голота"));
    }
    
}
