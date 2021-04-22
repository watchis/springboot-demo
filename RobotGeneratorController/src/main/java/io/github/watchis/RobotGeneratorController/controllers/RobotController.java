package io.github.watchis.RobotGeneratorController.controllers;

import io.github.watchis.RobotGeneratorController.models.HumanProfile;
import io.github.watchis.RobotGeneratorController.models.Profile;
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
    public Profile getProfile(@PathVariable("message") String message) {

        Profile profile = new Profile();

        profile.setRobotImage(fetchRobotImage(message));
        profile.setProfile(fetchProfile());

        return profile;
    }

    private HttpEntity<byte[]> fetchRobotImage(String message) {
        byte[] image = restTemplate.getForObject("http://robot-icon-service/roboticon/" + message, byte[].class);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        headers.setContentLength(image.length);

        return new HttpEntity<>(image, headers);
    }

    private HumanProfile fetchProfile() {
        return restTemplate.getForObject("http://user-info-service/userinfo/generate", HumanProfile.class);
    }
}
