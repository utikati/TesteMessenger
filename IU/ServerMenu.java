package IU;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Connect.*;

public class ServerMenu extends JFrame implements ActionListener {
    private JPanel portPanel, bottonPanel, mainPanel, topPanel;
    private JButton startServer, closeMenu;
    private Container container;
    private  JTextField textFieldPort;
    private Connection connection;
    public ServerMenu(){

        container = getContentPane();
        container.setLayout(new BorderLayout());
        topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        topPanel.add(new JLabel("Start Server MSN"));

        mainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        portPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel labelPort = new JLabel("Insert Port: ");
        textFieldPort = new JTextField(15);
        portPanel.add(labelPort);
        portPanel.add(textFieldPort);

        bottonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        startServer = new JButton("Start Server");
        startServer.setActionCommand("Start");
        startServer.addActionListener(this);
        startServer.setCursor(new Cursor(Cursor.HAND_CURSOR));
        startServer.setPreferredSize(new Dimension(180, 30));
        bottonPanel.add(startServer);


        closeMenu = new JButton("Close Menu");
        closeMenu.addActionListener(this);
        closeMenu.setActionCommand("Close");
        closeMenu.setPreferredSize(new Dimension(180, 30));
        closeMenu.setCursor(new Cursor(Cursor.HAND_CURSOR));
        bottonPanel.add(closeMenu);

        mainPanel.add(portPanel);


        container.add(topPanel, BorderLayout.NORTH);
        container.add(mainPanel, BorderLayout.CENTER);
        container.add(bottonPanel, BorderLayout.SOUTH);
        this.setSize(550, 150);
        this.setLocationRelativeTo(null);
        this.setTitle("Server");
        this.setResizable(true);
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }




    @Override
    public void actionPerformed(ActionEvent e) {
        String op = e.getActionCommand();
        switch (op){
            case "Close": this.dispose(); break;
            case "Start": connection = new Connection(Integer.parseInt(textFieldPort.getText()));



            break;
        }

    }



}
