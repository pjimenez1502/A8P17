package com.company.manager;

import com.company.model.Corredor;
import com.company.model.Equip;

import java.io.*;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class ManagerCorredors2 {
    static Corredor[] corredors = new Corredor[100];

    public static Corredor inscriureCorredor(String nom, Equip equip){
        if(equip == null){
            return null;
        }

        try {
            FileWriter outputStream = new FileWriter("Corredors.txt",true);
            outputStream.write("\n" + nom+":");
            outputStream.write(String.valueOf(equip.id+":"));
            outputStream.write(String.valueOf(obtenirUltimIdCorredor()+1));
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

        try {

            BufferedReader buffReader = new BufferedReader(new FileReader("Corredors.txt"));

            String line;
            int j = 0;
            while((line = buffReader.readLine()) != null) {
                String[] partes = line.split(":");

                llistaCorredors[j]= new Corredor(partes[0], Integer.parseInt(partes[1]));

                j++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return llistaCorredors;
    }

    public static Corredor[] buscarCorredorsPerNom(String nom){
        Corredor[] llistaCorredors = new Corredor[obtenirNumeroCorredorsPerNom(nom)];

        try {

            BufferedReader buffReader = new BufferedReader(new FileReader("Corredors.txt"));

            String line;
            int j = 0;
            while((line = buffReader.readLine()) != null) {
                String[] partes = line.split(":");
                if (partes[0].contains(nom.toLowerCase())){
                    llistaCorredors[j]= new Corredor(partes[0], Integer.parseInt(partes[1]));
                    j++;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
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

        try {

            BufferedReader buffReader = new BufferedReader(new FileReader("Corredors.txt"));
            FileWriter fileWriter = new FileWriter("Corredors2.txt",true);

            String line;
            while((line = buffReader.readLine()) != null) {
                String[] partes = line.split(":");
                if (id==Integer.parseInt(partes[2])){
                    fileWriter.write(nouNom + ":");
                    fileWriter.write(String.valueOf(partes[1]) + ":");
                    fileWriter.write(String.valueOf(id));
                }else{
                    fileWriter.write("\n" + line);
                }

            }
            fileWriter.close();
            buffReader.close();

            Files.move(FileSystems.getDefault().getPath("Corredors2.txt"), FileSystems.getDefault().getPath("Corredors.txt"), REPLACE_EXISTING);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void modificarEquipCorredor(int id, Equip nouEquip){
        if(nouEquip == null){
            return;
        }

        try {

            BufferedReader buffReader = new BufferedReader(new FileReader("Corredors.txt"));
            FileWriter fileWriter = new FileWriter("Corredors2.txt",true);

            String line;
            while((line = buffReader.readLine()) != null) {
                String[] partes = line.split(":");
                if (id==Integer.parseInt(partes[2])){
                    fileWriter.write(String.valueOf(partes[0]) + ":");
                    fileWriter.write(nouEquip.id + ":");
                    fileWriter.write(String.valueOf(partes[2]));
                }else{
                    fileWriter.write("\n" + line);
                }

            }
            fileWriter.close();
            buffReader.close();

            Files.move(FileSystems.getDefault().getPath("Corredors2.txt"), FileSystems.getDefault().getPath("Corredors.txt"), REPLACE_EXISTING);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void esborrarCorredor(int id){

        try {

            BufferedReader buffReader = new BufferedReader(new FileReader("Corredors.txt"));
            FileWriter fileWriter = new FileWriter("Corredors2.txt",true);

            String line;
            while((line = buffReader.readLine()) != null) {
                String[] partes = line.split(":");
                if (id!=Integer.parseInt(partes[2])) {
                    fileWriter.write("\n" + line);
                }
            }
            fileWriter.close();
            buffReader.close();

            Files.move(FileSystems.getDefault().getPath("Corredors2.txt"), FileSystems.getDefault().getPath("Corredors.txt"), REPLACE_EXISTING);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
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
