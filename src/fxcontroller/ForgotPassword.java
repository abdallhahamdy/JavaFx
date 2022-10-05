/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxcontroller;

import com.mysql.cj.conf.PropertyKey;
import controller.UserController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.User;

/**
 *
 * @author dell
 */
public class ForgotPassword implements Initializable {

    @FXML
    private AnchorPane getPassword;

    @FXML
    private PasswordField lastDigts;
    
    @FXML
    private TextField firstDigits;

    @FXML
    private CheckBox last;
    
    @FXML
    private CheckBox first;
    
    @FXML
    private Label result;

    @FXML
    private PasswordField newpassword;
    
    @FXML
    private TextField username;
    
    @FXML
    private Button done;
    
    @FXML
    private Button finish;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        first.setSelected(true);
        last.setDisable(true);
        lastDigts.setDisable(true);
        newpassword.setVisible(false);
        finish.setVisible(false);
    }
    
    @FXML
    void done(ActionEvent event) {
        UserController us = new UserController();
        User user;
        if (!first.isSelected() && !last.isSelected()) { // !false !false
            result.setText("you must chech one only");
            PauseTransition pt = new PauseTransition();
            pt.setDuration(Duration.seconds(2));
            pt.setOnFinished(ev -> {
                result.setText("");
            });
            pt.play();
            return;
        }
        if (first.isSelected()) {
            user = new User(username.getText(), firstDigits.getText());
            if (us.getUserByFirstDigits(user) == 1) {
                newpassword.setVisible(true);
                disabled();
            } else {
                invalidData();
            }
        } else {
            user = new User(username.getText(), lastDigts.getText());
            if (us.getUserByLastDigits(user) == 1) {
                newpassword.setVisible(true);
                disabled();
            } else {
                invalidData();
            }
        }
    }

    @FXML
    void firstDigts(ActionEvent event) {
        if (first.isSelected()) {
            last.setDisable(true);
            lastDigts.setDisable(true);
        } else {
            last.setDisable(false);
            lastDigts.setDisable(false);
        }
    }

    @FXML
    void lastDigits(ActionEvent event) {
       if (last.isSelected()) {
           first.setDisable(true);
           firstDigits.setDisable(true);
       } else {
           first.setDisable(false);
           firstDigits.setDisable(false);
       }
    }
    
    @FXML
    void finish(ActionEvent event) throws IOException {
        User user = new User(username.getText(), newpassword.getText());
        UserController uc = new UserController();
        uc.editUserPassword(user);
        getPassword.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/frontend/Main.fxml"));
        Stage login = new Stage();
        Scene scene = new Scene(root, 600, 500);
        login.setScene(scene);
        login.setResizable(false);
        login.show();
    }
    
    public void disabled() {
        first.setDisable(true);
        last.setDisable(true);
        lastDigts.setDisable(true);
        username.setDisable(true);
        firstDigits.setDisable(true);
        done.setVisible(false);
        finish.setVisible(true);
    }
    
    public void invalidData() {
        result.setText("Invalid Data");
        PauseTransition pt = new PauseTransition();
        pt.setDuration(Duration.seconds(2));
        pt.setOnFinished(ev -> {
            result.setText("");
        });
        pt.play();
    }
}
