package zookeeper;

import java.util.concurrent.LinkedBlockingQueue;
import java.lang.InterruptedException;

public class PrintProcessor extends Thread implements RequestProessor {

    LinkedBlockingQueue<Request> requests = new LinkedBlockingQueue<Request>();
    private RequestProessor next;

    public PrintProcessor() {}

    public PrintProcessor(RequestProessor requestProessor) {
        this.next = requestProessor;
    }

    @Override
    public void processRequest(Request request) {
        requests.add(request);
    }

    @Override
    public void run() {
        while(true) {
            try {
                Request take = requests.take();
                System.out.println("print data:" + take.getName());
                if (null != take && next != null)
                    next.processRequest(take);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
