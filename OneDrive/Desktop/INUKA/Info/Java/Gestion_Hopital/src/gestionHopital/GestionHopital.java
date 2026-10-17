package gestionHopital;

/**
 *
 * @author Regis Jordany
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class GestionHopital {

    public static void verifierNom(String nom) throws Utils {
        if (nom == null || nom.trim().isEmpty()) {
            throw new Utils("Non an paka rete vid.");
        }
    }

    // =========================
    // LIS APLIKASYON AN
    // =========================
    static Map<Integer, Patient> patients = new HashMap<>();
    static Map<Integer, Medecin> medecins = new HashMap<>();
    static Map<Integer, Infirmier> infirmiers = new HashMap<>();
    static Map<Integer, Dossier> dossiers = new HashMap<>();
    static Map<String, Utilisateur> utilisateurs = new HashMap<>();
    static List<Personne> personnes = new ArrayList<>();

    static Scanner scanner = new Scanner(System.in);

    // =========================
    // PWOGRAM PRINCIPAL LA
    // =========================
    public static void main(String[] args) {

        int choix;

        do {
            System.out.println("=====================================");
            System.out.println("          JESYON LOPITAL LA          ");
            System.out.println("=====================================\n");
            System.out.println("1. Jesyon pasyan yo");
            System.out.println("2. Jesyon dokte yo");
            System.out.println("3. Jesyon enfimye yo");
            System.out.println("4. Jesyon dosye yo");
            System.out.println("5. Aksede ak tout infomasyon moun yo.");
            System.out.println("6. Jesyon itilizate yo");
            System.out.println("0. Kite aplikasyon an");

            choix = Utils.lireChoix();

            switch (choix) {
                case 1:
                    menuPatients();
                    break;

                case 2:
                    menuMedecins();
                    break;

                case 3:
                    menuInfirmiers();
                    break;

                case 4:
                    menuDossiers();
                    break;

                case 5:
                    accederInformationsTousLeMonde();
                    break;

                case 6:
                    menuUtilisateurs();
                    break;

                case 0:
                    System.out.println(" Kite aplikasyon an ...");
                    break;

                default:
                    System.out.println("\nERE : ou sipose antre youn nan opsyon sa yo kise 1, 2, 3, 4, 5, 6 oswa 0.\n");
            }

        } while (choix != 0);
    }

    // =====================================================
    // JESYON PASYAN YO
    // =====================================================
    public static void menuPatients() {

        int choix;

        do {
            System.out.println("\n===== JESYON PASYAN YO =====\n");
            System.out.println("1. Ajoute yon pasyan");
            System.out.println("2. Modifye yon pasyan");
            System.out.println("3. Efase yon pasyan");
            System.out.println("4. Montre lis pasyan yo");
            System.out.println("0. Retounen");

            choix = Utils.lireChoix();

            switch (choix) {

                case 1:
                    ajouterPatient();
                    break;

                case 2:
                    modifierPatient();
                    break;

                case 3:
                    supprimerPatient();
                    break;

                case 4:
                    afficherPatients();
                    break;

                case 0:
                    break;

                default:
                    System.out.println("\nERE : ou sipose antre youn nan opsyon sa yo kise 1, 2, 3, 4, oswa 0.\n");
            }

        } while (choix != 0);
    }

    public static void ajouterPatient() {

        System.out.println("\n--- AJOUTE YON PASYAN ---\n");
        try {
            System.out.print("Non : ");
            String nom = scanner.nextLine();
            verifierNom(nom);

            System.out.print("Prenon : ");
            String prenom = scanner.nextLine();
            verifierNom(prenom);

            System.out.print("Seks : ");
            String sexe = scanner.nextLine();
            verifierNom(sexe);

            System.out.print("Adre : ");
            String adresse = scanner.nextLine();
            verifierNom(adresse);

            System.out.print("Dat nesans : ");
            String dateNaissance = scanner.nextLine();
            verifierNom(dateNaissance);

            Patient patient = new Patient(
                    nom,
                    prenom,
                    sexe,
                    adresse,
                    dateNaissance
            );

            patients.put(patient.getId(), patient);

            personnes.add(patient);

            System.out.println("Pasyan an ajoute avek sikse.");

        } catch (Utils e) {
            System.out.println("Ere : " + e.getMessage());
        }
    }

    public static void modifierPatient() {

        if (patients.isEmpty()) {
            System.out.println("Pa gen okenn pasyan.");
            return;
        }

        afficherPatients();

        int id = Utils.modifierId();

        Patient patient = patients.get(id);

        if (patient == null) {
            System.out.println("Patient sa pa jwenn.");
            return;
        }

        System.out.print("Nouvo non : ");
        patient.setNom(scanner.nextLine());

        System.out.print("Nouvo prenon : ");
        patient.setPrenom(scanner.nextLine());

        System.out.print("Nouvo seks : ");
        patient.setSexe(scanner.nextLine());

        System.out.print("Nouvo adres : ");
        patient.setAdresse(scanner.nextLine());

        System.out.println("Pasyan an modifye avek sikse");
    }

    public static void supprimerPatient() {

        if (patients.isEmpty()) {
            System.out.println("Pa gen okenn pasyan.");
            return;
        }

        afficherPatients();

        int id = Utils.supprimerId();

        Patient supprime = patients.remove(id);

        if (supprime == null) {
            System.out.println("Pasyan a pa jwenn.");
        } else {
            System.out.println("Pasyan a efase avek sikse.");
        }
    }

    public static void afficherPatients() {

        if (patients.isEmpty()) {
            System.out.println("Pa gen okenn pasyan ki anrejistre.");
            return;
        }

        System.out.println("\n===== LIS PASYAN YO =====");

        for (Patient patient : patients.values()) {
            patient.afficherInformations();
            System.out.println();
        }

    }

    // =====================================================
    // JESYON DOKTÈ YO
    // =====================================================
    public static void menuMedecins() {

        int choix;

        do {
            System.out.println("===== JESYON DOKTE YO =====\n");
            System.out.println("1. Ajoute yon dokte");
            System.out.println("2. Modifye yon dokte");
            System.out.println("3. Efase yon dokte");
            System.out.println("4. Montre lis dokte yo");
            System.out.println("0. Retounen");

//            System.out.print("Chwazi yon opsyon : ");
//            choix = scanner.nextInt();
//            scanner.nextLine();
            choix = Utils.lireChoix();

            switch (choix) {

                case 1:
                    ajouterMedecin();
                    break;

                case 2:
                    modifierMedecin();
                    break;

                case 3:
                    supprimerMedecin();
                    break;

                case 4:
                    afficherMedecins();
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opsyon sa a pa valab.");
            }

        } while (choix != 0);
    }

    public static void ajouterMedecin() {

        System.out.println("--- AJOUTE YON DOKTE ---\n");

        System.out.print("Non : ");
        String nom = scanner.nextLine();

        System.out.print("Prenon : ");
        String prenom = scanner.nextLine();

        System.out.print("Seks : ");
        String sexe = scanner.nextLine();

        System.out.print("Adres : ");
        String adresse = scanner.nextLine();

        System.out.print("Dat nesans : ");
        String dateNaissance = scanner.nextLine();

        Medecin medecin = new Medecin(
                nom,
                prenom,
                sexe,
                adresse,
                dateNaissance
        );

        medecins.put(medecin.getId(), medecin);

        personnes.add(medecin);

        System.out.println("Dokte a ajoute avek sikse.");
    }

    public static void modifierMedecin() {

        if (medecins.isEmpty()) {
            System.out.println("Pa gen okenn dokte.");
            return;
        }

        afficherMedecins();

        int id = Utils.modifierId();

        Medecin medecin = medecins.get(id);

        if (medecin == null) {
            System.out.println("ID a pa valab.");
            return;
        }

        System.out.print("Nouvo non : ");
        medecin.setNom(scanner.nextLine());

        System.out.print("Nouvo prenon : ");
        medecin.setPrenom(scanner.nextLine());

        System.out.print("Nouvo seks : ");
        medecin.setSexe(scanner.nextLine());

        System.out.print("Nouvo adres : ");
        medecin.setAdresse(scanner.nextLine());

        System.out.println("Dokte a modifye avek sikse.");
    }

    public static void supprimerMedecin() {

        if (medecins.isEmpty()) {
            System.out.println("Pa gen okenn dokte.");
            return;
        }

        afficherMedecins();

        int id = Utils.modifierId();

        Medecin supprime = medecins.remove(id);

        if (supprime == null) {
            System.out.println("Dokte pa jwenn.");
        } else {
            System.out.println("Dokte a efase avek sikse.");
        }
    }

    public static void afficherMedecins() {

        if (medecins.isEmpty()) {
            System.out.println("Pa gen okenn dokte ki anrejistre.");
            return;
        }

        System.out.println("\n===== LIS DOKTE YO =====");

        for (Medecin medecin : medecins.values()) {
            medecin.afficherInformations();
            System.out.println();
        }
    }

    // =====================================================
    // JESYON ENFIMYÈ YO
    // =====================================================
    public static void menuInfirmiers() {

        int choix;

        do {
            System.out.println("\n===== JESYON ENFIMYE YO =====\n");
            System.out.println("1. Ajoute yon enfimye");
            System.out.println("2. Modifye yon enfimye");
            System.out.println("3. Efase yon enfimye");
            System.out.println("4. Montre lis enfimye yo");
            System.out.println("0. Retounen");

            choix = Utils.lireChoix();

            switch (choix) {

                case 1:
                    ajouterInfirmier();
                    break;

                case 2:
                    modifierInfirmier();
                    break;

                case 3:
                    supprimerInfirmier();
                    break;

                case 4:
                    afficherInfirmiers();
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opsyon sa a pa valab.");
            }

        } while (choix != 0);
    }

    public static void ajouterInfirmier() {

        System.out.println("\n--- AJOUTE YON ENFIMYE ---\n");

        System.out.print("Non : ");
        String nom = scanner.nextLine();

        System.out.print("Prenon : ");
        String prenom = scanner.nextLine();

        System.out.print("Seks : ");
        String sexe = scanner.nextLine();

        System.out.print("Adre : ");
        String adresse = scanner.nextLine();

        System.out.print("Dat nesans : ");
        String dateNaissance = scanner.nextLine();

        Infirmier infirmier = new Infirmier(
                nom,
                prenom,
                sexe,
                adresse,
                dateNaissance
        );

        infirmiers.put(infirmier.getId(), infirmier);

        personnes.add(infirmier);

        System.out.println("Enfimye a ajoute avek sikse.");
    }

    public static void modifierInfirmier() {

        if (infirmiers.isEmpty()) {
            System.out.println("Pa gen okenn enfimye.");
            return;
        }

        afficherInfirmiers();

        int id = Utils.modifierId();

        Infirmier infirmier = infirmiers.get(id);

        if (infirmier == null) {
            System.out.println("ID a pa valab.");
            return;
        }

        System.out.print("Nouvo non : ");
        infirmier.setNom(scanner.nextLine());

        System.out.print("Nouvo prenon : ");
        infirmier.setPrenom(scanner.nextLine());

        System.out.print("Nouvo seks : ");
        infirmier.setSexe(scanner.nextLine());

        System.out.print("Nouvo adres : ");
        infirmier.setAdresse(scanner.nextLine());

        System.out.println("Enfimye a modifye ave sikse.");
    }

    public static void supprimerInfirmier() {

        if (infirmiers.isEmpty()) {
            System.out.println("Pa gen okenn enfimye");
            return;
        }

        afficherInfirmiers();

        int id = Utils.supprimerId();

        Infirmier supprime = infirmiers.remove(id);

        if (supprime == null) {
            System.out.println("ID a pa valab.");
            return;
        } else {
            System.out.println("Enfimyea efase avek sikse.");
        }
    }

    public static void afficherInfirmiers() {

        if (infirmiers.isEmpty()) {
            System.out.println("Pa gen okenn enfimye ki anrejistre.");
            return;
        }

        System.out.println("\n===== LIS ENFIMYE YO =====\n");

        for (Infirmier infirmier : infirmiers.values()) {
            infirmier.afficherInformations();
            System.out.println();
        }
    }

    // =====================================================
    // JESYON DOSYE YO
    // =====================================================
    public static void menuDossiers() {

        int choix;

        do {
            System.out.println("\n===== JESYON DOSYE YO =====\n");
            System.out.println("1. Ajoute yon dosye");
            System.out.println("2. Modifye yon dosye");
            System.out.println("3. Efase yon dosye");
            System.out.println("4. Montre lis dosye yo");
            System.out.println("0. Retounen");

            choix = Utils.lireChoix();

            switch (choix) {

                case 1:
                    ajouterDossier();
                    break;

                case 2:
                    modifierDossier();
                    break;

                case 3:
                    supprimerDossier();
                    break;

                case 4:
                    afficherDossiers();
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opsyon sa a pa valab.");
            }

        } while (choix != 0);
    }

    public static void ajouterDossier() {

        if (patients.isEmpty()) {
            System.out.println("Fok ou ajoute yon pasyan anvan.");
            return;
        }

        System.out.println("\n--- AJOUTE YON DOSYE ---");

        int numero = Utils.ajouterDossier();

        if (dossiers.containsKey(numero)) {
            System.out.println("Nimero dosye sa a deja agziste.");
            return;
        }

        System.out.print("Maladi : ");
        String maladie = scanner.nextLine();

        System.out.print("Deskripsyon : ");
        String description = scanner.nextLine();

        afficherPatients();

        int choixPatient = Utils.numeroChoixPatient();

        Patient patient = patients.get(choixPatient);

        if (patient == null) {
            System.out.println("ID Pasyan an pa valab.");
            return;
        }

        Dossier dossier = new Dossier(
                numero,
                maladie,
                description,
                patient
        );

        // Fè lyen ant dosye a ak yon doktè
        if (!medecins.isEmpty()) {

            afficherMedecins();

            System.out.print(
                    "Chwazi nimewo dokte a (0 si pa gen dokte) : "
            );

            int choixMedecin = Utils.lienDossierMedecin();

            Medecin medecin = medecins.get(choixMedecin);

            if (medecin != null) {
                dossier.setMedecin(medecin);
            }
        }

        // Fè lyen ant dosye a ak yon enfimyè
        if (!infirmiers.isEmpty()) {

            afficherInfirmiers();

            System.out.print(
                    "Chwazi nimewo enfimye a (0 si pa gen enfimye) : "
            );

            int choixInfirmier = Utils.lienDossierInfirmier();

            Infirmier infirmier = infirmiers.get(choixInfirmier);

            if (infirmier != null) {
                dossier.setInfirmier(infirmier);
            }
        }

        dossiers.put(numero, dossier);

        System.out.println("Dosye a ajoute ave sikse.");
    }

    public static void modifierDossier() {

        if (dossiers.isEmpty()) {
            System.out.println("Pa gen okenn dosye.");
            return;
        }

        afficherDossiers();

        int numero = Utils.modifierDossier();

        Dossier dossierTrouve = dossiers.get(numero);

        if (dossierTrouve == null) {
            System.out.println("Dosye a pa jwenn.");
            return;
        }

        System.out.print("Nouvo maladi : ");
        dossierTrouve.setMaladie(scanner.nextLine());

        System.out.print("Nouvo deskripsyon : ");
        dossierTrouve.setDescription(scanner.nextLine());

        System.out.println("Dosye a modifye avèk siksè.");
    }

    public static void supprimerDossier() {

        if (dossiers.isEmpty()) {
            System.out.println("Pa gen okenn dosye.");
            return;
        }

        afficherDossiers();

        int numero = Utils.supprimerDossier();

        Dossier supprime = dossiers.remove(numero);

        if (supprime == null) {
            System.out.println("Dosye a pa jwenn.");
        } else {
            System.out.println("Dosye a efase avek sikse.");
        }
    }

    public static void afficherDossiers() {

        if (dossiers.isEmpty()) {
            System.out.println("Pa gen okenn dosye ki anrejistre.");
            return;
        }

        System.out.println("\n===== LIS DOSYE YO =====");

        for (Dossier dossier : dossiers.values()) {
            dossier.afficherDossier();
            System.out.println();
        }
    }

    public static void accederInformationsTousLeMonde() {
        if (personnes.isEmpty()) {
            System.out.println("Pa gen moun ki anregistre.");
            return;
        }
        for (Personne personne : personnes) {
            personne.accederAuxInformations(dossiers);
        }
    }

    // =====================================================
    // JESYON ITILIZATÈ YO
    // =====================================================
    public static void menuUtilisateurs() {

        int choix;

        do {
            System.out.println("\n===== JESYON ITILIZATEYO =====\n");
            System.out.println("1. Ajoute yon itilizate");
            System.out.println("2. Modifye modpas la");
            System.out.println("3. Efase yon itilizate");
            System.out.println("4. Montre lis itilizate yo");
            System.out.println("5. Teste otantifikasyon");
            System.out.println("0. Retounen");

            choix = Utils.lireChoix();

            switch (choix) {

                case 1:
                    ajouterUtilisateur();
                    break;

                case 2:
                    modifierMotDePasse();
                    break;

                case 3:
                    supprimerUtilisateur();
                    break;

                case 4:
                    afficherUtilisateurs();
                    break;

                case 5:
                    testerAuthentification();
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opsyon sa a pa valab.");
            }

        } while (choix != 0);
    }

    public static void ajouterUtilisateur() {

        System.out.println("\n--- AJOUTE YON ITILIZATE ---");

        System.out.print("Idantifyan : ");
        String identifiant = scanner.nextLine();

        if (utilisateurs.containsKey(identifiant)) {
            System.out.println("Idantifyan sa a deja agziste.");
            return;
        }

        System.out.print("Modpas : ");
        String motDePasse = scanner.nextLine();

        Utilisateur utilisateur = new Utilisateur(
                identifiant,
                motDePasse
        );

        utilisateurs.put(identifiant, utilisateur);

        System.out.println("Itilizate a ajoute avek sikse.");
    }

    public static void modifierMotDePasse() {

        if (utilisateurs.isEmpty()) {
            System.out.println("Pa gen okenn itilizate.");
            return;
        }

        afficherUtilisateurs();

        System.out.print("Idantifyan itilizate a : ");
        String identifiant = scanner.nextLine();

        Utilisateur utilisateur = utilisateurs.get(identifiant);

        if (utilisateur == null) {
            System.out.println("Itilizate a pa jwenn.");
            return;
        }
        System.out.print("Nouvo modpas : ");
        String nouveauMotDePasse = scanner.nextLine();

        utilisateur.setMotDePasse(nouveauMotDePasse);

        System.out.println("Modpas la modifye avèk sikse.");
    }

    public static void supprimerUtilisateur() {

        if (utilisateurs.isEmpty()) {
            System.out.println("Pa gen okenn itilizate.");
            return;
        }

        System.out.print(
                "Idantifyan itilizate pou efase a : "
        );

        String identifiant = scanner.nextLine();

        Utilisateur supprime = utilisateurs.remove(identifiant);

        if (supprime == null) {
            System.out.println("Itilizate sa poko egziste.");
        } else {
            System.out.println("Itilizate sa siprime ak siskse.");
        }

    }

    public static void afficherUtilisateurs() {

        if (utilisateurs.isEmpty()) {
            System.out.println(
                    "Pa gen okenn itilizatè ki anrejistre."
            );
            return;
        }

        System.out.println("\n===== LIS ITILIZATE YO =====");

        for (Utilisateur utilisateur : utilisateurs.values()) {

            System.out.println(
                    "Idantifyan : "
                    + utilisateur.getIdentifiant()
            );
        }
    }

    public static void testerAuthentification() {

        if (utilisateurs.isEmpty()) {
            System.out.println(
                    "Pa gen okenn itilizatè ki disponib."
            );
            return;
        }

        System.out.println("\n===== OTANTIFIKASYON =====");

        System.out.print("Idantifyan : ");
        String identifiant = scanner.nextLine();

        System.out.print("Modpas : ");
        String motDePasse = scanner.nextLine();

        Utilisateur utilisateur = utilisateurs.get(identifiant);

        if (utilisateur != null && utilisateur.verifierAuthentification(identifiant, motDePasse)) {
            System.out.println(
                    "Otantifikasyon an reyisi."
            );
        } else {
            System.out.println(
                    "Idantifyan oswa modpas la pa korek."
            );
        }

    }
}
