/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echoserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Runes tryllemaskine
 */
public class Server {

  
    public static void main(String[] args) {
        
       try (ServerSocket serverSocket = new ServerSocket(8080)){
           // ServerSocket venter på at der sendes en request over netværket
           //Porten er en integer der kan gå fra 1-65.000
           
           
           
           Socket socket = serverSocket.accept();
           // socket er en endpoint connection mellem to maskiner
           //.accept blokerer indtil at en client er connected
           //Client connected vil aldrig blive skrevet, da systemet venter på en client connecter.
           System.out.println("Client Connected");
           
           //Reads text from a character-input stream, buffering characters so as to provide for the efficient reading of characters, arrays, and lines.
           //Without buffering, each invocation of read() or readLine() could cause bytes to be read from the file, converted into characters, and then returned, which can be very inefficient.
           BufferedReader input  = new BufferedReader(
           //An InputStreamReader is a bridge from byte streams to character streams: It reads bytes and decodes them into characters      
           new InputStreamReader(socket.getInputStream()));
           
           //Prints formatted representations of objects to a text-output stream
           //Vi skriver true, så den flusher hver gang den har været i brug
           PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
           
           while(true){
               //Sættes til true da serveren skal være i live så længe clienten har brug for det
               
               String echoString = input.readLine();
               if(echoString.equals("exit")){
                   break;
               }
               output.println("Echo from server" + echoString);
           }
           
           
           
       }
       catch(IOException e)  {
           System.out.println("Server exception" + e.getMessage());
           
           e.printStackTrace();
       }
       
        
    }
    
}
