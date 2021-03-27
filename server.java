import java.io.*;
import java.net.*;

public class server{
    public static void main(String args[]) throws Exception{
        //Initialize a server
        ServerSocket masterSocket = new ServerSocket(3333);
        Socket s = masterSocket.accept();

        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String s1="",s2="";

        while(!s2.equals("stop")){

            //Receive from Client
            s1 = din.readUTF();
            System.out.println("Client "+"["+s.getLocalPort()+"]"+": "+s1);

            //Server to Client
            s2 = buff.readLine();//server write in buffer
            dout.writeUTF(s2);   //goes to client
            dout.flush();        //clean dout
        }
        din.close();
        s.close();
        masterSocket.close();
    }
}