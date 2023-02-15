


import java.awt.Font;
import javax.swing.*;

public class About extends JFrame {
    About(){
        setBounds(100,100,440,210);
        setTitle("About us");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ImageIcon icon = new ImageIcon("notepad.png");
        setIconImage(icon.getImage());
   

        setLayout(null);

        JLabel ilbl = new JLabel(new ImageIcon(getClass().getResource("notepad.png")));
        ilbl.setBounds(20,40,100,100);
        add(ilbl);

        JLabel tlbl = new JLabel("<html>  My name is Dishant Patel, <br><br> Welcome to Notepad.... <br> Notepad is a simple text editor for Microsoft <br> Windows and a basic text-editing program which <br> enables computer users to create documents. </html>");
        tlbl.setBounds(130,25,280,130);
        tlbl.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,13));
        add(tlbl);
    }
    public static void main(String args[]) {
        new About().setVisible(true);
    }
}
