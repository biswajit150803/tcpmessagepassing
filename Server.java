import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args)throws IOException {
        Socket socket = null;
        InputStreamReader inputStreamReader = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        ServerSocket serverSocket = new ServerSocket(9999);
        // accept a new client connection
        while (true) {
            try{
                socket=serverSocket.accept();
                inputStreamReader = new InputStreamReader(socket.getInputStream());
                outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());
                bufferedReader = new BufferedReader(inputStreamReader);
                bufferedWriter = new BufferedWriter(outputStreamWriter);
                // for sending messages to the client
                while(true)
                {
                    String messageFromClient=bufferedReader.readLine();
                    System.out.println("Client: "+messageFromClient);
                    bufferedWriter.write("Message recieved");
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                    if(messageFromClient.equalsIgnoreCase("BYE"))
                    {
                        break;
                    }
                }
                socket.close();
                inputStreamReader.close();
                outputStreamWriter.close();
                bufferedReader.close();
                bufferedWriter.close();
            }catch(IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
