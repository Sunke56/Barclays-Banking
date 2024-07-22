package com.barclays.parellel.tasks;


import com.barclays.parellel.dao.POffersDao;
import com.barclays.parellel.model.Offers;
import com.barclays.parellel.model.TaskResult;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public class POffersTask implements Callable<TaskResult> {

    private String cardNum;

    public POffersTask(String cardNum) {
        this.cardNum = cardNum;
    }

    public TaskResult call() throws Exception{

        System.out.println("Enter into pOffers task");

        POffersDao dao = new POffersDao();
        Offers offers = dao.getOffers(cardNum);

        TaskResult taskResult = new TaskResult();
        taskResult.setTaskName("ptask");
        taskResult.setResult(offers);

        System.out.println("Exit from POffers task");


        return  taskResult;





    }
}
