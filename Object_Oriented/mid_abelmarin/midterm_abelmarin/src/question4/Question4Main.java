// Abel Marin
// Question 4
package question4;

public class Question4Main {
    public static void main(String args[]) {
        City London = new City("London", 8000000);

        Nation UK = new Nation("UK", 60000000, London);

        City capital = UK.getCapital();

        System.out.printf("Nation capital name: %s, capital population: %s%n", capital.name, capital.population);

    }
}
