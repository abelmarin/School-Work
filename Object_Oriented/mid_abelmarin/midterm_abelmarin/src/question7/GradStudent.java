// Abel Marin
// Question 7
package question7;

import java.util.LinkedHashSet;
import java.util.Set;

public class GradStudent extends Student {
    private String advisor;
    private Set<String> courses;


    public GradStudent(String name, int year, String advisor) {
        super(name, year);
        this.advisor = advisor;
        this.courses = new LinkedHashSet<String>();
    }

    @Override
    public int getYear() {
        return super.getYear() + 4;
    }

    @Override
    public void addCourse(String name) {
        if (courses.size() < 6) {
            courses.add(name);
        } else {
            System.out.println("Already at maximum number of courses.");
        }
    }

    @Override
    public double getTuition() {
        if (courses.size() <= 1) {
            return 1000;
        } else {
            return super.getTuition() * 2;
        }
    }

    public String getAdvisor() {
        return advisor;
    }

    public boolean isBurntOut() {
        if (this.getYear() >= 8 || this.getCourseCount() >= 5) {
            return true;
        } else {
            return false;
        }
    }
}
