import java.io.IOException;
import java.nio.file.Paths;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        CaesarCipherDecoder ccd = new CaesarCipherDecoder();

        Map<Character, Float> probabilityMap = ccd.getCharProbabilityMap(Paths.get("src/main/resources/russian.txt"));
        probabilityMap.forEach((c, f) -> System.out.println(c + " " + f));
        System.out.println(probabilityMap.values().stream().reduce(Float::sum));
    }
}
