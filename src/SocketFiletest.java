import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by wame1 on 2016/8/15.
 */
public class SocketFiletest {
    public static void main(String arg[]){
        try {
            SocketChannel in = SocketChannel.open();
            in.connect(new InetSocketAddress("http://jenkov.com/",80));
            ByteBuffer buf=ByteBuffer.allocate(80);
            int bts=in.read(buf);
            while(bts!=-1){
                buf.flip();
                while (buf.hasRemaining()){
                    System.out.print((char)buf.get());
                }
                buf.clear();
                in.read(buf);
            }
            in.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
