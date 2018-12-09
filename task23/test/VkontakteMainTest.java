package task23;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class VkontakteMainTest {
    private static final String userId = "172667690";
    private VkontakteMain vkComApi;

    @BeforeSuite
    public void beforeSuite() {
        vkComApi = new VkontakteMain();
    }

    @Test
    public void sendMessageTest() {
        String message = "Test message for send";
        String messageID =
                vkComApi.sendMessage(userId, message);
        assertTrue(vkComApi.isMessageExist(messageID));
    }

    @Test
    public void editMessageTest() {
        String peer_id = userId;
        String message = "Test message for edit";
        String editMessage = "Edit message";
        String messageID =
                vkComApi.sendMessage(userId, message);
        String editMessageID = vkComApi.editMessage(peer_id, messageID, editMessage);
        assertTrue(vkComApi.isMessageExist(editMessageID));
    }

    @Test
    public void deleteMessageTest() {
        String message = "Test message for delete";
        String messageID =
                vkComApi.sendMessage(userId, message);
        int expectedCode = 200;
        int status = vkComApi.deleteMessage(messageID);
        assertEquals(status, expectedCode);
    }

    @Test
    public void sendPhotoTest() {
        String message = "Test message with photo";
        String media_id = "317600131";
        String messageID =
                vkComApi.sendPhoto(userId, message, media_id);
        assertTrue(vkComApi.isMessageExist(messageID));
    }
}