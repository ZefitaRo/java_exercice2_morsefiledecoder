public class Main {
    public static void main(String[] args) {

        MorseTranslator translator = new MorseTranslator();
        translator.translateFile("input.txt", "output.txt");
    }
}