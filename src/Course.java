import java.util.Calendar;

public class Course {

    private String courseTitle, courseProfessor, courseLocation;

    public Course(String title, String prof, String location){
        courseTitle = title;
        courseProfessor = prof;
        courseLocation = location;

        System.out.print(this.toString());

    }

    public String toString(){
        String temp = "Course Title: " + courseTitle;
        return temp;
    }

    public String getCourseTitle(){
        return courseTitle;
    }


}
