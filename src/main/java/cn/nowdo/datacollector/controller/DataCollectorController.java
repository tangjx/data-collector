package cn.nowdo.datacollector.controller;

import cn.nowdo.datacollector.service.KafkaService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@RequestMapping("toc/log")
@Controller
public class DataCollectorController {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(DataCollectorController.class);
    @Autowired
    private KafkaService kafkaService;

    @Value("${data.sink.kafka.topic}")
    private String topic;

    @ResponseBody
    @RequestMapping("logstash")
    public Object logstash(HttpServletRequest request, HttpServletResponse response, @RequestBody Map<String,Object> params) {
        logger.debug(params.get("message").toString());
        kafkaService.sendMessage(topic, params.get("message").toString());
        return "ok";
    }

    @ResponseBody
    @RequestMapping("flume")
    public Object flume(HttpServletRequest request, @RequestBody String params) {
        logger.debug(params);
        kafkaService.sendMessage(topic, params);
        return "ok";
    }
}
