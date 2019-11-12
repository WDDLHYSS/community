package com.wddlhyss.community.provider;

import com.alibaba.fastjson.JSON;
import com.wddlhyss.community.model.AccessToken;
import com.wddlhyss.community.model.GithubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * 模拟post请求获取令牌
 */
@Component
public class GitHubProvider {
    public String getAccessToken(AccessToken accessToken){
       MediaType mediaType = MediaType.get("application/json; charset=utf-8");

        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(accessToken));
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String string = response.body().string();

            String[] split= string.split("$");

            String token = split[0].split("=")[1];
            return token;
            } catch (Exception e) {
                e.printStackTrace();
            }
        return null;
        }

        public GithubUser getuser(String accessToken){
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                .url("https://api.github.com/user?access_token="+accessToken)
                .build();
            try {
                Response response = client.newCall(request).execute();
                return JSON.parseObject(response.body().string(),GithubUser.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

}
