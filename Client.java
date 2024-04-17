import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        // Create a new instance of the class
        // and call the method
        Socket socket = null;
        InputStreamReader inputStreamReader = null;
        OutputStreamWriter outputStreamWriter = null;
        // bufferdereader reads a large amount of block at a time
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try{
            socket=new Socket("localhost", 9999);
            inputStreamReader = new InputStreamReader(socket.getInputStream());
            outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());
            bufferedReader = new BufferedReader(inputStreamReader);
            bufferedWriter = new BufferedWriter(outputStreamWriter);
            Scanner sc=new Scanner(System.in);
            while(true)
            {
                String messageToSend=sc.nextLine();
                bufferedWriter.write(messageToSend);
                bufferedWriter.newLine();
                bufferedWriter.flush();
                System.out.println("Server: "+bufferedReader.readLine());
                if(messageToSend.equalsIgnoreCase("BYE"))
                {
                    break;
                }
            }
        }catch(UnknownHostException e){
            e.printStackTrace();
    }
    catch(Exception e){
        e.printStackTrace();
    }
    finally{
        try{
            if(socket!=null)
            {
                socket.close();
            }
            if(inputStreamReader!=null)
            {
                inputStreamReader.close();
            }
            if(outputStreamWriter!=null)
            {
                outputStreamWriter.close();
            }
            if(bufferedReader!=null)
            {
                bufferedReader.close();
            }
            if(bufferedWriter!=null)
            {
                bufferedWriter.close();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
}