public class Course {

    private String courseTitle, courseProfessor, courseLocation;

    public Course(String title, String prof, String location){
        courseTitle = title;
        courseProfessor = prof;
        courseLocation = location;

        System.out.print(this.toString());

    }

    public String toString(){
        String temp = "Class Name: " + courseTitle;
        return temp;
    }


}
