package cn.nowdo.datacollector;

import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {
    public static void main(String[] args) {
//        String regexStr = "^([^ ]+) ([^ ]+) \\[(.*)\\] ([^ ]+) (-|[0-9]+) (-|[0-9]+) ([^ ]+) \\\"(.*?)\\\" \\\"(.*?)\\\" \\\"(.*?)\\\"$";
//        String regexStr = "(.*?)\\ (.*?)\\ \\[(.*?)\\]\\ (.*?)";
//        String regexStr = "([^ ]+) ([^ ]+) \\[(.*)\\] ([^ ]+) (-|[0-9]+) (-|[0-9]+)  (.*)";
        String regexStr = "^([^ ]+) ([^ ]+) \\[(.*)\\] ([^ ]+) (-|[0-9]+) (-|[0-9]+) ([^ ]+) \\\"(.*?)\\\" \\\"(.*?)\\\" \\\"(.*?)\\\" (.*)$";
        Pattern regex = Pattern.compile(regexStr, 1);
        String str = "60.195.40.2 www.wdyedu.com [30/May/2019:18:30:50 +0800] 2hdEhlukRrzZk3lR9 200 31 0.200 \"POST /api/report/tongji HTTP/1.1\" \"http://www.wdyedu.com/\" \"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.169 Safari/537.36\" wdyid=CgAAIFzmc/2h1a2jAy4UAg==; Hm_lvt_cfc99c618211ef6d7feb13fe17499f2c=1558606850; Hm_lpvt_cfc99c618211ef6d7feb13fe17499f2c=1559212231";

//        String str = "60.195.40.2 www.wdyedu.com [30/May/2019:18:30:50 +0800] 2hdEhlukRrzZk3lR9";
//        String str = "60.195.40.2 www.wdyedu.com [2016] 2hdEhlukRrzZk3lR9 200 31 0.200";
        Matcher matcher = regex.matcher(new String(str.getBytes(), Charset.forName("UTF-8")));
        if(matcher.matches()) {
            System.out.println("匹配");
            System.out.println(matcher.groupCount());
            for(int i =1; i <= matcher.groupCount(); i++) {
                System.out.println(matcher.group(i));
            }
        } else {
            System.out.println("不匹配");
        }
    }
}
