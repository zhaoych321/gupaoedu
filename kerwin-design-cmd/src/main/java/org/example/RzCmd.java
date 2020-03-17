package org.example;

public class RzCmd implements ICmd {
    protected FTPServer ftpServer;

    public RzCmd(FTPServer ftpServer) {
        this.ftpServer = ftpServer;
    }

    @Override
    public void execute() {
        ftpServer.rz();
    }
}
