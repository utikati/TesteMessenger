package IU;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class Menu extends JFrame implements ActionListener {

    private Container cont;
    private JPanel topPanel, centerPanel, southPanel, outPanel, addressPanel, joinServerPanel, createServerPanel;
    private JButton giveAddress, goOut, joinServer, createServer;

    public Menu(){
        cont = getContentPane();
        cont.setLayout(new BorderLayout());

        centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        topPanel.add(new JLabel("Main Menu"));

        addressPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        giveAddress = new JButton("My IP");
        giveAddress.setPreferredSize(new Dimension(180, 30));
        giveAddress.setActionCommand("giveMyAddress");
        giveAddress.addActionListener(this);
        giveAddress.setCursor(new Cursor(Cursor.HAND_CURSOR));
        addressPanel.add(giveAddress);

        outPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        goOut = new JButton("Exit Program");
        goOut.setPreferredSize(new Dimension(200, 30));
        goOut.setActionCommand("exitProgram");
        goOut.addActionListener(this);
        goOut.setCursor(new Cursor(Cursor.HAND_CURSOR));
        outPanel.add(goOut);

        joinServerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        joinServer = new JButton("Join Server");
        joinServer.setPreferredSize(new Dimension(180, 30));
        joinServer.setActionCommand("joinServer");
        joinServer.addActionListener(this);
        joinServer.setCursor(new Cursor(Cursor.HAND_CURSOR));
        joinServerPanel.add(joinServer);

        createServerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        createServer = new JButton("Create Server");
        createServer.setPreferredSize(new Dimension(180, 30));
        createServer.setActionCommand("createServer");
        createServer.addActionListener(this);
        createServer.setCursor(new Cursor(Cursor.HAND_CURSOR));
        createServerPanel.add(createServer);

        centerPanel.add(addressPanel);
        centerPanel.add(createServerPanel);
        centerPanel.add(joinServerPanel);
        centerPanel.add(outPanel);

        cont.add(topPanel, BorderLayout.NORTH);
        cont.add(centerPanel, BorderLayout.CENTER);
        cont.add(southPanel, BorderLayout.SOUTH);

        this.setSize(350, 400);
        this.setLocationRelativeTo(null);
        this.setTitle("MSN");
        this.setResizable(true);
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        String option = e.getActionCommand();
        switch (option){
            case "exitProgram": System.exit(0); break;
            case "giveMyAddress": MyIp myIp = new MyIp(); break;
            case "createServer": ServerMenu serverMenu = new ServerMenu(); break;
            case "joinServer": JoinServerMenu joinServerMenu = new JoinServerMenu(); break;
        }
    }
}
