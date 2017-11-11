package application.DatabaseUtils;

import application.TimetableClasses.Course;
import application.TimetableClasses.Teacher;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by the_Shashwat on 11/11/2017.
 */
public class TeacherCourseDAO {
    /*
    * DAO for teacher course relation
    * field one : courseID
    * field two : teacherID
    * */

    public static void insertCourseTeacherRecord(String courseId,String teacherId)
    {
        Connection connection = DatabaseConnection.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO course_teacher VALUES (?,?)");
            preparedStatement.setString(1,courseId);
            preparedStatement.setString(2,teacherId);
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
    public static Teacher getTeacherByCourseId(String courseId)
    {
        Teacher teacher=null;
        PreparedStatement pstmt=null;
        Connection conn=DatabaseConnection.getConnection();
        Statement stmt=null;
        ResultSet rs=null;
        try {
            stmt = conn.createStatement();
            rs=stmt.executeQuery("Select * from course_teacher where courseId="+courseId);
            while(rs.next())
            {
                TeacherDAO teacherDAO=new TeacherDAO();
                teacher=teacherDAO.getTeacherById(rs.getString(2));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if(stmt!=null)
            {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return teacher;
    }

    public static List<Course> getCoursesByTeacherId(String teacherId)
    {
        ArrayList<Course> list=new ArrayList<Course>();
        Connection conn=DatabaseConnection.getConnection();
        Statement stmt=null;
        ResultSet rs=null;
        try {
            stmt = conn.createStatement();
            rs=stmt.executeQuery("Select * from course_teacher where teacherId="+teacherId);
            while(rs.next())
            {
                Course course =  CourseDAO.getCourseByCourseId(rs.getString(1));
                list.add(course);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if(stmt!=null)
            {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }
}
