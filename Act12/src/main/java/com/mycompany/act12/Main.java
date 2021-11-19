package com.mycompany.act12;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author Cortez Ramos
 */
public class Main {
    public static BufferedReader entrada =new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{    
        AddressBook directorio = new AddressBook();
        directorio.load();
        int opcion;
        String numero;
        String nombre;
        String eleccion;
        do{
        System.out.println("Selecciona una opción para realizar con la agenda: "
                + "Lista de contactos(1), Crear contacto(2) o Borrar contacto(3)");
        opcion = Integer.parseInt(entrada.readLine());
        switch(opcion){
            case 1:
                System.out.println("Seleccionaste \"Lista de contactos\"");
                System.out.println("------------------------------------");
                directorio.list();
                break;
            case 2:
                System.out.println("Seleccionaste \"Crear contacto\""); 
                System.out.println("------------------------------------");
                System.out.println("Ingresa el número del contacto");
                numero = entrada.readLine();
                System.out.println("Ingresa el nombre del contacto");
                nombre = entrada.readLine();
                directorio.create(numero, nombre);
                break;
            case 3:
                System.out.println("Seleccionaste \"Borrar contacto\""); 
                System.out.println("------------------------------------");
                System.out.println("Ingresa el número del contacto que deseas"
                        + " borrar");
                numero = entrada.readLine();
                directorio.delate(numero);
                break;
            default:
                System.out.println("La opción ingresada es incorrecta, "
                        + "ingresa alguna opción valido");
        }
        System.out.println("¿Quieres hacer algo más? (S o N)");
        eleccion = entrada.readLine();
        }while("s".equals(eleccion) || "S".equals(eleccion)); 
    }
}
