/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;
import java.util.Iterator;

/**
 *
 * @author titou
 */
public class TestWoE {

    /**
     *
     * @param args
     */
    public static void main(String[] args){
        World monde = new World();
        monde = monde.creerMondeAlea(0,0,0,1,4, 2, 2);
        Joueur moi =  new Joueur();
        monde.AjoutPJ(moi);
        monde.afficheWorld();
        System.out.println("debut du jeu");
        System.out.println("vous etes au 0");
        System.out.println("1 : Paysan, 2 : Archer, 3 : Guerrier, 4 : Loup, 5 : Lapin");
        for (int i = 0; i< 100; i++){
            monde.TourDeJeu();
        }
    }
}
