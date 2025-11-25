package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Writer;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TimeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        Writer writer = response.getWriter();

        String city = request.getPathInfo();

        String timeZone = null;
        String cityName = "";

        switch (city) {
            case "/minsk":
                timeZone = "Europe/Minsk";
                cityName = "Минске";
                break;
            case "/washington":
                timeZone = "America/New_York";
                cityName = "Вашингтоне";
                break;
            case "/beijing":
                timeZone = "Asia/Shanghai";
                cityName = "Пекине";
                break;
        }

        ZonedDateTime time = ZonedDateTime.now(ZoneId.of(timeZone));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        String formattedTime = time.format(formatter);

        writer.write("<head><title>Время в городах</title></head>");
        writer.write("<h1>Текущее время в " + cityName + ": " + formattedTime + "</h1>");
    }
}