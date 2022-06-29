import test01.Course;
import test01.Student;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class StudentApp {

    public static ArrayList<Student> studentList = new ArrayList<Student>();
    public static ArrayList<Course> courseList = new ArrayList<Course>();

    public  static HashMap<Long, Student> studentMap = new HashMap<Long, Student>();
//学生的学号是个long
    public static void readStudents(String filename) {
        try (Scanner sc = new Scanner(new File(filename))) {
            int lineno = 0;
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                lineno++;
                if (lineno == 1) {
                    continue;
                }
                String[] fileds = line.split(",");

                Student s = new Student(Long.parseLong(fileds[0]), fileds[1]);
                studentList.add(s);

                studentMap.put(Long.parseLong(fileds[0]),s);
            }
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }



    public static void readCourses(String filename)
    {
        try (Scanner sc = new Scanner(new File(filename))) {
            int lineno = 0;
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                //
                lineno++;
                if (lineno == 1) {
                    continue;
                }
                String[] fileds = line.split(",");

                Course c = new Course(fileds[0],fileds[1],Double.parseDouble(fileds[2]));
                courseList.add(c);
            }
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void readScore(String filename) {
        try (Scanner sc = new Scanner(new File(filename))) {
            int lineno = 0;
            String[] header;
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                lineno++;
                if (lineno == 1) {
                    header = line;
                    continue;
                    //第一行的话 保存下来header

                }
                String[] fileds = line.split(",");
                //为学生增加课程成绩
                for(int i = 3;i<fileds.length;i++)
                {
                    Student s = studentMap.get(Long.parseLong(fileds[0]));
                    s.addCourseScore(header[i], Double.parseDouble(fileds[i]));
                }
            }
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        //System.out.println("");
        readStudents("F:/java_data/student.csv");
        studentList.forEach(System.out::println);

        readCourses("F:/java_data/courses.csv");
        courseList.forEach(System.out::println);

        readScore("F:/java_data/score.csv");
    }

}
