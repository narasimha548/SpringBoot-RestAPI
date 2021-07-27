package com.cgs;

import java.net.URI;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.util.UriComponentsBuilder;

import com.cgs.dto.HsmDetailsDto;
import com.cgs.entiy.HsmDetailsEntity;
import com.cgs.rest.controller.HsmDetailsRestController;
import com.cgs.service.HsmService.HsmService;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class SpringBootExampleApplicationTests {

	private static final String URL = "http://localhost:2021/hsmDetails";

	@Autowired
	private MockMvc mvc;

	@Autowired
	private TestRestTemplate restTemplate;

	@MockBean
	private HsmService hsmService;

	@MockBean
	private HsmDetailsRestController restController;

	String jsonRequest = "\"{\\\"hsmId\\\":1,\\\"hsmName\\\":\\\"Test HSM\\\",\\\"hsmProtocol\\\":\\\"TCP\\/IP\\\",\\\"hsmType\\\":\\\"SafeNet\\\",\\\"hsmAddress\\\":\\\"172.16.10.21\\\",\\\"hsmPort\\\":\\\"4000\\\",\\\"headerLen\\\":\\\"4\\\",\\\"headerType\\\":\\\"ASCII\\\",\\\"hsmHeaderLen\\\":\\\"4\\\",\\\"hsmTImeOut\\\":\\\"30\\\",\\\"connectionIntervel\\\":\\\"30\\\",\\\"hsmStatus\\\":\\\"1\\\",\\\"addedBy\\\":\\\"superadmin1\\\",\\\"addedDate\\\":1627370143548,\\\"remarks\\\":\\\"hsm test\\\",\\\"authCode\\\":null,\\\"authDate\\\":null,\\\"authBy\\\":null}\"";

	private URI uri;

	HsmDetailsEntity entityMock = new HsmDetailsEntity(1, "Test HSM", "TCP/IP", "SafeNet", "172.16.10.21", "4000", "4",
			"ASCII", "4", "30", "30", "1", "superadmin1", new Date(), "hsm test", null, null, null);

	HsmDetailsDto dto = new HsmDetailsDto(1, "Test HSM", "TCP/IP", "SafeNet", "172.16.10.21", "4000", "4", "ASCII", "4",
			"30", "30", "1", "superadmin1", new Date(), "hsm test", null, null, null);

	@Test
	public void test() throws Exception {

		JSONObject jsonReq = new JSONObject();
		// jsonReq.put("hsmId", "1");
		jsonReq.put("hsmName", "Test HSM");
		jsonReq.put("hsmProtocol", "TCP/IP");
		jsonReq.put("hsmType", "safe net");
		jsonReq.put("hsmAddress", "172.16.10.21");
		jsonReq.put("hsmPort", "4000");
		jsonReq.put("headerLen", "4");
		jsonReq.put("headerType", "ASCII");
		jsonReq.put("hsmHeaderLen", "2");
		jsonReq.put("hsmTImeOut", "30");
		jsonReq.put("connectionIntervel", "300");
		jsonReq.put("hsmStatus", "1");
		jsonReq.put("addedBy", "superadmin");
		jsonReq.put("addedDate", new Date());
		jsonReq.put("remarks", "Test HSM");
		jsonReq.put("authCode", null);
		jsonReq.put("authDate", null);
		jsonReq.put("authBy", null);

		String URI = "/saveHsmDetails";
		Mockito.when(hsmService.saveHsmDetails(Mockito.any(HsmDetailsEntity.class))).thenReturn(2);

		HttpEntity<String> req = new HttpEntity<String>(jsonReq.toString());

		ResponseEntity<String> status = restTemplate.postForEntity(URL + URI, entityMock, String.class);

		// String status=restTemplate.postForObject(URL+URI, jsonReq.toString(),
		// String.class);

		System.out.println(" response ########  " + status.getStatusCodeValue());

		Assert.assertEquals(201, status.getStatusCodeValue());

	}

	@Test
	public void findByHsmDetails() throws Exception {

		String urlfind = "/updateHsmDetails/{hsmId}";

		Map<String, Integer> params = new HashMap<>();
		params.put("hsmId", 1);

		// HttpHeaders headers = new HttpHeaders();
		// HttpEntity requestEntity = new HttpEntity<>(headers);

		// uri = UriComponentsBuilder.fromUriString(URL +
		// urlfind).buildAndExpand(params).toUri();
		Mockito.when(hsmService.findById(Mockito.anyInt())).thenReturn(dto);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.put(URL + urlfind, 1);
		// get(URL + urlfind, 1);
		MvcResult result = mvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		System.out.println(response.getStatus());

		Assert.assertEquals(HttpStatus.OK.value(), response.getStatus());

	}

}
