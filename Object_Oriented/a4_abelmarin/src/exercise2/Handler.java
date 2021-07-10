// Exercise 2
// Abel Marin
package exercise2;

public interface Handler {
    void setNextChain(Handler nextChain);
    String nextConversion(String units, String value);
}
