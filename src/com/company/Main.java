package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try
        {
          ServerClass server = new ServerClass(7000);
          Thread serverThread = new Thread(server);
          serverThread.start();
        }
        catch (IOException e)
        {
          e.printStackTrace();
        }
    }
}
