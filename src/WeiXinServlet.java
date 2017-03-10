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
        // TODO 消息的接收、处理、响应
    }
}
