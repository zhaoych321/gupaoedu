package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        final FTPServer ftpServer = new FTPServer();
        Controller.execute(new RzCmd(ftpServer));

        Controller.addCmd(new RzCmd(ftpServer));
        Controller.addCmd(new SzCmd(ftpServer));
        Controller.execute();
    }
}
