package presentation.view;

import presentation.controller.AdherentCaseAction;
import presentation.controller.AuteurCaseAction;

import javax.swing.*;
import java.awt.*;

public class AdherentView extends JFrame {


    private JComboBox<String> AdherentsComboBox;
    private JButton ajouterbtn;
    private JButton supprimerbtn;
    private JButton modifierbtn;
    private JButton cleanBtn;

    // Text Fields

    private JTextField idTextField;
    private JTextField nomTextField;
    private JTextField prenomTextField;
    private JTextField addresseTextField;
    private JTextField emailTextField;

    // labels

    private JLabel idLabel;
    private JLabel nomLabel;
    private JLabel prenomLabel;
    private JLabel adresseLabel;
    private JLabel emailLabel;

    // panels

    private JPanel topPanel; // this is the panel that contains the combo box
    private JPanel centerPanel; // this is the panel that contains the text fields
    private JPanel bottomPanel; // this is the panel that contains the buttons
    private JPanel leftCenterPanel; // this is the panel that contains the labels
    private JPanel rightCenterPanel; // this is the panel that contains the text fields

    public AdherentView(){

        // initialize the text fields

        idTextField = new JTextField(23);
        idTextField.setEditable(false);
        nomTextField = new JTextField(23);
        prenomTextField = new JTextField(23);
        addresseTextField = new JTextField(23);
        emailTextField = new JTextField(23);
        // initialize the labels

        idLabel = new JLabel("ID");
        nomLabel = new JLabel("Nom");
        prenomLabel = new JLabel("Prenom");
        adresseLabel = new JLabel("Adresse");
        emailLabel = new JLabel("Email");
        // initialize the buttons

        ajouterbtn = new JButton("Ajouter");
        supprimerbtn = new JButton("Supprimer");
        modifierbtn = new JButton("Modifier");
        cleanBtn = new JButton("Vider");

        // initialize the combo box

        AdherentsComboBox = new JComboBox<>();

        // initialize the panels

        topPanel = new JPanel();
        centerPanel = new JPanel();
        bottomPanel = new JPanel();

        // set the layout of the panels

        topPanel.add(AdherentsComboBox, BorderLayout.CENTER);
        leftCenterPanel = new JPanel(new GridLayout(5, 1));
        rightCenterPanel = new JPanel(new GridLayout(5, 1));

        // align these panels to be in same level of Y axis

        leftCenterPanel.setAlignmentY(Component.TOP_ALIGNMENT);
        rightCenterPanel.setAlignmentY(Component.TOP_ALIGNMENT);


        // add the labels and text fields to the panels

        leftCenterPanel.add(idLabel);
        leftCenterPanel.add(nomLabel);
        leftCenterPanel.add(prenomLabel);
        leftCenterPanel.add(adresseLabel);
        leftCenterPanel.add(emailLabel);

        rightCenterPanel.add(idTextField);
        rightCenterPanel.add(nomTextField);
        rightCenterPanel.add(prenomTextField);
        rightCenterPanel.add(addresseTextField);
        rightCenterPanel.add(emailTextField);
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

        AdherentsComboBox.setPreferredSize(new Dimension(300, 30));

        // add the panels to the frame

        this.add(topPanel, BorderLayout.NORTH);
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(bottomPanel, BorderLayout.SOUTH);

        // add actions to the buttons

        this.ajouterbtn.addActionListener(new AdherentCaseAction(this));
        this.supprimerbtn.addActionListener(new AdherentCaseAction(this));
        this.modifierbtn.addActionListener(new AdherentCaseAction(this));
        this.cleanBtn.addActionListener(new AdherentCaseAction(this));

        // add actions to the combo box

        this.AdherentsComboBox.addActionListener(new AdherentCaseAction(this));

        // set the frame properties

        this.setTitle("Adherent");
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // so it won"t close the whole application
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public JComboBox<String> getAdherentsComboBox() {
        return AdherentsComboBox;
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

    public JTextField getNomTextField() {
        return nomTextField;
    }

    public JTextField getPrenomTextField() {
        return prenomTextField;
    }

    public JTextField getAddresseTextField() {
        return addresseTextField;
    }

    public JTextField getEmailTextField() {
        return emailTextField;
    }

    public JLabel getIdLabel() {
        return idLabel;
    }

    public JLabel getNomLabel() {
        return nomLabel;
    }

    public JLabel getPrenomLabel() {
        return prenomLabel;
    }

    public JLabel getAdresseLabel() {
        return adresseLabel;
    }

    public JLabel getEmailLabel() {
        return emailLabel;
    }

}
