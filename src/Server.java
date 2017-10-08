/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @authors Derouich Elyes && ElMay Zied && Najar Atef
 */

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import static java.lang.Math.abs;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.Vector;

public class Server implements Runnable {

    Socket csocket;

    Server(Socket csocket) {
        this.csocket = csocket;
    }

    public static void main(String args[]) throws Exception {
        ServerSocket ssock = new ServerSocket(5555);
        System.out.println("Serveur Lancée...");
        while (true) {
            Socket sock = ssock.accept();
            System.out.println("Client Connected");
            new Thread(new Server(sock)).start();
        }
    }

    public void run() {
        try {
            boolean done = false;
            boolean gagnant = false;
            Vector allComb = new Vector();
            Vector randomComb = new Vector();
            Vector clientEssai = new Vector();
            allComb.add(0, "Rouge");
            allComb.add(1, "Vert");
            allComb.add(2, "Turquoise");
            allComb.add(3, "Orange");
            allComb.add(4, "Jaune");
            allComb.add(5, "Violet");
            allComb.add(6, "Rose");
            allComb.add(7, "Blue");
            
            PrintStream pstream = new PrintStream(csocket.getOutputStream());
            Random r = new Random();
            for (int i = 0; i < 4; i++) {
                int rndm = abs(r.nextInt() % 8);
                String str = allComb.get(rndm).toString();
                randomComb.add(i, str);
                pstream.println(str);
            }
            BufferedReader input = new BufferedReader(new InputStreamReader(csocket.getInputStream()));
            //int coup=10;
            while (!done) {
                // coup--; //Decrementation
                int nbBlanc = 0;
                int nbNoir = 0;
                clientEssai.add(0, input.readLine());
                clientEssai.add(1, input.readLine());
                clientEssai.add(2, input.readLine());
                clientEssai.add(3, input.readLine());
                for (int i = 0; i < 4; i++) {
                    if (randomComb.get(i).equals(clientEssai.get(i))) {
                        nbNoir++;
                    } else if ((randomComb.contains(clientEssai.get(i)))) {
                        nbBlanc++;
                    }
                }
                pstream.println(nbNoir);
                pstream.println(nbBlanc);
                //Refresh attemps counter
                if (nbNoir == 4) {
                    done = true;
                    gagnant=true;
                }
            }
            int i = 0;
            while (i < 100000000) {
                Thread.sleep(3000);
                i++;
            }
            pstream.close();
            csocket.close();
        } catch (IOException e) {
            System.out.println(e);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
