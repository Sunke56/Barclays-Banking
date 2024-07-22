package com.barclays.enrollment.controller;

import com.barclays.enrollment.model.EnrollmentRequest;
import com.barclays.enrollment.model.EnrollmentResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class EnrollmentDetailsController {


@PostMapping("/enrollment")
EnrollmentResponse enrollment (@RequestBody EnrollmentRequest enrollmentRequest,
                             @RequestHeader(name = "clientId", required = false) String clientId,
                             @RequestHeader(name = "channelId", required = false) String channelId,
                             @RequestHeader(name = "msgTs", required = false) String msgTs,
                             @RequestHeader(name = "correlationId", required = false) String correlationId,
                             @RequestHeader(name = "authToken", required = false) String authToken )  {
    System.out.println("Enter into Enrollment Service");

    EnrollmentResponse enrollmentResponse = new EnrollmentResponse();
    enrollmentResponse.setRespCode("0");
    enrollmentResponse.setRespMsg("success");
    enrollmentResponse.setStatus("active");


    System.out.println("Exit into Enrollment Service");

        return enrollmentResponse;

    }
}
