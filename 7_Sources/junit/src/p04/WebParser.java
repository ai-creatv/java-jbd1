package p04;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebParser {
    private final Http http;

    // Dependency injection
    // 테스트 케이스로 인해서, 더 테스트하기 좋은 코드로 리팩토링할 수 있었다.
    public WebParser(Http http) {
        this.http = http;
    }

    public int countImageFromWebPage(String url) throws IOException {
        String text = http.get(url);

        Pattern pattern = Pattern.compile("(\\w+.(png|jpg|gif))");
        Matcher matcher = pattern.matcher(text);

        int count = 0;
        while (matcher.find()) {
            count++;
        }

        return count;
    }
}
