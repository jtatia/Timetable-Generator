package application.TimetableClasses;

public class Course {
    private String id;

    private String courseName;

    private int frequencyOfCourse;

    public Course(String id,String courseName,int frequencyOfCourse){
        this.id = id;
        this.courseName = courseName;
        this.frequencyOfCourse = frequencyOfCourse;
    }

    public String getId() {
        return this.id;
    }

    public String getCourseName() {
        return this.courseName;
    }

    public int getFrequencyOfCourse() {
        return this.frequencyOfCourse;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setFrequencyOfCourse(int frequencyOfCourse) {
        this.frequencyOfCourse = frequencyOfCourse;
    }
}
