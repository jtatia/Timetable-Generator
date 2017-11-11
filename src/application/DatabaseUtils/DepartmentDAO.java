package application.DatabaseUtils;

import application.TimetableClasses.Department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DepartmentDAO {

    public static void insertDepartment(Department department){

        Connection connection = DatabaseConnection.getConnection();

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO department VALUES (?,?)");
            preparedStatement.setString(1,department.getId());
            preparedStatement.setString(2,department.getDeptName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(preparedStatement!=null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static List<Department> getAllDepartments(){
        Connection connection = DatabaseConnection.getConnection();
    }

}
