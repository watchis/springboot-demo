package io.github.watchis.RobotIconService.controllers;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.InputStream;
import java.net.URL;

@RestController
@RequestMapping("/roboticon")
public class RobotIconController {

    @GetMapping("/{message}")
    @ResponseBody
    public byte[] getRobotIcon(@PathVariable("message") String message) throws Exception {
        String uri = "https://robohash.org/";

        InputStream in = new URL(uri + message).openStream();
        return in.readAllBytes();
    }
}
