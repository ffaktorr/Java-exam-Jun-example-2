package gui;

import events.lavEvent;
import javafx.scene.layout.Border;

import javax.swing.*;
import java.awt.*;

public class mainWindow extends JFrame {
    private JLabel unesiLav,unesiLav2,serverResp;
    private JTextArea serverRespText;
    private JTextField lav[][] = new JTextField[9][9];
    private JButton sendReq;
    private mainWindow(){


        this.setTitle("Jebeni GUI");
        this.setBounds(0,0,500,950);
        this.setLayout(null);

        initLavLab();
        lavirintMaker();
        serverResponce();


        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);

    }
    public void initLavLab(){

        unesiLav = new JLabel("Unesite lavirint",SwingConstants.CENTER);
        unesiLav.setFont(new Font("Serif",Font.PLAIN,25));
        unesiLav.setBounds(0,0,500,40);
        unesiLav.setBackground(Color.blue);
        unesiLav.setForeground(Color.WHITE);
        unesiLav.setOpaque(true);
        this.add(unesiLav);

        unesiLav2 = new JLabel("Prazno 0, Zid 1, Robot 2,Izlaz 5",SwingConstants.CENTER);
        unesiLav2.setFont(new Font("Serif",Font.PLAIN,25));
        unesiLav2.setBounds(0,40,500,40);
        unesiLav2.setBackground(Color.blue);
        unesiLav2.setForeground(Color.WHITE);
        unesiLav2.setOpaque(true);
        this.add(unesiLav2);

    }

    public void lavirintMaker(){
        int x=20,y=100;
        for (int i=0;i<9;i++){
            x=20;
            for(int j=0;j<9;j++){
                lav[i][j] = new JTextField();
                lav[i][j].setBounds(x,y,50,50);
                lav[i][j].setFont(new Font("Serif",Font.PLAIN,20));
                if(i==0 || j==0 || i==8 || j==8 ){lav[i][j].setText("1");lav[i][j].setForeground(Color.red);}else {lav[i][j].setText("0");}

                this.add(lav[i][j]);
                x+=50;
            }
            y+=50;
        }
    }

    public void serverResponce(){

        sendReq = new JButton("Send request to server");
        sendReq.setBounds(0,570,500,50);
        sendReq.setBackground(Color.red);
        sendReq.setForeground(Color.white);
        sendReq.setOpaque(true);
        this.add(sendReq);

        serverResp = new JLabel("Server responce",SwingConstants.CENTER);
        serverResp.setBounds(0,630,500,30);
        serverResp.setBackground(Color.yellow);
        serverResp.setForeground(Color.black);
        serverResp.setOpaque(true);
        this.add(serverResp);

        serverRespText = new JTextArea();
        serverRespText.setBounds(20,660,440,200);

        this.add(serverRespText);
        sendReq.addActionListener(new lavEvent(lav,serverRespText));


    }

public static void main(String[] args){

    mainWindow prozor = new mainWindow();


}


}
