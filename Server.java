import java.net.*;
import java.io.*;

/*
//Server takes a string, converts it into two numbers adds them
//and sends the sum back to the client.
 */
public class Server {


    public static void main(String[] args) throws IOException {
    	//server starts listening on port 8080
        ServerSocket listen = new ServerSocket(8080);

       try
        {
 
            int port = 9000; //used to communicate with client; 
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server waiting on client");
 
            //server will hang until client closes it
            while(true) 
            {
                //Reads in the numbers from client
               	Socket socket = serverSocket.accept();
                InputStream input = socket.getInputStream();
                InputStreamReader inputReader = new InputStreamReader(input);
                BufferedReader buffer = new BufferedReader(inputReader);
                String number = buffer.readLine();
                System.out.println("Message received from client is "+number);
 
               
                String returnMessage;
        
                	//splits the string into two numbers
                	String splitStr=number.substring(0,number.indexOf(" "));
                	String splitStr2=number.substring(number.indexOf(" ")+1,number.length());

                	//string back to int to create sum
                    int numberInIntFormat = Integer.parseInt(splitStr);
                    int numberInIntFormat2=Integer.parseInt(splitStr2);
                   
                    //sum the two numbers
                    int returnValue = numberInIntFormat + numberInIntFormat2;

                    //put into string message to be sent back to client
                    returnMessage = String.valueOf(returnValue) + "\n";
                
 
                //Sending the response back to the client.
                OutputStream os = socket.getOutputStream();
                OutputStreamWriter osw = new OutputStreamWriter(os);
                BufferedWriter bw = new BufferedWriter(osw);
                bw.write(returnMessage);
                System.out.println("The sum is "+returnMessage);
                bw.flush();
            }
        }
        finally {
            listen.close();
        }
    }
}