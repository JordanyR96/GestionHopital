package gestionHopital;

public class Dossier {

    // Atribi prive yo pou pwoteje done yo
    private int numeroDossier;
    private String maladie;
    private String description;

    // Asosyasyon ant yon dosye ak moun ki konsène yo
    private Patient patient;
    private Medecin medecin;
    private Infirmier infirmier;

    // Konstriktè klas Dossier lan
    public Dossier(int numeroDossier, String maladie, String description, Patient patient) {
        this.numeroDossier = numeroDossier;
        this.maladie = maladie;
        this.description = description;
        this.patient = patient;
    }

    // Retounen nimewo dosye a
    public int getNumeroDossier() {
        return numeroDossier;
    }

    // Retounen maladi a
    public String getMaladie() {
        return maladie;
    }

    // Modifye maladi a
    public void setMaladie(String maladie) {
        this.maladie = maladie;
    }

    // Retounen deskripsyon an
    public String getDescription() {
        return description;
    }

    // Modifye deskripsyon an
    public void setDescription(String description) {
        this.description = description;
    }

    // Retounen pasyan ki asosye ak dosye a
    public Patient getPatient() {
        return patient;
    }

    // Retounen doktè ki asosye ak dosye a
    public Medecin getMedecin() {
        return medecin;
    }

    // Fè lyen ant dosye a ak yon doktè
    public void setMedecin(Medecin medecin) {
        this.medecin = medecin;
    }

    // Retounen enfimyè ki asosye ak dosye a
    public Infirmier getInfirmier() {
        return infirmier;
    }

    // Fè lyen ant dosye a ak yon enfimyè
    public void setInfirmier(Infirmier infirmier) {
        this.infirmier = infirmier;
    }

    // Montre tout enfòmasyon ki nan dosye a
    public void afficherDossier() {

        System.out.println("===== DOSYE MEDIKAL =====");
        System.out.println("Nimewo : " + numeroDossier);
        System.out.println("Deskripsyon : " + description);
        System.out.println("Pasyan :");
        patient.afficherInformations(maladie);

        // Verifye si gen yon doktè ki asosye ak dosye a
        if (medecin != null) {
            System.out.println(
                "Dokte: " + medecin.getNom() + " " + medecin.getPrenom()
            );
        }

        // Verifye si gen yon enfimyè ki asosye ak dosye a
        if (infirmier != null) {
            System.out.println(
                "Enfimye : " + infirmier.getNom() + " " + infirmier.getPrenom()
            );
        }
    }
}