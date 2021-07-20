package main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Open {
    private JButton button1;
    private JPanel Open;
    private JButton profilePageButton;

    public JPanel getOpen() {
        return Open;
    }

    public Open(JFrame jFrame) {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.setContentPane(new AdminPage(jFrame).getPanel1());
                jFrame.revalidate();
                jFrame.repaint();

            }
        });
        profilePageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.setContentPane(new ProfilePage(jFrame).getPanel1());
                jFrame.revalidate();
                jFrame.repaint();
            }
        });
    }
}
