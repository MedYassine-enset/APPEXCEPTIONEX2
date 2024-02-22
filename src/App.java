import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws FondsInsuffisantsException, CompteInexistantException {
        ArrayList<CompteBancaire> comptes = new ArrayList<>();

        // Ajout de comptes
        comptes.add(new CompteCourant("123456", 1000, "Alice", 500));
        comptes.add(new CompteEpargne("654321", 2000, "Bob", 2.5));

        // Suppression d'un compte
        comptes.removeIf(compte -> compte instanceof CompteEpargne && ((CompteEpargne) compte).getSolde() == 0);

        // Opérations sur les comptes
        try {
            comptes.get(0).retraitArgent(3000);
            comptes.get(1).transfererArgent(comptes.get(0), 300);
            ((CompteEpargne) comptes.get(1)).genererInterets();
        } catch (FondsInsuffisantsException | CompteInexistantException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

}
