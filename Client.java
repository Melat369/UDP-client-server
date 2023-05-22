import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client{
    public static void main (String args[])throws Exception {
        try (DatagramSocket ds = new DatagramSocket()) {
            int i = 4;
            byte[] b = String.valueOf(i).getBytes();
            InetAddress ia = InetAddress.getLocalHost();
            DatagramPacket dp = new DatagramPacket(b, b.length,ia,8500);

            ds.send(dp);


            byte[] b2= new byte[5241];
            DatagramPacket dp2 = new DatagramPacket(b2, b2.length);

            ds.receive( dp2);

            String str = new String(dp2.getData());
            System.out.println("The resutl is: "+ str);
        } 


    }

}