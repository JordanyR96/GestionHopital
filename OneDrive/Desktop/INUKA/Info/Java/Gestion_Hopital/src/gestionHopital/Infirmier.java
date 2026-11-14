package gestionHopital;

import java.util.Map;

public class Infirmier extends Personne {

    // Sèvi lè n ap relire Infirmier la epi retabli ID li te genyen an.
    public Infirmier(int id, String nom, String prenom, String sexe,
            String adresse, String dateNaissance) {
        super(id, nom, prenom, sexe, adresse, dateNaissance);
    }

    // Kont itilizatè enfimyè a pou li konekte nan sistèm nan
    private Utilisateur utilisateur;

    // Konstriktè klas Infirmier lan
    public Infirmier(String nom, String prenom, String sexe,
            String adresse, String dateNaissance) {

        // Rele konstriktè klas paran Personne lan
        super(nom, prenom, sexe, adresse, dateNaissance);
    }

    // Mete kont itilizatè enfimyè a
    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    // Retounen kont itilizatè enfimyè a
    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    // Montre rezime dosye kote enfimyè sa a asosye.
    @Override
    public void accederAuxInformations(Map<Integer, Dossier> dossiers) {
        boolean trouve = false;
        System.out.println("\nDosye medikal kote enfimye sa a asosye :");
        for (Dossier d : dossiers.values()) {
            if (d.getInfirmier() == this) {
                d.afficherRezime();
                trouve = true;
            }
        }
        if (!trouve) {
            System.out.println("  Pa gen dosye medikal pou enfimye sa a.");
        }
    }
}
