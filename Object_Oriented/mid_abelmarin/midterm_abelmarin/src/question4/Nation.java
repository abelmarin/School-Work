// Abel Marin
// Question 4
package question4;

public class Nation {
    public String name;
    public int population;
    public City capital;

    public City getCapital() {
        return capital;
    }

    public Nation(String name, int population, City capital) {
        this.name = name;
        this.population = population;
        this.capital = capital;
    }

}
