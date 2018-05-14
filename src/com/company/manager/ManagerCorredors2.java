package com.company.manager;

import com.company.model.Corredor;
import com.company.model.Equip;

import java.io.*;

public class ManagerCorredors2 {
    static Corredor[] corredors = new Corredor[100];

    public static Corredor inscriureCorredor(String nom, Equip equip){
        if(equip == null){
            return null;
        }


        try {
            FileWriter outputStream = new FileWriter("Corredors.txt",true);
            outputStream.write(nom+":");
            outputStream.write(String.valueOf(equip.id+":"));
            outputStream.write(String.valueOf(1000+1)+"\n");
            outputStream.close();

        } catch (IOException e) {
            System.out.println("No se ha podido crear el fichero");
        }


        return null;
    }

    public static Corredor obtenirCorredor(int id){

        try {

            BufferedReader buffReader = new BufferedReader(new FileReader("Corredors.txt"));

            String line;
            while((line = buffReader.readLine()) != null) {
                String[] partes = line.split(":");
                if (id==Integer.parseInt(partes[2])){

                    Corredor corredor = new Corredor(partes[0],Integer.parseInt(partes[1]));
                    corredor.id=Integer.parseInt(partes[2]);
                    return corredor;
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static Corredor[] obtenirLlistaCorredors(){
        Corredor[] llistaCorredors = new Corredor[obtenirNumeroCorredors()];

        int j = 0;
        for (int i = 0; i < corredors.length; i++) {
            if(corredors[i] != null){
                llistaCorredors[j] = corredors[i];
                j++;
            }
        }

        return llistaCorredors;
    }

    public static Corredor[] buscarCorredorsPerNom(String nom){
        Corredor[] llistaCorredors = new Corredor[obtenirNumeroCorredorsPerNom(nom)];

        int j = 0;
        for (int i = 0; i < corredors.length; i++) {
            if(corredors[i] != null && corredors[i].nom.toLowerCase().contains(nom.toLowerCase())){
                llistaCorredors[j] = corredors[i];
                j++;
            }
        }

        return llistaCorredors;
    }

    public static boolean existeixCorredor(String nom){

        try {

            BufferedReader buffReader = new BufferedReader(new FileReader("Corredors.txt"));

            String line;
            while((line = buffReader.readLine()) != null) {
                String[] partes = line.split(":");
                if (nom.equals(partes[0])){
                    return true;
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    public static void modificarNomCorredor(int id, String nouNom){
        for (int i = 0; i < corredors.length; i++) {
            if(corredors[i] != null && corredors[i].id == id){
                corredors[i].nom = nouNom;
            }
        }
    }

    public static void modificarEquipCorredor(int id, Equip nouEquip){
        if(nouEquip == null){
            return;
        }

        for (int i = 0; i < corredors.length; i++) {
            if(corredors[i] != null && corredors[i].id == id){
                corredors[i].idEquip = nouEquip.id;
            }
        }
    }

    public static void esborrarCorredor(int id){
        for (int i = 0; i < corredors.length; i++) {
            if(corredors[i] != null && corredors[i].id == id){
                corredors[i] = null;
            }
        }
    }

    public static int obtenirUltimIdCorredor(){
        int maxId = 0;

        try {

            BufferedReader buffReader = new BufferedReader(new FileReader("Corredors.txt"));

            String line;
            while((line = buffReader.readLine()) != null) {
                String[] partes = line.split(":");
                if (maxId<Integer.parseInt(partes[2])){
                    maxId=Integer.parseInt(partes[2]);
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return maxId;
    }

    public static int obtenirNumeroCorredors(){
        int count = 0;

        try {

            BufferedReader buffReader = new BufferedReader(new FileReader("Corredors.txt"));

            String line;
            while((line = buffReader.readLine()) != null) {
                count++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return count;
    }

    public static int obtenirNumeroCorredorsPerNom(String nom){
        int count = 0;

        try {

            BufferedReader buffReader = new BufferedReader(new FileReader("Corredors.txt"));

            String line;
            while((line = buffReader.readLine()) != null) {
                String[] partes = line.split(":");
                if (nom.equals(partes[0])){
                    count++;
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return count;
    }
}
