package io.github.watchis.UserInfoService.controllers;

import io.github.watchis.UserInfoService.models.HumanProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/userinfo")
public class UserInfoController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/generate")
    public HumanProfile generateRandomUser() {
        List<String> words = restTemplate.getForObject("http://random-word-api.herokuapp.com/word?number=4", List.class);
        String humanImage = words.get(0);
        String name = words.get(1);
        String email = words.get(2);
        String birthday = words.get(3);

        return new HumanProfile(humanImage, name, email, birthday);
    }
}
