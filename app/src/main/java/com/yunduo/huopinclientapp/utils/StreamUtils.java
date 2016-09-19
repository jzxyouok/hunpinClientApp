package com.yunduo.huopinclientapp.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.net.HttpURLConnection;

/**
 *操作流的  工具类
 */
public final class StreamUtils {
	
	private StreamUtils(){}

	public static void close(Object o) {
		
		if(o!=null){
			try {
				if(o instanceof InputStream){
					((InputStream) o).close();
				}else if(o instanceof OutputStream){
					((OutputStream) o).close();
				}else if(o instanceof Reader){
					((Reader) o).close();
				}else if(o instanceof Writer){
					((Writer) o).close();
				}else if(o instanceof HttpURLConnection){
					((HttpURLConnection) o).disconnect();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static byte[] readStream(InputStream in) throws IOException{
		byte[] ret  = null;
		
		if(in!=null){
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			byte[] buffer = new byte[128];
			int len;
			while(true){
				len = in.read(buffer);
				if(len == -1){
					break;
				}
				bos.write(buffer,0,len);
			}
			buffer = null;
			ret = bos.toByteArray();
			bos.close();
		}
		return ret;
	}
}
