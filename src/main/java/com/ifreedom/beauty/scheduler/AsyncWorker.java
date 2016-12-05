package com.ifreedom.beauty.scheduler;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @atuhor:eavawu
 * @date:04/12/2016
 * @todo:异步任务
 */
@Component
public class AsyncWorker {

    @Async
    public void work(String name) {
        String threadName = Thread.currentThread().getName();
        System.out.println("   " + threadName + " beginning work on " + name);
        try {
            Thread.sleep(5000); // simulates work

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("   " + threadName + " completed work on " + name);
    }

    @Async
    public void work(Runnable runnable) {
        if (runnable != null) {
            runnable.run();
        }

    }
}
