package org.example;

public class SzCmd implements ICmd {
    protected FTPServer ftpServer;

    public SzCmd(FTPServer ftpServer) {
        this.ftpServer = ftpServer;
    }

    @Override
    public void execute() {
        ftpServer.sz();
    }
}
