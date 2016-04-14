package de.seven.fate.jaas.converter;

import org.apache.commons.codec.digest.DigestUtils;

import javax.persistence.AttributeConverter;
import java.util.Base64;

/**
 * Created by Mario on 13.04.2016.
 */
public class PasswordConverter implements AttributeConverter<String, String> {

    @Override
    public String convertToDatabaseColumn(String attribute) {

        String base64 = Base64.getEncoder().encodeToString(attribute.getBytes());

        byte[] hash = DigestUtils.sha256(base64);

        String pwd = Base64.getEncoder().encodeToString(hash);

        return pwd;
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        return dbData;
    }
}
