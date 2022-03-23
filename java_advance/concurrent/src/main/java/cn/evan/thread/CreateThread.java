package cn.evan.thread;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

@Slf4j(topic = "c.CreateThread")
public class CreateThread {

    @Test
    public void createThread() {
        Thread t1 = new Thread(
                () -> {
                    log.info("running");
                }
        );

        t1.start();
    }

    public static void main(String[] args) {
        FutureTask<Integer> task = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                log.debug("callable");
                return 10;
            }
        });

        new Thread(task, "t1").start();
        Integer result = null;
        try {
            result = task.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        log.info("result = {}", result);
    }
}
