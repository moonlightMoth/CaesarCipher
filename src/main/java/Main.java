import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("src/main/resources/russian.txt");

        new CaesarCipherEncoder().encode("СИГУРД БАХНУЛ БРАГИ И УПАЛ С ДРАККАРА", 33, "ЛИКЁРО-ВОДОЧНЫЕ ЗАВОДЫ - ОСНОВА ЗДОРОВОЙ ЭКОНОМИКИ ГОСУДАРСТВА!");

    }
}
