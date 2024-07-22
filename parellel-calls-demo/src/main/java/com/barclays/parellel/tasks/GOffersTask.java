package com.barclays.parellel.tasks;

import com.barclays.parellel.dao.GOffersDaO;
import com.barclays.parellel.model.Offers;
import com.barclays.parellel.model.TaskResult;

import java.util.concurrent.Callable;

public class GOffersTask implements Callable<TaskResult> {

    private String cardNum;

    public GOffersTask(String cardNum) {
        this.cardNum = cardNum;
    }

    public TaskResult call() throws Exception{

        System.out.println("Enter into GOffers task");

        GOffersDaO dao = new GOffersDaO();
        Offers offers = dao.getOffers(cardNum);

        TaskResult taskResult = new TaskResult();
        taskResult.setTaskName("gtask");
        taskResult.setResult(offers);

        System.out.println("Exit from GOffers task");


        return  taskResult;





    }
}
