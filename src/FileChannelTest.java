import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by wame1 on 2016/8/15.
 */
public class FileChannelTest {
    public static void main(String arg[]){
        RandomAccessFile file;
        File a;
        try{

            file= new RandomAccessFile(".\\test.txt", "rw") ;
            FileChannel in=file.getChannel();
            ByteBuffer buf=ByteBuffer.allocate(48);
            int bytes=in.read(buf);
            while(bytes!=-1){
                System.out.println(bytes);
                buf.flip();
                while (buf.hasRemaining()){
                    System.out.print((char)buf.get());
                }
                buf.clear();
                bytes=in.read(buf);
            }
            file.close();
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
