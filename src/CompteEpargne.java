class CompteEpargne extends CompteBancaire {
    private double tauxInteret;

    public CompteEpargne(String numero, double solde, String nomClient, double tauxInteret) {
        super(numero, solde, nomClient);
        this.tauxInteret = tauxInteret;
    }

    public void genererInterets() {
        double solde=getSolde();
        double interets = solde * tauxInteret / 100;
        solde = getSolde() + interets;
        setSolde(solde);
        System.out.println("Intérêts générés : " + interets + " MAD. Nouveau solde : " + solde + " €");
    }
}
