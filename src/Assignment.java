public class Assignment {

    private int dayDue, monthDue, yearDue;
    private Course assignmentCourse;
    private String assignmentName;

    public Assignment(int day, int month, int year, Course assignmentCourse, String name){
        this.assignmentCourse = assignmentCourse;
        dayDue = day;
        monthDue = month;
        yearDue = year;
        assignmentName = name;
    }


}
