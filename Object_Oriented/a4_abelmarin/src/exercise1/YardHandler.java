// Exercise 1
// Abel Marin
package exercise1;

public class YardHandler implements Handler {
    private Handler chain;

    @Override
    public void setNextChain(Handler nextChain) {
        this.chain=nextChain;
    }

    @Override
    public String nextConversion(String units, String value) {
        try {
            Double valueNum = Double.valueOf(value);
            valueNum = valueNum * 1760;
            String valueStr = String.valueOf(valueNum);
            if (units.equals("Yard") && valueNum >= 0) {
                return valueStr;
            } else {
                return this.chain.nextConversion(units, valueStr);
            }
        } catch (Exception e) {
            return this.chain.nextConversion(units, value);
        }
    }
}
