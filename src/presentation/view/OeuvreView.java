package presentation.view;

import javax.swing.*;

public class OeuvreView extends JFrame {

    private JTextField txtId;
    private JTextField txtTitre;
    private JTextField txtDateDeParution;
    private JTextField txtCategorie;
    private JTextField txtAuteur;
    private JTextField txtEditeur;
    private JTextField txtStatut;
    private JButton btnAjouter;
    private JButton btnModifier;
    private JButton btnSupprimer;
    private JButton btnRechercher;
    private JButton btnQuitter;
    private JTable tableOeuvre;


    public OeuvreView(){

        this.tableOeuvre = new JTable();
        this.txtId = new JTextField();
        this.txtTitre = new JTextField();
        this.txtDateDeParution = new JTextField("");
        this.txtCategorie = new JTextField();
        this.txtAuteur = new JTextField();
        this.txtEditeur = new JTextField();
        this.txtStatut = new JTextField();
        this.btnAjouter = new JButton();
        this.btnModifier = new JButton();
        this.btnSupprimer = new JButton();
        this.btnRechercher = new JButton();
        this.btnQuitter = new JButton();


    }

}
