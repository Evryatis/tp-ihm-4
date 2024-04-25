package modele;

public class ExceptionPlanning extends Exception implements ConstantesErreur {

    private int chCodeErreur;
    public ExceptionPlanning(String parMessage) {
        super(parMessage);
    }

    public ExceptionPlanning(int parCodeErreur){
        super();
        chCodeErreur = parCodeErreur;
    }
}
