package com.cosmos.integration;

import java.io.File;

import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.PollableChannel;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.cosmos.controllers.AccountController;
import com.cosmos.models.Account;
import com.cosmos.models.AccountDetail;
import com.cosmos.models.AccountList;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@ImportResource(locations={
	      "classpath:http-outbound-gateway.xml"
	     })
@Repository
public class AccountHIFImpl implements AccountHIF {
	final Logger log = LogManager.getLogger(AccountController.class);
	@Autowired
    @Qualifier("get_send_channel")
    MessageChannel getSendChannel;
 
    @Autowired
    @Qualifier("get_receive_channel")
    PollableChannel getReceiveChannel;
    @Autowired RestTemplate restTemplate;
    
    
    @Bean RestTemplate restTemplate() {
        return new RestTemplate();
      }

    
    
	public List<Account> findAll() {
		// TODO Auto-generated method stub
		log.info("Inside findAll()");
		Message message = MessageBuilder.withPayload("").build();
		ArrayList accountList=new ArrayList();
		AccountList readValue=new AccountList();;
        getSendChannel.send(message);
        
        String responseJsonStr=getReceiveChannel.receive().getPayload().toString();
        log.debug("response = "+responseJsonStr);
        //System.out.println("response = "+responseJsonStr);
        
        JSONParser parser = new JSONParser(responseJsonStr);
        JSONObject json = null;
		Map<String, Object> jsonHash = new HashMap<String, Object>();

        //HashMap jsonHash=new HashMap();
		try {
			jsonHash = (HashMap) parser.parse();
			log.debug("Hashmap length = "+jsonHash.size());
			//System.out.println("Hashmap length = "+jsonHash.size() );
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			log.error("Exception at parsing the parser ",e1);
			//e1.printStackTrace();
		}
		/*
		for (Map.Entry<String, Object> set : jsonHash.entrySet()) {
		    System.out.println(set.getKey() + " = " + set.getValue());
		}*/
		
		Map<String, Object> jsonHashData = new HashMap<String, Object>();

			jsonHashData =  (HashMap) jsonHash.get("Data");
			log.debug(" string = "+jsonHashData.get("Account").toString());
	       //System.out.println(" string = "+jsonHashData.get("Account").toString());
	       //System.out.println(" class = "+jsonHashData.get("Account").getClass());
	       log.debug(" class = "+jsonHashData.get("Account").getClass());

	       ArrayList accountArray=(ArrayList) jsonHashData.get("Account");
	       log.debug("Array List size = "+accountArray.size());
	       //System.out.println("Array List size = "+accountArray.size());
	       
	        JSONArray arrayAccount = new JSONArray(accountArray);
	        Account account=new Account();
	        ObjectMapper mapper;
	        for(int i=0; i < arrayAccount.length(); i++) {
	        	mapper = new ObjectMapper();
	        	mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	           JSONObject object = arrayAccount.getJSONObject(i);
	           //System.out.println("account class = "+arrayAccount.getJSONObject(i).getClass());
	           log.debug("account class = "+arrayAccount.getJSONObject(i).getClass());
	           
           try {
				account = mapper.readValue(object.toString(), Account.class);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				log.error("Exception in JSON mapper.readValue",e);
				e.printStackTrace();
			}
	           accountList.add(account);
	      }
		return accountList;
	}

	@Override
	public AccountDetail getAccountDetails(String id) {

		final String uri = "http://localhost:8081/testdataservice/api/v1/accounts/"+id;
		//final String uri = "http://actestdata:8081/testdataservice/api/v1/accounts/"+id;
		
		HttpHeaders headers = new HttpHeaders();
		
		headers.set("user_name", "ABC");

		HttpEntity entity = new HttpEntity(headers);

		//ResponseEntity<ResponseObject> response = restTemplate.exchange(
		  //  url, HttpMethod.GET, entity,ResponseObject.class);
		
	    //RestTemplate restTemplate = new RestTemplate();
	    ResponseEntity<String> responseJsonStr1= restTemplate.exchange(uri,HttpMethod.GET,entity, String.class);
	    
	    String responseJsonStr = responseJsonStr1.getBody(); 
	    //String responseJsonStr= restTemplate.getForObject(uri, String.class);
	    //String responseJsonStr= restTemplate.getForObject(uri,HttpMethod.GET,entity, String.class);
	    log.debug("***responseJsonStr****="+responseJsonStr);
	    System.out.println("***responseJsonStr****="+responseJsonStr);
		
   
        JSONParser parser = new JSONParser(responseJsonStr);
        JSONObject json = null;
		Map<String, Object> jsonHash = new HashMap<String, Object>();

        //HashMap jsonHash=new HashMap();
		try {
			jsonHash = (HashMap) parser.parse();
			log.debug("Hashmap length = "+jsonHash.size());
			//System.out.println("Hashmap length = "+jsonHash.size() );
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			log.error("Parsing error "+e1);
			//e1.printStackTrace();
		}
		/*
		for (Map.Entry<String, Object> set : jsonHash.entrySet()) {
		    System.out.println(set.getKey() + "  << = >> " + set.getValue());
		}
		*/
		Map<String, Object> jsonHashData = new HashMap<String, Object>();

			jsonHashData =  (HashMap) jsonHash.get("Data");
			log.debug(" string = "+jsonHashData.get("Account").toString());
			log.debug(" class = "+jsonHashData.get("Account").getClass());

	       ArrayList accountArray=(ArrayList) jsonHashData.get("Account");
	       log.debug("Array List size = "+accountArray.size());
	       //System.out.println("Array List size = "+accountArray.size());
	       
	       
	        JSONArray arrayAccount = new JSONArray(accountArray);
	        log.debug("arrayAccount  length = "+arrayAccount.length());
	        //System.out.println("arrayAccount  length = "+arrayAccount.length());
	        AccountDetail accountDetail=new AccountDetail();
	        ObjectMapper mapper;
	        for(int i=0; i < arrayAccount.length(); i++) {
	        	//System.out.println("########## i = "+i);
	        	mapper = new ObjectMapper();
	        	mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	           JSONObject object = arrayAccount.getJSONObject(i);
	           //System.out.println("account class = "+arrayAccount.getJSONObject(i).getClass()+" object.toString()= "+object.toString());
	           
	           
           try {
        	   accountDetail = mapper.readValue(object.toString(), AccountDetail.class);
				} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
					log.error("error at readValue",e);
					//e.printStackTrace();
				}
	           
	        }
	        //System.out.println("AccountDetails accountId = "+accountDetail.getAccountId());
	        log.debug("AccountDetails accountId = "+accountDetail.getAccountId());
	        
		return accountDetail;

	}

}
