package application.DatabaseUtils;

import application.TimetableClasses.Department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("Duplicates")
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

        PreparedStatement preparedStatement = null;
        ArrayList<Department> list = new ArrayList<Department>();

        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM department");
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next())
            {
                Department department = new Department();
                department.setId(resultSet.getString(1));
                department.setDeptName(resultSet.getString(2));
                list.add(department);
            }

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

        return list;

    }

    public static List<Department> getDepartmentByID(String id){

        Connection connection = DatabaseConnection.getConnection();

        PreparedStatement preparedStatement = null;
        ArrayList<Department> list = new ArrayList<Department>();

        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM department WHERE id = ?");
            preparedStatement.setString(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next())
            {
                Department department = new Department();
                department.setId(resultSet.getString(1));
                department.setDeptName(resultSet.getString(2));
                list.add(department);
            }

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

        return list;

    }

}
