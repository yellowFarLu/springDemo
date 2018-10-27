package com.sheng.example.springaop.controller;

import com.sheng.example.springaop.model.arg.SaveCustomFieldArg;
import com.sheng.example.springaop.model.result.AjaxResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author huangy
 * @date 2018/3/16
 */
@RequestMapping(value = "/test")
@Controller
public class TestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    @RequestMapping(value = "/addList")
    @ResponseBody
    public AjaxResult saveList(@RequestBody SaveCustomFieldArg saveCustomFieldArg) {
        LOGGER.debug(saveCustomFieldArg.toString());

        return new AjaxResult(saveCustomFieldArg);
    }
}
