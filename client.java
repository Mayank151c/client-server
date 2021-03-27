import java.io.*;
import java.net.*;

public class client{
    public static void main(String args[]) throws Exception{
        Socket s = new Socket("localhost",3333);

        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String s1="",s2="";

        System.out.println("Address : "+s.getInetAddress());
        System.out.println("Local Port : "+s.getLocalPort());
        System.out.println("Port : "+s.getPort());

        while(!s1.equals("stop")){

            //Client to server
            s1 = buff.readLine();//client writes in buffer
            dout.writeUTF(s1);// goes to server
            dout.flush();// clean dout

            //Receive from server
            s2 = din.readUTF();
            System.out.println("Server : "+s2);
        }
        dout.close();
        s.close();
    }
}