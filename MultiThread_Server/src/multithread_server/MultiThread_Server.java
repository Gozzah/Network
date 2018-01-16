/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multithread_server;

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
public class MultiThread_Server {

    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            while (true) {
//               Socket socket = serverSocket.accept();
//               Client_Connection client = new Client_Connection(socket);
//               client.start();
                new Client_Connection(serverSocket.accept()).start();
                System.out.println("Client connected");
            }

        } catch (IOException e) {
            System.out.println("Server exception" + e.getMessage());

            e.printStackTrace();
        }

    }

}
