package gestionHopital;

import java.util.Map;

public class Medecin extends Personne {
    // Sèvi lè n ap relire Medecin la epi retabli ID li te genyen an.
    public Medecin(int id, String nom, String prenom, String sexe,
            String adresse, String dateNaissance) {
        super(id, nom, prenom, sexe, adresse, dateNaissance);
    }

    // Kont doktè a genyen pou li konekte nan sistèm nan
    private Utilisateur utilisateur;

    // Konstriktè klas Medecin lan
    public Medecin(String nom, String prenom, String sexe,
            String adresse, String dateNaissance) {

        // Rele konstriktè klas paran Personne lan
        super(nom, prenom, sexe, adresse, dateNaissance);
    }

    // Mete kont itilizatè doktè a
    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    // Retounen kont itilizatè doktè a
    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    // Montre rezime dosye kote doktè sa a asosye.
    @Override
    public void accederAuxInformations(Map<Integer, Dossier> dossiers) {
        boolean trouve = false;
        System.out.println("\nDosye medikal kote dokte sa a asosye :");
        for (Dossier d : dossiers.values()) {
            if (d.getMedecin() == this) {
                d.afficherRezime();
                trouve = true;
            }
        }
        if (!trouve) {
            System.out.println("  Pa gen dosye medikal pou dokte sa a.");
        }
    }
}

