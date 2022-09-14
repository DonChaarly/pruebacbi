package com.prueba.demo;

import java.time.LocalDate;
import java.util.Date;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Pueba67Application {

	public static void main(String[] args) {
		SpringApplication.run(Pueba67Application.class, args);
                
                var ruta = "https://pokeapi.co/api/v2/pokemon?limit10";
                
                System.out.println(getDia(2017, 10, 10));
                
                String arreglo[] = {"perro", "Oaxaca"};
                System.out.println(buscarPalabra(arreglo));
                
                
                       
	}

        
    public static String getDia(int año, int mes, int dia){
        var date = new Date(año, mes, dia);

        var fecha = date.toString();

        switch(fecha.substring(0, 3)){
            case "Mon":{
                return "Lunes";
            }
            case "Tue":{
                return "martes";
            }
            case "Wed":{
                return "miércoles";
            }
            case "Thu":{
                return "Jueves";
            }
            case "Fri":{
                return "viernes";
            }
            case "Sat":{
                return "sabado";
            }
            case "Sun":{
                return "domingo";
            }

        }

        return date.toString();
    }

    public static String buscarPalabra(String[] array){


        for(var i =0; i< array.length; i++){
            if(array[i] == "Oaxaca"){
                return "Si existe Oaxaca en la posicion: " + i;
            }
        }
        return "No existe Oaxaca";
    }
        
}
