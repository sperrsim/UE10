package controller;

import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.*;


/**
 * @author Simon Sperr
 * @version 2020.3, 10.12.2020
 */
public class upnController{

    Stack<Double> numbers = new Stack<>();

    @FXML
    private TextField numb_txt;
    @FXML
    private ListView numb_list;
    @FXML
    private Label message_lbl;


    public void addNumber()
    {
        message_lbl.setVisible(false);
        if(!numb_txt.getText().isEmpty())
        {
            try
            {
                numbers.add(Double.parseDouble(numb_txt.getText()));
                numb_list.setItems((stackToObservable(numbers)));
            }
            catch (Exception e)
            {
                message_lbl.setText("Fehler bei der Eingabe!");
                message_lbl.setVisible(true);
            }
            numb_txt.clear();
        }
    }

    public void inputNumber(Event event)
    {
        Object node = event.getSource();
        Button btn = (Button)node;
        String in = btn.getText();
        if(numb_txt.getLength() < 14)
        {
            message_lbl.setVisible(false);
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
            {
                message_lbl.setText("Fehler bei der Eingabe!");
                message_lbl.setVisible(true);
            }
        }
        else
        {
            message_lbl.setText("Zahl zu lang!");
            message_lbl.setVisible(true);
        }
    }

    public ObservableList stackToObservable(Stack stack)
    {
        ObservableList<Double> observableList = FXCollections.observableList(stack);
        return observableList;
    }
}
