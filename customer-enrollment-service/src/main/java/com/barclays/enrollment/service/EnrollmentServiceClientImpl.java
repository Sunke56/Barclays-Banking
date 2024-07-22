package com.barclays.enrollment.service;

import com.barclays.enrollment.model.EnrollmentRequest;
import com.barclays.enrollment.model.EnrollmentResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class EnrollmentServiceClientImpl implements IEnrollmentServiceClient{
    @Value("${enrollment_svc_uri}")
    private String enrollmentSvcUri;

    @Override
    public EnrollmentResponse enrollment(EnrollmentRequest enrollmentRequest) {

        EnrollmentResponse enrollmentResp  = new EnrollmentResponse();

        RestTemplate restTemplate = new RestTemplate();

        MultiValueMap<String, Object> headers = new LinkedMultiValueMap<String,Object>();
        HttpEntity<EnrollmentRequest> requestEntity = new HttpEntity(headers);
        ResponseEntity<EnrollmentResponse>  responseEntity = restTemplate.exchange(enrollmentSvcUri, HttpMethod.POST,
                requestEntity,EnrollmentResponse.class);

        if( responseEntity.getStatusCode().equals(HttpStatus.OK) ) {

            enrollmentResp = responseEntity.getBody();

        }else {
                //handle the Exception based on error response from service
        }


        return enrollmentResp;
    }
}
