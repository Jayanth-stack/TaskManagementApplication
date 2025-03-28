package com.project.taskmanagement.service;
import com.project.taskmanagement.entity.Passcode;
import com.project.taskmanagement.entity.Program;
import com.project.taskmanagement.repository.PasscodeRepository;
import com.project.taskmanagement.utils.AuthUtils;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;




@Service
public class MailService {
    @Autowired
    JavaMailSender mailSender;

    @Autowired
    PasscodeRepository passcodeRepository;

    public String generatePasscodeForProgram(long programId) {
        String code = AuthUtils.OTP(8);
        Passcode passcode = new Passcode();
        passcode.setCode(code);
        passcode.setPid(programId);
        passcodeRepository.save(passcode);
        return code;
    }

    public String sendPasscode(String email, String passcode, Program prgm) {
        String text = "<html><body>You are invited to join program:\n"+prgm.getId()+" | "+prgm.getName();
        text = text + "\n\nUse passcode given below:\n"+ passcode + "\n\n";
        text = text + prgm.getDescription()+ "</body></html>";
        String subject = "Invitation to Join Program: "+ prgm.getId()+" | "+prgm.getName();
        try {
            sendMail(email, text, subject);
        } catch (MessagingException e) {
            return ""; //no-use
        }
        return passcode;
    }

    public boolean sendMail(String to, String text, String subject, String res) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,true);
        try {
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(text,true);
            ClassPathResource file = new ClassPathResource(res);
            helper.addAttachment(res, file);
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
        mailSender.send(message);
        return true;
    }

    public boolean sendMail(String to, String text, String subject) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,true);
        try {
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(text,true);
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
        mailSender.send(message);
        return true;
    }
}