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
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Runes tryllemaskine
 */
public class Client {
    
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        
        try( 
                Socket socket = new Socket("localhost", 8080)){
                 BufferedReader echoes = new BufferedReader(
                 new InputStreamReader(socket.getInputStream()))   ;
                 PrintWriter stringToEcho = new PrintWriter(socket.getOutputStream(), true);
                 
                 Scanner scanner = new Scanner(System.in);
                 String echoString;
                 String response;
                 
                 do{
                    
                    System.out.println("Enter String to be echoed: ");
                    echoString = scanner.nextLine();
                    stringToEcho.println(echoString);
                    if (!echoString.equals("exit")) {
                        response = echoes.readLine();
                        System.out.println(response);
                    }
                 }
                 //Grunden til vi bruger et do/while loop, er fordi vi vil have at overstående kommando bliver kørt hvertfald en gang, 
                 //Så brugeren har mulighed for at trykke exit hvis han/hun startede det ved en fejl
                 while(!echoString.equals("exit"));
                
                
                
                
    } catch(IOException e){
            System.out.println("Client Error" +  e.getMessage());
    }
    
}
}