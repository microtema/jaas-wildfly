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
        String hash = sut.convertToDatabaseColumn("admin");

        Assert.assertEquals("jGl25bVBBBW96Qi9Te4V37Fnqchz/Eu4qB9vKrRIqRg=", hash);
    }

    @Test
    public void convertToDatabaseColumn2() throws Exception {
        String hash = sut.convertToDatabaseColumn("password");

        Assert.assertEquals("XohImNooBHFR0OVvjcYpJ3NgPQ1qq73WKhHvch0VQtg=", hash);
    }

    @Test
    public void convertToEntityAttribute() throws Exception {
        String hash = sut.convertToEntityAttribute("foo");

        Assert.assertEquals("foo", hash);
    }

}