package com.evan.note.servlet;

import com.alibaba.fastjson.JSON;
import com.evan.note.pojo.User;
import com.evan.note.service.ReportService;
import com.evan.note.service.impl.ReportServiceImpl;
import com.evan.note.vo.LocationVo;
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
import java.util.Map;

@WebServlet(name = "ReportServlet", value = "/ReportServlet")
@Slf4j
@SuppressWarnings("all")
public class ReportServlet extends HttpServlet {
    private ReportService reportService = new ReportServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置高亮

        String actionName = req.getParameter("actionName");
        switch (actionName) {
            case "info":
                this.reportInfo(req, resp);
                break;
            case "month":
                this.getMonthData(req, resp);
                break;
            case "location":
                this.getLoactions(req, resp);
                break;
            default:
                log.error("no such path exists!");
        }
    }

    /**
     * 获取云记发布的地理位置
     *
     * @param req
     * @param resp
     */
    private void getLoactions(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        User user = (User) req.getSession().getAttribute("user");
        List<LocationVo> locationList = reportService.getLocations(user.getUserId());
        resp.setContentType("application/json;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        String json = JSON.toJSONString(locationList);
        writer.write(json);
        writer.close();
    }

    /**
     * 统计每个月份机器对应的数据, 绘制echarts
     *
     * @param req
     * @param resp
     */
    private void getMonthData(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        User user = (User) req.getSession().getAttribute("user");
        ResultInfo<Map<String, Object>> resultInfo = reportService.getNoteCountByMonth(user.getUserId());
        resp.setContentType("application/json;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        String json = JSON.toJSONString(resultInfo);
        writer.write(json);
        writer.close();
    }

    private void reportInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("changePage", "report/reportInfo.jsp");
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
