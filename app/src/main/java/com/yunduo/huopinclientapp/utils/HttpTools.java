package com.yunduo.huopinclientapp.utils;

import android.content.Context;
import android.os.Build;
import android.util.Log;

import com.yunduo.huopinclientapp.AppAplication;
import com.yunduo.huopinclientapp.AppException;
import com.yunduo.huopinclientapp.configs.URLS;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.httpclient.methods.multipart.StringPart;
import org.apache.commons.httpclient.params.HttpMethodParams;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * 网络访问  封装类
 */
public final class HttpTools {

	public static final String UTF_8 = "UTF-8";
	public static final String DESC = "descend";
	public static final String ASC = "ascend";

	private final static int TIMEOUT_CONNECTION = 20000;
	private final static int TIMEOUT_SOCKET = 20000;
	private final static int RETRY_TIME = 3;  //尝试重新  连接三次

	public static final String USER_AGENT = "hunpinClient_1_0_0(" + Build.MODEL + "," + Build.VERSION.SDK_INT + ")";


	private HttpTools(){}


	private static PostMethod getHttpPost(String url, String cookie, String userAgent) {
		PostMethod httpPost = new PostMethod(url);
		// 设置 请求超时时间
		httpPost.getParams().setSoTimeout(TIMEOUT_SOCKET);

		//设置  请求头信息
		httpPost.setRequestHeader("Host", URLS.URL_HOST); //添加  主机信息
		httpPost.setRequestHeader("Connection","Keep-Alive");
//		httpPost.setRequestHeader("Cookie", cookie);
		httpPost.setRequestHeader("User-Agent", userAgent);

		return httpPost;
	}

	/**
	 * 公用post方法
	 * @param url
	 * @param params
	 * @param files
	 */
	public static InputStream _post(String url, Map<String, Object> params, Map<String,File> files) throws AppException {
		//System.out.println("post_url==> "+url);
//		String cookie = getCookie(appContext);  获取cookie信息
		String userAgent = USER_AGENT;

		HttpClient httpClient = null;
		PostMethod httpPost = null;

		//post表单参数处理
		int length = (params == null ? 0 : params.size()) + (files == null ? 0 : files.size());
		Part[] parts = new Part[length];
		int i = 0;
		if(params != null)
			for(String name : params.keySet()){
				parts[i++] = new StringPart(name, String.valueOf(params.get(name)), UTF_8);
			}
		if(files != null)
			for(String file : files.keySet()){
				try {
					parts[i++] = new FilePart(file, files.get(file));
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}

		String responseBody = "";
		int time = 0;

		while(time < RETRY_TIME){
			try
			{
				httpClient = getHttpClient();  //获取  请求信息
				httpPost = getHttpPost(url, null, userAgent);	 //添加  请求头  请求代理  以及  请求头
				//添加  请求体  信息
				httpPost.setRequestEntity(new MultipartRequestEntity(parts,httpPost.getParams()));

				int statusCode = httpClient.executeMethod(httpPost);

				if(statusCode != HttpStatus.SC_OK)
				{
					throw AppException.http(statusCode); //抛出异常
				}
				else if(statusCode == HttpStatus.SC_OK)
				{
					//应在此  获取cookie信息  并保存下来
				}
				responseBody = httpPost.getResponseBodyAsString();
				break;
			} catch (HttpException e) {
				//连接异常  重新尝试
				time++;
				if(time < RETRY_TIME) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e1) {}
					continue;
				}
				// 发生致命的异常，可能是协议不对或者返回的内容有问题
				e.printStackTrace();
				throw AppException.http(e);
			} catch (IOException e) {
				time++;
				if(time < RETRY_TIME) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e1) {}
					continue;
				}
				// 发生网络异常
				e.printStackTrace();
				throw AppException.network(e);
			} finally {
				// 释放 连接
				httpPost.releaseConnection();
				httpClient = null;
			}
		};
		responseBody = responseBody.replaceAll("\\p{Cntrl}", "");
		ByteArrayInputStream data = new ByteArrayInputStream(responseBody.getBytes());
		if(data!=null){
			return data;
		}
		return data;
	}

	private static HttpClient getHttpClient() {
		HttpClient httpClient = new HttpClient();
		// 设置 HttpClient 接收 Cookie,用与浏览器一样的策略
		httpClient.getParams().setCookiePolicy(CookiePolicy.BROWSER_COMPATIBILITY);
		// 设置 默认的超时重试处理策略
		httpClient.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler());
		// 设置 连接超时时间
		httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(TIMEOUT_CONNECTION);
		// 设置 读数据超时时间
		httpClient.getHttpConnectionManager().getParams().setSoTimeout(TIMEOUT_SOCKET);
		// 设置 字符集
		httpClient.getParams().setContentCharset(UTF_8);
		return httpClient;
	}


}
