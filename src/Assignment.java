import javafx.scene.control.CheckBox;

import java.io.Serializable;
import java.time.LocalDate;

public class Assignment implements Serializable {

    private Course assignmentCourse;
    private String assignmentName;
    private LocalDate dueDate;

    public Assignment(LocalDate dueDate, Course assignmentCourse, String name){
        this.assignmentCourse = assignmentCourse;
        this.dueDate = dueDate;
        assignmentName = name;
    }

    public String toString(){
        String temp;
        temp = "Assignment Name: " + assignmentName;
        temp += "\nDue Date: " + dueDate.toString();
        temp += "\nCourse: " + assignmentCourse.getCourseTitle();
        return temp;
    }

    public LocalDate getDueDate(){
        return dueDate;
    }

    public String getAssignmentName(){
        return assignmentCourse.getCourseTitle() + ": " + assignmentName;
    }

    public Course getCourse(){
        return assignmentCourse;
    }

}
