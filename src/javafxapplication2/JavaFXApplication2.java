/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import controller.UserController;
import dao.DatabaseConnection;
import dao.UserDao;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.User;

/**
 *
 * @author dell
 */
public class JavaFXApplication2 extends Application{
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        launch(args);
//          User user = new User();
//          user.setUsername("eslam");
//          user.setPassword("12345");
//          user.setPhone("01232133");
//          user.setAddress("dasdas");
//          UserController sc = new UserController();
//          UserDao dao = new UserDao();
//          System.out.println(dao.getUserByFirstDigits(user));
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        Parent root = FXMLLoader.load(getClass().getResource("/frontend/ForgotPassword.fxml"));
        Scene scene = new Scene(root, 600, 550);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    
}
