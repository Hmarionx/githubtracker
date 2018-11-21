package fr.wildcodeschool.githubtracker.jwt;

import javax.crypto.spec.SecretKeySpec;
import javax.enterprise.context.Dependent;
import java.security.Key;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
@Dependent
public class SimpleKeyGenerator implements KeyGenerator {

    // ======================================
    // =          Business methods          =
    // ======================================

    @Override
    public Key generateKey() {
        String keyString = "simplekey";
        return new SecretKeySpec(keyString.getBytes(), 0, keyString.getBytes().length, "DES");
    }
}