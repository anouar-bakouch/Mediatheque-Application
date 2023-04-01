package presentation.view;

import javax.swing.*;

public class AdherentView extends JFrame {

    private JTextField txtId;
    private JTextField txtNom;
    private JTextField txtPrenom;
    private JTextField txtAdresse;
    private JTextField txtEmail;

    private JButton btnAjouter;
    private JButton btnModifier;
    private JButton btnSupprimer;
    private JButton btnRechercher;
    private JButton btnQuitter;

    private JTable table;
    private JScrollPane scrollPane;

    // 2 panes top
    private JPanel paneTop;
    private JPanel paneCenter;
    private JPanel paneBottom;
    private JPanel paneleft;
    private JPanel paneRight;
    // 1 pane bottom

    public AdherentView() {

        this.txtId = new JTextField();
        this.txtNom = new JTextField();
        this.txtPrenom = new JTextField();
        this.txtEmail = new JTextField();
        this.txtAdresse = new JTextField();

        this.paneleft = new JPanel();
        this.paneCenter = new JPanel();
        this.paneRight = new JPanel();
        this.paneBottom = new JPanel();

        this.btnAjouter = new JButton("Ajouter un adhérent");
        this.btnModifier = new JButton("Modifier un adhérent");
        this.btnSupprimer = new JButton("Supprimer un adhérent");
        this.btnRechercher = new JButton("Rechercher un adhérent");
        this.btnQuitter = new JButton("Quitter");

        this.table = new JTable();
        this.scrollPane = new JScrollPane(table);

        this.paneleft.setLayout(new BoxLayout(paneleft, BoxLayout.Y_AXIS));
        this.paneleft.add(txtId);
        this.paneleft.add(txtNom);
        this.paneleft.add(txtPrenom);
        this.paneleft.add(txtEmail);
        this.paneleft.add(txtAdresse);


        this.setTitle("Adhrenet");
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

}
