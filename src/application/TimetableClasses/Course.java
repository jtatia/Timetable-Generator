package application.TimetableClasses;

public class Course {
    private String courseId;

    private String courseName;

    private int frequencyOfCourse;

    private int courseCredits;

    public Course(String courseId,String courseName,int frequencyOfCourse,int courseCredits){
        this.courseId = courseId;
        this.courseName = courseName;
        this.frequencyOfCourse = frequencyOfCourse;
        this.courseCredits = courseCredits;
    }

    public String getCourseId() {
        return this.courseId;
    }

    public String getCourseName() {
        return this.courseName;
    }

    public int getFrequencyOfCourse() {
        return this.frequencyOfCourse;
    }

    public int getCourseCredits() {
        return this.courseCredits;
    }

    public void setCourseId(String id) {
        this.courseId = courseId;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setFrequencyOfCourse(int frequencyOfCourse) {
        this.frequencyOfCourse = frequencyOfCourse;
    }

    public void setCourseCredits(int courseCredits) {
        this.courseCredits = courseCredits;
    }
}
