package modele;

public class Reservation {

    private Date chDate;
    private Horaire chPlageHoraireDebut;
    private Horaire chPlageHoraireFin;
    private String chIntitule;

    public Reservation(Date parDate, Horaire parPlageHoraireDebut, Horaire parPlageHoraireFin, String parIntitule) {


        this.chDate = parDate;
        this.chPlageHoraireDebut = parPlageHoraireDebut;
        this.chPlageHoraireFin = parPlageHoraireFin;
        this.chIntitule = parIntitule;

    }

    /**
     * Méthode compareTo prends un objet et un paramêtre parReservation.
     * Elle renvoie un entier < 0 quand this est antérieur à parReservation
     * Elle renvoie un entier > 0 quand this est inférieur à parReservation
     * Elle renvoie 0 quand this et parReservation sont égales ou incompatibles
     * @return int
     */
    /*
    public int compareTo(Reservation parReservation){
        int compareDate = this.chDate.compareTo(parReservation.chDate);
        if (compareDate != 0)
            return compareDate;

        return this.chPlageHoraire.compareTo(parReservation.chPlageHoraire);

    }

     */
    /*
    public boolean estValide(){

        if (!chDate.estValide())
            return false;

        if (!chPlageHoraire.estValide())
            return false;

        return true;
    }

     */

    public Date getDate(){
        return chDate;
    }

    public String getIntitule(){return chIntitule;}
    
    public String toString(){

        return chIntitule + ", " + chDate.toString() + ", " + chPlageHoraireDebut.toString() + ", " + chPlageHoraireFin;

    }

}
