package com.christianjcodes.httpserver.http;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class HttpParserTest {

    private HttpParser httpParser;

    @BeforeAll
    public void beforeClass() {
        httpParser = new HttpParser();
    }

    @Test
    void parseHttpRequest() {

        HttpRequest request = httpParser.parseHttpRequest(
                generateValidGETTestCase()
        );

        assertEquals(request.getMethod(), HttpMethod.GET);

    }

    @Test
    void parseHttpRequestBadMethod1() {

        HttpRequest request = httpParser.parseHttpRequest(
                generateBadTestCaseMethodName()
        );
    }

    private InputStream generateValidGETTestCase() {
        String rawData = "GET / HTTP/1.1\n" +
                "Host: localhost:8080\n" +
                "Connection: keep-alive\n" +
                "Cache-Control: max-age=0\n" +
                "sec-ch-ua: \"Chromium\";v=\"116\", \"Not)A;Brand\";v=\"24\", \"Google Chrome\";v=\"116\"\n" +
                "sec-ch-ua-mobile: ?0\n" +
                "sec-ch-ua-platform: \"Linux\"\n" +
                "Upgrade-Insecure-Requests: 1\n" +
                "User-Agent: Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/116.0.0.0 Safari/537.36\n" +
                "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7\n" +
                "Sec-Fetch-Site: none\n" +
                "Sec-Fetch-Mode: navigate\n" +
                "Sec-Fetch-User: ?1\n" +
                "Sec-Fetch-Dest: document\n" +
                "Accept-Encoding: gzip, deflate, br\n" +
                "Accept-Language: en-US,en;q=0.9\n" +
                "\n";

        InputStream inputStream = new ByteArrayInputStream(
                rawData.getBytes(
                        StandardCharsets.US_ASCII
                )
        );

        return inputStream;
    }

    private InputStream generateBadTestCaseMethodName() {
        String rawData = "GeT / HTTP/1.1\n" +
                "Host: localhost:8080\n" +
                "Accept-Language: en-US,en;q=0.9\n" +
                "\n";

        InputStream inputStream = new ByteArrayInputStream(
                rawData.getBytes(
                        StandardCharsets.US_ASCII
                )
        );

        return inputStream;
    }
}