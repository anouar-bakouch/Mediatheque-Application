package presentation.controller;

import beans.Adherent;
import presentation.view.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrincipaleCaseAction implements ActionListener {

    private PrincipaleView Pview;

    public PrincipaleCaseAction(PrincipaleView Pview){
        this.Pview = Pview;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

       if(e.getSource()==Pview.getAuteurBtn()){
           new AuteurView();
           System.out.println("hello world");
       }

       if(e.getSource()==Pview.getOeuvreBtn()){
              new OeuvreView();
              System.out.println("oeuvre");
       }

       if(e.getSource()==Pview.getPretBtn()){
                new PretView();
                System.out.println("Pret");
       }

       if(e.getSource()==Pview.getAdherentBtn()){
                   new AdherentView();
                   System.out.println("adherent");
       }

    }
}
