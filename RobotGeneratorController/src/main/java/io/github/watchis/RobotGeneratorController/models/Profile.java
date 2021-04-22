package io.github.watchis.RobotGeneratorController.models;

import org.springframework.http.HttpEntity;

public class Profile {

    private HttpEntity<byte[]> robotImage;
    private HumanProfile profile;

    public HttpEntity<byte[]> getRobotImage() {
        return robotImage;
    }

    public void setRobotImage(HttpEntity<byte[]> robotImage) {
        this.robotImage = robotImage;
    }

    public HumanProfile getProfile() {
        return profile;
    }

    public void setProfile(HumanProfile profile) {
        this.profile = profile;
    }
}
