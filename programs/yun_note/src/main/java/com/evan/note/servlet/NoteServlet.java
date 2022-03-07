package com.evan.note.servlet;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
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
import java.io.PrintWriter;
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
        String date = req.getParameter("date");
        String type = req.getParameter("type");
        //获取user
        User user = (User) req.getSession().getAttribute("user");
        Page<Note> page = noteService.findNoteListByPage(pageNo, pageSize, user.getUserId(), title, date, type);
        req.setAttribute("page", page);
        req.setAttribute("changePage", "list.jsp");
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    /**
     * 查询云记详情
     *
     * @param req
     * @param resp
     */
    private void getNoteDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String noteId = req.getParameter("noteId");
        String typeId = req.getParameter("typeId");
        //查询note
        Note note = noteService.findNoteById(Integer.parseInt(noteId));
        String typeName = noteService.findNoteTypeByTypeId(Integer.parseInt(typeId));
        req.setAttribute("note", note);
        req.setAttribute("typeName", typeName);
        req.setAttribute("changePage", "note/detail.jsp");
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    /**
     * 删除云记
     *
     * @param req
     * @param resp
     */
    private void deleteNode(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String noteId = req.getParameter("noteId");
        ResultInfo<Note> resultInfo = noteService.deleteNoteById(Integer.parseInt(noteId));
        resp.setContentType("application/json;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        String json = JSON.toJSONString(resultInfo);
        writer.write(json);
        writer.close();
    }

    private void addOrUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String noteId = req.getParameter("noteId");
        //获取经纬度
        String lon = req.getParameter("lon"); //经度
        String lat = req.getParameter("lat"); //纬度
        if (StrUtil.isBlank(noteId)) {
            //添加
            this.addNote(req, resp, lon, lat);
        } else {
            //修改
            this.updateNote(req, resp, Integer.parseInt(noteId));
        }
    }

    /**
     * 修改日记
     *
     * @param req
     * @param resp
     */
    private void updateNote(HttpServletRequest req, HttpServletResponse resp, Integer noteId) throws ServletException, IOException {
        String typeId = req.getParameter("typeId");
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        ResultInfo<Note> resultInfo = noteService.updateNote(noteId, typeId, title, content);
        if (resultInfo.getCode() == 1) {
            req.getRequestDispatcher("IndexServlet").forward(req, resp);
        } else {
            req.setAttribute("resultInfo", resultInfo);
            req.getRequestDispatcher("NoteServlet?actionName=view&&noteId=" + noteId).forward(req, resp);
        }
    }

    /**
     * 添加云记
     *
     * @param req
     * @param resp
     * @param lon
     * @param lat
     */
    private void addNote(HttpServletRequest req, HttpServletResponse resp, String lon, String lat) throws IOException, ServletException {
        String typeId = req.getParameter("typeId");
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        ResultInfo<Note> resultInfo = noteService.addNote(typeId, title, content, lon, lat);
        if (resultInfo.getCode() == 1) {
            req.getRequestDispatcher("IndexServlet").forward(req, resp);
        } else {
            req.setAttribute("resultInfo", resultInfo);
            req.getRequestDispatcher("NoteServlet?actionName=view").forward(req, resp);
        }
    }

    private void view(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String noteId = req.getParameter("noteId");
        //通过noteId查询云记
        if (!StrUtil.isBlank(noteId)) {
            Note note = noteService.findNoteById(Integer.parseInt(noteId));
            req.setAttribute("noteInfo", note);
        }

        User user = (User) req.getSession().getAttribute("user");
        //根据userID查询类型列表
        List<NoteType> typeList = new NoteTypeServiceImpl().findTypeList(user.getUserId());
        req.setAttribute("typeList", typeList);
        req.setAttribute("changePage", "note/view.jsp");
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
