import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        new CaesarCipherEncoder().encode("СИГУРД БАХНУЛ БРАГИ И УПАЛ С ДРАККАРА", 4, "ЛИКЁРО-ВОДОЧНЫЕ ЗАВОДЫ - ОСНОВА ЗДОРОВОЙ ЭКОНОМИКИ ГОСУДАРСТВА!");
        new CaesarCipherEncoder().encode("СИГУРД БАХНУЛ БРАГИ И УПАЛ С ДРАККАРА", 4, "анатолий");

    }
}
