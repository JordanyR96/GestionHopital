package gestionHopital;

import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

// Klas sa a kenbe enfòmasyon pou konekte yon itilizatè san li pa sere modpas li an tèks klè.
public class Utilisateur implements Authentifiable {

    private static final int ITERATIONS = 600_000;
    private static final int LONGUEUR_CLE = 256;
    private static final int LONGUEUR_SEL = 16;
    private static final SecureRandom ALEATOIRE = new SecureRandom();

    private final String identifiant;
    private byte[] sel;
    private byte[] empreinteMotDePasse;

    // Kreye yon nouvo kont epi pwoteje modpas la ak yon sèl o aza.
    public Utilisateur(String identifiant, String motDePasse) {
        if (!identifiantValide(identifiant)) {
            throw new IllegalArgumentException("Idantifyan an pa valab.");
        }
        this.identifiant = identifiant;
        setMotDePasse(motDePasse);
    }

    // Rekreye kont lan depi sèl ak anprent ki te li nan fichye a.
    private Utilisateur(String identifiant, byte[] sel, byte[] empreinteMotDePasse) {
        this.identifiant = identifiant;
        this.sel = sel.clone();
        this.empreinteMotDePasse = empreinteMotDePasse.clone();
    }

    public static boolean identifiantValide(String identifiant) {
        return identifiant != null
                && !identifiant.trim().isEmpty()
                && !identifiant.contains("|")
                && !identifiant.contains("\n")
                && !identifiant.contains("\r");
    }

    // Li sèl ak anprent modpas la san li pa bezwen konnen modpas orijinal la.
    public static Utilisateur depiFichye(String identifiant, String selEncode, String empreinteEncode) {
        if (!identifiantValide(identifiant)) {
            throw new IllegalArgumentException("Idantifyan an pa valab.");
        }

        byte[] sel = Base64.getDecoder().decode(selEncode);
        byte[] empreinte = Base64.getDecoder().decode(empreinteEncode);
        if (sel.length != LONGUEUR_SEL || empreinte.length != LONGUEUR_CLE / 8) {
            throw new IllegalArgumentException("Done modpas yo pa valab.");
        }
        return new Utilisateur(identifiant, sel, empreinte);
    }

    public String getIdentifiant() {
        return identifiant;
    }

    // Retounen sèlman done ki nesesè pou anrejistre kont lan.
    String getSelEncode() {
        return Base64.getEncoder().encodeToString(sel);
    }

    String getEmpreinteEncode() {
        return Base64.getEncoder().encodeToString(empreinteMotDePasse);
    }

    // Chanje modpas la epi kreye yon nouvo sèl.
    public void setMotDePasse(String motDePasse) {
        if (motDePasse == null || motDePasse.isEmpty()) {
            throw new IllegalArgumentException("Modpas la pa ka vid.");
        }

        byte[] nouvoSel = new byte[LONGUEUR_SEL];
        ALEATOIRE.nextBytes(nouvoSel);
        byte[] nouvoEmpreinte = kalkileEmpreinte(motDePasse, nouvoSel);

        if (sel != null) {
            Arrays.fill(sel, (byte) 0);
        }
        if (empreinteMotDePasse != null) {
            Arrays.fill(empreinteMotDePasse, (byte) 0);
        }
        sel = nouvoSel;
        empreinteMotDePasse = nouvoEmpreinte;
    }

    // Konpare idantifyan an ak anprent modpas yo san konpare modpas an tèks klè.
    @Override
    public boolean verifierAuthentification(String identifiant, String motDePasse) {
        if (motDePasse == null || !this.identifiant.equals(identifiant)) {
            return false;
        }
        byte[] anprentEseye = kalkileEmpreinte(motDePasse, sel);
        try {
            return MessageDigest.isEqual(empreinteMotDePasse, anprentEseye);
        } finally {
            Arrays.fill(anprentEseye, (byte) 0);
        }
    }

    // Itilize PBKDF2 ak HMAC-SHA-256 pou fè yon anprent difisil pou rekalkile.
    private static byte[] kalkileEmpreinte(String motDePasse, byte[] sel) {
        char[] karakte = motDePasse.toCharArray();
        PBEKeySpec espesifikasyon = new PBEKeySpec(karakte, sel, ITERATIONS, LONGUEUR_CLE);
        try {
            SecretKeyFactory faktori = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            return faktori.generateSecret(espesifikasyon).getEncoded();
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException("Pa kapab pwoteje modpas la.", e);
        } finally {
            espesifikasyon.clearPassword();
            Arrays.fill(karakte, '\0');
        }
    }
}
