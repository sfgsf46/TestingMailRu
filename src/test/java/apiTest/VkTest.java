package apiTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class VkTest {
    private Vk vk;

    @BeforeEach
    public void before() {
        vk = new Vk();
    }

    @Test
    public void messageWall() throws IOException, URISyntaxException {
        vk.writeAMessageOnTheWall("Hello user!");
        vk.editMessage("What your name?");
        vk.deleteMessage();
    }
}
