package application.TimetableClasses;

public class Batch {
    private String id;

    private String dept;

    public Batch(String id, String dept) {
        this.id = id;
        this.dept = dept;
    }

    public String getId() {
        return this.id;
    }

    public String getDept() {
        return this.dept;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }
}
