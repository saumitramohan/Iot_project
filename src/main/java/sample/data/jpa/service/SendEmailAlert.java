package sample.data.jpa.service;

import sample.data.jpa.emailService.AmazonSESSample;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class SendEmailAlert {
    public SendEmailAlert (String emailId, List<Double> alertValues){

            try {
                        AmazonSESSample obj = new AmazonSESSample();
                        //String emailId = "saumitra90@gmail.com";
                        obj.sendEmail(emailId, alertValues);
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }  catch (javax.mail.internet.AddressException e) {
                e.printStackTrace();
            }

        }
    }

