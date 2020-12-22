package controller;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * @author Simon Sperr
 * @version 2020.3, 10.12.2020
 */
public class upnController{

    @FXML
    private TextField numb_txt;

    public void addChar(Event event)
    {
        Object node = event.getSource();
        Button btn = (Button)node;
        String in = btn.getText();
        if(numb_txt.getLength() < 14)
        {
            if(in.equals("1")||in.equals("2")||in.equals("3")||in.equals("4")||in.equals("5")||in.equals("6")||in.equals("7")||in.equals("8")||in.equals("9")||in.equals("0"))
                numb_txt.appendText(in);
            else if(in.equals(".") && !numb_txt.getText().contains("."))
                numb_txt.appendText(in);
            else if (in.equals("-"))
            {
                if(numb_txt.getText().contains("-"))
                    numb_txt.deleteText(0,1);
                else
                    numb_txt.insertText(0,in);
            }
            else
                System.out.println("Fehler bei Eingabe!");
        }
        else
            System.out.println("Zahl zu lang!");
    }
}
