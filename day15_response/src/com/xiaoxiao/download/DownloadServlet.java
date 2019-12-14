package com.xiaoxiao.download;

import com.xiaoxiao.utils.DownLoadUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author Xiaoyu
 * @date 2019/12/9 - 14:42
 */
@WebServlet("/downloadServlet")
public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //首先先获得请求,然后将请求的任务做完,请求需要获取文件名,然后再服务器上关联文件,将该文件进行关联进输入流
        //获取请求文件的参数-文件名
        String filename = request.getParameter("filename");
        //获取servlet公共域
        ServletContext servletContext = this.getServletContext();
        //拿到请求中的文件名去服务器中找到真实路径
        String realPath = servletContext.getRealPath("/img/" + filename);
        //关联输入流
        FileInputStream fis = new FileInputStream(realPath);
        //设置响应头
        String mimeType = servletContext.getMimeType(filename);
        response.setHeader("content-type", mimeType);
        //解决中文乱码
        //String agent = response.getHeader("user-agent");这句话会造成空指针异常
        //因为应该是从request中拿到请求头才能知道浏览器用的是什么
        String agent = request.getHeader("user-agent");
        //借用别人写的Utils对浏览器的头进行解析
        System.out.println(agent);
        filename = DownLoadUtils.getFileName(agent, filename);
        //这里的filename就是弹出的下载框里面显示的名字
        response.setHeader("content-disposition" ,"attachment;filename=" + filename );
        //设置byte数组,将文件进行写出
        ServletOutputStream sos = response.getOutputStream();
        byte[] bf = new byte[1024*8];
        int len;
        while ((len = fis.read(bf))!= -1) {
            sos.write(bf,0,len);
        }
        fis.close();
        sos.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
