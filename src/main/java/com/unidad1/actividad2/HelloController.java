package com.unidad1.actividad2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class HelloController {

    int resultado = 0;
    int iterator = 0;
    String input = "";
    @FXML
    private Button btnContarVocales;

    @FXML
    private Button btnLargoPalabras;

    @FXML
    private Button btnMyM;

    @FXML
    private TextField inptUser;

    @FXML
    private Label lblContarVocales;

    @FXML
    private Label lblLargoPalabras;

    @FXML
    private Label lblMyM;

    @FXML
    void clicBtnContarValores(ActionEvent event) {

        // OBTENEMOS EL TEXTO DEL LABEL y COLOCAR MINUSCULAS
        input = inptUser.getText().toLowerCase();

        //DECLARAR VOCALES EN UN ARREGLO
        final char vocales[] = {'a','e','i','o','u'};

        for (int i = 0; i < 5; i++) {
            if (input.contains(String.valueOf(vocales[i]))) {
                resultado += 1;
            }
        }
        //MOSTRAR EL RESULTADO
        lblContarVocales.setText(String.format("La cantidad de vocales encontradas: %d", resultado));
        resultado = 0;
    }

    @FXML
    void clicBtnLargoPalabras(ActionEvent event) {

        //SEPARAR POR PALABRAS
        String[] palabras = inptUser.getText().split(" ");
        String palabraLarga = palabras[0];
        String palabraCorta = palabras[0];

        for (String palabra : palabras){
            if(palabra.length() < palabraCorta.length()){
                palabraCorta = palabra;
            }
            if(palabra.length() > palabraLarga.length()){
                palabraLarga = palabra;
            }
        }

        // CONTAR CARACTERES
        int totalCaracteres = inptUser.getText().length();
        //MOSTRAR EN LABEL
        lblLargoPalabras.setText(String.format("Palabra larga: %s\nPalabra pequeña: %s\nTotal: %d",palabraLarga,palabraCorta,totalCaracteres));
    }

    //FUNCION PARA MODIFICAR ORDEN DE MAYUSCULAS
    public String myM(String s){
        String[] palabras = s.split(" ");
        for(int i =0; i<palabras.length; i++){
            palabras[i] = palabras[i].toUpperCase();
            i++;
        }
        return String.join(" ",palabras);
    }

    @FXML
    void clicBtnMyM(ActionEvent event) {

        iterator += 1;  //contador en aumento de clic

        if(iterator == 1){
            input = inptUser.getText().toUpperCase();
            lblMyM.setText(input);
        }else if (iterator == 2){
            input = inptUser.getText().toLowerCase();
            lblMyM.setText(input);
        } else{
            lblMyM.setText( myM(input));
            iterator = 0;
        }

    }

}
