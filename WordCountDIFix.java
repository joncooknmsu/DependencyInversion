//
// Word counter with the fixed dependency direction using the
// dependency inversion pattern. Now this code does not depend
// on the Java library (no import statements!), it only depends
// on its own desired abstractions.
//

public class WordCountDIFix
{

public WordCountDIFix()
{
}

public int countWords(String resource, String prefix)
{
    int words = 0;
    // Note that we MUST create an object of the wrapper class,
    // but then we use it as an interface object. A factory class
    // could further isolate us from the wrapper dependency
    WordSource source = new WordSourceJavaLib();
    // Our code below is now at our own desired abstraction; because
    // this is a simple example, the abstract is not hugely different
    // from the Java library capability, but it still demonstrates the idea
    if (source.open(resource) == false)
        return -1;
    while (source.notDone()) {
        String word = source.nextWord();
        if (prefix == null || word.startsWith(prefix))
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