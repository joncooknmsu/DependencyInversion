//
// Word counter with the bad dependency direction, with high level
// code (this class) depending on low level code (Java library)
//

// We have to import the Java library classes because we
// are depending on low-level modules
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class WordCountNoDI
{

public WordCountNoDI()
{
}

public int countWords(String resource, String prefix)
{
    // In here we use all the Java library classes to
    // implement our capability. We are depending on the
    // low level modules, not abstractions!
    Scanner scanner;
    int words = 0;
    try {
        scanner = new Scanner(new File(resource));
    } catch (IOException e) {
        System.err.println("I/O Error! (" + e + ")");
        return -1;
    }
    while (scanner.hasNext()) {
        String token = scanner.next();
        if (prefix == null || token.startsWith(prefix))
            words++;
    }
    return words;
}

public static void main(String args[])
{
    String prefix = null;
    int wordCount;
    if (args == null || args.length < 1 || args.length > 2) {
        System.err.println("Usage: WordCountNoDI <filename> [prefix]");
        return;
    }
    if (args.length == 2) {
        prefix = args[1];
    }
    WordCountNoDI wordCounter = new WordCountNoDI();
    wordCount = wordCounter.countWords(args[0], prefix);
    if (wordCount < 0)
        return;
    System.out.println("Word count for (" + args[0] + "), prefix (" + prefix + "): " + wordCount);
}
}