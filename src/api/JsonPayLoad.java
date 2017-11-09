package api;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

public class JsonPayLoad {

	@Test
	public void
	  InformationIsRetrieved_thenRetrievedResourceIsCorrect()
	  throws ClientProtocolException, IOException{
	    // Given
	    HttpUriRequest request = new HttpGet( "https://pia.services.carrentals.com/api/v2/destinations?language=us&limit=1000&q=san" );
	 
	    // When
	    org.apache.http.HttpResponse response = HttpClientBuilder.create().build().execute( request );
	 
	    // Then
	    @SuppressWarnings("unused")
		KayakCarSearch resource = RetrieveUtil.retrieveResourceFromResponse(
	      response, KayakCarSearch.class);
	    
	}

}
