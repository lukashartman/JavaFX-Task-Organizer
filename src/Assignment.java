import java.time.LocalDate;

public class Assignment {

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
        temp = "\nAssignment Name: " + assignmentName;
        temp += "\nDue Date: " + dueDate;
        temp += "\nCourse: " + assignmentCourse.getCourseTitle();
        return temp;
    }

    public LocalDate getDueDate(){
        return dueDate;
    }

}
