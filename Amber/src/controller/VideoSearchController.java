package controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Listen;


import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class VideoSearchController {
	
	private static final long serialVersionUID = 1L;
    private static final String serverURL = "http://vop.baidu.com/server_api";
    private static String token = "";
    //private static final String testFileName = "D:/java web/apache-tomcat-9.0.0.M17/webapps/pcm/";
    //put your own params here
    private static final String apiKey = "zDDeCHLFLD6PfgEGurTMFwRO";
    private static final String secretKey = "ZVaMT3lHTvLYuN2vGxCs1vk8qyZiTWlh ";
    private static final String cuid = "58-FB-84-0D-BC-86";
	
    
    private static void getToken() throws Exception {
        String getTokenURL = "https://openapi.baidu.com/oauth/2.0/token?grant_type=client_credentials" + 
            "&client_id=" + apiKey + "&client_secret=" + secretKey;
        HttpURLConnection conn = (HttpURLConnection) new URL(getTokenURL).openConnection();
        token = new JSONObject(printResponse(conn)).getString("access_token");
    }


    private static String method2(String testFileName) throws Exception {
        File wavFile = new File(testFileName);
        HttpURLConnection conn = (HttpURLConnection) new URL(serverURL
                + "?cuid=" + cuid + "&token=" + token).openConnection();

        // add request header
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "audio/wav; rate=8000; charset=utf-8");

        conn.setDoInput(true);
        conn.setDoOutput(true);

        // send request
        DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
        wr.write(loadFile(wavFile));
        wr.flush();
        wr.close();
        String hp = printResponse(conn);
//        System.out.println("识别到的东西"+getChinese(getUtf8String(hp)));
        return getChinese(getUtf8String(hp));
    }

    private static String printResponse(HttpURLConnection conn) throws Exception {
        if (conn.getResponseCode() != 200) {
            // request error
            return "";
        }
        InputStream is = conn.getInputStream();
        BufferedReader rd = new BufferedReader(new InputStreamReader(is));
        String line;
        StringBuffer response = new StringBuffer();
        while ((line = rd.readLine()) != null) {
            response.append(line);
            response.append('\r');
        }
        rd.close();
//        System.out.println("duxiang"+new JSONObject(getUtf8String(response.toString())).toString(4));
//        System.out.println("到这了"+response.toString());        
//        System.out.println("dedaojieguo"+getChinese(getUtf8String(response.toString())));
        return response.toString();
    }

    private static byte[] loadFile(File file) throws IOException {
        InputStream is = new FileInputStream(file);

        long length = file.length();
        byte[] bytes = new byte[(int) length];

        int offset = 0;
        int numRead = 0;
        while (offset < bytes.length
                && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
            offset += numRead;
        }

        if (offset < bytes.length) {
            is.close();
            throw new IOException("Could not completely read file " + file.getName());
        }

        is.close();
        return bytes;
    }
    public static String getChinese(String paramValue) {
    	String regex = "([\u4e00-\u9fa5]+)";
    	String str = "";
    	Matcher matcher = Pattern.compile(regex).matcher(paramValue);
    	while (matcher.find()) {
    	str+= matcher.group(0);
    	}
    	return str;
    	}
    
	@RequestMapping(value="/listen",method = RequestMethod.GET)
	public String Listen(HttpServletRequest request, HttpServletResponse response,Model m) throws ServletException, IOException {
		System.out.println("语音听写");
		Listen lis=new Listen();
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		String userName = "nihao";
		PrintWriter out = response.getWriter();
		String testFileName = "E:/"+userName+".wav";
        try {
			getToken();
			String hp = method2(testFileName);
			lis.setContent(hp);
			System.out.println("识别结果："+hp);
			m.addAttribute("hp",lis);
//			System.out.println(lis.content+"111");
//	        System.out.println(m.toString());

        } catch (Exception e) {
			e.printStackTrace();
		}
        return "home";
//        return "redirect:/main";
		
	}

	private static String getUtf8String(String s) throws UnsupportedEncodingException  
    {  
        StringBuffer sb = new StringBuffer();  
        sb.append(s);  
        String xmlString = "";  
        String xmlUtf8 = "";  
        xmlString = new String(sb.toString().getBytes("GBK"));  
        xmlUtf8 = URLEncoder.encode(xmlString , "GBK");  
          
        return URLDecoder.decode(xmlUtf8, "UTF-8");  
    }  
}
