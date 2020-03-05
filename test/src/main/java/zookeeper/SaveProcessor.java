package zookeeper;

import java.util.concurrent.LinkedBlockingQueue;

public class SaveProcessor extends Thread implements RequestProessor {

    LinkedBlockingQueue<Request> requests = new LinkedBlockingQueue<Request>();
    private RequestProessor next;

    public SaveProcessor(){}
    public SaveProcessor(RequestProessor requestProessor) {
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
                System.out.println("save data:" + take.getName());
                if (take != null && next != null)
                    next.processRequest(take);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
