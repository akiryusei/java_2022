package test01;

import java.util.HashMap;

public class Student {
    private long id;
    private String name;

    HashMap<String,  Double>  scoreMap;//成绩存放在hashmap里面
    public Student(long id, String name)
    {
        this.id = id;
        this.name = name;

        scoreMap = new HashMap<String, Double>();
    }

    public void addCourseScore(String courseId,Double score){
        scoreMap.put(courseId,score);
    }//增加

    public double getCourseScore(String courseId){
        if(scoreMap.containsKey(courseId))
        {
            return  scoreMap.get(courseId);
        }
        else
            return -1;
    }
    //打印学生成绩
    public void printScore()
    {

    }

    @Override  //重写tostring
    public String toString()
    {
        return id + " : " + name;
    }

}
