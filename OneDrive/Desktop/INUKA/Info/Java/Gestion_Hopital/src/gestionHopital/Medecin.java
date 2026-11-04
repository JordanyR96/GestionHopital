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

    // Redefinisyon metòd abstrè ki soti nan Personne
    @Override
    public void accederAuxInformations(Map<Integer, Dossier> dossiers) {
        System.out.println(
                "Doktè a ap konsilte enfòmasyon medikal pasyan an."
        );
        boolean trouve = false;
        for (Dossier d : dossiers.values()) {
            if (d.getMedecin() == this) {
                d.afficherDossier();
                trouve = true;
            }
        }
        if (!trouve) {
            System.out.println("Poko gen dosye pou dokte.");
        }
    }
}

