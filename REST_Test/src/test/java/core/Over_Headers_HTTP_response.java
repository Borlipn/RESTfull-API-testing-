package core;

import static org.junit.Assert.*;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

@SuppressWarnings("deprecation")
public class Over_Headers_HTTP_response {
	
	/* Verify the HTTP response code (HTTP_response class)
	   Verify other HTTP headers in the response (Over_Headers_HTTP_response class)
	   Verify the content the payload JSON and XML file   5/7/2016  
	   http://www.baeldung.com/2011/10/13/integration-testing-a-rest-api/ */

	// Testing other headers of the HTTP response/Testing the Media Type - second phase
	
	private Object httpClient;

	@Test
	public void givenRequestWithNoAcceptHeader_whenRequestIsExecuted_thenDefaultResponseContentTypeIsJson()
      throws ClientProtocolException, IOException{
	 
	   // Given
 
	   String jsonMimeType = "application/json";
 
	   HttpUriRequest request = new HttpGet( "https://api.github.com/users/Borlipn" );
 
	   // When
		@SuppressWarnings("resource")
		HttpClient http_client = new DefaultHttpClient();
 		HttpResponse httpResponse = http_client.execute( request );
 
	   // Then
 	   String mimeType = EntityUtils.getContentMimeType(httpResponse.getEntity() );
 
	   assertEquals( jsonMimeType, mimeType );
 
	}

	public Object getHttpClient() {
		return httpClient;
	}

	public void setHttpClient(Object httpClient) {
		this.httpClient = httpClient;
	}


}