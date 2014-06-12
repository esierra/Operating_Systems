import java.net.*;
import java.io.*;
import java.util.Scanner;
/*
//Client sends two numbers and expects the sum from server
 //
 **/
public class Client {

    public static void main(String[] args) throws IOException {
        String host = "localhost";
        int port = 9000;
        InetAddress address = InetAddress.getByName(host);
        Socket  socket = new Socket(address, port);
 
            //Send the message to the server
            OutputStream outSteam = socket.getOutputStream();
            OutputStreamWriter outStreamWriter = new OutputStreamWriter(outSteam);
            BufferedWriter buffer = new BufferedWriter(outStreamWriter);
            Scanner scan=new Scanner(System.in);
 			
 			System.out.println("Please enter first number: ");
            String num1 = scan.nextLine();
            System.out.println("Please enter second number: ");
            String num2	  = scan.nextLine();
 
 			//separate the two numbers so buffer can read them as separate
            String mssg = num1 + " "+num2+"\n";
            buffer.write(mssg);
            buffer.flush();
            System.out.println("Numbers sent to server:" +num1 +" " +num2);
 
            //Get the return message from the server
            InputStream input = socket.getInputStream();
            InputStreamReader inputReader = new InputStreamReader(input);
            BufferedReader bufferReader = new BufferedReader(inputReader);
            String message = bufferReader.readLine();

            System.out.println("Server says : " + message);
        System.exit(0);
    }
}