package com.company;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import javax.mail.*;

public class Main {

    public static void main(String[] args) throws IOException, MessagingException {

        //Read credentials
        FileInputStream fileInputStream = new FileInputStream("mail.properties");
        final Properties properties = new Properties();
        properties.load(fileInputStream);

        String user = properties.getProperty("mail.user");
        String password =  properties.getProperty("mail.password");
        String host = properties.getProperty("mail.host");

        //work with IMAP
        Properties prop = new Properties();
        prop.put("mail.store.protocol", "imaps");

        //Buildings of store and connection
        Store store = Session.getInstance(prop).getStore();
        store.connect(host, user, password);

        Folder inbox = store.getFolder("Inbox");
        inbox.open(Folder.READ_ONLY);

        System.out.println("Numbers of letters: " + inbox.getMessageCount());

    }
}
