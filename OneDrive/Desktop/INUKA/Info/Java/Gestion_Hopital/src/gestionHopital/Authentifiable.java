package gestionHopital;

// Entèfas ki defini règ pou otantifikasyon yon itilizatè
public interface Authentifiable {

    // Retounen idantifyan itilizatè a
    String getIdentifiant();

    // Verifye si idantifyan ak modpas yo kòrèk
    boolean verifierAuthentification(String identifiant, String motDePasse);
}