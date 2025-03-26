package quantum;

import java.nio.charset.StandardCharsets;
import java.security.*;

/**
 * <p>This is code is to used the algorithms that is introduce in JDK24 called <span>
 *      Module-Lattice-Based Key-Encapsulation Mechanism (ML-KEM, JEP 496)
 * </span></p>
 * <p>These features implement cryptographic algorithms standardized by
 * NIST (National Institute of Standards and Technology)
 * to protect against future quantum computing attacks,
 * which could break traditional algorithms like RSA and ECC (Elliptic Curve Cryptography)
 * by efficiently solving problems such as integer factorization and discrete logarithms.</p>
 * @author Kim Chansokpheng
 * @version 1.0
 * @since JDK24
 */
public class ML_DSA {
    public static void getAlgorithms() throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        // Step 1: Generate a key pair for ML-DSA
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("ML-DSA");
        // ML-DSA supports different parameter sets (e.g., ML-DSA-44, ML-DSA-65, ML-DSA-87)
        // Use ML-DSA-65 for a balanced security level
        kpg.initialize(65); // Correct parameter set for ML-DSA-65
        KeyPair keyPair = kpg.generateKeyPair();

        // Step 2: Sign a message using the private key
        Signature signer = Signature.getInstance("ML-DSA");
        signer.initSign(keyPair.getPrivate());

        String message = "This is a message to sign.";
        byte[] messageBytes = message.getBytes(StandardCharsets.UTF_8);
        signer.update(messageBytes);

        byte[] signature = signer.sign();
        System.out.println("Signature length: " + signature.length);

        // Step 3: Verify the signature using the public key
        Signature verifier = Signature.getInstance("ML-DSA");
        verifier.initVerify(keyPair.getPublic());
        verifier.update(messageBytes);

        boolean isValid = verifier.verify(signature);
        System.out.println("Signature valid: " + isValid);

        // Step 4: Test with a tampered message
        String tamperedMessage = "This is a tampered message.";
        byte[] tamperedMessageBytes = tamperedMessage.getBytes(StandardCharsets.UTF_8);
        verifier.update(tamperedMessageBytes);

        boolean isTamperedValid = verifier.verify(signature);
        System.out.println("Tampered signature valid: " + isTamperedValid);
    }
}
