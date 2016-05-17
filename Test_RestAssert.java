package core;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import org.apache.http.client.HttpClient;

import org.junit.Test;
import static org.junit.Assert.assertEquals;


// https://www.javacodegeeks.com/2011/10/java-restful-api-integration-testing.html


public class Test_RestAssert {	
	//
	//Java RESTful API integration testing
	//About Eugen Paraschiv
	//Java RESTful API integration testing
	
	
	//Testing the HTTP response code
	@Test

	public void givenUserDoesNotExists_whenUserInfoIsRetrieved_then404IsReceived()

			throws ClientProtocolException, IOException{

		// Given	
		String name = "AbDeRkIt";

		HttpUriRequest request = new HttpGet( "https://api.github.com/users/" + name );

		HttpClient http_client = new DefaultHttpClient();

		// When

		HttpResponse httpResponse = http_client.execute( request );
		
		System.out.println("Request:\n" + request + "\n" );
		
		System.out.println("httpResponse:\n" + httpResponse + "\n" );

		// Then

		RestAssert.assertResponseCodeIs( httpResponse, 404 );

	}
	
	
	
	@Test	
	
		public void givenRequestWithNoAcceptHeader_whenRequestIsExecuted_thenDefaultResponseContentTypeIsJson()
	
		      throws ClientProtocolException, IOException{
	
		   // Given
	
		   String jsonMimeTypeAndCharSet = "application/json; charset=utf-8";
		   HttpEntity entity = null;
		   HttpResponse response = null;
	
		   HttpUriRequest request = new HttpGet( "https://api.github.com/users/eugenp" );
		   HttpClient http_client = new DefaultHttpClient();
	  
		   // When
	
		   response = http_client.execute( request );
		   entity = response.getEntity();
		
		   // Then
	
		   // String mimeType = org.apache.http.util.EntityUtils.( response.getEntity().getContentType() );
		   
		   String contentType = entity.getContentType().getValue().trim();
		   
		   System.out.println("contentType is:\n" + contentType);
	
		   assertEquals( jsonMimeTypeAndCharSet, contentType );
	
		}
		
	/**
	public static void assertResponseCodeIs

	( final HttpResponse response, final int expectedCode ){

		final int statusCode = response.getStatusLine().getStatusCode();

		assertEquals( expectedCode, statusCode );

	}
	
	
	 */
}
