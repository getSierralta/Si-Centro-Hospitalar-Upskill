package com.Bgrupo4.hospitalupskill.imagem;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/DownloadImage")
public class DownloadImage extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        byte[] image = null;
        ServletOutputStream servletOutputStream = null;
        String sqlQuery = "select image from imageupload";
        try {
            Connection connection = DbConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                image = resultSet.getBytes(1);
            }
            servletOutputStream = res.getOutputStream();
            servletOutputStream.write(image);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
