public abstract class CompteBancaire {
    private String numero;
    private double solde;
    private String nomClient;


    public CompteBancaire(String numero, double solde, String nomClient) {
        this.numero = numero;
        this.solde = solde;
        this.nomClient = nomClient;

    }

    public CompteBancaire() {
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public void depotArgent(double montant) {
        solde=montant+solde;
        System.out.println(montant + " MAD déposés avec succès. Nouveau solde : " + solde + " MAD");
    }
    public void retraitArgent(double montant) throws FondsInsuffisantsException {
        if (montant>solde) throw new FondsInsuffisantsException("Solde insuffisant");
        solde=solde-montant;
        System.out.println(montant + " MAD retirés avec succès. Nouveau solde : " + solde + " MAD");

    }

    public void afficherSolde() {
        System.out.println("Solde du compte : " + solde + " MAD");
    }
    public void transfererArgent(CompteBancaire compteDestinataire, double montant) throws FondsInsuffisantsException, CompteInexistantException {
        if (compteDestinataire == null) {
            throw new CompteInexistantException("Le compte destinataire n'existe pas.");
        }
        retraitArgent(montant);
        compteDestinataire.depotArgent(montant);
        System.out.println("Transfert de " + montant + " MAD effectué avec succès vers le compte " + compteDestinataire.numero);}
    }


