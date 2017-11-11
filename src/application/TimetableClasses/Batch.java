package application.TimetableClasses;

public class Batch {
    private String id;

    private String department;

    public Batch(String id, String dept) {
        this.id = id;
        this.department = dept;
    }

    public Batch() {

    }

    public String getId() {
        return this.id;
    }

    public String getDepartment() {
        return this.department;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDepartment(String dept) {
        this.department = dept;
    }
}
