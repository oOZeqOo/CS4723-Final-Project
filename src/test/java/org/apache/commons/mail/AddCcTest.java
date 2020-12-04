package org.apache.commons.mail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.mail.internet.InternetAddress;

import static org.junit.Assert.assertEquals;

public class AddCcTest {


    Email testEmail;

    @Before
    public void setUp() throws Exception {
        testEmail = new SimpleEmail();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testAddCc() throws EmailException {
        this.testEmail.addCc("a@b.com");
        assertEquals("a@b.com",
                ((InternetAddress)this.testEmail.getCcAddresses().get(0)).toString());
    }

    @Test (expected = EmailException.class)
    public void testAddCcNothing() throws EmailException {
        String expectedOutput = "Address List provided was invalid";
        assertEquals(expectedOutput, this.testEmail.addCc());
    }
}
