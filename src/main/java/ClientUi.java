import org.apache.kafka.clients.producer.ProducerRecord;
import java.awt.*;
import java.awt.event.*;

public class ClientUi extends Frame {

    String nickname = "";
    TextArea ta = new TextArea();
    TextField tf = new TextField();
    Panel p = new Panel();
    Producer pdu = new Producer();


    public ClientUi() {
        this.nickname = "guest";
    }

    public ClientUi(String nickname) {

        super("Chatting");
        this.nickname = nickname;
        setBounds(100, 100, 500, 400);
        p.setLayout(new BorderLayout());
        p.add(tf, "Center");
        add(ta, "Center");
        add(p, "South");

        EventHandler1 handler1 = new EventHandler1();

        ta.addFocusListener(handler1);
        tf.addFocusListener(handler1);
        tf.addActionListener(handler1);

        ta.setText("#" + nickname + "님 즐거운 채팅되세요.\n");
        ta.setEditable(false);
    }
    public void run(){
        setVisible(true);
        tf.requestFocus();
    }

    class EventHandler1 extends FocusAdapter implements ActionListener {


        
    }
}

