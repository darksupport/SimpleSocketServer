package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Brainacad4 on 24.05.2018.
 */
public class ServerClass implements Runnable{

    ServerSocket listener;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    boolean enabled = true;

    public ServerClass(int port) throws IOException {
        listener = new ServerSocket(port);
    }

    @Override
    public void run() {
        try {
            while (enabled)
            {
                Socket socket = listener.accept();
                System.out.println("New client conected" + socket.getInetAddress());
                ConnectionHandler connect = new ConnectionHandler(socket);
                Thread thr = new Thread(connect);
                thr.start();
                //----- invoke handler method
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}
