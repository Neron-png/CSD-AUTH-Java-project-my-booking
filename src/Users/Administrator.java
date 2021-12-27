package Users;
import Users.Actions.CommandLine.AdminCommandLineManager;
import Users.Actions.Graphical.AdminGUIManager;

import javax.swing.*;
import java.awt.*;

/**
 * This is a child of the User class, which contains functionality unique
 * to the Administrator User Type
 * @author Neron Panagiotopoulos
 */
public class Administrator extends User{


    /**
     * Primary constructor of an Administrator User object, takes in credentials,
     * initializes the class fields and assigns a unique ID to the object
     *
     * @param username Login username of the new user
     * @param password Login password of the new user
     */
    public Administrator(String username, String password) {
        super(username, password);
        this.typeName = "Administrator";
        this.commandLineManager = new AdminCommandLineManager(this);
        this.guiManager = new AdminGUIManager(this);
    }


    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("Administrator\n");
        str.append(super.toString());
        return str.toString();
    }

}
