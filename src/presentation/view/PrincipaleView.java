package presentation.view;

import presentation.controller.PrincipaleCaseAction;
import utils.Constants;

import javax.swing.*;
import java.awt.*;

public class PrincipaleView extends JFrame{

    private JLabel choixLbl;
    private JButton AuteurBtn;
    private JButton OeuvreBtn;
    private JButton PretBtn;
    private JButton AdherentBtn;

    private JPanel pan;

    // let us add a picture to the main view
    private JLabel imageLabel;
    private ImageIcon image;


    public PrincipaleView(){


        this.AuteurBtn = new JButton("Auteur");
        this.OeuvreBtn = new JButton("Oeuvre");
        this.PretBtn = new JButton("Pret");
        this.AdherentBtn = new JButton("Adherent");

        this.AuteurBtn.setSize(40, 30);
        this.AuteurBtn.setBackground(Color.YELLOW);
        // delete the border
        this.AuteurBtn.setBorderPainted(false);
        this.OeuvreBtn.setSize(40, 30);
        this.OeuvreBtn.setBackground(Color.CYAN);
        this.OeuvreBtn.setForeground(Color.WHITE);
        this.OeuvreBtn.setBorderPainted(false);
        this.PretBtn.setSize(40, 30);
        this.PretBtn.setBackground(Color.GREEN);
        this.PretBtn.setForeground(Color.WHITE);
        this.PretBtn.setBorderPainted(false);
        this.AdherentBtn.setSize(40, 30);
        this.AdherentBtn.setBackground(Color.RED);
        this.AdherentBtn.setForeground(Color.WHITE);
        this.AdherentBtn.setBorderPainted(false);
        this.pan = new JPanel();
        this.pan.add(AuteurBtn,BorderLayout.SOUTH);
        this.pan.add(OeuvreBtn,BorderLayout.SOUTH);
        this.pan.add(PretBtn,BorderLayout.SOUTH);
        this.pan.add(AdherentBtn,BorderLayout.SOUTH);

        this.image = new ImageIcon(Constants.ImagePath);
        this.imageLabel = new JLabel(image);
        this.pan.add(imageLabel, BorderLayout.CENTER);

        this.pan.setSize(300, 300);
        this.add(pan, BorderLayout.CENTER);
        this.setTitle("Mon MediaThèque");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        this.AuteurBtn.addActionListener(new PrincipaleCaseAction(this));
        this.OeuvreBtn.addActionListener(new PrincipaleCaseAction(this));
        this.PretBtn.addActionListener(new PrincipaleCaseAction(this));
        this.AdherentBtn.addActionListener(new PrincipaleCaseAction(this));

    }

    public JButton getAuteurBtn() {
        return AuteurBtn;
    }

    public JButton getOeuvreBtn() {
        return OeuvreBtn;
    }

    public JButton getPretBtn() {
        return PretBtn;
    }

    public JButton getAdherentBtn() {
        return AdherentBtn;
    }
}
