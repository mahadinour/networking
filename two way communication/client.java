package mahadi201902121;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.*;
public class client {
    public static void main(String[] args) throws Exception{
        //creat socket(builtin) object 
       Socket s = new Socket("localhost", 6550);//host and port 
       System.out.println("connected to server at using port number"+s.getLocalPort());
       
       
       /// data transmission
      DataInputStream input = new DataInputStream(s.getInputStream());
      DataOutputStream output= new DataOutputStream(s.getOutputStream());
      BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
      String input_str ="";
      String output_str ="";
      
      while(!output_str.equals("stop")){
          //read
      output_str = read.readLine();
      output.writeUTF(output_str);
      
      //write
      input_str = input.readUTF();
      System.out.println("server says "+input_str);
    }
    output.close();
    s.close();
}
}
