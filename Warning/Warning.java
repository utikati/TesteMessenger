package Warning;

import javax.swing.*;
import java.awt.*;


public class Warning extends JFrame{

    public static void showMessage(String aMessage, String aTitle, String aType) {
        if(aType.equals("info")) JOptionPane.showMessageDialog(new JFrame(), aMessage, aTitle, JOptionPane.INFORMATION_MESSAGE);
        if(aType.equals("error")) JOptionPane.showMessageDialog(new JFrame(), aMessage, aTitle, JOptionPane.ERROR_MESSAGE);
    }

    public static void staticMessage(String aMessage) {
        JOptionPane optionPane = new JOptionPane(aMessage, JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);

        JDialog dialog = new JDialog();

        dialog.setTitle("Message");
        dialog.setModal(true);

        dialog.setContentPane(optionPane);

        //dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dialog.pack();

        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);

    }


}
