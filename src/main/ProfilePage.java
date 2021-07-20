package main;

import company.employee.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfilePage extends JFrame{
    private JPanel panel1;
    private JTextField textField1;
    private JButton searchButton;
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JTextArea textArea3;
    private JButton backButton;

    ProfilePage(JFrame jFrame){
        super("Profile");

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(User u : Application.getInstance().users){
                    if((u.getResume().information.getFirstName() + " " + u.getResume().information.getLastName()).
                            equals(textField1.getText())){
                        textArea3.setText(u.getResume().information.toString());
                        textArea1.setText(u.getResume().educations.toString());
                        textArea2.setText(u.getResume().experiences.toString());


                    }
                }
            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.setContentPane(new Open(jFrame).getOpen());
                jFrame.revalidate();
                jFrame.repaint();
            }
        });
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }
}
