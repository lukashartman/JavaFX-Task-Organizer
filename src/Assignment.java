import java.io.Serializable;
import java.time.LocalDate;

public class Assignment implements Serializable {

    //Instance variables
    private Course assignmentCourse;
    private String assignmentName;
    private LocalDate dueDate;

    //Construct new assignment
    public Assignment(LocalDate dueDate, Course assignmentCourse, String name){
        this.assignmentCourse = assignmentCourse;
        this.dueDate = dueDate;
        assignmentName = name;
    }

    //Override method to print as string
    public String toString(){
        String temp;
        temp = "Assignment Name: " + assignmentName;
        temp += "\nDue Date: " + dueDate.toString();
        temp += "\nCourse: " + assignmentCourse.getCourseTitle();
        return temp;
    }

    //Accessor to get due date of assignment
    public LocalDate getDueDate(){
        return dueDate;
    }

    //Accessor to course and title of assignment
    public String getAssignmentName(){
        return assignmentCourse.getCourseTitle() + ": " + assignmentName;
    }

    //Accessor to return course of assignment
    public Course getCourse(){
        return assignmentCourse;
    }

}
