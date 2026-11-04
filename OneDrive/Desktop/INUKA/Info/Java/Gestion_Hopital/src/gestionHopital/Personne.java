package gestionHopital;

import java.util.Map;

public abstract class Personne {

    private static int prochainId = 1;
    // Atribi prive yo pou pwoteje done yo (enkapsilasyon)
    private final int id;
    private String nom;
    private String prenom;
    private String sexe;
    private String adresse;
    private final String dateNaissance;

    // Konstriktè sa a bay yon nouvo ID pou chak nouvo moun.
    public Personne(String nom, String prenom, String sexe, String adresse, String dateNaissance) {
        this(prochainId, nom, prenom, sexe, adresse, dateNaissance);
    }

    // Sèvi lè n ap relire yon moun epi retabli ID ki te anrejistre a.
    public Personne(int id, String nom, String prenom, String sexe, String adresse, String dateNaissance) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID a dwe pi gran pase zewo.");
        }
        this.id = id;
        if (id >= prochainId) {
            prochainId = id + 1;
        }
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.adresse = adresse;
        this.dateNaissance = dateNaissance;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public abstract void accederAuxInformations(Map<Integer, Dossier> dossiers);

    public void afficherInformations() {
        System.out.println("ID : " + getId());
        System.out.println("Non : " + getNom());
        System.out.println("Prenon : " + getPrenom());
        System.out.println("Sèks : " + getSexe());
        System.out.println("Adrès : " + getAdresse());
        System.out.println("Dat nesans : " + getDateNaissance());
    }

    public void afficherInformations(String maladie) {
        afficherInformations();
        System.out.println("Maladi : " + maladie);
    }
}
