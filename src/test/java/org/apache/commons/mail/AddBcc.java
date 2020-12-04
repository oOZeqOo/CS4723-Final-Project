package org.apache.commons.mail;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.mail.internet.InternetAddress;
import java.util.Date;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.*;

public class AddBcc {
	Email testEmail;
	
	@Before
	public void setUp() throws Exception {
		testEmail = new SimpleEmail();
	}

	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void testAddBccList() throws EmailException {
		String [] emails = {"a@b.com", "wa@b.com", "a2@b.com", "w3qeq@b.com"};
		this.testEmail.addBcc(emails);
		assertEquals("[a@b.com, wa@b.com, a2@b.com, w3qeq@b.com]",
				(this.testEmail.getBccAddresses().toString() ));
	}

	@Test (expected = EmailException.class)
	public void testAddBccListEmpty() throws EmailException {
		String [] emails = {};
		expect(this.testEmail.addBcc(emails)) ;
	}

	@Test (expected = EmailException.class)
	public void testAddBccListNull() throws EmailException {
		String [] emails = null;
		String expectedOutput = "Address List provided was invalid";
		assertEquals(expectedOutput, this.testEmail.addBcc(emails));
	}




}
