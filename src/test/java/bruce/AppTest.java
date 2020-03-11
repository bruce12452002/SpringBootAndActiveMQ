package bruce;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class AppTest {
    @Resource
    private JmsTemplate template;

    /**
     * 將訊息放到 MQ
     */
    @Test
    public void testSendMsg() {
        // 如果 yml 設定了 setPubSubDomain，這裡的設定會被覆蓋
        // template.setPubSubDomain(false); // 預設是 false

        // convertAndSend 是重載方法，如果只有一個參數，會去抓 yml 的 default-destination，如果沒設就報錯
        template.convertAndSend("aaa");
        template.convertAndSend("myQueue", "bbb");
        template.convertAndSend("myTopic", "ccc");

        // Queue 是點對點，所以是一對一，就生產再消費
        // Topic 是多對一，先訂閱(消費)再生產
    }
}
