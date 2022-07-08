// Author : evan lee
// Time ： 2022-07-07  9:11
// FILENAME : MonitorTest.java
// STATEMENT: 

package cn.evan.thread;

import lombok.extern.slf4j.Slf4j;


public class MonitorTest {
    public static void main(String[] args) throws InterruptedException {
        TwoPhaseTermination twoPhaseTermination = new TwoPhaseTermination();
        twoPhaseTermination.startMonitor();

        Thread.sleep(3000);
        twoPhaseTermination.endMonitor();
    }
}

@Slf4j(topic = "c.a")
class TwoPhaseTermination {
    private Thread monitor;

    public void startMonitor() {
        this.monitor = new Thread(() -> {
            Thread currentThread = Thread.currentThread();
            while (true) {
                boolean interrupted = currentThread.isInterrupted();
                if (interrupted) {
                    log.info("monitor线程结束!");
                    break;
                }
                //为打断, 执行监控
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    //重置打断标记
                    currentThread.interrupt();
                }
                log.info("执行监控记录!");
            }
        });
        this.monitor.start();
    }

    public void endMonitor() {
        this.monitor.interrupt();
    }
}
