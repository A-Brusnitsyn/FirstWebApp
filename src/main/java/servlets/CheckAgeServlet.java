package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

@WebServlet("/check-age")
public class CheckAgeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        String ageParametr = request.getParameter("age");

        writer.write("<html>");
        writer.write("<head><title>Проверка возраста</title></head>");
        writer.write("<body>");
        writer.write("<h1>Проверка совершеннолетия</h1>");
        writer.write("<h2>Передача возраста через URL с параметром 'age' </h2>");
        writer.write("</body>");
        writer.write("</html>");

        int age = Integer.parseInt(ageParametr);

        if (age < 0) {
            writer.write("Ошибка: возраст не может быть отрицательным!");
        } else if (age >= 18) {
            writer.write("Возраст: " + age + " лет - совершеннолетний");
        } else {
            writer.write("Возраст: " + age + " лет - несовершеннолетний</p>");
        }
    }
}
