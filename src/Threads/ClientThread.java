/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Threads;

import Controller.Controller;
import Transfer.TransferObject;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author User
 */
public class ClientThread extends Thread {
    
    private Socket socket;
    ObjectOutputStream out;
    ObjectInputStream in;
    int clientNumber;

    public ClientThread(Socket socket, int clientNumber) {
        this.socket = socket;
        this.clientNumber = clientNumber;
        System.out.println("Klijent: " + clientNumber + " je uspostavio konekciju!");
        start();
    }

    @Override
    public void run() {
        try {
            String signal = "";

            TransferObject transferObject;

            while (true) {
                out = new ObjectOutputStream(socket.getOutputStream());
                in = new ObjectInputStream(socket.getInputStream());

                transferObject = (TransferObject) in.readObject();
                String operation = transferObject.operation;
                
                if(operation.equals("login")) {
                    Controller.getInstance().login(transferObject);
                }

//                if (operation.equals("kreirajKorisnika")) {
//                    kreirajKorisnika(transferObject);
//                }
//                if (operation.equals("promeniKorisnika")) {
//                    promeniKorisnika(transferObject);
//                }
//                if (operation.equals("obrisiKorisnika")) {
//                    obrisiKorisnika(transferObject);
//                }
//                if (operation.equals("nadjiKorisnika")) {
//                    nadjiKorisnika(transferObject);
//                }
//                if (operation.equals("naPrvi")) {
//                    naPrvi(transferObject);
//                }
//                if (operation.equals("naSledeci")) {
//                    naSledeci(transferObject);
//                }
//                if (operation.equals("naPredhodni")) {
//                    naPredhodni(transferObject);
//                }
//                if (operation.equals("naPoslednji")) {
//                    naPoslednji(transferObject);
//                }
                out.writeObject(transferObject);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
    
    
    
}
