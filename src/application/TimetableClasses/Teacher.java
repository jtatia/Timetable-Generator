package application.TimetableClasses;

public class Teacher {
    private String id;

    private String teacherName;

    private String department; // ForeignKey
    public Teacher()
    {
        // Default Constructor
    }

    public Teacher(String id,String teacherName,String department){
        this.id = id;
        this.teacherName = teacherName;
        this.department = department;
    }

    public String getId() {
        return this.id;
    }

    public String getTeacherName() {
        return this.teacherName;
    }

    public String getDepartment() {
        return this.department;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
