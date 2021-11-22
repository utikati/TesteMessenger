package IU;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class MyIp extends JFrame implements ActionListener {
    private Container container;
    private JPanel myIpPanel, topPanel, southPanel;
    private JButton outBotton;

    public MyIp(){
        container = getContentPane();
        container.setLayout(new BorderLayout());
        topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        topPanel.add(new JLabel("My Ip"));
        myIpPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));


        JPanel infoIP = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel infoLabel = new JLabel(showMyIp());
        infoIP.add(infoLabel);

        JPanel botton = new JPanel(new FlowLayout(FlowLayout.CENTER));
        outBotton = new JButton("Exit");
        outBotton.setPreferredSize(new Dimension(180, 30));
        outBotton.setActionCommand("Exit");
        outBotton.addActionListener(this);
        outBotton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        botton.add(outBotton);

        myIpPanel.add(infoIP);
        southPanel.add(botton);

        container.add(topPanel, BorderLayout.NORTH);
        container.add(myIpPanel, BorderLayout.CENTER);
        container.add(southPanel, BorderLayout.SOUTH);

        this.setSize(350, 150);
        this.setLocationRelativeTo(null);
        this.setTitle("IP");
        this.setResizable(true);
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public String showMyIp() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    String option = e.getActionCommand();
    switch (option){
        case "Exit": this.dispose(); break;
    }
    }
}
