package gestionHopital;

import java.util.Map;

public class Patient extends Personne {
    // Sèvi lè n ap relire Patient la epi retabli ID li te genyen an.
    public Patient(int id, String nom, String prenom, String sexe,
            String adresse, String dateNaissance) {
        super(id, nom, prenom, sexe, adresse, dateNaissance);
    }

    // Konstriktè klas Patient lan
    public Patient(String nom, String prenom, String sexe, String adresse, String dateNaissance) {
        super(nom, prenom, sexe, adresse, dateNaissance);
    }

    // Redefinisyon metòd abstrè ki soti nan klas Personne lan
    @Override
    public void accederAuxInformations(Map<Integer, Dossier> dossiers) {
        boolean trouve = false;
        System.out.println("Pasyan an ap konsilte dosye li.");
        for (Dossier d : dossiers.values()) {
            if (d.getPatient() == this) {
                d.afficherDossier();
                trouve = true;
            }
        }
        if (!trouve) {
            System.out.println("Pa gen dosye.");
        }
    }
}

