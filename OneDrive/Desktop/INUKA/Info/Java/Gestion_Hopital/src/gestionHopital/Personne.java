package gestionHopital;

import java.util.Map;

public abstract class Personne {

    private static int comptId = 1;
    // Atribi prive yo pou pwoteje done yo (enkapsilasyon)
    private final int id;
    private String nom;
    private String prenom;
    private String sexe;
    private String adresse;
    private final String dateNaissance;

    // Konstriktè klas Personne lan
    public Personne(String nom, String prenom, String sexe, String adresse, String dateNaissance) {
        this.id = comptId;
        comptId++;
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

    // Getter pou non an
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    // Definisyon yon metòd abstrè
    public abstract void accederAuxInformations(Map<Integer, Dossier> dossiers);

    // Montre enfòmasyon jeneral moun nan
    public void afficherInformations() {
        System.out.println("ID : " + getId());
        System.out.println("Non : " + getNom());
        System.out.println("Prenon : " + getPrenom());
        System.out.println("Sèks : " + getSexe());
        System.out.println("Adrès : " + getAdresse());
        System.out.println("Dat nesans : " + getDateNaissance());
    }

    // Surcharge metòd afficherInformations lan
    public void afficherInformations(String maladie) {
        afficherInformations();
        System.out.println("Maladi : " + maladie);
    }
}
