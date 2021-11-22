package Connect;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import Connect.*;

import IU.Chat;
import Warning.Warning;

public class Connection {

    private ServerSocket server;
    private Socket client;
    private PrintWriter send;
    private BufferedReader receiver;
    private String ipAddress;

    public Connection(int Port) {
        try {
            server = new ServerSocket(Port);
            ipAddress = getMyIP();
            Warning.showMessage("Servidor conectado com IP "+ ipAddress +":"+ server.getLocalPort(), "Informação", "info");

            client = server.accept();
            Warning.showMessage("Conexao estabelecida com cliente: " + client.getRemoteSocketAddress().toString().replace("/","."), "Informação", "info");
            send = new PrintWriter(client.getOutputStream(), true);
            receiver = new BufferedReader(new InputStreamReader(client.getInputStream()));

            Chat chat = new Chat(this);

        }catch (IOException ioe){

            Warning.showMessage("Erro na conexão", "Erro", "error");
            ioe.printStackTrace();
        }
    }

    public Connection(String ip, int port){
        try{
            server = null;

            client = new Socket(ip, port);
            Warning.showMessage("Conexao estabelecida com servidor:  " + ip + ":" + port, "Informação", "info");
            send = new PrintWriter(client.getOutputStream(), true);
            receiver = new BufferedReader(new InputStreamReader(client.getInputStream()));

            Chat chat = new Chat(this);
        }catch (UnknownHostException uhe) {

            Warning.showMessage("Erro: Servidor desconhecido: "+ip+":"+port, "Erro", "error");
            client = null;
        }catch (ConnectException ce) {

            Warning.showMessage("Erro: Sem resposta do servidor: "+ip+":"+port, "Erro", "error");
            client = null;
        }catch (IOException ioe) {
            Warning.showMessage("Erro na ligação", "Erro", "error");
            ioe.printStackTrace();
        }
    }

    private String getMyIP(){
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Socket getClient() {
        return client;
    }

    public ServerSocket getServer() {
        return server;
    }

    public void closeCon(){
        try {
            if (receiver != null)
                receiver.close();
            if (send != null)
                send.close();
            if (client != null)
                client.close();
            if (server != null)
                server.close();
        } catch (Exception e) { // aqui trata tanto da UnknowHost tal como da IOE Exception
            e.printStackTrace();
        } finally { // assegurar que ficam mesmo close !
            if(receiver != null) {
                try{receiver.close();} catch(Exception e) {e.printStackTrace();}
            }if(send != null) {
                try{send.close();} catch(Exception e) {e.printStackTrace();}
            }if(client != null) {
                try{client.close();} catch(Exception e) {e.printStackTrace();}
            }if(server != null) {
                try{server.close();} catch(Exception e) {e.printStackTrace();}
            }
        }
    }

    public String receiveMsg() { //recebe o socket
        try {
            return receiver.readLine();
        } catch (IOException ioe) {
            return null; //na excepção envia null para na comunicação interpretar como interrompida
        }
    }

    public void sendMsg(String aMsg) { //envia o socket

        send.println(aMsg);
    }

    public BufferedReader getReceiver() {
        return receiver;
    }
}
