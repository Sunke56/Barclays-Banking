package com.barclays.parellel.tasks;


import com.barclays.parellel.dao.MOffersDao;
import com.barclays.parellel.model.Offers;
import com.barclays.parellel.model.TaskResult;

import java.util.concurrent.Callable;

public class MOffersTask implements Callable<TaskResult> {

    private String cardNum;

    public MOffersTask(String cardNum) {
        this.cardNum = cardNum;
    }

    public TaskResult call() throws Exception{

        System.out.println("Enter into MOffers task");

        MOffersDao dao = new MOffersDao();
        Offers offers = dao.getOffers(cardNum);

        TaskResult taskResult = new TaskResult();
        taskResult.setTaskName("mtask");
        taskResult.setResult(offers);

        System.out.println("Exit from Mimplements Callable<TaskResult>Offers task");


        return  taskResult;





    }


}
