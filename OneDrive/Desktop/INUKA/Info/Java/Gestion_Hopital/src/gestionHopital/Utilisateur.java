package gestionHopital;

// Klas sa a reprezante yon itilizatè ki ka konekte nan sistèm nan
public class Utilisateur implements Authentifiable {

    // Idantifyan an pa ka chanje apre kreyasyon itilizatè a
    private final String identifiant;

    // Modpas la ka modifye
    private String motDePasse;

    // Konstriktè klas Utilisateur lan
    public Utilisateur(String identifiant, String motDePasse) {
        this.identifiant = identifiant;
        this.motDePasse = motDePasse;
    }

    // Retounen idantifyan itilizatè a
    public String getIdentifiant() {
        return identifiant;
    }

    // Retounen modpas itilizatè a
    public String getMotDePasse() {
        return motDePasse;
    }

    // Pèmèt modifye modpas la
    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    // Redefinisyon metòd ki soti nan interface Authentifiable
    @Override
    public boolean verifierAuthentification(String identifiant, String motDePasse) {

        // Verifye si idantifyan ak modpas yo koresponn
        return this.identifiant.equals(identifiant)
                && this.motDePasse.equals(motDePasse);
    }
}
