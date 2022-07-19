// Author : evan lee
// Time ： 2022-07-18  18:33
// FILENAME : MsgQueue.java
// STATEMENT: 

package cn.evan.pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;

@Data
@NoArgsConstructor
@AllArgsConstructor
class Message {
    private int id;
    private Object message;
}

@Slf4j(topic = "c.MsgQueue")
public class MsgQueue {


    private LinkedList<Message> queue;
    private int capacity;

    public MsgQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new LinkedList<>();
    }

    public Message take() {
        synchronized (queue) {
            while (queue.isEmpty()) {
                log.debug("没货了, wait");
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Message message = queue.removeFirst();
            log.debug("已消费消息 {}", message);
            queue.notifyAll();
            return message;
        }
    }

    public void put(Message message) {
        synchronized (queue) {
            while (queue.size() == capacity) {
                log.debug("库存已达上限, wait");
                try {
                    log.debug("队列已满, 生产者线程等待");
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            queue.addLast(message);
            log.debug("已生产消息 {}", message);
            queue.notifyAll();
        }
    }
}


class MsgQueueTest {
    public static void main(String[] args) {
        MsgQueue queue = new MsgQueue(2);

        for (int i = 0; i < 3; i++) {
            int id = i + 1;
            new Thread(() -> {
                queue.put(new Message(id, "值" + id));
            }, "生产者" + i).start();
        }

        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                Message message = queue.take();
            }
        }, "消费者").start();
    }
}
