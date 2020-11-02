package p04;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class WebParserTest {

    // 이렇게 테스트하면 문제점?
    // 1. Fast에 대응하지 않는다. 느리다. 인터넷 연결이 순간 안될수도 있다.
    // 2. 웹페이지 내용이 변할 수 있다.
//    @Test
//    public void countImageFromGoogleDotCom() throws IOException {
//        WebParser parser = new WebParser();
//        int actualResult =
//                parser.countImageFromWebPage("http://google.com");
//        assertThat(actualResult, equalTo(5));
//    }

    private WebParser parser;

    @Before
    public void setUpUsingPageWithThreeImages() {
        // DI를 이용해 Http 객체의 Stub을 구현하여 넣어준다.
        parser = new WebParser((targetUrl) -> {
            return "<html> <meta content=a.png> <meta content=b.gif> <meta content=c.jpg> </html>";
        });
    }

    @Test
    public void countImageFromThreeImagePageStub() throws IOException {
        int actualResult = parser.
                countImageFromWebPage("http://google.com");
        assertThat(actualResult, is(equalTo(3)));
    }
}