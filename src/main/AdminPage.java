package main;

import company.Company;
import company.departament.Department;
import company.employee.User;
import company.job.Job;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;

public class AdminPage {
    private JPanel panel1;
    private JButton button1;
    private JButton backButton;
    private JButton searchButton;
    private JTextArea Compania;
    private JTextField textField1;
    private JTextArea Departamente;
    private JTextArea Angajatii;
    private JTextArea Angajati;
    private JTextArea Useri;
    private JTextArea Manageri;
    private JList list1;

    public AdminPage(JFrame jFrame){

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.setContentPane(new Open(jFrame).getOpen());
                jFrame.revalidate();
                jFrame.repaint();
            }
        });


        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(Company c : Application.getInstance().getCompanies()) {
                    if (c.getName().equals(textField1.getText())) {
                        Compania.setText(c.getName().toString());
                        Departamente.setText("IT\n" + "Management\n" + "Marketing\n" + "Finance\n");
                        Manageri.setText(c.getManager().toString() + "\n");

                    for(Department d : c.getDepartments())
                        Angajati.append(d.getEmployees().toString());
                        }
                }
                Useri.setText("");
               for(User u : Application.getInstance().users)
                   Useri.append(u.getResume().information.getFirstName() + " "
                           + u.getResume().information.getLastName() + "\n");
            }
        });

    }

    public JPanel getPanel1() {
        return panel1;
    }

    public JButton getButton1() {
        return button1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    public void setButton1(JButton button1) {
        this.button1 = button1;
    }
}
