package IU;

import Connect.Connection;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import java.util.EventListener;



public class Chat extends JFrame implements ActionListener, EventListener {
    private JPanel listChatPanel, toolsChatPanel, topPanel, body, closeCom;
    private Container container;
    private JTextArea chatTextField, listMessage;
    private JButton sendMessage, closeComunication;
    private Connection connect;
    private Thread thread;

    public Chat(Connection connection) { //refresh


        connect = connection;
        container = getContentPane();
        container.setLayout(new BorderLayout());
        topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        topPanel.add(new JLabel("Chat MSN"));

        listChatPanel = new JPanel();
        JScrollPane scrollPane = new JScrollPane();
        JPanel listPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        topPanel.add(new JLabel("Chat"));

        listMessage = new JTextArea("Start \n");

        listMessage.setPreferredSize(new Dimension(600, 150));
        listMessage.setEnabled(false);


        scrollPane = new JScrollPane(listMessage);


        listPanel.add(scrollPane);

        listChatPanel.add(topPanel);
        listChatPanel.add(listMessage);


        toolsChatPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        chatTextField = new JTextArea(10, 42);
        chatTextField.setMaximumSize(new Dimension(10, 40));
        JScrollPane scrolltextArea = new JScrollPane();
        scrolltextArea = new JScrollPane(chatTextField);
        sendMessage = new JButton("Enviar");
        sendMessage.addActionListener(this);
        sendMessage.setPreferredSize(new Dimension(180, 100));
        sendMessage.setActionCommand("send");
        sendMessage.setCursor(new Cursor(Cursor.HAND_CURSOR));

        closeComunication = new JButton("Sair");
        closeComunication.addActionListener(this);
        closeComunication.setPreferredSize(new Dimension(180, 30));
        closeComunication.setSize(new Dimension(180, 30));
        closeComunication.setActionCommand("close");
        closeComunication.setCursor(new Cursor(Cursor.HAND_CURSOR));


        toolsChatPanel.add(scrolltextArea);
        toolsChatPanel.add(sendMessage);

        body = new JPanel(new GridLayout(2, 2));
        body.add(listChatPanel);
        body.add(toolsChatPanel);

        closeCom = new JPanel(new FlowLayout(FlowLayout.CENTER));
        closeCom.add(closeComunication);


        container.add(topPanel, BorderLayout.NORTH);
        container.add(body, BorderLayout.CENTER);
        container.add(closeCom, BorderLayout.SOUTH);


        this.setSize(700, 500);
        this.setLocationRelativeTo(null);
        this.setTitle("Chat");
        this.setResizable(true);
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        thread = new Thread(() -> {
            String msg;
            while (!Thread.interrupted()) {
                try {
                    msg = connect.getReceiver().readLine();
                    if (msg.equals("codeZbyeBYE3434hgdf") || msg == null) {
                        listMessage.setText(listMessage.getText() + "Other: Saiu da Conversa \n");
                        connect.sendMsg("codeZbyeBYE3434hgdf");
                        break;
                    } else
                        listMessage.setText(listMessage.getText() + "Other: " + msg + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String op = e.getActionCommand();
        switch (op) {
            case "send":
                connect.sendMsg(chatTextField.getText());
                listMessage.setText(listMessage.getText() + "Me: " + chatTextField.getText() + "\n");
                chatTextField.setText("");
                break;
            case "close":
                connect.sendMsg("codeZbyeBYE3434hgdf");
                thread.interrupt();
                connect.closeCon();
                dispose();
                break;
        }
    }

}
