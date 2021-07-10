// Abel Marin
// Question 7
package question7;

import java.util.LinkedHashSet;
import java.util.Set;

public class Student {
    private String name;
    private int year;
    private Set<String> courses;

    public Student(String name, int year) {
        this.name = name;
        this.year = year;
        this.courses = new LinkedHashSet<String>();
    }

    public void addCourse(String name) {
        courses.add(name);
    }

    public void dropAll() {
        courses.clear();
    }

    public int getCourseCount() {
        return courses.size();
    }

    public String getName() {
        return name;
    }

    public double getTuition() {
        return 1450 * courses.size();
    }

    public int getYear() {
        return year;
    }
}
