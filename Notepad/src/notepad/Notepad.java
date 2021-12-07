/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notepad;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.URI;
import javax.swing.JFileChooser;
import javax.swing.filechooser.*;

/**
 *
 * @author PRANESH
 */
 public class Notepad extends JFrame implements ActionListener {
    JTextArea area;
    JScrollPane pane;
    String text;
    String savetext;
    
        Notepad(){
            setBounds(0,0,1950,1050);
            JMenuBar menubar = new JMenuBar();
            
            JMenu file = new JMenu("File");
           
            JMenuItem newdocument = new JMenuItem("New");
            newdocument.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
            newdocument.addActionListener(this);
            
            JMenuItem open= new JMenuItem("Open");
            open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,ActionEvent.CTRL_MASK));
            open.addActionListener(this);
            
            JMenuItem saveitem = new JMenuItem("Save");
            saveitem.addActionListener(this);
            
            JMenuItem save= new JMenuItem("Save as");
            save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
            save.addActionListener(this);
            
            JMenuItem print= new JMenuItem("Print");
            print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,ActionEvent.CTRL_MASK));
            print.addActionListener(this);
            
            JMenuItem exit= new JMenuItem("Exit");
            exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE,0));
            exit.addActionListener(this);
            
            file.add(newdocument);
            file.add(open);
            file.add(saveitem);
            file.add(save);
            file.add(print);
            file.add(exit);
            
            
            
            
            JMenu edit = new JMenu("Edit");
            JMenuItem copy= new JMenuItem("Copy");
            copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
            copy.addActionListener(this);
            
            JMenuItem paste= new JMenuItem("Paste");
            paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,ActionEvent.CTRL_MASK));
            paste.addActionListener(this);
            
            JMenuItem cut= new JMenuItem("Cut");
            cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,ActionEvent.CTRL_MASK));
            cut.addActionListener(this);
            
            JMenuItem selectall= new JMenuItem("Select All");
            selectall.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.CTRL_MASK));
            selectall.addActionListener(this);
            
            
            edit.add(copy);
            edit.add(paste);
            edit.add(cut);
            edit.add(selectall);
                    
            
            JMenu help = new JMenu("Help");
            JMenuItem aboutnotepad =  new JMenuItem ("About Notepad");
            help.add(aboutnotepad);
            aboutnotepad.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H,ActionEvent.ALT_MASK));
            aboutnotepad.addActionListener(this);
            
      
            
            menubar.add(file);
            menubar.add(edit);
            menubar.add(help);
            
            setJMenuBar(menubar);
            
            area = new JTextArea();
            pane = new JScrollPane(area);
            add(pane,BorderLayout.CENTER);
            pane.setBorder(BorderFactory.createEmptyBorder());
            area.setLineWrap(true);
            area.setWrapStyleWord(true);
            area.setFont(new Font("Sans_Serif", Font.PLAIN, 20));
            
      
            
            
        }
        
        @Override
           public void actionPerformed(ActionEvent ae)  {
            if(ae.getActionCommand().equals("New")){
                area.setText("");
                 
                
            }else if(ae.getActionCommand().equals("Open")){
                JFileChooser chooser = new JFileChooser();
               // chooser.setAcceptAllFileFilterUsed(false); //choose specific file
               // FileNameExtensionFilter restrict = new FileNameExtensionFilter("Only .txt files",".txt");
               // chooser.addChoosableFileFilter(restrict);
                BufferedReader reader ;
                
                int open =  chooser.showOpenDialog(this);
                if(open!= JFileChooser.APPROVE_OPTION){
                    return;
                }
                File file = chooser.getSelectedFile();
                   try{
                       reader = new BufferedReader(new FileReader(file));
                       area.read(reader,null);
                       
                       
                   }catch(Exception e){}
            } 
           
               
                
            
                
            
                
                else if(ae.getActionCommand().equals("Save as")){
                JFileChooser saveas = new JFileChooser();
                saveas.setApproveButtonText("Save as");
                int action =  saveas.showOpenDialog(this);
                if(action!= JFileChooser.APPROVE_OPTION){
                    return;
               }
                
                File filename = new File(saveas.getSelectedFile()+ ".txt");
                BufferedWriter writer = null;
                
                try{
                    writer = new BufferedWriter(new FileWriter(filename));
                    area.write(writer);
                    
                }catch(Exception e){}
                
                }
                else if(ae.getActionCommand().equals("Print")){
                try{
                    area.print();
                }catch(Exception e){}
            }
            
                else if(ae.getActionCommand().equals("Exit")){
                    System.exit(0);
                }
                else if(ae.getActionCommand().equals("Copy")){
                    text = area.getSelectedText();
                }else if(ae.getActionCommand().equals("Paste")){
                    area.insert(text,area.getCaretPosition());
                }else if(ae.getActionCommand().equals("Cut")){
                    area.getSelectedText();
                    area.replaceRange("", area.getSelectionStart(), area.getSelectionEnd());
                }else if(ae.getActionCommand().equals("Select All")){
                    area.selectAll();
                    
                }else if(ae.getActionCommand().equals("About Notepad")){
                    new AboutNotepad().setVisible(true);
                }
                else if(ae.getActionCommand().equals("Save")){}
           }
            
            
                    
         
                
            
            
                


 
 
           

                   
               
              
           
    public static void main(String[] args) {
        new Notepad().setVisible(true);
        
    }
}



    

