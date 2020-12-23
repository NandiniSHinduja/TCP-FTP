

import java.io.*;
import java.util.*;
import java.net.*;
public class Client{
    public static void main(String[] args) throws Exception {
        Socket s=new Socket("localhost", 9999);
        System.out.println("Client is online");
        DataInputStream din= new DataInputStream(s.getInputStream());
        DataOutputStream dout=new DataOutputStream(s.getOutputStream());
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the file to be received from the server:");
        String fname=sc.nextLine();
        File f1=new File(fname);
        
        dout.writeUTF(fname);
        int isthere=din.readInt();
        if(isthere==1){
            String inputline;
            FileWriter fw=new FileWriter(f1);
            while((inputline=din.readUTF())!=null){
                fw.write(inputline);
                fw.flush();

            }
            System.out.println("File received");
            fw.close();
        }
        
        else{
            System.out.println("The file is not there in the server");
            f1.delete();
        }
        
        sc.close();
        s.close();


        
    }
}