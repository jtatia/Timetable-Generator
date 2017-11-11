package application.TimetableClasses;

public class Doublet {
    private Teacher teacher;
    private Course course;

    public Doublet(Teacher teacher, Course course) {
        this.teacher = teacher;
        this.course = course;
    }

    public Teacher getDTeacher() {
        return teacher;
    }

    public Course getDCourse() {
        return course;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
