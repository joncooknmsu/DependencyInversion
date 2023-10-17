//
// Abstract interface for a source of words; this is our
// dependency inversion interface, our main program now uses
// this abstraction rather than the raw Java Library classes.
// 
public interface WordSource {
    public boolean initialize(String resource);
    public boolean notDone();
    public String nextWord();
}
