import java.io.Serializable;

public class Course implements Serializable{

    //Instance variables
    private String courseTitle, courseProfessor, courseLocation;

    //Construct new course
    public Course(String title, String prof, String location){
        courseTitle = title;
        courseProfessor = prof;
        courseLocation = location;

    }

    //Override method to print as string
    public String toString(){
        String temp = "Course Title: " + courseTitle;
        return temp;
    }

    //Accessor to get course title
    public String getCourseTitle(){
        return courseTitle;
    }


}
