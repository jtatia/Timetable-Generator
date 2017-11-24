package application.DatabaseUtils;

import application.TimetableClasses.Course;
import application.TimetableClasses.Teacher;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by the_Shashwat on 11/11/2017.
 */
public class CourseBatchDAO {
    /*
    * DAO for teacher course relation
    * field one : courseID
    * field two : teacherID
    * */

    public static void insertCourseBatchRecord(String courseId,String batchId)
    {
        Connection connection = DatabaseConnection.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO course_batch VALUES (?,?)");
            preparedStatement.setString(1,courseId);
            preparedStatement.setString(2,batchId);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(preparedStatement!=null){
                try {
                    preparedStatement.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static List<Course> getCoursesByBatchId(String batchId)
    {
        ArrayList<Course> courseList = new ArrayList<Course>();
        Teacher teacher=null;
        PreparedStatement pstmt=null;
        Connection conn=DatabaseConnection.getConnection();
        Statement stmt=null;
        ResultSet rs=null;
        try {
            stmt = conn.createStatement();
            rs=stmt.executeQuery("Select * from course_batch where batchId="+batchId);
            while(rs.next())
            {
                courseList.add(CourseDAO.getCourseByCourseId(rs.getString("courseId")));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if(stmt!=null)
            {
                try {
                    stmt.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return courseList;
    }


}
