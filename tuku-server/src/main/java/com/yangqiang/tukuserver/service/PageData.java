package com.yangqiang.tukuserver.service;


import com.yangqiang.tukuserver.mapper.TukuMapper;
import com.yangqiang.tukuserver.model.Tuku;
import com.yangqiang.tukuserver.model.YamlConfig;
import com.yangqiang.tukuserver.utils.DateUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledFuture;

@Component
//@EnableScheduling
public class PageData implements CommandLineRunner {

    private static List<String> imageList = new ArrayList<>();

    @Autowired
    private ThreadPoolTaskScheduler threadPoolTaskScheduler;

    private ScheduledFuture<?> future;

    @Resource
    private YamlConfig yamlConfig;

    @Resource
    private TukuMapper tukuMapper;


    @Override
    public void run(String... args) {


        threadPoolTaskScheduler.schedule(() -> {

            sendGet(yamlConfig.getWebsite(), null);

        }, new CronTrigger(yamlConfig.getCron().getFrist()));


        threadPoolTaskScheduler.schedule(() -> {

            for (String imageUrl : imageList) {

                sendGet(imageUrl, null);

            }

            imageList.clear();

        }, new CronTrigger(yamlConfig.getCron().getSecond()));


    }

    /**
     * 向指定URL发送GET方法的请求
     *
     * @param url
     *      发送请求的URL
     * @param param
     *      请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return URL 所代表远程资源的响应结果
     */
    public void sendGet(String url, String param) {
        //1.生成httpclient，相当于该打开一个浏览器
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        //2.创建get请求，相当于在浏览器地址栏输入 网址
        HttpGet request = new HttpGet(url);
        try {
            //3.执行get请求，相当于在输入地址栏后敲回车键
            response = httpClient.execute(request);

            //4.判断响应状态为200，进行处理
            if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                //5.获取响应内容
                HttpEntity httpEntity = response.getEntity();
                String html = EntityUtils.toString(httpEntity, "utf-8");
                parseHtml(html);
            } else {
                //如果返回状态不是200，比如404（页面不存在）等，根据情况做处理，这里略
                System.out.println("返回状态不是200");
                System.out.println(EntityUtils.toString(response.getEntity(), "utf-8"));
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //6.关闭
            HttpClientUtils.closeQuietly(response);
            HttpClientUtils.closeQuietly(httpClient);
        }
    }


    private void parseHtml(String html){

        /**
         * 下面是Jsoup展现自我的平台
         */
        //6.Jsoup解析html
        Document document = Jsoup.parse(html);
        //像js一样，通过标签获取title
//        System.out.println(document.getElementsByTag("title").first());
        //像js一样，通过id 获取文章列表元素对象
//        Element postList = document.getElementById("post_list");

        //像js一样，通过class 获取列表下的所有博客
        Elements postItems = document.getElementsByClass("media_article_title");
        //第一次获取网页中的每个文章的连接
        for (Element postItem : postItems) {
            //像jquery选择器一样，获取文章标题元素
            Elements titleEle = postItem.select("a");
            String href = titleEle.attr("href");
            imageList.add(href);
            System.out.println("文章地址:" + href);
        }


        if (!imageList.isEmpty()) {

            Tuku tuku = new Tuku();
            StringBuilder srcBuilder = new StringBuilder();
            Elements postItems2 = document.getElementsByClass("f_center");
            //循环处理，获取每一张图片
            for (Element postItem : postItems2) {
                //像jquery选择器一样，获取文章标题元素
                Elements titleEle = postItem.select("img");
                String src = titleEle.attr("src");
                srcBuilder.append(src).append(";");
                System.out.println("图片地址:" + src);
            }

            System.out.println("---"+srcBuilder.length());

            tuku.setImages(srcBuilder.toString());
            //获取标题
            Elements postItems3 = document.getElementsByClass("post_title");
            for (Element postItem : postItems3) {
                String title = postItem.text();
                tuku.setTitle(title);
                System.out.println("-------:" + title);

            }
            String currentDate = DateUtils.getCurrentDate();
            tuku.setCreateTime(currentDate);
            tukuMapper.addImages(tuku);



        }


    }



}
