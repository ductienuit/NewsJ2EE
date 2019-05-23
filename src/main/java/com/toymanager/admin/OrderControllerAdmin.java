package com.toymanager.admin;

import com.toymanager.constant.SystemConstant;
import com.toymanager.model.NewsModel;
import com.toymanager.paging.PageRequest;
import com.toymanager.paging.Pageble;
import com.toymanager.service.INewService;
import com.toymanager.sort.Sorter;
import com.toymanager.utils.FormUtil;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/admin-order"})
public class OrderControllerAdmin extends HttpServlet {

    @Inject
    private INewService newsService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Thay vì dùng request.getParameter từng giá trị thì mình dùng
        //FormUtil để mapping với model của mình
        NewsModel model = FormUtil.toModel(NewsModel.class, request);
        Sorter sort = new Sorter(model.getSortName(), model.getSortBy());
        Pageble pageble = new PageRequest(model.getPage(), model.getMaxPageItem(), sort);

        model.setListResult(newsService.findAll(pageble));
        model.setTotalItem(newsService.getTotalItem());
        model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getMaxPageItem()));
        request.setAttribute(SystemConstant.MODEL, model);
        RequestDispatcher rd = request.getRequestDispatcher("/view/admin/orders/detail.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}