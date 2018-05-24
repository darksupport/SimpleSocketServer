package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Brainacad4 on 24.05.2018.
 */
public class ConnectionHandler implements Runnable{

    Socket socket;
    public ConnectionHandler(Socket socket)
    {
        this.socket = socket;
    }


    @Override
    public void run() {
        try {
            InputStreamReader stream = new InputStreamReader(socket.getInputStream());
            BufferedReader reader = new BufferedReader(stream);
            PrintWriter pr = new PrintWriter(socket.getOutputStream(), true);
            while (socket.isConnected()) {
                String data = reader.readLine();
                System.out.println("Recived data: " + data);
                pr.println("Data recived");
            }
            socket.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
