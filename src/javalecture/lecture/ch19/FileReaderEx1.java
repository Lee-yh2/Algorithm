package javalecture.lecture.ch19;

import java.io.*;

public class FileReaderEx1 {
    public static void main(String[] args) {
        try{
            String sep = File.separator;

            String fileName = "C:\\Users\\dbsgu\\Desktop\\메가바이트스쿨\\EduExample\\src\\javalecture\\lecture\\ch19\\FileReaderEx1.java";
            FileInputStream fis = new FileInputStream(fileName);
            FileReader fr = new FileReader(fileName);

            int data = 0;

            //바이트기반으로 읽어와 유니코드인 한글이 깨져보인다
            while((data = fis.read())!=-1){
                System.out.print((char)data);
            }
            System.out.println();
            fis.close();

            //문자기반이라 유니코드인 한글도 잘보임
            while((data=fr.read())!=-1) {
                System.out.print((char)data);
            }
            System.out.println();
            fr.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
