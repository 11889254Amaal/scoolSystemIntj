package com.example.demo.slacks;

import com.example.demo.Models.Course;
import com.example.demo.Services.CourseServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class SlackClient {
    @Autowired
    CourseServices courseServices ;
    public String sendMessage(String text) {
        return WebClient.create().post()
                .uri("https://hooks.slack.com/services/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")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(new SlackPayload(text))
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }




}

