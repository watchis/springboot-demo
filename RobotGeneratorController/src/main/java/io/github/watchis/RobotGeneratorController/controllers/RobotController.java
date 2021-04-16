package io.github.watchis.RobotGeneratorController.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.InputStream;
import java.net.URL;

@RestController
@RequestMapping("/robotgenerator")
public class RobotController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/{message}")
    @ResponseBody
    public HttpEntity<byte[]> getRobotIcon(@PathVariable("message") String message) throws Exception {
        String uri = "https://robohash.org/";

        InputStream in = new URL(uri + message).openStream();
        byte[] image = in.readAllBytes();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        headers.setContentLength(image.length);

        return new HttpEntity<>(image, headers);
    }
}
