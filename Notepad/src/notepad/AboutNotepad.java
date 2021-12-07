/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notepad;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author PRANESH
 */
public class AboutNotepad extends JFrame implements ActionListener {
    JButton b1;
    AboutNotepad(){
        setBounds(300,150,700,600);
        setLayout(null);
        JLabel l1 =new JLabel("<html><h2>Free open-source text & code editor<br><p>Project Version 1.0</p><br><p><Built at 06/12/2021 at 9:40pm</p><p>Notepad is a word Processing program which allows changing of text and save files.It is a text editor.Which enables computer users to make documents</p></html>");
        l1.setBounds(150,130,500,300);
        l1.setFont(new Font("SANS_SERIF", Font.PLAIN, 35));
        add(l1);
        
        b1= new JButton("OK");
        b1.setBounds(580,500,80,25);
        b1.addActionListener(this);
        add(b1);
    }
    
    public void actionPerformed(ActionEvent ae){
        this.setVisible(false);
    }
    
    
    


public static void main(String[] args){
    new AboutNotepad().setVisible(true);
}
}
