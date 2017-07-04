package events;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class lavEvent implements ActionListener {
    private JTextField lav[][];
    private JTextArea serverRespText;
    int vrednostiLav[][]=new int[9][9];

    public lavEvent(JTextField lav[][],JTextArea serverRespText){
        this.lav = lav;
        this.serverRespText = serverRespText;
    }


    @Override
    public void actionPerformed(ActionEvent e){

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                vrednostiLav[i][j] = Integer.parseInt(lav[i][j].getText());
                System.out.print(vrednostiLav[i][j]);
            }
        }

        try {
            Socket s = new Socket("192.168.1.3", 6005);
            ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
            oos.reset();
            oos.writeObject(vrednostiLav);
            ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
            String poruka ="Odgovor " + (String) ois.readObject();



            serverRespText.setText(poruka);

            ois.close();
            oos.close();
            s.close();


        }catch (IOException | ClassNotFoundException e1){
            e1.printStackTrace();
        }

    }

}
