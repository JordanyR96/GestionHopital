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

    // Montre enfòmasyon pasyan an ak rezime dosye ki asosye avè l.
    @Override
    public void accederAuxInformations(Map<Integer, Dossier> dossiers) {
        boolean trouve = false;
        System.out.println("\nDosye medikal ki asosye ak pasyan sa a :");
        for (Dossier d : dossiers.values()) {
            if (d.getPatient() == this) {
                d.afficherRezime();
                trouve = true;
            }
        }
        if (!trouve) {
            System.out.println("  Pa gen dosye medikal pou pasyan sa a.");
        }
    }
}

