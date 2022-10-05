/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxcontroller;

import controller.UserController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.User;

/**
 *
 * @author dell
 */
public class SignupController implements Initializable{
    
    @FXML
    private PasswordField password;
    
    @FXML
    private TextField address;
    
    @FXML
    private TextField phone;
    
    @FXML
    private TextField username;
    
    @FXML
    private AnchorPane signup;
    
    @FXML
    private ImageView loading;
    
    @FXML
    private Label invalid;

    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loading.setVisible(false);
    }
    
    @FXML
    void logInPage(ActionEvent event) throws IOException {
        signup.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/frontend/Login.fxml"));
        Stage login = new Stage();
        Scene scene = new Scene(root, 600, 400);
        login.setScene(scene);
        login.setResizable(false);
        login.show();
    }
    
    @FXML
    void signUp(ActionEvent event) {
        PauseTransition pt = new PauseTransition();
        pt.setDuration(Duration.seconds(2));
        User user = new User(username.getText(), password.getText(),
        phone.getText(), address.getText() );
        UserController uc = new UserController();
        int result = uc.register(user);
        
       
            if(result == 1){
                loading.setVisible(true);
                pt.setOnFinished(ev -> {
                    mainPage();
                });
                pt.play();
                
            } else if (result == 2){
                invalid.setText("Fields is Empty");
            } else if (result == 3){
                invalid.setText("username must be more than 5 digits");
            } else if (result == 4){
                invalid.setText("password must be more than 7 digits");
            } else if (result == 5){
                invalid.setText("phone must equal 11 digits");
            } else if (result == 6){
                invalid.setText("phone must be only number");
            } else {
                loading.setVisible(true);
                pt.setOnFinished(ev -> {
                    loading.setVisible(false);
                    invalid.setText("username already exit ");
                });
                pt.play();
            } 
        
        PauseTransition pt1 = new PauseTransition();
        pt1.setDuration(Duration.seconds(5));
        pt1.setOnFinished(e -> {
            invalid.setText("");
        });
        pt1.play();
    }
    
     public void mainPage() {
        signup.getScene().getWindow().hide();
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/frontend/Main.fxml"));
            Stage mainPage = new Stage();
            Scene scene = new Scene(root, 600, 650);
            mainPage.setScene(scene);
            mainPage.setResizable(false);
            mainPage.show();
        } catch (IOException ex) {
            Logger.getLogger(LogInController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
