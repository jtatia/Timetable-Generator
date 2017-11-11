package application.TimetableClasses;

public class Department {
    private String id;

    private String deptName;

    public Department(String id,String deptName){
        this.id = id;
        this.deptName = deptName;
    }

    public Department() {

    }

    public String getId() {
        return this.id;
    }

    public String getDeptName() {
        return this.deptName;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}
