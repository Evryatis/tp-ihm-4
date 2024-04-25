package modele;

public class PlageHoraire {
    private final static int DUREE_MIN = 60;
    private Horaire chHoraireDebut;
    private Horaire chHoraireFin;

    public PlageHoraire(Horaire parHoraireDebut, Horaire parHoraireFin)  {

        chHoraireDebut = parHoraireDebut;
        chHoraireFin = parHoraireFin;
    }

    /**
     * Prends deux paramêtres HoraireDebut et HoraireFin
     * @param parHoraireCompare
     * @return renvoie la durée en Horaire.
     */
    public Horaire duree(PlageHoraire parHoraireCompare){

        int duree_minute = parHoraireCompare.chHoraireDebut.toMinutes() - parHoraireCompare.chHoraireFin.toMinutes();
        int duree_heure = duree_minute / 60;
        int duree_finale_minute = duree_minute % 60;

        return new Horaire(duree_heure, duree_finale_minute);
    }

    /**
     * compareTo retourne :
     * Un négatif quand l'objet appelant est antérieur à parPlageHoraire
     * Un positif quand l'objet appelant est postérieur à parPlageHoraire
     * 0 dans tout les autres cas ( égalité, chevauchement, inclusion)
     * @param parPlageHoraire, la plage à comparer avec this
     * @return int résultat de la comparaison
     */
    public int compareTo(PlageHoraire parPlageHoraire){

        if (this.chHoraireFin.toMinutes() <= parPlageHoraire.chHoraireDebut.toMinutes()) {
            return -1;
        }

        if (this.chHoraireDebut.toMinutes() >= parPlageHoraire.chHoraireFin.toMinutes()){
            return 1;
        }

        return 0;
    }



    /**
     * Méthode estValide retourne true quand this est une plage horaire valide
     * L'horaire de fin doit être plus grand que l'horaire de début, et la durée doit être supérieur ou égal à DUREE_MIN
     * @return boolean
     */
    public Boolean estValide(){

        return chHoraireFin.toMinutes() - chHoraireDebut.toMinutes() >= DUREE_MIN;
    }

    public String toString()
    {
        return chHoraireDebut+ "-" + chHoraireFin;
    }
}



