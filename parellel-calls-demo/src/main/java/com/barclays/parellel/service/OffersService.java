package com.barclays.parellel.service;

import com.barclays.parellel.model.Offers;
import com.barclays.parellel.model.TaskResult;
import com.barclays.parellel.tasks.GOffersTask;
import com.barclays.parellel.tasks.MOffersTask;
import com.barclays.parellel.tasks.POffersTask;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

public class OffersService {

    public List<Offers> getOffers(String cardNum) throws InterruptedException, ExecutionException {
        List<Offers> offersList = new ArrayList<Offers>();


        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Set<Callable<TaskResult>> tasks = new HashSet<>();
        tasks.add(new GOffersTask(cardNum));
        tasks.add(new POffersTask(cardNum));
        tasks.add(new MOffersTask(cardNum));

        //Execute 3 tasks by 3 threads parellelly and hold all the threads response by future object
        List<Future<TaskResult>> futureTask = executorService.invokeAll(tasks);

        for (Future<TaskResult> future : futureTask) {

            TaskResult taskResult = future.get();
            Offers offers = (Offers) taskResult.getResult();
            offersList.add(offers);
        }
        executorService.shutdown();
        return offersList;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        OffersService offersService = new OffersService();
        List<Offers> offersList = offersService.getOffers("34356824793753");
        System.out.println("List of Offers ;" + offersList);


    }


}