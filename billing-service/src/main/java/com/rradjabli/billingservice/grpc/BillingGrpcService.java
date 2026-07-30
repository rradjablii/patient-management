package com.rradjabli.billingservice.grpc;

import billing.BillingResponse;
import billing.BillingServiceGrpc;
import com.google.api.Billing;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@GrpcService
public class BillingGrpcService extends BillingServiceGrpc.BillingServiceImplBase {

    private static final Logger log = LoggerFactory.getLogger(BillingGrpcService.class);

    @Override
    public void createBillingAccount(billing.BillingRequest request, StreamObserver<BillingResponse> responseObserver) {
        log.info("createBillingAccount request received: {}", request.toString());

        // Here we do some business logic

        BillingResponse response = BillingResponse.newBuilder()
                .setAccountId("1234")
                .setStatus("ACTIVE")
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}














