package presentation.view;

import presentation.controller.AuteurCaseAction;
import presentation.controller.OeuvreCaseAction;

import javax.swing.*;
import java.awt.*;

public class OeuvreView extends JFrame {

    private JComboBox<String> oeuvreComboBox;
    private JButton ajouterbtn;
    private JButton supprimerbtn;
    private JButton modifierbtn;
    private JButton cleanBtn;

    // Text Fields

    private JTextField idTextField;
    private JTextField titreTextField;
    private JTextField categorieTextField;
    private JTextField auteurtextField;
    private JTextField editeurTextField;
    private JTextField anneeSortieTextField;
    // checkbox
    private JCheckBox statutCheckBox;

    // labels

    private JLabel idLabel;
    private JLabel titreLabel;
    private JLabel categorieLabel;
    private JLabel editeurLabel;
    private JLabel anneeSortieLabel;
    private JLabel statutLabel;
    private JLabel auteurLabel;

    // panels

    private JPanel topPanel; // this is the panel that contains the combo box
    private JPanel centerPanel; // this is the panel that contains the text fields
    private JPanel bottomPanel; // this is the panel that contains the buttons


    // panel to contain label and a text field
    private JPanel idPanel;
    private JPanel titrePanel;
    private JPanel categoriePanel;
    private JPanel auteurPanel;
    private JPanel editeurPanel;
    private JPanel anneeSortiePanel;
    private JPanel statutPanel;


    public OeuvreView() {

        // initialize the text fields

        idTextField = new JTextField(23);
        idTextField.setEditable(false);
        titreTextField = new JTextField(23);
        categorieTextField = new JTextField(23);
        auteurtextField = new JTextField(23);
        editeurTextField = new JTextField(23);
        anneeSortieTextField = new JTextField(23);
        statutCheckBox = new JCheckBox();


        // initialize the labels

        idLabel = new JLabel("ID");
        titreLabel = new JLabel("Nom");
        categorieLabel = new JLabel("Prenom");
        editeurLabel = new JLabel("Editeur");
        anneeSortieLabel = new JLabel("Annee de sortie");
        statutLabel = new JLabel("Statut");
        auteurLabel = new JLabel("Auteur");


        // initialize the buttons

        ajouterbtn = new JButton("Ajouter");
        supprimerbtn = new JButton("Supprimer");
        modifierbtn = new JButton("Modifier");
        cleanBtn = new JButton("Vider");

        // initialize the combo box

        oeuvreComboBox = new JComboBox<>();

        // initialize the panels

        topPanel = new JPanel();
        centerPanel = new JPanel();
        bottomPanel = new JPanel();

        // set the layout of the panels

        topPanel.add(oeuvreComboBox, BorderLayout.CENTER);
        centerPanel.setLayout(new BorderLayout());

        // initialize the panel to contain label and a text field
        idPanel = new JPanel();
        titrePanel = new JPanel();
        categoriePanel = new JPanel();
        auteurPanel = new JPanel();
        editeurPanel = new JPanel();
        anneeSortiePanel = new JPanel();
        statutPanel = new JPanel();

        // set the layout of the panel to contain label and a text field
        idPanel.setLayout(new BorderLayout());
        titrePanel.setLayout(new BorderLayout());
        categoriePanel.setLayout(new BorderLayout());
        auteurPanel.setLayout(new BorderLayout());
        editeurPanel.setLayout(new BorderLayout());
        anneeSortiePanel.setLayout(new BorderLayout());
        statutPanel.setLayout(new BorderLayout());

        // add the label and the text field to the panel
        idPanel.setLayout(new FlowLayout());
        idPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
        idPanel.add(idLabel);
        idPanel.add(idTextField);

        titrePanel.setLayout(new FlowLayout());
        titrePanel.add(titreLabel);
        titrePanel.add(titreTextField);

        categoriePanel.setLayout(new FlowLayout());
        categoriePanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
        categoriePanel.add(categorieLabel);
        categoriePanel.add(categorieTextField);

        auteurPanel.setLayout(new FlowLayout());
        auteurPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
        auteurPanel.add(auteurLabel);
        auteurPanel.add(auteurtextField);

        editeurPanel.setLayout(new FlowLayout());
        editeurPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
        editeurPanel.add(editeurLabel);
        editeurPanel.add(editeurTextField);

        anneeSortiePanel.setLayout(new FlowLayout());
        anneeSortieLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
        anneeSortiePanel.add(anneeSortieLabel);
        anneeSortiePanel.add(anneeSortieTextField);

        statutPanel.setLayout(new FlowLayout());
        // fix a margin between the label and the text field
        statutPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
        statutPanel.add(statutLabel);
        statutPanel.add(statutCheckBox);

        // add the panel to the center panel
        centerPanel.setLayout(new GridLayout(7, 1));
        centerPanel.add(idPanel);
        centerPanel.add(titrePanel);
        centerPanel.add(categoriePanel);
        centerPanel.add(auteurPanel);
        centerPanel.add(editeurPanel);
        centerPanel.add(anneeSortiePanel);
        centerPanel.add(statutPanel);

        // add the buttons to the bottom panel

        bottomPanel.add(ajouterbtn);
        bottomPanel.add(supprimerbtn);
        bottomPanel.add(modifierbtn);
        bottomPanel.add(cleanBtn);

        // set the size of the panels

        topPanel.setPreferredSize(new Dimension(700, 50));
        centerPanel.setPreferredSize(new Dimension(700, 500));
        bottomPanel.setPreferredSize(new Dimension(700, 50));

        // set the size of the combo box

        oeuvreComboBox.setPreferredSize(new Dimension(300, 30));

        // add the panels to the frame

        this.add(topPanel, BorderLayout.NORTH);
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(bottomPanel, BorderLayout.SOUTH);

        // add actions to the buttons

        this.ajouterbtn.addActionListener(new OeuvreCaseAction(this));
        this.supprimerbtn.addActionListener(new OeuvreCaseAction(this));
        this.modifierbtn.addActionListener(new OeuvreCaseAction(this));
        this.cleanBtn.addActionListener(new OeuvreCaseAction(this));

        // add actions to the combo box

        this.oeuvreComboBox.addActionListener(new OeuvreCaseAction(this));

        // set the frame properties

        this.setTitle("Oeuvre");
        this.setSize(700, 700);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // so it won"t close the whole application
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    public JComboBox<String> getOeuvreComboBox() {
        return oeuvreComboBox;
    }

    public JButton getAjouterbtn() {
        return ajouterbtn;
    }

    public JButton getSupprimerbtn() {
        return supprimerbtn;
    }

    public JButton getModifierbtn() {
        return modifierbtn;
    }

    public JButton getCleanBtn() {
        return cleanBtn;
    }

    public JTextField getIdTextField() {
        return idTextField;
    }

    public JTextField getTitreTextField() {
        return titreTextField;
    }

    public JTextField getCategorieTextField() {
        return categorieTextField;
    }

    public JTextField getAuteurtextField() {
        return auteurtextField;
    }

    public JTextField getEditeurTextField() {
        return editeurTextField;
    }

    public JTextField getAnneeSortieTextField() {
        return anneeSortieTextField;
    }

    public JCheckBox getStatutCheckBox() {
        return statutCheckBox;
    }
}
