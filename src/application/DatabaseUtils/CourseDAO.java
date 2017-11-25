package application.DatabaseUtils;

import application.TimetableClasses.Course;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 11/11/2017.
 */
public class CourseDAO {
    public static void insertCourse(Course course)
    {
        Connection conn=DatabaseConnection.getConnection();
        PreparedStatement pstmt=null;
        try {
            pstmt=conn.prepareStatement("INSERT INTO course VALUES(?,?,?,?)");
            pstmt.setString(1,course.getCourseId());
            pstmt.setString(2,course.getCourseName());
            pstmt.setInt(3,course.getFrequencyOfCourse());
            pstmt.setInt(4,course.getCourseCredits());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if(pstmt!=null)
            {
                try {
                    pstmt.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static List<Course> getAllCourses()
    {
        ArrayList<Course> list=new ArrayList<Course>();
        Connection conn=DatabaseConnection.getConnection();
        Statement stmt=null;
        ResultSet rs=null;
        try {
            stmt = conn.createStatement();
            rs=stmt.executeQuery("Select * from course");

            while(rs.next())
            {
                Course course =  new Course();
                course.setCourseId(rs.getString(1));
                course.setCourseName(rs.getString(2));
                course.setFrequencyOfCourse(rs.getInt(3));
                course.setCourseCredits(rs.getInt(4));

                list.add(course);
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
        return list;
    }
    public static Course getCourseByCourseId(String courseId)
    {
        Connection conn=DatabaseConnection.getConnection();
        PreparedStatement preparedStatement=null;
        Course course=null;
        try {
            preparedStatement = conn.prepareStatement("SELECT * FROM course WHERE courseId = ?");
            preparedStatement.setString(1,courseId);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next())
            {
                course =  new Course();
                course.setCourseId(rs.getString(1));
                course.setCourseName(rs.getString(2));
                course.setFrequencyOfCourse(rs.getInt(3));
                course.setCourseCredits(rs.getInt(4));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if(preparedStatement!=null)
            {
                try {
                    preparedStatement.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return course;
    }

    //course_id should be the name of the field in table
    public static void deleteCourse(String id){
        Connection conn=DatabaseConnection.getConnection();
        PreparedStatement pstmt = null;
        try{
            pstmt = conn.prepareStatement("delete from course where courseId = ?");
            pstmt.setString(1,id);
            pstmt.executeUpdate();
        }catch(Exception exc){
            exc.printStackTrace();
        }finally{
            if(pstmt!=null){
                try{
                    pstmt.close();
                }catch (Exception exc){
                    exc.printStackTrace();
                }
            }
        }
    }
}
