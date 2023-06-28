package javalecture.lecture.ch19;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferdeOutputStreamEx01 {
    public static void main(String[] args) {
        try {
            FileOutputStream fos =
                    new FileOutputStream("out\\BufferedOutputStream.txt");
            BufferedOutputStream bos =
                    new BufferedOutputStream(fos);
            String s = "Welcome to stream!!!";
            byte[] b = s.getBytes();
            bos.write(b);
            bos.flush();
            bos.close();
            fos.close();
            System.out.println("Success!");
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
