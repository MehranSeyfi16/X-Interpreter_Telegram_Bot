import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;

public class MainClass {
    public static void main(String[] args) {

        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi() ;
        try {
            telegramBotsApi.registerBot(new XInterpreterBot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
//
//        new LineReader(
//                "int x = 10\n"
//                        + "int y = 30\n"
//                        + "int z\n"
//                        + "int w = 50\n"
//                        + "int sum\n"
//                        + "%%\n"
//                        + "sum = y + x \n"
//                        + "sum = sum + z\n"
//                        + "sum = sum + w\n"
//                        + "for 3\n"
//                        + "for 2\n"
//                        + "for 4\n"
//                        + "sum = sum + 1\n"
//                        + "print sum\n"
//                        + "end for\n"
//                        + "print 10\n"
//                        + "end for\n"
//                        + "end for\n"
//                        + "for 5\n"
//                        + "print w\n"
//                        + "end for\n"
//        );

    }
}
