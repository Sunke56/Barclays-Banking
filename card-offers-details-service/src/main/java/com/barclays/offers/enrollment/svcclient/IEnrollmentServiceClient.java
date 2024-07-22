package com.barclays.offers.enrollment.svcclient;

import com.barclays.offers.model.EnrollmentRequest;
import com.barclays.offers.model.EnrollmentResponse;

public interface IEnrollmentServiceClient {
    EnrollmentResponse enrollment(EnrollmentRequest enrollmentRequest);
}
