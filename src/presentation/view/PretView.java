package presentation.view;

import javax.swing.*;
import java.awt.*;

public class PretView extends JFrame {

    // test Jtext place holder

    private JTextField idAdherentTxt;
    private JTextField idOeuvreTxt;
    private JTextField datePretTxt;

    private JLabel idAdherentLbl;
    private JLabel idOeuvreLbl;

    private JButton ajouterBtn;

    private JPanel panLeft;
    private JPanel panRight;

    public PretView(){

        this.idAdherentLbl = new JLabel("Identite Adherent");
        this.idOeuvreLbl = new JLabel("Titre Oeuvre");

        this.idAdherentTxt = new JTextField();
        this.idOeuvreTxt = new JTextField();
        this.datePretTxt = new JTextField();

        this.ajouterBtn = new JButton("Ajouter");

        this.panLeft = new JPanel();
        this.panRight = new JPanel();
        this.panRight.setLayout(new BoxLayout(panRight, BoxLayout.Y_AXIS));
        this.panLeft.setLayout(new BoxLayout(panLeft, BoxLayout.Y_AXIS));

        this.panLeft.add(idAdherentLbl);
        this.panLeft.add(idOeuvreLbl);

        this.panRight.add(idAdherentTxt);
        this.panRight.add(idOeuvreTxt);
        this.panRight.add(datePretTxt);
        this.panRight.add(ajouterBtn);

        this.add(panLeft, BorderLayout.WEST);
        this.add(panRight, BorderLayout.EAST);

        this.setTitle("Pret d'un oeuvre");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);

    }

}
