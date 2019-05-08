
package kladionicaii.kladionica.serviceSEmailClasses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import kladionicaii.kladionica.pojoClasses.EmailObject;

@Service
public class EmailService {
 
    private TemplateEngine templateEngine;
 
    @Autowired
    public EmailService(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }
 
    public String build(EmailObject emailObject) {
        Context context = new Context();
        context.setVariable("text", emailObject.getText());
        context.setVariable("email", emailObject.getEmail());
        context.setVariable("subject", emailObject.getSubject());
        return templateEngine.process("mailTemplate", context);
    }
 
}