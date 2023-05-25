import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MorseTranslator {
    private Map<String, String> morseToCharMap;

    public MorseTranslator() {
        initializeMorseToCharMap();
    }

    private void initializeMorseToCharMap()
    {
        morseToCharMap = new HashMap<>();
        morseToCharMap.put(".-", "A");
        morseToCharMap.put("-...", "B");
        morseToCharMap.put("-.-.", "C");
        morseToCharMap.put("-..", "D");
        morseToCharMap.put(".", "E");
        morseToCharMap.put("..-.", "F");
        morseToCharMap.put("--.", "G");
        morseToCharMap.put("....", "H");
        morseToCharMap.put("..", "I");
        morseToCharMap.put(".---", "J");
        morseToCharMap.put("-.-", "K");
        morseToCharMap.put(".-..", "L");
        morseToCharMap.put("--", "M");
        morseToCharMap.put("-.", "N");
        morseToCharMap.put("---", "O");
        morseToCharMap.put(".--.", "P");
        morseToCharMap.put("--.-", "Q");
        morseToCharMap.put(".-.", "R");
        morseToCharMap.put("...", "S");
        morseToCharMap.put("-", "T");
        morseToCharMap.put("..-", "U");
        morseToCharMap.put("...-", "V");
        morseToCharMap.put(".--", "W");
        morseToCharMap.put("-..-", "X");
        morseToCharMap.put("-.--", "Y");
        morseToCharMap.put("--..", "Z");
        morseToCharMap.put("-.-..", "Ç");
        morseToCharMap.put(" ", " ");
    }

    public String translateMorseToChar(String morseCode)
    {
        StringBuilder translatedText = new StringBuilder();
        String[] morseWords = morseCode.split(" / ");

        for (String morseWord : morseWords) {
            String[] morseLetters = morseWord.split(" ");
            for (String morseLetter : morseLetters) {
                if (morseLetter.isEmpty()) {
                    translatedText.append(" ");
                } else {
                    String character = morseToCharMap.get(morseLetter);
                    translatedText.append(character != null ? character : "?");
                }
            }
            translatedText.append(" ");
        }

        return translatedText.toString().trim();
    }

    public void translateFile(String inputFile, String outputFile)
    {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile)))
        {
            String line;
            while ((line = reader.readLine()) != null)
            {
                String morseCode = line.trim();
                String translatedText = translateMorseToChar(morseCode);
                writer.write(morseCode + " -> " + translatedText);
                writer.newLine();
            }
            System.out.println("La traduction est terminée. Veuillez consulter le fichier " + outputFile + ".");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
