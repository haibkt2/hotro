package control;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class ActionService {
	public static void main (String a[]) throws IOException{

        BufferedReader br = null;

        try {

            URL url = new URL("https://www.24h.com.vn/tin-tuc-trong-ngay/bo-truong-noi-vu-noi-ve-thuc-trang-nhan-tai-o-da-nang-xin-thoi-viec-c46a962209.html");
            br = new BufferedReader(new InputStreamReader(url.openStream()));

            String line;

            StringBuilder sb = new StringBuilder();

            while ((line = br.readLine()) != null) {

                sb.append(line);
                sb.append(System.lineSeparator());
            }

            System.out.println(sb);
        } finally {

            if (br != null) {
                br.close();
            }
        }
        System.out.println( br);
    }
}