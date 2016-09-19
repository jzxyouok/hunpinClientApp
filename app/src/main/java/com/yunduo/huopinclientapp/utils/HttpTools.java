package com.yunduo.huopinclientapp.utils;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;

import android.os.Build;

/**
 *
 */
public final class HttpTools {
	

	private HttpTools(){}
	
	private static final int CONNECTION_TIMEOUT= 10000;
	private static final int READ_TIMEOUT = 10000;
	public static final String USER_AGENT =
			"hlrjCloundPos_1.0.0(" + Build.MODEL + "," + Build.VERSION.SDK_INT + ")";
	
	@SuppressWarnings("unused")
	private static InputStream in = null;

	public static byte[] doGet(String urlStr) {
		byte[] ret = null;
	
		if(urlStr!=null){
			HttpURLConnection conn = null;
			try {
				URL url = new URL(urlStr);
				conn = (HttpURLConnection) url.openConnection();
				
				conn.setConnectTimeout(CONNECTION_TIMEOUT);
				conn.setReadTimeout(READ_TIMEOUT);
				
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Accept", "appliction/*,text/*,image/*,*/*");
				conn.setRequestProperty("Accept-Encoding", "gzip");
				conn.setRequestProperty("User-Agent", USER_AGENT);
				
				conn.connect();
				
				int code = conn.getResponseCode();
				if(code == 200){
					InputStream fin = conn.getInputStream();
					String encoding = conn.getHeaderField("Content-Encoding");
					
					if("gzip".equals(encoding)){
						fin = new GZIPInputStream(fin);
					}
					
					ret = StreamUtils.readStream(fin);
				}
				
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				StreamUtils.close(conn);
			}
		}
		return ret;
	}
	
	public static String doPost(String url,String action, HashMap<String,String> map){
		
		InputStream in = null;
		ByteArrayOutputStream bos = null;
		
		if(url!=null){
			StringBuilder sb = new StringBuilder();
			
			try {

				sb.append(action);
				for(Map.Entry<String,String> en : map.entrySet()){
						sb.append(en.getKey())
								.append("=")
								.append(URLEncoder.encode(en.getValue(),"utf-8"));
				}

				HttpURLConnection connection = null;
			
				URL u = new URL(url);
				
				connection = (HttpURLConnection) u.openConnection();
				connection.setReadTimeout(READ_TIMEOUT);
				connection.setConnectTimeout(CONNECTION_TIMEOUT);

				connection.setRequestMethod("POST");

				connection.setRequestProperty("Accept", "appliction/*,text/*,image/*,*/*");
				
				connection.setDoInput(true);
				connection.setDoOutput(true);
				connection.connect();
				byte[] b = sb.toString().getBytes();
				
				OutputStream outputStream = connection.getOutputStream();
				outputStream.write(b);
				outputStream.close();
				
				bos = new ByteArrayOutputStream();

				in = connection.getInputStream();
				byte[] buffer = new byte[1024];
				int len = 0;
				while((len=in.read(buffer))!=-1){
					bos.write(buffer, 0, len);
				}
				buffer = null;
				byte[] ret = bos.toByteArray();
				bos.close();
				
				return new String(ret,"utf-8");
				
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
		return null;
	}

}
