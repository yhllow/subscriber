package com.ineng.ssr;

import com.ineng.utils.Base64;
import com.ineng.utils.FileUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class SSRSubscriber {
    public static void main(String[] args) throws IOException {
		new SSRSubscriber().generateSubscribe();
    }

    public void generateSubscribe() throws IOException {
        String freeSsr = getFreeSsr();
	System.out.println(freeSsr);
		
        String subscribe = Base64.encode(freeSsr);
        FileUtil.writeFile("subscribe.txt", subscribe);
    }

    public String getFreeSsr() throws IOException {
        Document document = Jsoup.connect("https://github.com/Alvin9999/new-pac/wiki/ss%E5%85%8D%E8%B4%B9%E8%B4%A6%E5%8F%B7")
                .userAgent("Mozilla/5.0 (Windows NT 6.1; rv:30.0) Gecko/20100101 Firefox/30.0").get();
        Elements elements = document.getElementsByTag("P");
        List<String> ssrList = new CopyOnWriteArrayList<>();
        elements.forEach(s -> {
            String text = s.text();
            if (text.startsWith("ssr://") || text.startsWith("ss://")) {
                ssrList.add(text);
            }
        });
        return ssrList.stream().collect(Collectors.joining("\r\n"));
    }
}
