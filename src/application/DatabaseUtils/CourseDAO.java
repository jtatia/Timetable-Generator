package application.DatabaseUtils;

import application.TimetableClasses.Course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by dell on 11/11/2017.
 */
public class CourseDAO {
    public void insertCourse(Course course)
    {
        Connection conn=DatabaseConnection.getConnection();
        PreparedStatement pstmt=null;
        try {
            pstmt=conn.prepareStatement("INSERT INTO Course(``,`course_name`,`course_info`)VALUES(?,?,?)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
