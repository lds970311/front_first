package com.evan.note.servlet;

import com.alibaba.fastjson.JSON;
import com.evan.note.pojo.NoteType;
import com.evan.note.pojo.User;
import com.evan.note.service.NoteTypeService;
import com.evan.note.service.impl.NoteTypeServiceImpl;
import com.evan.note.vo.ResultInfo;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "NoteTypeServlet", value = "/NoteTypeServlet")
@Slf4j
public class NoteTypeServlet extends HttpServlet {
    private final NoteTypeService noteTypeService = new NoteTypeServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String actionName = req.getParameter("actionName");
        switch (actionName) {
            case "list":
                this.getTypeList(req, resp);
                break;
            case "delete":
                this.deleteType(req, resp);
                break;
            case "addOrUpdate":
                this.updateType(req, resp);
                break;
            default:
                log.error("请求路径错误!");
        }
    }

    private void updateType(HttpServletRequest req, HttpServletResponse resp) {

    }

    private void deleteType(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String typeId = req.getParameter("typeId");
        ResultInfo<NoteType> resultInfo = noteTypeService.deleteType(typeId);
        //设置响应类型.编码格式
        resp.setContentType("application/json;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        String json = JSON.toJSONString(resultInfo);
        writer.write(json);
        writer.close();
    }

    /**
     * 获取类型列表
     *
     * @param req
     * @param resp
     */
    private void getTypeList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        List<NoteType> typeList = noteTypeService.findTypeList(user.getUserId());
        req.setAttribute("typeList", typeList);
        req.getRequestDispatcher("UserServlet?actionName=typeAdmin").forward(req, resp);
    }
}
