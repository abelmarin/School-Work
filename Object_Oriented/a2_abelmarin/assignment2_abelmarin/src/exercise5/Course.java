// Abel Marin
// Exercise 5
package exercise5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

public class Course {
    private String title;
    private ArrayList<CourseRecord> courseRecords = new ArrayList<CourseRecord>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void addCourseRecord(CourseRecord courseRecord) {}

    public Enumeration<CourseRecord> getCourseRecords() {
        Enumeration<CourseRecord> enumeration = Collections.enumeration(courseRecords);
        return enumeration;
    }

    public void printCourseStudents() {

    }

    public void printBestStudent() {

    }

    public void printFinalExamStudents() {

    }
}
