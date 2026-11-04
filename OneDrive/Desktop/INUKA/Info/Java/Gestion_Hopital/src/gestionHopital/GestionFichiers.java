package gestionHopital;

import static gestionHopital.GestionHopital.patients;
import static gestionHopital.GestionHopital.personnes;
import static gestionHopital.GestionHopital.medecins;
import static gestionHopital.GestionHopital.infirmiers;
import static gestionHopital.GestionHopital.dossiers;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class GestionFichiers {

    /*
     * Fichye Patyan
     * Li pasyan ki te sovegade yo lè pwogram nan demare.
     */
    public static void chargerPatients() {
        File fichier = new File("patients.txt");
        if (!fichier.exists()) {
            return; // Premye itilizasyon: fichye a poko egziste.
        }

        try (Scanner lecteur = new Scanner(fichier)) {
            while (lecteur.hasNextLine()) {
                String ligne = lecteur.nextLine();
                if (ligne.trim().isEmpty()) {
                    continue;
                }
                String[] champs = ligne.split("\\|", -1);
                if (champs.length != 6) {
                    System.out.println("Liy pasyan sa a pa valab: " + ligne);
                    continue;
                }

                int id = Integer.parseInt(champs[0]);
                Patient patient = new Patient(id, champs[1], champs[2], champs[3], champs[4], champs[5]);
                patients.put(id, patient);
                personnes.add(patient);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Pa kapab li patients.txt: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Gen yon ID pasyan ki pa yon nonb valab.");
        }
    }

    // Anrejistre tout pasyan yo; fichye a reflete eta aktyèl Map patients la.
    public static void sauvegarderPatients() {
        try (PrintWriter sortie = new PrintWriter(new FileWriter("patients.txt"))) {
            for (Patient patient : patients.values()) {
                sortie.println(patient.getId() + "|"
                        + patient.getNom() + "|"
                        + patient.getPrenom() + "|"
                        + patient.getSexe() + "|"
                        + patient.getAdresse() + "|"
                        + patient.getDateNaissance());
            }
        } catch (IOException e) {
            System.out.println("Pa kapab anrejistre patients.txt: " + e.getMessage());
        }
    }

    /*
     * Fichye Medcin
     * Li pasyan ki te sovegade yo lè pwogram nan demare.
     */
    public static void chargerMedecins() {
        File fichier = new File("medecins.txt");
        if (!fichier.exists()) {
            return;
        }

        try (Scanner lecteur = new Scanner(fichier)) {
            while (lecteur.hasNextLine()) {
                String ligne = lecteur.nextLine();
                if (ligne.trim().isEmpty()) {
                    continue;
                }
                String[] champs = ligne.split("\\|", -1);
                if (champs.length != 6) {
                    System.out.println("Liy medcin sa a pa valab: " + ligne);
                    continue;
                }

                int id = Integer.parseInt(champs[0]);
                Medecin medecin = new Medecin(id, champs[1], champs[2], champs[3], champs[4], champs[5]);
                medecins.put(id, medecin);
                personnes.add(medecin);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Pa kapab li medecins.txt: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Gen yon ID medcin ki pa yon nonb valab.");
        }
    }

    // Anrejistre tout medcin yo; fichye a reflete eta aktyèl Map medecins an.
    public static void sauvegarderMedecins() {
        try (PrintWriter sortie = new PrintWriter(new FileWriter("medecins.txt"))) {
            for (Medecin medecin : medecins.values()) {
                sortie.println(medecin.getId() + "|"
                        + medecin.getNom() + "|"
                        + medecin.getPrenom() + "|"
                        + medecin.getSexe() + "|"
                        + medecin.getAdresse() + "|"
                        + medecin.getDateNaissance());
            }
        } catch (IOException e) {
            System.out.println("Pa kapab anrejistre medecins.txt: " + e.getMessage());
        }
    }

    /*
     * Fichye Infimye
     * Li pasyan ki te sovegade yo lè pwogram nan demare.
     */
    public static void chargerInfirmiers() {
        File fichier = new File("infirmiers.txt");
        if (!fichier.exists()) {
            return;
        }

        try (Scanner lecteur = new Scanner(fichier)) {
            while (lecteur.hasNextLine()) {
                String ligne = lecteur.nextLine();
                if (ligne.trim().isEmpty()) {
                    continue;
                }
                String[] champs = ligne.split("\\|", -1);
                if (champs.length != 6) {
                    System.out.println("Liy infimye sa a pa valab: " + ligne);
                    continue;
                }

                int id = Integer.parseInt(champs[0]);
                Infirmier infirmier = new Infirmier(id, champs[1], champs[2], champs[3], champs[4], champs[5]);
                infirmiers.put(id, infirmier);
                personnes.add(infirmier);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Pa kapab li infirmiers.txt: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Gen yon ID infimye ki pa yon nonb valab.");
        }
    }

    // Anrejistre tout infimye yo; fichye a reflete eta aktyèl Map infirmiers an.
    public static void sauvegarderInfirmier() {
        try (PrintWriter sortie = new PrintWriter(new FileWriter("infirmiers.txt"))) {
            for (Infirmier infirmier : infirmiers.values()) {
                sortie.println(infirmier.getId() + "|"
                        + infirmier.getNom() + "|"
                        + infirmier.getPrenom() + "|"
                        + infirmier.getSexe() + "|"
                        + infirmier.getAdresse() + "|"
                        + infirmier.getDateNaissance());
            }
        } catch (IOException e) {
            System.out.println("Pa kapab anrejistre infirmiers.txt: " + e.getMessage());
        }
    }

    // Li dosye yo apre chajman pasyan, dokte ak enfimye yo.
    public static void chargerDossiers() {
        File fichier = new File("dossiers.txt");
        if (!fichier.exists()) {
            return;
        }

        try (Scanner lecteur = new Scanner(fichier)) {
            while (lecteur.hasNextLine()) {
                String ligne = lecteur.nextLine();
                if (ligne.trim().isEmpty()) {
                    continue;
                }

                String[] champs = ligne.split("\\|", -1);
                if (champs.length != 6) {
                    System.out.println("Liy dosye sa a pa valab: " + ligne);
                    continue;
                }

                try {
                    int numero = Integer.parseInt(champs[0]);
                    int idPatient = Integer.parseInt(champs[3]);
                    int idMedecin = Integer.parseInt(champs[4]);
                    int idInfirmier = Integer.parseInt(champs[5]);
                    Patient patient = patients.get(idPatient);
                    if (patient == null) {
                        System.out.println("Pasyan " + idPatient + " pou dosye " + numero + " pa jwenn.");
                        continue;
                    }

                    Dossier dossier = new Dossier(numero, champs[1], champs[2], patient);
                    if (idMedecin != 0) {
                        Medecin medecin = medecins.get(idMedecin);
                        if (medecin != null) {
                            dossier.setMedecin(medecin);
                        } else {
                            System.out.println("Dokte " + idMedecin + " pou dosye " + numero + " pa jwenn.");
                        }
                    }
                    if (idInfirmier != 0) {
                        Infirmier infirmier = infirmiers.get(idInfirmier);
                        if (infirmier != null) {
                            dossier.setInfirmier(infirmier);
                        } else {
                            System.out.println("Enfimye " + idInfirmier + " pou dosye " + numero + " pa jwenn.");
                        }
                    }
                    dossiers.put(numero, dossier);
                } catch (NumberFormatException e) {
                    System.out.println("ID nan liy dosye sa a pa valab: " + ligne);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Pa kapab li dossiers.txt: " + e.getMessage());
        }
    }

    // Ekri ID moun ki asosye yo pou lyen yo ka retabli nan pwochen lansman.
    public static void sauvegarderDossiers() {
        try (PrintWriter sortie = new PrintWriter(new FileWriter("dossiers.txt"))) {
            for (Dossier dossier : dossiers.values()) {
                int idMedecin = dossier.getMedecin() == null ? 0 : dossier.getMedecin().getId();
                int idInfirmier = dossier.getInfirmier() == null ? 0 : dossier.getInfirmier().getId();
                sortie.println(dossier.getNumeroDossier() + "|"
                        + dossier.getMaladie() + "|"
                        + dossier.getDescription() + "|"
                        + dossier.getPatient().getId() + "|"
                        + idMedecin + "|"
                        + idInfirmier);
            }
        } catch (IOException e) {
            System.out.println("Pa kapab anrejistre dossiers.txt: " + e.getMessage());
        }
    }
}
