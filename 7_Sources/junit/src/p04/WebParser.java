package p04;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebParser {
    public int countImageFromWebPage(String url) throws IOException {
        String text = new HttpImpl().get(url);

        Pattern pattern = Pattern.compile("(\\w+.(png|jpg|gif))");
        Matcher matcher = pattern.matcher(text);

        int count = 0;
        while (matcher.find()) {
            count++;
        }

        return count;
    }
}
