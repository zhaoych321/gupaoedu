package zookeeper;

public class Main {
    PrintProcessor printProcessor;

    protected Main() {
        SaveProcessor saveProcessor = new SaveProcessor();
        saveProcessor.start();
        printProcessor = new PrintProcessor(saveProcessor);
        printProcessor.start();
    }

    private void doTest(Request request) {
        printProcessor.processRequest(request);
    }

    public static void main(String[] args) {
        Request request = new Request();
        request.setName("kerwin.zhao");
        new Main().doTest(request);
    }
}
