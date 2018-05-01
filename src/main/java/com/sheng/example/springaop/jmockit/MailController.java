package com.sheng.example.springaop.jmockit;

import com.sheng.example.springaop.model.Result;
import com.sheng.example.springaop.service.MailService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import static java.lang.String.format;

@Controller
@RequestMapping("/mail")
public class MailController {
    private static final Log log = LogFactory.getLog(MailController.class);

    @Autowired
    private MailService mailService;

    @RequestMapping(value = "/send", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
    public
    @ResponseBody
    String send(@RequestParam("recipients") String recipients,
                @RequestParam("subject") String subject,
                @RequestParam("content") String content) throws Exception {
        log.debug("mail controller send start");
        log.debug(format("recipients:%s", recipients));
        log.debug(format("subject:%s", subject));
        log.debug(format("content:%s", content));
        Result mailResult = mailService.send(recipients, subject, content);
        String result = mailResult.toString();
        log.debug(format("result:%s", result));
        log.debug("mail controller send finish");
        return result;
    }
}
