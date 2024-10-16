/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

import java.util.Random;

/**
 *
 * @author thomas
 */
public class Archer extends Personnage implements Combattant{
    /**
     * Nombre de fleches de l'archer
     */
    private int nbFleche;
    

    /**
     *
     * @return
     */
    public int getNbFleche() {
        return nbFleche;
    }

    /**
     *
     * @param nbFleche
     */
    public void setNbFleche(int nbFleche) {
        this.nbFleche = nbFleche;
    }
    
      
    /**
     *
     * @param n
     * @param pV
     * @param dA
     * @param pPar
     * @param paAtt
     * @param paPar
     * @param dMax
     * @param p
     * @param nbFl
     */
        
    public Archer(String n, int pV, int dA, int pPar, int paAtt, int paPar, float dMax, Point2D p, int nbFl){
        super(n, pV, dA, pPar, paAtt, paPar, dMax, p);
        nbFleche = nbFl;
    }
    
    /**
     *
     * @param a
     */
        
    public Archer(Archer a){
        super(a.getNom(), a.getPtVie(), a.getDegatAtt(), a.getPtPar(), a.getPageAtt(), a.getPagePar(), a.getDistAttMax(), new Point2D(a.getPos()));
        nbFleche = a.getNbFleche();
    }
    
    /**
     *
     */
    public Archer(){
        super();
        nbFleche = 0;
    }
    
    /**
     *
     * @param monde
     * @return
     */
    public Archer archerAlea(World monde){
        Random genAl = new Random();        
        int pv = genAl.nextInt(12)+1;
        int dA = genAl.nextInt(4)+1;
        int pPar = genAl.nextInt(2)+1;
        int paPar = genAl.nextInt(74)+25;
        int paAtt = genAl.nextInt(74)+25;
        float dMax = genAl.nextInt(5)+3;
        int nombFlech = genAl.nextInt(10)+5;
        int x = genAl.nextInt(0, (monde.taille)-1);
        int y = genAl.nextInt(0, (monde.taille)-1);
        Archer robin = new Archer(nom, pv, dA, pPar, paAtt, paPar, dMax, new Point2D(x, y), nombFlech);
        return robin;
    }
    
    /**
     * 
     * @param c 
     * On commence par vérifier que le combat à distance est possible et que l'archer a au moins une flèche
     * On test la réussite de l'attaque
     * Si les ptVie tombent en dessous de 0 on les remets à 0.
     */
    @Override
    public void combattre(Creature c){
        if ((this.pos.distance(c.pos)<=this.distAttMax)&&(this.pos.distance(c.pos)>1)&&(this.nbFleche>0)){
            System.out.println(this.getNom()+" attaque !");
            this.nbFleche -= 1;
            Random genAl = new Random();
            int jetAtt = genAl.nextInt(99)+1;
            int deg = 0;
            if (jetAtt<=this.pageAtt){
                deg += this.degatAtt;
                c.setPtVie(c.getPtVie()-deg);
                if (c.getPtVie() < 0){
                    c.setPtVie(0);
                }
                System.out.println(deg+" degats infliges !");
            }
            else{
                System.out.println("attaque manquee");
            }
        }
        else{
            System.out.println("attaque impossible");
        }
    }
    
    @Override
    public void affiche(){
        System.out.println("nom : "+nom+"\npoints de vie : "+ptVie);
        System.out.println("degats d'attaque : "+degatAtt);
        System.out.println("points de parade : "+ptPar);
        System.out.println("pourcentage de parade : "+pagePar);
        System.out.println("pourcentage d'attaque : "+pageAtt);
        System.out.println("distance d'attaque maximale : "+distAttMax);
        System.out.println("fleches restantes :"+this.nbFleche);
        pos.affiche();
    }
}
