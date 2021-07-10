// Exercise 1
// Abel Marin
package exercise1;

public interface Handler {
    void setNextChain(Handler nextChain);
    String nextConversion(String units, String value);
}
