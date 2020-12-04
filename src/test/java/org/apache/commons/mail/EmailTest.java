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

public class EmailTest {
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

	@Test
	public void testAddHeaderWorking(){
		testEmail.addHeader("Random", "5465");
	}


	@Test (expected = IllegalArgumentException.class)
	public void testAddHeaderNullName(){
		testEmail.addHeader("", "27");
	}

	@Test (expected = IllegalArgumentException.class)
	public void testAddHeaderNullValue(){
		testEmail.addHeader("Random", "");
	}


	@Test
	public void testAddReplyTo() throws EmailException{
		testEmail.addReplyTo("abc@gmail.com", "Robert");
	}


	@Test (expected = EmailException.class)
	public void testAddReplyToFail() throws EmailException{
		testEmail.addReplyTo("abcmail.com", "Robert");
	}


	@Test
	public void testBuildMimeMessage() throws EmailException {
		testEmail = EasyMock.createNiceMock(Email.class);
		//expect(testEmail.setMsg("Hello there")).andReturn(testEmail);
		testEmail.buildMimeMessage();
		replay(testEmail);
	}


	@Test
	public void testGetHostName() throws EmailException {

		testEmail.setHostName("Banana");
		assertEquals("Banana", testEmail.getHostName());

	}

	@Test
	public void testGetHostNameNull() throws EmailException {
		testEmail.setHostName(null);
		assertEquals(null, testEmail.getHostName());
	}//setBounceAddress



	@Test
	public void testGetMailSession() throws EmailException {
		testEmail.setHostName("Banana");
		assertFalse(testEmail.getMailSession() == null);
	}


	@Test
	public void testGetMailSessionAuthenticatorNull() throws EmailException {
		testEmail.setHostName("TrueRight");
		testEmail.setAuthenticator(
				new DefaultAuthenticator("userName", "password"));
		assertFalse(testEmail.getMailSession()==null);
	}

	@Test
	public void testGetMailSessionSocketTimeOutGreaterThanZero()
			throws EmailException {
		testEmail.setHostName("TrueRight");
		testEmail.setSocketTimeout(20);
		assertFalse(testEmail.getMailSession()==null);
	}

	@Test
	public void testGetMailSessionNullBounceAddress() throws EmailException {
		testEmail.setHostName("TrueRight");
		testEmail.setBounceAddress("ae@rafg.com");
		testEmail.getMailSession();
	}

	@Test
	public void testGetSentDate(){
		testEmail.setSentDate(new Date(1200));
		assertEquals(new Date(1200),testEmail.getSentDate());
	}

	@Test
	public void testGetSentDateNull(){
		testEmail.setSentDate(null);
		assertFalse(new Date(1200)==testEmail.getSentDate());
	}

	@Test
	public void testGetSocketConnectionTimeout(){
		assertTrue(testEmail.getSocketConnectionTimeout()== EmailConstants.SOCKET_TIMEOUT_MS);
	}

	@Test
	public void testSend() throws EmailException {
		testEmail = EasyMock.createMock(SimpleEmail.class);

		//record
		expect(testEmail.addBcc("asdasda@adsd")).andReturn(testEmail);
		testEmail.setHostName("TrueRight");
		EasyMock.expectLastCall().asStub();
		testEmail.setFrom("qw@ra");
		EasyMock.expectLastCall().andReturn(testEmail);
		testEmail.addReplyTo("awd@da");
		EasyMock.expectLastCall().andReturn(testEmail);
		expect(testEmail.send()).andReturn("");

		//replay
		replay(testEmail);

		assertEquals("", testEmail.send());
		//System.out.println(testEmail.send());
	}

	@Test
	public void testSetFrom() throws EmailException {
		this.testEmail.setFrom("abc@assa.com");
		assertEquals( "abc@assa.com", this.testEmail.getFromAddress().toString());
	}

	@Test (expected = EmailException.class)
	public void testSetFromFail() throws EmailException {
		testEmail.setFrom("");
	}

	@Test
	public void testUpdateContentType(){
		testEmail.updateContentType("banana");

	}


}
