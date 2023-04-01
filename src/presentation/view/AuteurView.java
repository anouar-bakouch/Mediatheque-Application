package presentation.view;
import dao.AuteurDao;
import dao.AuteurDaoImp;
import presentation.controller.AuteurCaseAction;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AuteurView extends JFrame {

    private JComboBox<String> auteurComboBox;
    private JButton ajouterbtn;
    private JButton supprimerbtn;
    private JButton modifierbtn;

    // Text Fields

    private JTextField idTextField;
    private JTextField nomTextField;
    private JTextField prenomTextField;
    private JTextField dateNaissanceTextField;

    // labels

    private JLabel idLabel;
    private JLabel nomLabel;
    private JLabel prenomLabel;
    private JLabel dateNaissanceLabel;

    // panels

    private JPanel topPanel; // this is the panel that contains the combo box
    private JPanel centerPanel; // this is the panel that contains the text fields
    private JPanel bottomPanel; // this is the panel that contains the buttons

    private JPanel leftCenterPanel; // this is the panel that contains the labels
    private JPanel rightCenterPanel; // this is the panel that contains the text fields

    public AuteurView(){

        // initialize the text fields

        idTextField = new JTextField(23);
        nomTextField = new JTextField(23);
        prenomTextField = new JTextField(23);
        dateNaissanceTextField = new JTextField(23);

        // initialize the labels

        idLabel = new JLabel("ID");
        nomLabel = new JLabel("Nom");
        prenomLabel = new JLabel("Prenom");
        dateNaissanceLabel = new JLabel("Date de naissance");

        // initialize the buttons

        ajouterbtn = new JButton("Ajouter");
        supprimerbtn = new JButton("Supprimer");
        modifierbtn = new JButton("Modifier");

        // initialize the combo box

        auteurComboBox = new JComboBox<>();

        // initialize the panels

        topPanel = new JPanel();
        centerPanel = new JPanel();
        bottomPanel = new JPanel();

        // set the layout of the panels

        topPanel.add(auteurComboBox, BorderLayout.CENTER);
        leftCenterPanel = new JPanel(new GridLayout(4, 1));
        rightCenterPanel = new JPanel(new GridLayout(4, 1));

        // add the labels and text fields to the panels

        leftCenterPanel.add(idLabel);
        leftCenterPanel.add(nomLabel);
        leftCenterPanel.add(prenomLabel);
        leftCenterPanel.add(dateNaissanceLabel);

        rightCenterPanel.add(idTextField);
        rightCenterPanel.add(nomTextField);
        rightCenterPanel.add(prenomTextField);
        rightCenterPanel.add(dateNaissanceTextField);

        // add the panels to the center panel

        centerPanel.add(leftCenterPanel, BorderLayout.WEST);
        centerPanel.add(rightCenterPanel, BorderLayout.EAST);

        // add the buttons to the bottom panel

        bottomPanel.add(ajouterbtn);
        bottomPanel.add(supprimerbtn);
        bottomPanel.add(modifierbtn);

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

        // add actions to the combo box

        this.auteurComboBox.addActionListener(new AuteurCaseAction(this));

        // set the frame properties

        this.setTitle("Auteur");
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // so it won"t close the whole application
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    public JComboBox<String> getAuteurComboBox() {
        return auteurComboBox;
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

    public JTextField getIdTextField() {
        return idTextField;
    }

    public JTextField getNomTextField() {
        return nomTextField;
    }

    public JTextField getPrenomTextField() {
        return prenomTextField;
    }

    public JTextField getDateNaissanceTextField() {
        return dateNaissanceTextField;
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

    public JLabel getDateNaissanceLabel() {
        return dateNaissanceLabel;
    }
}