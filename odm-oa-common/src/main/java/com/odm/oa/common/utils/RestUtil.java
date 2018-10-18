package com.odm.oa.common.utils;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
//import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.ResourceHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class RestUtil {
	public static RestTemplate restTemplate = new RestTemplate();

	static {
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		HttpComponentsClientHttpRequestFactory httpComponentsClientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(
				httpClient);
		restTemplate.setRequestFactory(httpComponentsClientHttpRequestFactory);
	}

	public RestUtil() {
	}

	// public static ResponseEntity<String> directRequest(String url, Object body,
	// String methodStr) {
	// ResponseEntity<String> response = null;
	// try {
	// HttpMethod httpMethod = HttpMethod.resolve(methodStr.toUpperCase());
	// HttpHeaders headers = new HttpHeaders();
	// headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
	// org.springframework.http.HttpEntity<Object> request = new
	// org.springframework.http.HttpEntity<>(body, headers);
	// restTemplate.getMessageConverters().add(0, new
	// ResourceHttpMessageConverter());
	// return restTemplate.exchange(url, httpMethod, request, String.class);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// System.out.println("response:" + response);
	// return response;
	// }
	public static <T> ResponseEntity<T> requestInUri(String url, String bodyJson, HttpMethod httpMethod,
			Class<T> responseClass, Object... variables) {
		HttpHeaders headers = new HttpHeaders();
		variables = variables == null ? new Object[0] : variables;
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
		org.springframework.http.HttpEntity<String> request = new org.springframework.http.HttpEntity<>(bodyJson,
				headers);
		restTemplate.getMessageConverters().add(0, new ResourceHttpMessageConverter());
		return restTemplate.exchange(url, httpMethod, request, responseClass, variables);
	}
}
