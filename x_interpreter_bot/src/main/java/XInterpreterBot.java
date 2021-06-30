import org.telegram.telegrambots.api.methods.BotApiMethod;
import org.telegram.telegrambots.api.methods.groupadministration.SetChatPhoto;
import org.telegram.telegrambots.api.methods.send.SendMediaGroup;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.methods.send.SendSticker;
import org.telegram.telegrambots.api.methods.stickers.AddStickerToSet;
import org.telegram.telegrambots.api.methods.stickers.CreateNewStickerSet;
import org.telegram.telegrambots.api.methods.stickers.UploadStickerFile;
import org.telegram.telegrambots.api.objects.File;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;
import org.telegram.telegrambots.updateshandlers.SentCallback;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class XInterpreterBot extends TelegramLongPollingBot {
    public static String command ;
    public SendMessage message = new SendMessage() ;


    @Override
    public void onUpdateReceived(Update update) {
        this.command = update.getMessage().getText() ;
        long chatId = update.getMessage().getChatId();


        switch (command){
            case "/start" :
                message.setText("Hello my dear friend! Here you can analyse your code in language X! Good luck!");
                setButtons(message);
                break;
            case "text analysis" :
                message.setText("Enter your text") ;
                break;
            case "Help" :
                message.setText("There is no difficult concept here! Just push the text analysis button and then enter your code.") ;
                break;
            default:
                if (command.length() < 15){
                    message.setText("invalid input!");
                }else {
                    new LineReader(command);
                    message.setText(" The answer is: " + String.valueOf(Print.stringBuffer) + "\nWish you got your answer! " +
                            "If you want to enter another code, please run the bot again");

                }
        }


        System.out.println(command);
        message.setChatId(chatId) ;

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public synchronized void setButtons(SendMessage sendMessage) {
        // Create a keyboard
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);        // Create a list of keyboard rows
        List<KeyboardRow> keyboard = new ArrayList<>();        // First keyboard row
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        // Add buttons to the first keyboard row
        keyboardFirstRow.add(new KeyboardButton("text analysis"));        // Second keyboard row
        KeyboardRow keyboardSecondRow = new KeyboardRow();
        // Add the buttons to the second keyboard row
        keyboardSecondRow.add(new KeyboardButton("Help"));        // Add all of the keyboard rows to the list
        keyboard.add(keyboardFirstRow);
        keyboard.add(keyboardSecondRow);
        // and assign this list to our keyboard
        replyKeyboardMarkup.setKeyboard(keyboard);

    }

    @Override
    public String getBotUsername() {
        return "X Interpreter Bot";
    }

    @Override
    public String getBotToken() {
        return "1761045299:AAHfz-pgZfxkD9QIrSh_0j_69tCpNFCBF2s";
    }

    public XInterpreterBot() {
        super();
    }

    @Override
    public void clearWebhook() throws TelegramApiRequestException {
        super.clearWebhook();
    }

    public XInterpreterBot(DefaultBotOptions options) {
        super(options);
    }

    @Override
    public Boolean setChatPhoto(SetChatPhoto setChatPhoto) throws TelegramApiException {
        return super.setChatPhoto(setChatPhoto);
    }

    @Override
    public List<Message> sendMediaGroup(SendMediaGroup sendMediaGroup) throws TelegramApiException {
        return super.sendMediaGroup(sendMediaGroup);
    }

    @Override
    public Boolean addStickerToSet(AddStickerToSet addStickerToSet) throws TelegramApiException {
        return super.addStickerToSet(addStickerToSet);
    }

    @Override
    public Boolean createNewStickerSet(CreateNewStickerSet createNewStickerSet) throws TelegramApiException {
        return super.createNewStickerSet(createNewStickerSet);
    }

    @Override
    public File uploadStickerFile(UploadStickerFile uploadStickerFile) throws TelegramApiException {
        return super.uploadStickerFile(uploadStickerFile);
    }

    @Override
    public <T extends Serializable, Method extends BotApiMethod<T>,
            Callback extends SentCallback<T>> void executeAsync(Method method, Callback callback) throws TelegramApiException {
        super.executeAsync(method, callback);
    }

    @Override
    public <T extends Serializable,
            Method extends BotApiMethod<T>> T execute(Method method) throws TelegramApiException {
        return super.execute(method);
    }

    @Override
    public void onClosing() {

    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
