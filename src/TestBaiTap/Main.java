package TestBaiTap;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List<Student> studentList=new ArrayList<>();
        Student st1=new Student("SV01","TUẤN",18);
        Student st2=new Student("SV02","TUẤN",19);
        Student st3=new Student("SV03","TUẤN",20);
        Student st4=new Student("SV04","TUẤN",21);
        Student st5=new Student("SV05","TUẤN",22);
        studentList.add(st1);
        studentList.add(st2);
        studentList.add(st3);
        studentList.add(st4);
        studentList.add(st5);
        try {
            writeObjectToFile(studentList,"studentList.txt");

        }catch (Exception e){
            throw new RuntimeException(e);
        }
        readObjectFromfile("studentList.txt");
    }
    public static void writeObjectToFile(List<Student> student, String path ) throws IOException {
        File file=null;
        FileOutputStream fos=null;
        ObjectOutputStream oos=null;
        try {
            file=new File(path);
            fos=new FileOutputStream(file);
            oos=new ObjectOutputStream(fos);
            oos.writeObject(student);
        }catch (Exception ex1){
            ex1.printStackTrace();
        }finally {
            try {
                if (fos!=null){
                    fos.close();
                }if (oos!=null){
                    oos.close();
                }
            }catch (Exception ex2){
                ex2.printStackTrace();
            }
        }
    }
    public static void readObjectFromfile(String path) throws IOException, ClassNotFoundException {
        File file=null;
        FileInputStream fis =null;
        ObjectInputStream ois=null;
        try {
            file=new File(path);
            fis=new FileInputStream(file);
            ois=new ObjectInputStream(fis);
            List<Student> studentList = (List<Student>) ois.readObject();
            for (Student st:studentList) {
                System.out.printf("Ma SV: %s - ten SV: %s - Tuoi: %d\n",st.getStudentId(),st.getName(),st.getAge());

            }

        }catch (Exception ex1){
            ex1.printStackTrace();
        }finally {
            try {
                if (ois!=null){
                    ois.close();
                }if (fis!=null){
                    fis.close();
                }
            }catch (Exception ex2){
                ex2.printStackTrace();
            }
        }

    }
}