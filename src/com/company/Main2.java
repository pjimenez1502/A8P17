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

        ManagerEquips.inscriureEquip("AAA");

        PantallaMenuPrincipal.mostrar();

    }
}