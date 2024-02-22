public class CompteCourant extends CompteBancaire {
    private double decouvertAutorise;

    public CompteCourant(String numero, double solde, String nomClient, double decouvertAutorise) {
        super(numero, solde, nomClient);
        this.decouvertAutorise = decouvertAutorise;
    }

    @Override
    public void retraitArgent(double montant) throws FondsInsuffisantsException {
        if (montant > getSolde() + decouvertAutorise) {
            throw new FondsInsuffisantsException("Retrait impossible : dépassement du découvert autorisé.");
        }
        double solde = getSolde() - montant;
        setSolde(solde);
        System.out.println(montant + " MAD retirés avec succès. Nouveau solde : " + solde + " MAD");
    }



}