package controller;

import javax.swing.*;
import java.net.URL;

public abstract class AbstractRudokAction extends AbstractAction {

    public Icon loadIcon(String fileName){
        URL imageUrl = getClass().getResource(fileName);
        Icon icon = null;

        if(imageUrl != null){
            icon = new ImageIcon(imageUrl);
        }else{
            System.err.println("Resource not found: "+ fileName);
        }

        return icon;
    }
}
