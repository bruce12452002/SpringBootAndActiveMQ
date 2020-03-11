package bruce;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * 去 MQ 取資料
 */
@Component
public class ActiveMqServer {
    @JmsListener(destination = "myQueue")
    public void receiveQueue(String msg) {
        System.out.println("myQueue:" + msg);
    }

    @JmsListener(destination = "myTopic")
    public void receiveTopic(String msg) {
        System.out.println("myTopic:" + msg);
    }

    @JmsListener(destination = "my-dest-test")
    public void ymlDes(String msg) {
        System.out.println("yml:" + msg);
    }
}
