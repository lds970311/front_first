package com.evan.note.servlet;

import cn.hutool.core.util.StrUtil;
import com.evan.note.pojo.Note;
import com.evan.note.pojo.NoteType;
import com.evan.note.pojo.User;
import com.evan.note.service.NoteService;
import com.evan.note.service.impl.NoteServiceImpl;
import com.evan.note.service.impl.NoteTypeServiceImpl;
import com.evan.note.utils.Page;
import com.evan.note.vo.ResultInfo;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "NoteServlet", value = "/NoteServlet")
@Slf4j
@SuppressWarnings("all")
public class NoteServlet extends HttpServlet {
    private final NoteService noteService = new NoteServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String actionName = req.getParameter("actionName");
        switch (actionName) {
            case "view":
                this.view(req, resp);
                break;
            case "addOrUpdate":
                this.addOrUpdate(req, resp);
                break;
            case "delete":
                this.deleteNode(req, resp);
                break;
            case "detail":
                this.getNoteDetail(req, resp);
                break;
            case "list":
                this.listNote(req, resp);
                break;
            default:
                log.error("no such response!");

        }
    }

    /**
     * 云记列表
     *
     * @param req
     * @param resp
     */
    private void listNote(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pageNo = req.getParameter("pageNo");
        Integer pageSize = Integer.valueOf(req.getParameter("pageSize"));
        String title = req.getParameter("title");
        //获取user
        User user = (User) req.getSession().getAttribute("user");
        Page<Note> page = noteService.findNoteListByPage(pageNo, pageSize, user.getUserId(), title);
        req.setAttribute("page", page);
        req.setAttribute("changePage", "list.jsp");
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    private void getNoteDetail(HttpServletRequest req, HttpServletResponse resp) {

    }

    private void deleteNode(HttpServletRequest req, HttpServletResponse resp) {

    }

    private void addOrUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String noteId = req.getParameter("noteId");
        if (StrUtil.isBlank(noteId)) {
            //添加
            this.addNote(req, resp);
        } else {
            //修改
            this.updateNote(req, resp);
        }
    }

    private void updateNote(HttpServletRequest req, HttpServletResponse resp) {

    }

    /**
     * 添加云记
     *
     * @param req
     * @param resp
     */
    private void addNote(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String typeId = req.getParameter("typeId");
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        ResultInfo<Note> resultInfo = noteService.addNote(typeId, title, content);
        if (resultInfo.getCode() == 1) {
            req.getRequestDispatcher("IndexServlet").forward(req, resp);
        } else {
            req.setAttribute("resultInfo", resultInfo);
            req.getRequestDispatcher("NoteServlet?actionName=view").forward(req, resp);
        }
    }

    private void view(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        //根据userID查询类型列表
        List<NoteType> typeList = new NoteTypeServiceImpl().findTypeList(user.getUserId());
        req.setAttribute("typeList", typeList);
        req.setAttribute("changePage", "note/view.jsp");
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
