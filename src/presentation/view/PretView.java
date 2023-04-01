package presentation.view;

import presentation.controller.AuteurCaseAction;

import javax.swing.*;
import java.awt.*;

public class PretView extends JFrame {

    private JComboBox<String> pretsComboBox;
    private JButton ajouterbtn;
    private JButton supprimerbtn;
    private JButton modifierbtn;
    private JButton cleanBtn;

    // Text Fields

    private JTextField idTextField;
    private JTextField idAdherentText;
    private JTextField datePretText;

    // labels

    private JLabel idLabel;
    private JLabel idAdherentLabel;
    private JLabel datePretLabel;


    // panels

    private JPanel topPanel; // this is the panel that contains the combo box
    private JPanel centerPanel; // this is the panel that contains the text fields
    private JPanel bottomPanel; // this is the panel that contains the buttons

    private JPanel leftCenterPanel; // this is the panel that contains the labels
    private JPanel rightCenterPanel; // this is the panel that contains the text fields

    public PretView(){

        // initialize the text fields

        idTextField = new JTextField(23);
        idAdherentText = new JTextField(23);
        datePretText = new JTextField(23);


        // initialize the labels

        idLabel = new JLabel("ID Oeuvre");
        idAdherentLabel = new JLabel("ID Adherent");
        datePretLabel = new JLabel("Date de pret");

        // initialize the buttons

        ajouterbtn = new JButton("Ajouter");
        supprimerbtn = new JButton("Supprimer");
        modifierbtn = new JButton("Modifier");
        cleanBtn = new JButton("Vider");

        // initialize the combo box

        pretsComboBox = new JComboBox<>();

        // initialize the panels

        topPanel = new JPanel();
        centerPanel = new JPanel();
        bottomPanel = new JPanel();

        // set the layout of the panels

        topPanel.add(pretsComboBox, BorderLayout.CENTER);
        leftCenterPanel = new JPanel(new GridLayout(4, 1));
        rightCenterPanel = new JPanel(new GridLayout(4, 1));

        // add the labels and text fields to the panels

        leftCenterPanel.add(idLabel);
        leftCenterPanel.add(idAdherentLabel);
        leftCenterPanel.add(datePretLabel);

        rightCenterPanel.add(idTextField);
        rightCenterPanel.add(idAdherentText);
        rightCenterPanel.add(datePretText);

        // add the panels to the center panel

        centerPanel.add(leftCenterPanel, BorderLayout.WEST);
        centerPanel.add(rightCenterPanel, BorderLayout.EAST);

        // add the buttons to the bottom panel

        bottomPanel.add(ajouterbtn);
        bottomPanel.add(supprimerbtn);
        bottomPanel.add(modifierbtn);
        bottomPanel.add(cleanBtn);

        // set the size of the panels

        topPanel.setPreferredSize(new Dimension(400, 50));
        centerPanel.setPreferredSize(new Dimension(400, 150));
        bottomPanel.setPreferredSize(new Dimension(400, 50));

        // set the size of the combo box

        auteurComboBox.setPreferredSize(new Dimension(300, 30));

        // add the panels to the frame

        this.add(topPanel, BorderLayout.NORTH);
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(bottomPanel, BorderLayout.SOUTH);

        // add actions to the buttons

        this.ajouterbtn.addActionListener(new AuteurCaseAction(this));
        this.supprimerbtn.addActionListener(new AuteurCaseAction(this));
        this.modifierbtn.addActionListener(new AuteurCaseAction(this));
        this.cleanBtn.addActionListener(new AuteurCaseAction(this));

        // add actions to the combo box

        this.auteurComboBox.addActionListener(new AuteurCaseAction(this));

        // set the frame properties

        this.setTitle("Auteur");
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // so it won"t close the whole application
        this.setLocationRelativeTo(null);
        this.setVisible(true);


    }
