package IU;

import Connect.Connection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JoinServerMenu extends JFrame implements ActionListener {
    private JPanel ipPanel, portPanel, bottonPanel, mainPanel, topPanel;
    private JButton startServer, closeMenu;
    private Container container;
    private JTextField textFieldIp, textFieldPort;
    private Connection connect;

    public JoinServerMenu(){

        container = getContentPane();
        container.setLayout(new BorderLayout());
        topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        topPanel.add(new JLabel("Join Server MSN"));

        mainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        ipPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel labelIP = new JLabel("Insert IP: ");
        textFieldIp = new JTextField(15);
        ipPanel.add(labelIP);
        ipPanel.add(textFieldIp);

        portPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel labelPort = new JLabel("Insert Port: ");
        textFieldPort = new JTextField(15);
        portPanel.add(labelPort);
        portPanel.add(textFieldPort);

        bottonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        startServer = new JButton("Join Server");
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

        mainPanel.add(ipPanel);
        mainPanel.add(portPanel);


        container.add(topPanel, BorderLayout.NORTH);
        container.add(mainPanel, BorderLayout.CENTER);
        container.add(bottonPanel, BorderLayout.SOUTH);

        this.setSize(550, 170);
        this.setLocationRelativeTo(null);
        this.setTitle("Join Server");
        this.setResizable(true);
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }




    @Override
    public void actionPerformed(ActionEvent e) {
        String op = e.getActionCommand();
        switch (op){
            case "Close": this.dispose(); break;
            case "Start": connect = new Connection(textFieldIp.getText(), Integer.parseInt(textFieldPort.getText()));



            break;
        }
    }
}
