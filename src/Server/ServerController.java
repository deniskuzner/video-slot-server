/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Threads.ClientThread;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class ServerController {
    
    static ServerSocket serverSocket;
    static List<ClientThread> clientThreads = new ArrayList<>();
    static int clientNumber;

    public static void main(String[] args) throws Exception {
        serverSocket = new ServerSocket(8189);
        System.out.println("Podignut je serverski program!");
        while (true) {
            Socket socket = serverSocket.accept();
            ClientThread clientThread = new ClientThread(socket, ++clientNumber);
            clientThreads.add(clientThread);
        }
    }
    
}
