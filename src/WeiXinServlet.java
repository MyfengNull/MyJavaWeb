import bean.User;
import net.sf.json.JSONObject;
import utils.SignUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by yangshirong on 2017/2/20.
 */
public class WeiXinServlet extends HttpServlet {
    private static final long serialVersionUID = 1282855229L;
    private static final String EncodingAESKey = "FbP8UFsuwRy3ZbkJ5Q9etWDfPKIDZYyUcF1vst0sd0i";
    private static final String AppID = "wx5885d5088e044309";
    private static final String AppSecret = "9f363698846a317625d34c6d76559db0";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String signature = req.getParameter("signature");
        String timestape = req.getParameter("timestamp");
        String nince = req.getParameter("nonce");
        String echostr = req.getParameter("echostr");
        PrintWriter out = resp.getWriter();
        if (SignUtil.checkSignature(signature, timestape, nince)) {
            out.print(echostr);
        }
        out.close();
        out = null;

    }

    /**
     * 处理微信服务器发来的消息
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
//        doGet(request,response);
        String signature = request.getParameter("signature");
        String timestape = request.getParameter("timestamp");

        if ("wang".equals(signature)&&"yi".equals(timestape)){
            response.setContentType("text/html");
            response.setCharacterEncoding("utf-8");
            // TODO 消息的接收、处理、响应
            postData(response);
        }
    }

    private void postData(HttpServletResponse response) {
        PrintWriter out = null;
        try {
            out = response.getWriter();
            User user = new User();
            user.setId("1111");
            user.setName("王一");
            user.setAge(22);
            user.setProvinces("安徽");
            user.setCity("合肥");
            JSONObject o = new JSONObject();
            JSONObject header = new JSONObject();
            JSONObject body = new JSONObject();
            header.put("token", "wq21133");
            body.put("user", user);
            o.put("header", header);
            o.put("body", body);
            out.write(o.toString());
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        Map map = new HashMap();
//        map.put("name", "Dana、Li");
//        map.put("age", new Integer(22));
//        map.put("Provinces", "广东");
//        map.put("citiy","珠海市");
//        map.put("Master", new String("C、C++、Linux、Java"));
//        JSONObject json = JSONObject.fromObject(map);
//        String content = URLEncoder.encode(JSON.toJSONString(json), "UTF-8");

    }
}
