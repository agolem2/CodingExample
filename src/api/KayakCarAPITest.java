package api;

import static org.junit.Assert.*;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

import Test.KayakCarSearch;

public class KayakCarAPITest {

    // simple request - response

    @Test
    public void VerifiesMoreThanTwoDestinationsAndCountriesAreReturned() throws ClientProtocolException, IOException {
        // Given
        final String jsonMimeType = "application/json";
        final HttpUriRequest request = new HttpGet("https://pia.services.carrentals.com/api/v2/destinations?language=us&limit=1000&q=san");

        // When
        final HttpResponse response = HttpClientBuilder.create().build().execute(request);

        // Then
        final String mimeType = ContentType.getOrDefault(response.getEntity()).getMimeType();
        assertEquals(jsonMimeType, mimeType);
        assertTrue(jsonMimeType, mimeType,hasSize(0));
    }

    private void assertTrue(String jsonMimeType, String mimeType, Object hasSize) {
		// TODO Auto-generated method stub
		
	}

	private Object hasSize(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Test
    public void DisplayAllTheNamesOfAllTheCountriesInResponse() throws ClientProtocolException, IOException {
        // Given
        final HttpUriRequest request = new HttpGet("https://pia.services.carrentals.com/api/v2/destinations?language=us&limit=1000&q=san");

        // When
        final HttpResponse response = HttpClientBuilder.create().build().execute(request);

        // Then
        final KayakCarSearch resource = RetrieveUtil.retrieveResourceFromResponse(response, KayakCarSearch.class);
                
    }

}
