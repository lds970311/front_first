package com.evan.note.servlet;

import com.evan.note.pojo.User;
import com.evan.note.service.NoteService;
import com.evan.note.service.impl.NoteServiceImpl;
import com.evan.note.vo.NoteTypeVo;
import com.evan.note.vo.NoteVo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "IndexServlet", value = "/IndexServlet")
public class IndexServlet extends HttpServlet {
    private final NoteService noteService = new NoteServiceImpl();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置首页动态包含的页面
        request.setAttribute("changePage", "list.jsp");
        //判断用户行为(标题,类型,日期)
        String actionName = request.getParameter("actionName");
        String title = "";
        String date = "";
        String type = "";
        if (actionName != null) {
            switch (actionName) {
                case "searchTitle":
                    title = request.getParameter("title");
                    request.getSession().setAttribute("title", title);
                    request.getSession().removeAttribute("date");
                    request.getSession().removeAttribute("type");
                    break;
                case "searchDate":
                    date = request.getParameter("date");
                    request.getSession().setAttribute("date", date);
                    request.getSession().removeAttribute("title");
                    request.getSession().removeAttribute("type");
                    break;
                case "searchType":
                    type = request.getParameter("type");
                    request.getSession().setAttribute("type", type);
                    request.getSession().removeAttribute("date");
                    request.getSession().removeAttribute("title");
                    break;
                default:
            }
        }
        //通过日期分组查询当前登录用户下的云记数量
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        List<NoteVo> noteVoList = noteService.findNoteCountByDate(user.getUserId());
        session.setAttribute("dateInfo", noteVoList);
        //通过类型分组查询当前登录用户下的云记数量
        List<NoteTypeVo> typeInfo = noteService.findNoteCountByType(user.getUserId());
        session.setAttribute("typeInfo", typeInfo);
        request.getRequestDispatcher("NoteServlet?actionName=list&pageNo=1&pageSize=5&title=" + title).forward(request, response);
    }
}


