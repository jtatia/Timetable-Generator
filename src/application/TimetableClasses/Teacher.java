package application.TimetableClasses;

public class Teacher {
    private String id;

    private String teacherName;

    public Teacher(String id,String teacherName){
        this.id = id;
        this.teacherName = teacherName;
    }

    public String getId() {
        return this.id;
    }

    public String getTeacherName() {
        return this.teacherName;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
}
