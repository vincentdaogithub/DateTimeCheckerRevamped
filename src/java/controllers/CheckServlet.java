/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.DateTimeFunctions;

/**
 *
 * @author Vincent
 */
public class CheckServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Short year = null;
        Byte day = null, month = null;
        
        try {
            day = Byte.parseByte(request.getParameter("day"));
        } catch (NumberFormatException e) {
            log("Input data for Day is incorrect format!");
            request.setAttribute("invalidDayFormat", true);
        }
        
        try {
            month = Byte.parseByte(request.getParameter("month"));
        } catch (NumberFormatException e) {
            log("Input data for Month is incorrect format!");
            request.setAttribute("invalidMonthFormat", true);
        }
        
        try {
            year = Short.parseShort(request.getParameter("year"));
        } catch (NumberFormatException e) {
            log("Input data for Year is incorrect format!");
            request.setAttribute("invalidYearFormat", true);
        }
        
        if (day == null || month == null || year == null) {
            request.setAttribute("prevDay", request.getParameter("day"));
            request.setAttribute("prevMonth", request.getParameter("month"));
            request.setAttribute("prevYear", request.getParameter("year"));
            request.getRequestDispatcher("index.jsp").forward(request, response);
            return;
        }
        
        boolean isInRange = true;
        if (day < 0 || day > 32) {
            log("Input data for Day is out of range!");
            request.setAttribute("invalidDayRange", true);
            isInRange = false;
        }
        if (month < 0 || month > 12) {
            log("Input data for Month is out of range!");
            request.setAttribute("invalidMonthRange", true);
            isInRange = false;
        }
        if (year < 1000 || year > 3000) {
            log("Input data for Year is out of range!");
            request.setAttribute("invalidYearRange", true);
            isInRange = false;
        }
        if (isInRange) {
            request.setAttribute("isValidDate", DateTimeFunctions.IsValidDate(year, month, day));
        }
        
        request.setAttribute("prevDay", request.getParameter("day"));
        request.setAttribute("prevMonth", request.getParameter("month"));
        request.setAttribute("prevYear", request.getParameter("year"));
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
