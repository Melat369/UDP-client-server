import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Server{
    public static void main (String a[]) throws Exception
    {
        try (DatagramSocket ds = new DatagramSocket(8500)) {
            byte[] b1 = new byte[5241];

            DatagramPacket dp = new DatagramPacket(b1,b1.length);
            ds.receive(dp);
            String str = new String(dp.getData());
            int num = Integer.parseInt(str.trim());
            int result = num*num;
            byte[] b2 = String.valueOf(result).getBytes();

            InetAddress ia = InetAddress.getLocalHost();
            DatagramPacket dpq = new DatagramPacket(b2,b2.length, ia , dp.getPort());
            ds.send(dpq);
        }
    }
} 