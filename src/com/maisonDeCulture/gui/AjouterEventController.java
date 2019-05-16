/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maisonDeCulture.gui;

import com.maisonDeCulture.entities.Event;
import com.maisonDeCulture.sercicesImpl.EventServiceImpl;
import java.net.URL;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author user
 */
public class AjouterEventController implements Initializable {

    @FXML
    private TextField libelle;
    @FXML
    private TextField lieu;
    @FXML
    private TextField image;
    @FXML
    private TextField prix;
    @FXML
    private TextField type;
    @FXML
    private TextField ticket;
    @FXML
    private DatePicker debut;
    @FXML
    private DatePicker fin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouter(ActionEvent event) {
        Event e;
        e = new Event(Date.from(debut.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()),
                lieu.getText(),
                libelle.getText(),
                Integer.parseInt(ticket.getText()),
                Date.from(fin.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()),
                Double.parseDouble(prix.getText()),
                type.getText(),
                image.getText());
        EventServiceImpl s= new EventServiceImpl();
        s.create(e);
    }

    @FXML
    private void annuler(ActionEvent event) {
    }
    
}
