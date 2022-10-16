package Bai1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> list = readDataformFile("C:/Users/Admin/IdeaProjectst/Session16-thucHanh/src/Bai1/tinnguon.txt");
        writeFile("C:\\Users\\Admin\\IdeaProjectst\\Session16-thucHanh\\src\\Bai1\\tindich.txt",list,tinhKyTu(list));

    }
    public static List<String> readDataformFile(String path){
        List<String> list =new ArrayList<>();
        File file = null;
        FileInputStream fis = null;
        InputStreamReader isr =null;
        BufferedReader br =null;
        try {
            file=new File(path);
            fis=new FileInputStream(file);
            isr =new InputStreamReader(fis);
            br=new BufferedReader(isr);
            String line ="";
            while ((line =br.readLine()) !=null){
                list.add(line);
            }


        }catch (Exception ex1){
            ex1.printStackTrace();
        }finally {
            try {
                if (br!=null){
                    br.close();
                }
                if (isr!=null){
                    br.close();
                }
                if (fis!=null){
                    br.close();
                }

            }catch (Exception ex2){
                ex2.printStackTrace();
            }
        }
        return list;


    }
    public static void writeFile(String path,List<String> list, String sokytu){
        File file =null;
        FileOutputStream fos=null;
        OutputStreamWriter osw=null;
        BufferedWriter bw =null;
        try {
            file= new File(path);
            fos=new FileOutputStream(file);
            osw=new OutputStreamWriter(fos);
            bw =new BufferedWriter(osw);
            for (String str:list) {
                bw.write(str);
                bw.flush();
                bw.newLine();
            }
            bw.write(sokytu);
        }catch (Exception ex2){
            ex2.printStackTrace();
        }finally {
            try {
                if (bw!=null){
                    bw.close();
                }
                if (osw!=null){
                    osw.close();
                }
                if (fos!=null){
                    fos.close();
                }
            }catch (Exception ex3){
                ex3.printStackTrace();
            }
        }
    }
    public static String tinhKyTu(List<String> list){
        int cnt =0;
        for (String sktu:list) {
            cnt+= sktu.length();
        }
        return " SỐ KÝ TỰ Là"+cnt;

    }
}
