// Exercise 2
// Abel Marin
package exercise2;

public class ConverterClient {
    private Handler chain;

    public ConverterClient(){
        this.chain = new MileHandler();

        Handler yardHandlerObj = new YardHandler();
        Handler footHandlerObj=new FootHandler();

        chain.setNextChain(yardHandlerObj);
        yardHandlerObj.setNextChain(footHandlerObj);
    }

    public String convert(String units, String value) {
        ConverterClient converterClient = new ConverterClient();
        return converterClient.chain.nextConversion(units,value);
    }
}
