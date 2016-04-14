package de.seven.fate.jaas;

import de.seven.fate.jaas.converter.PasswordConverter;
import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by Mario on 13.04.2016.
 */
public class PasswordConverterTest {

    PasswordConverter sut = new PasswordConverter();

    @Test
    public void convertToDatabaseColumn() throws Exception {
        String hash = sut.convertToDatabaseColumn("password");

        Assert.assertEquals("mepWztR8IUMdDFbvkE8oKuQlatthLE6JC22qG2HQwyw=", hash);
    }

    @Test
    public void convertToEntityAttribute() throws Exception {
        String hash = sut.convertToEntityAttribute("foo");

        Assert.assertEquals("foo", hash);
    }

}