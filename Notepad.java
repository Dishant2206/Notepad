import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.filechooser.FileNameExtensionFilter;


public class Notepad extends JFrame implements ActionListener {
    int fsize = 20;

    JTextArea area;
    String text = "";

    JFrame f = new JFrame("Notepad");

    JPanel bottomPanel;
    String fontNameValues[] = {"Agency FB", "Arial", "Calibri", "Comic Sans MS", "Courier", "Cursive","Impact","monospace" ,"Serif","Tahoma","Times New Roman","Verdana"};
    String fontSizeValues[] = {"5", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55", "60", "65", "70"};
    int[] stylevalue = {Font.PLAIN, Font.BOLD, Font.ITALIC};
    String[] fontStyleValues = {"PLAIN", "BOLD", "ITALIC"};
    String fontName, fontSize, fontStyle;
    int fstyle;
    int cl;
    int linecount;

    public Notepad() {

        ImageIcon icon = new ImageIcon("notepad.png");
        f.setIconImage(icon.getImage());

        JLabel detailsOfFile = new JLabel();
        bottomPanel = new JPanel();
        JMenuBar menuBar = new JMenuBar();
        menuBar.setFont(FontSize.30);

  

        // add menu
        JMenu file = new JMenu("File");
        JMenu edit = new JMenu("Edit");
        JMenu format = new JMenu("Format");
        JMenu theme = new JMenu("Theme");
        JMenu about = new JMenu("About");
        
        
        // add menu item
        JMenuItem newdoc = new JMenuItem("New");
        JMenuItem open = new JMenuItem("Open");
        JMenuItem save = new JMenuItem("Save");
        JMenuItem print = new JMenuItem("Print");
        JMenuItem exit = new JMenuItem("Exit");
        
        JMenuItem copy = new JMenuItem("Copy");
        JMenuItem paste = new JMenuItem("Paste");
        JMenuItem cut = new JMenuItem("Cut");
        JMenuItem selectall = new JMenuItem("Select All");
        
        JMenuItem fontname = new JMenuItem("Font Name");
        JMenuItem fontstyle = new JMenuItem("Font Style");
        JMenuItem fontsize = new JMenuItem("Font Size");
        
        JMenuItem theme1 = new JMenuItem("Lavender");
        JMenuItem theme2 = new JMenuItem("Aquamarine");        
        JMenuItem theme3 = new JMenuItem("Dark Slate Gray");
        JMenuItem theme4 = new JMenuItem("Light Green");
        JMenuItem theme5 = new JMenuItem("Cyan");        
        JMenuItem theme6 = new JMenuItem("Light Pink");
        JMenuItem theme7 = new JMenuItem("Teal Blue");
        
        JMenuItem aboutus = new JMenuItem("About us");
        

        //  short cut key
        newdoc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0));

        copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
        cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        selectall.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));

    
        
        area = new JTextArea();
        area.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));
        
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        
        JScrollPane scpane = new JScrollPane(area);
        scpane.setBorder(BorderFactory.createEmptyBorder());
        
        
        
        f.setJMenuBar(menuBar);
        
        menuBar.add(file);
        menuBar.add(edit);
        menuBar.add(format);
        menuBar.add(theme);
        menuBar.add(about);
        
        file.add(newdoc);
        file.add(open);
        file.add(save);
        file.add(print);
        file.add(exit);
        
        edit.add(copy);
        edit.add(paste);
        edit.add(cut);
        edit.add(selectall);
        
        format.add(fontname);
        format.add(fontstyle);
        format.add(fontsize);
        
        theme.add(theme1);
        theme.add(theme2);
        theme.add(theme3);
        theme.add(theme4);
        theme.add(theme5);
        theme.add(theme6);
        theme.add(theme7);
        
        about.add(aboutus);
        
        bottomPanel.add(detailsOfFile);
        
        
        f.setBounds(120,60,1200,600);
        
        f.setLayout(new BorderLayout());
        
        f.add(scpane, BorderLayout.CENTER);
        f.add(bottomPanel, BorderLayout.SOUTH);
        f.setVisible(true);


        
        //  Actionevent
        newdoc.addActionListener(this);
        open.addActionListener(this);
        save.addActionListener(this);
        print.addActionListener(this);
        exit.addActionListener(this);
        
        copy.addActionListener(this);
        paste.addActionListener(this);
        cut.addActionListener(this);
        selectall.addActionListener(this);
        
        fontname.addActionListener(this);
        fontsize.addActionListener(this);
        fontstyle.addActionListener(this);
        
        theme1.addActionListener(this);
        theme2.addActionListener(this);
        theme3.addActionListener(this);
        theme4.addActionListener(this);
        theme5.addActionListener(this);
        theme6.addActionListener(this);
        theme7.addActionListener(this);
        
        aboutus.addActionListener(this);
    }

    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("New")) {
            area.setText("");
        } 
        else if (ae.getActionCommand().equals("Open")) {
            JFileChooser chooser = new JFileChooser("F:/");
            
            int result = chooser.showOpenDialog(f);
            if (result == JFileChooser.APPROVE_OPTION) {
                File file = chooser.getSelectedFile();
                try {
                    FileReader reader = new FileReader(file);
                    BufferedReader br = new BufferedReader(reader);
                    area.read(br, null);
                    br.close();
                    area.requestFocus();
                } catch (Exception e) {
                    System.out.print(e);
                }
            }
        } 
        else if (ae.getActionCommand().equals("Save")) {
            final JFileChooser Save = new JFileChooser("F:/");
            Save.setApproveButtonText("Save");
            
            int actionDialog = Save.showOpenDialog(f);
            if (actionDialog != JFileChooser.APPROVE_OPTION) {
                return;
            }
            File fileName = new File(Save.getSelectedFile() + ".txt");
            BufferedWriter outFile = null;
            try {
                outFile = new BufferedWriter(new FileWriter(fileName));
                area.write(outFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } 
        
        else if (ae.getActionCommand().equals("Print")) {
            final JFileChooser print = new JFileChooser("F:/");
            try {
                area.print();
            } catch (Exception e) {
            }
        } 
        
        else if (ae.getActionCommand().equals("Exit")) {
            System.exit(0);
        }

        else if (ae.getActionCommand().equals("Copy")) {
            area.copy();
        }
        
        else if (ae.getActionCommand().equals("Paste")) {
            area.paste();
        } 

        else if (ae.getActionCommand().equals("Cut")) {
            area.cut();
        }
        
        else if (ae.getActionCommand().equals("Select All")) {
            area.selectAll();
        }
        
        else if (ae.getActionCommand().equals("Font Name")) {
            JList fontNameList = new JList(fontNameValues);
            fontNameList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            JOptionPane.showConfirmDialog(null, fontNameList, "Choose Font Name", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            fontName = String.valueOf(fontNameList.getSelectedValue());
            Font newFont = new Font(fontName, fstyle, fsize);
            area.setFont(newFont);
        }
        
        
        else if (ae.getActionCommand().equals("Font Style")) {
            JList fontStyleList = new JList(fontStyleValues);
            fontStyleList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            JOptionPane.showConfirmDialog(null, fontStyleList, "Choose Font Style", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            fstyle = stylevalue[fontStyleList.getSelectedIndex()];
            Font newFont = new Font(fontName, fstyle, fsize);
            area.setFont(newFont);
        } 
        
        else if (ae.getActionCommand().equals("Font Size")) {
            JList fontSizeList = new JList(fontSizeValues);
            fontSizeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            JOptionPane.showConfirmDialog(null, fontSizeList, "Choose Font Size", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            fontSize = String.valueOf(fontSizeList.getSelectedValue());
            fsize = Integer.parseInt(fontSize);
            Font newFont = new Font(fontName, fstyle, fsize);
            area.setFont(newFont);
        }
        
        else if (ae.getActionCommand().equals("Lavender")){
            bottomPanel.setBackground(new Color(215,180,243));
            area.setBackground(new Color(215,180,243));
            area.setForeground(Color.black);
        }
        
        else if (ae.getActionCommand().equals("Aquamarine")){
            bottomPanel.setBackground(new Color(127,255,212));
            area.setBackground(new Color(127,255,212));
            area.setForeground(Color.black);
        }
        
        else if (ae.getActionCommand().equals("Dark Slate Gray")){
            bottomPanel.setBackground(new Color(54,84,80));
            area.setBackground(new Color(54,84,80));
            area.setForeground(Color.white);
        }
        

        else if (ae.getActionCommand().equals("Light Green")){
            bottomPanel.setBackground(new Color(144,238,144));
            area.setBackground(new Color(144,238,144));
            area.setForeground(Color.black);
        }

        else if (ae.getActionCommand().equals("Cyan")){
            bottomPanel.setBackground(Color.cyan);
            area.setBackground(Color.cyan);
            area.setForeground(Color.black);
        }
        
        else if (ae.getActionCommand().equals("Light Pink")){
            bottomPanel.setBackground(new Color(230,122,156));
            area.setBackground(new Color(230,122,156));    
            area.setForeground(Color.black);
        }

        else if (ae.getActionCommand().equals("Teal Blue")){
            bottomPanel.setBackground(new Color(35,112,138));
            area.setBackground(new Color(35,112,138));    
            area.setForeground(Color.white);
        }

        else if (ae.getActionCommand().equals("About us")){
            // new About().setVisible(true);
        }
    }
    

    public static void main(String args[]) {
        Notepad np = new Notepad();
    }   
}