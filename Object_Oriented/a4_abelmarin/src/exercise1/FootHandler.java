// Exercise 1
// Abel Marin
package exercise1;

public class FootHandler implements Handler {
    private Handler chain;

    @Override
    public void setNextChain(Handler nextChain) {
        this.chain=nextChain;
    }

    @Override
    public String nextConversion(String units, String value) {
        try {
            Double valueNum = Double.valueOf(value);
            valueNum = valueNum * 3;
            String valueStr = String.valueOf(valueNum);
            if(units.equals("Foot") && valueNum >= 0) {
                return valueStr;
            } else {
                return "Value cannot be negative.";
            }
        } catch (Exception e) {
            return "Not a number.";
        }
    }
}
