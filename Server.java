
import java.io.*;
import java.net.*;
import java.util.*;
public class Server {
    public static void main (String args[]) throws Exception{
         ServerSocket ss=new ServerSocket(9999);
         Socket s= ss.accept();
         DataInputStream din= new DataInputStream(s.getInputStream());
         DataOutputStream dout=new DataOutputStream(s.getOutputStream());
         File newfile=new File("hello.txt");
         Scanner sc=new Scanner(newfile);
         int isthere=0;
         String fname=din.readUTF();
         if(fname.equals(newfile.getName())){
             isthere=1;
             dout.writeInt(isthere);
             System.out.println("File exists");
             String inputline;
             while(sc.hasNextLine()){
                 inputline=sc.nextLine();
                 dout.writeUTF(inputline);
             }

         }
         else{
             System.out.println("File not found");
             dout.writeInt(isthere);
         }
         sc.close();
         s.close();
         ss.close();
         

    }
    
}
