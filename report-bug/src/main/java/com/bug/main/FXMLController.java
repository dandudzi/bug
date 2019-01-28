package com.bug.main;

import com.bug.model.MyBean;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FXMLController {

    @FXML
    private Label label;

    @Autowired
    MyBean myBean;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        myBean.setDaj("da");
        label.setText("Hello World!" + myBean.getDaj());
       myBean.say();
    }

    public void initialize() {
        // TODO
    }
}