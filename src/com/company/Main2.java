package com.company;

import com.company.manager.ManagerCorredors;
import com.company.manager.ManagerCorredors2;
import com.company.manager.ManagerEquips;
import com.company.model.Corredor;
import com.company.model.Equip;
import com.company.view.PantallaMenuPrincipal;

import javax.sound.midi.Soundbank;

public class Main2 {

    public static void main(String[] args) {

        Equip equipo1 = new Equip("equipo1");

        Corredor corredor = ManagerCorredors2.obtenirCorredor(1004);
        System.out.println(corredor.id + " " + corredor.nom + " " + corredor.idEquip);

        System.out.println(ManagerCorredors2.existeixCorredor("Corredor1"));

        System.out.println(ManagerCorredors2.obtenirUltimIdCorredor());

        System.out.println(ManagerCorredors2.obtenirNumeroCorredors());

        System.out.println(ManagerCorredors2.obtenirNumeroCorredorsPerNom("Corredor1"));
    }
}
