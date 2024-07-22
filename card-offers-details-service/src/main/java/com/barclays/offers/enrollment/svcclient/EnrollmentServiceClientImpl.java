package com.barclays.offers.enrollment.svcclient;

import com.barclays.offers.model.EnrollmentRequest;
import com.barclays.offers.model.EnrollmentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.UUID;


@Component
public class EnrollmentServiceClientImpl implements IEnrollmentServiceClient{

    @Value("${enrollment_svc_uri}")
    private String enrollmentSvcUri;

    @Autowired
    RestTemplate restTemplate;
    @Override
    public EnrollmentResponse enrollment(EnrollmentRequest enrollmentRequest) {
        EnrollmentResponse enrollmentResp = new EnrollmentResponse();


        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();

        headers.add("authToken","@#$%^&$#*@");
        headers.add("channelId","app");
        headers.add("clientId","coms");
        headers.add("correlationId", UUID.randomUUID().toString().substring(0,16));
        headers.add("msgTs",new Date().toString());

        HttpEntity<EnrollmentRequest> requestEntity = new HttpEntity<>(enrollmentRequest,headers);

        restTemplate = new RestTemplate();

      ResponseEntity<EnrollmentResponse> responseEntity = restTemplate.exchange(enrollmentSvcUri, HttpMethod.POST,requestEntity, EnrollmentResponse.class);

         if( responseEntity !=null && responseEntity.getStatusCode() != null) {

             if( responseEntity.getStatusCode().is2xxSuccessful() ) {

                 enrollmentResp = responseEntity.getBody();

             }


         }
        System.out.println("enrollmentResp from EnrollmentServiceClient is :"+ enrollmentResp);

      return enrollmentResp;

    }


}
