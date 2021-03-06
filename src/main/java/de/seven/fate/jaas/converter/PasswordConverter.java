package de.seven.fate.jaas.converter;


import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

import javax.persistence.AttributeConverter;

/**
 * Created by Mario on 13.04.2016.
 */
public class PasswordConverter implements AttributeConverter<String, String> {

    @Override
    public String convertToDatabaseColumn(String password) {

        byte[] hash = DigestUtils.sha256(password.getBytes());

        String base64String = Base64.encodeBase64String(hash);

        return base64String;
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        return dbData;
    }
}
