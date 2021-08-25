package tech.reisu1337.minecrafttwitch;

import com.github.philippheuer.credentialmanager.domain.OAuth2Credential;
import com.github.philippheuer.events4j.core.EventManager;
import com.github.philippheuer.events4j.simple.SimpleEventHandler;
import com.github.twitch4j.TwitchClient;
import com.github.twitch4j.TwitchClientBuilder;

public class CreateTwitchClient {
    private TwitchClient twitchClient;
    private EventManager eventManager;
    private SimpleEventHandler simpleEventHandler;

    public void createEventManager() {
        this.eventManager = new EventManager();
        this.eventManager.autoDiscovery();
        this.simpleEventHandler = this.twitchClient.getEventManager().getEventHandler(SimpleEventHandler.class);
    }

    public void createTwitchClient() {
        createEventManager();
        TwitchClientBuilder builder = TwitchClientBuilder.builder();
        builder.withEnableHelix(true);
        builder.withEventManager(eventManager);
        builder.withDefaultAuthToken(new OAuth2Credential("twitch", ""));
        this.twitchClient = builder.build();
        this.twitchClient.getClientHelper().enableFollowEventListener("Reisu1337");
    }

    public void onFollowEvent() {
        this.twitchClient.getClientHelper().enableFollowEventListener("Reisu1337");
    }

}
