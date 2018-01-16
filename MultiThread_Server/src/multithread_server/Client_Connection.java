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
import java.net.Socket;

/**
 *
 * @author Runes tryllemaskine
 */
public class Client_Connection extends Thread {

    private Socket socket;

    public Client_Connection(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        try {
            BufferedReader input = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            while (true) {
                String echoString = input.readLine();

                if (echoString.equals("exit")) {
                    break;
                }
                output.println(echoString);

            }
        } catch (IOException e) {
            System.out.println("Error :" + e.getMessage());
        } finally {
            try {
                socket.close();
            } catch (IOException e) {

            }

        }
    }

}
