package com.dummy.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at \"myresource\" path)
 */
@Path("dummyResponse")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as \"text/plain\" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getCreateDummyData() {
        return "{\"type\": \"SUBSCRIPTION_ORDER\",\"marketplace\": { \"baseUrl\": \"https://www.acme.com\",      \"partner\": \"APPDIRECT\"    },    \"creator\": {      \"address\": {        \"firstName\": \"Test\",        \"fullName\": \"Test User\",        \"lastName\": \"User\"      },      \"email\": \"testuser@testco.com\",      \"firstName\": \"Test\",      \"language\": \"en\",      \"lastName\": \" User\",      \"locale\": \"en-US\",      \"openId\": \"https://www.acme.com/openid/id/47cb8f55-1af6-5bfc-9a7d-8061d3aa0c97\",      \"uuid\": \"47cb8f55-1af6-5bfc-9a7d-8061d3aa0c97\"    },    \"payload\": {      \"company\": {        \"country\": \"US\",        \"name\": \"tester\",        \"phoneNumber\": \"1-800-333-3333\",        \"uuid\": \"385beb51-51ae-4ffe-8c05-3f35a9f99825\",        \"website\": \"www.testco.com\"      },      \"order\": {        \"editionCode\": \"Standard\",        \"pricingDuration\": \"MONTHLY\",        \"items\": [{          \"quantity\": \"4\",          \"unit\": \"USER\"        }]      }    }}"; 
        }

@GET
@Path("/cancel")
@Produces(MediaType.TEXT_PLAIN)
public String getCancelDummyData() {
    return  "{    \"type\": \"SUBSCRIPTION_CANCEL\",    \"marketplace\": {      \"baseUrl\": \"https://www.acme.com\",      \"partner\": \"APPDIRECT\"    },    \"creator\": {      \"address\": {        \"city\": \"Sommerville\",        \"country\": \"US\",        \"firstName\": \"Test\",        \"fullName\": \"Test User\",        \"lastName\": \"User\",        \"phone\": \"5305556465\",        \"state\": \"MA\",        \"street1\": \"55 Grove St\",        \"zip\": \"02144\"      },      \"email\": \"testuser@testco.com\",      \"firstName\": \"Test\",      \"language\": \"en\",      \"lastName\": \"User\",      \"locale\": \"en-US\",      \"openId\": \"https://www.acme.com/openid/id/d124bf8b-0b0b-40d3-831b-b7f5a514d487\",      \"uuid\": \"d124bf8b-0b0b-40d3-831b-b7f5a514d487\"    },    \"payload\": {      \"account\": {        \"accountIdentifier\": \"9d6fca98-aa94-462b-85fa-118804ad3fe3\",        \"status\": \"ACTIVE\"      }    }}" ;
    }}