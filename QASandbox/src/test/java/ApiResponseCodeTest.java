package test.java;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

import org.junit.Assert;


public class ApiResponseCodeTest {

	@Test
	public void getAllUseCases_whenAuthorizationIsNotSet_then401IsReceived()
			throws ClientProtocolException, IOException {

		System.out.println("TEST getAllUseCases_whenAuthorizationIsNotSet_then401IsReceived STARTED");
		HttpUriRequest request = new HttpGet("https://qa-sandbox.apps.htec.rs/api/usecases/all");
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

		Assert.assertEquals("Response code is not as expected", HttpStatus.SC_UNAUTHORIZED,
				httpResponse.getStatusLine().getStatusCode());
		
		System.out.println("TEST getAllUseCases_whenAuthorizationIsNotSet_then401IsReceived FINISHED");
	}
	
	@Test
	public void getAllUseCases_whenAuthorizationIsSetWrong_then401IsReceived()
			throws ClientProtocolException, IOException {

		System.out.println("TEST getAllUseCases_whenAuthorizationIsSetWrong_then401IsReceived STARTED");
		HttpUriRequest request = new HttpGet("https://qa-sandbox.apps.htec.rs/api/usecases/all");
		request.addHeader("authorization",
				"Bearer3 eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MjQ3LCJmdWxsX25hbWUiOiJNaWxpamFuYSBKYWtvdmxqZXZpYyIsImFjdGl2YXRlZCI6dHJ1ZSwiYXZhdGFyIjoiaHR0cHM6Ly9xYS1zYW5kYm94LnMzLmFwcHMuaHRlYy5ycy9pbWFnZS1wcm9kLzE1ODQwOTgyNzQ0NDllN2JkN2Y5NGM4NmJkOTVhNjNhZDcyMTViOWQ1MmE0ODA5ZGQ0M2Q2IiwiY3JlYXRlZF9vbiI6IjIwMjAtMDMtMTNUMTE6MTM6MzUuNDY2WiIsInJvbGUiOiJVc2VyIiwic2NlbmFyaW9faWQiOjEwLCJvZmZpY2UiOjMsImJ1ZyI6IkkgQU0gQSBCVUchIFJFUE9SVCBNRSEiLCJpYXQiOjE1ODQyMTgyODQsImV4cCI6MTU4NDIyMTg4NH0.SGIFwIkedqibUbdsNe16hyPlE_br0wM6SIGnqgAPviQ");
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

		Assert.assertEquals("Response code is not as expected", HttpStatus.SC_UNAUTHORIZED,
				httpResponse.getStatusLine().getStatusCode());
		System.out.println("TEST getAllUseCases_whenAuthorizationIsSetWrong_then401IsReceived FINISHED");
	}


	
}
