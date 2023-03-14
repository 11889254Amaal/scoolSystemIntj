package com.example.demo.malling.Interface;

import com.example.demo.malling.models.EmailDetails;

public interface EmailInterface {

    String sentSimpleMailToMany(EmailDetails emailDetails);
    String sendSimpleMail(EmailDetails emailDetails);

    String sendSimpleMailToMany(EmailDetails emailDetails);

    String sendMailWithAttachmentToMany(EmailDetails emailDetails);
    String sendMailWithAttachment(EmailDetails emailDetails);

}
