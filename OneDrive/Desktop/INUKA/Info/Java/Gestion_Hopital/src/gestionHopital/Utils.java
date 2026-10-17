package gestionHopital;

import static gestionHopital.GestionHopital.scanner;
import java.util.InputMismatchException;

/**
 *
 * @author Regis Jordany
 */
public class Utils extends Exception {

    public Utils(String message) {
        super(message);
    }

    public static int lireChoix() {
        int choix = -1;
        System.out.println("Chwazi yon opsyon : ");
        try {
            choix = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException exception) {
//            System.out.println("\nERE : ou sipose antre youn nan opsyon sa yo kise " + message + " oswa 0.\n");
            scanner.next();
        }
        return choix;
    }

    public static int modifierId() {
        int id = -1;
        System.out.print("Chwazi id wap modifye a : ");
        try {
            id = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException exception) {
            scanner.next();
        }
        return id;
    }

    public static int supprimerId() {
        int id = -1;
        System.out.print("Chwazi id wap modifye a : ");
        try {
            id = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException exception) {
            scanner.next();
        }
        return id;
    }

    public static int ajouterDossier() {
        int numero = -1;
        System.out.print("Nimewo dosye a : ");
        try {
            numero = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException exception) {
            scanner.next();
        }
        return numero;
    }

    public static int numeroChoixPatient() {
        int choixPatient = -1;
        System.out.print("Chwazi nimewo pasyan an : ");
        try {
            choixPatient = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException exception) {
            scanner.next();
        }
        return choixPatient;
    }

    // Fè lyen ant dosye a ak yon doktè
    public static int lienDossierMedecin() {
        int choixMedecin = 0;
        try {
            choixMedecin = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException exception) {
            scanner.next();
        }

        return choixMedecin;
    }

    // Fè lyen ant dosye a ak yon enfimye
    public static int lienDossierInfirmier() {
        int choixInfirmier = 0;
        try {
            choixInfirmier = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException exception) {
            scanner.next();
        }

        return choixInfirmier;
    }

    public static int modifierDossier() {
        int numero = -1;
        System.out.print("Nimewo dosye pou modifye a : ");
        try {
            numero = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException exception) {
            scanner.next();
        }
        return numero;
    }

    public static int supprimerDossier() {
        int numero = -1;
        System.out.print("Nimewo dosye pou efase a : ");
        try {
            numero = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException exception) {
            scanner.next();
        }
        return numero;
    }
}
