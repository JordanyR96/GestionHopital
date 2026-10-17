package gestionHopital;

import java.util.Map;

public class Infirmier extends Personne {

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

    // Redefinisyon metòd abstrè ki soti nan Personne
    @Override
    public void accederAuxInformations(Map<Integer, Dossier> dossiers) {
        System.out.println(
                "Enfimyè a ap konsilte dosye pasyan an pou li ba li swen."
        );
        boolean trouve = false;
        for (Dossier d : dossiers.values()) {
            if(d.getInfirmier() == this) {
                d.afficherDossier();
                trouve = true;
            }
        }
        if (!trouve) {
            System.out.println("Poko gen dosye pou enfimye.");
        }
    }
}
