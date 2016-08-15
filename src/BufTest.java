import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

/**
 * Created by wame1 on 2016/8/15.
 */
public class BufTest {
    public static void main(String arg[]){
        RandomAccessFile file;
        File a;
        try{

            file= new RandomAccessFile(".\\test.txt", "rw") ;
            FileChannel in=file.getChannel();


            ByteBuffer buf=ByteBuffer.allocate(48);
            CharBuffer cbuf;
            int bytes=in.read(buf);
            String temp="sfdsfsfs王蒙";
            while(bytes!=-1){
                System.out.println(bytes);
                buf.flip();
               cbuf= Charset.forName("GBK").decode(buf);
               // cbuf.flip();
                System.out.println(cbuf);


                buf.clear();
                bytes=in.read(buf);
            }

            in.write(ByteBuffer.wrap("I love world".getBytes()));
            in.close();
            file.close();
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
