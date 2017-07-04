package coms;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class server {
    public static void main(String[] args) {
        StringBuilder ispis = new StringBuilder();
        try {
            ServerSocket ss = new ServerSocket(6005);
            while (true) {

                Socket s = ss.accept();
                ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
                int vrednosti[][] = (int[][]) ois.readObject();
                System.out.println("Maze received :\n");
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        System.out.print(vrednosti[i][j]);
                    }
                    System.out.println("");
                }

                ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
                ispis.append("aaasadf");
                ispis.append("\n");
                oos.writeObject(ispis.toString());


                ois.close();
                oos.close();
                s.close();
                

            }
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

}
