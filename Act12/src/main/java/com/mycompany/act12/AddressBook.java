package com.mycompany.act12;

import java.util.HashMap;
import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author Cortez Ramos
 */
public class AddressBook {
    HashMap<String, String> map = new HashMap<>();
    ArrayList<String> lista = new ArrayList<String>();
    public AddressBook(){
    }
    
    public void list() {
        if(map.size()==0){
            System.out.println("No hay contactos para mostrar, crea alguno");
        }else{
            System.out.println("{Número}:{Nombre}");
                    for (String key: map.keySet()){  
            System.out.println("{"+key+ "}:{" + map.get(key) + "}");
            } 
        }
    }
    
    public void create(String num,String nombre) throws IOException{
        map.put(num, nombre);
        lista.add(num+","+nombre);
        System.out.println("El contacto fue añadido a la lista"); 
        save(lista);  
    }
    
    public void delate(String num) throws IOException{
        if (map.containsKey(num)){
           String valtemp= "";
           for(int i=0; i<lista.size(); i++){
             valtemp=lista.get(i);
             if(valtemp.contains(num)){
                lista.remove(valtemp);
             }
           }
           map.remove(num); 
           System.out.println("El contacto se ha eliminado");
        }else{
            System.out.println("El numero ingresado no existe");
        }
        save(lista);
    }
    
    public void load() throws IOException{
        String file="C:\\Users\\Cortez Ramos\\OneDrive\\Documentos\\txt\\agenda.txt";
        File archivo = new File(file);
        if (!archivo.exists()) {
            System.out.println("No se ha detectado ninguna agenda existente");
        }else{
            System.out.println("Hay una agenda ya existente");
            System.out.println("Cargando...");
            ArrayList<String> texto = new ArrayList<String>();
            texto=leerTxt("C:\\Users\\Cortez Ramos\\OneDrive\\Documentos\\txt\\agenda.txt");

            for(int i=0; i<texto.size(); i++){
                 String data = texto.get(i);
                 String[] split = data.split(",");
                 String a="";
                 String b="";
                 for (int x=0; x<split.length; x++){
                    if(x==(split.length/2)){
                        for (int j=0; j<x; j++){
                            a=a+split[j];
                            b=b+split[x];
                        }
                    }
                } 
                create(a,b);
            }
        }
    }
    
    public void save(ArrayList<String> lista) throws IOException{
        String file="C:\\Users\\Cortez Ramos\\OneDrive\\Documentos\\txt\\agenda.txt";
        FileWriter fichero = new FileWriter(file);
        fichero.close();
        File archivo = new File(file);
        archivo.delete();
        BufferedWriter bufferW = new BufferedWriter(new FileWriter(file, true));
        for(int i=0; i<lista.size(); i++){
            bufferW.write(lista.get(i)+"\n");
        }
        bufferW.close();
        System.out.println("Se ha guardado el contenido con exito");
    }

    
    public static ArrayList leerTxt(String direccion){
        ArrayList<String> lista = new ArrayList<String>();
        try{
            BufferedReader bf = new BufferedReader(new FileReader(direccion));
            String bfRead;
            while((bfRead = bf.readLine()) != null){
                lista.add(bfRead);
            }   
        }catch(Exception e){
            System.out.println("No se encontró archivo");
        }
        return lista;
    }
}
