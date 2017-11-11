package application.TimetableClasses;

public class Triplet {
    private Teacher teacher;
    private Course course;
    private Batch batch;

    public Triplet(Teacher teacher, Course course, Batch batch) {
        this.teacher = teacher;
        this.course = course;
        this.batch = batch;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public Course getCourse() {
        return course;
    }

    public Batch getBatch() {
        return batch;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setBatch(Batch batch) {
        this.batch = batch;
    }
}
