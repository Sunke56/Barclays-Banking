package com.barclays.enrollment.service;

import com.barclays.enrollment.model.EnrollmentRequest;
import com.barclays.enrollment.model.EnrollmentResponse;

public interface IEnrollmentServiceClient {
    EnrollmentResponse enrollment(EnrollmentRequest enrollmentRequest);
}
