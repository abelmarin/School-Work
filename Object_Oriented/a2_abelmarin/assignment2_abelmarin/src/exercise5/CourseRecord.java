// Abel Marin
// Exercise 5
package exercise5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

public class CourseRecord {
    private Student student;
    private ArrayList<Assignment> assignments;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void addAssignments(Assignment a) {

    }

    public Enumeration<Assignment> getAssignments() {
        Enumeration<Assignment> enumeration = Collections.enumeration(assignments);
        return enumeration;
    }

    public double average() {
        return 0;
    }

    public boolean canTakeFinalExam() {
        return true;
    }
}
