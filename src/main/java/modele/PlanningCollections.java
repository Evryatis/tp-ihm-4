package modele;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.TreeSet;

public class PlanningCollections {
    private ArrayList <Reservation> chListeArray;
    private TreeSet <Reservation> chEnsembleArbre;
    private TreeMap<Integer, TreeSet<Reservation>> chMapReservation;

    public PlanningCollections(){
        chListeArray = new ArrayList<>();
        chEnsembleArbre = new TreeSet<>();
    }
    /**
     * Méthode ajout, prends une reservation en paramêtre
     * @return None
      */
    public void ajout (Reservation parReservation){
        chListeArray.add(parReservation);
        chEnsembleArbre.add(parReservation);

    }

    public TreeSet <Reservation> getReservation(DateCalendrier parDate){
        TreeSet<Reservation> res = new TreeSet<Reservation>();
        Iterator<Reservation> itr = chEnsembleArbre.iterator();
        while(itr.hasNext()) {
            Reservation resa = itr.next();
            if (resa.getDate().compareTo(parDate) == 0) {
                res.add(resa);
            }

        }
        if (res.size() == 0){
            return null;
        }

        return res;
    }


    public TreeSet <Reservation> getReservation(String parString) {
        TreeSet<Reservation> res = new TreeSet<Reservation>();
        Iterator<Reservation> itr = chEnsembleArbre.iterator();
        while (itr.hasNext()) {
            Reservation resa = itr.next();
            if (resa.getIntitule().contains(parString)) {
                res.add(resa);
            }

        }

        return res;

    }

    /**
     * Méthode toString
     * @return La taille de chaque array, et l'array, et la taille de l'arbre, et l'arbre.
     */
    public String toString() {
        return chListeArray.size() + " " + chListeArray + " " + chEnsembleArbre.size() + " " + chEnsembleArbre;
    }


}
