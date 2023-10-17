//
// Java Library wrapper that implements the abstract interface of
// the WordSource interface. Notice that this is the only class in
// this version of the program that imports any Java library classes;
// the rest of our program is abstracted away from these dependencies!
//
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class WordSourceJavaLib implements WordSource
{

private Scanner scanner;

public boolean initialize(String resource)
{
    try {
        scanner = new Scanner(new File(resource));
    } catch (IOException e) {
        System.err.println("I/O Error! (" + e + ")");
        return false;
    }
    return true;
}

public boolean notDone()
{
    if (scanner == null)
        return false;
    return scanner.hasNext();
}

public String nextWord()
{
    if (scanner == null)
        return null;
    return scanner.next();
}

}
