package com.pisl;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.ejb.EJB;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/generateNumbers")
public class Servlet extends HttpServlet {

    @EJB
    private Bean generatorBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Integer> randomNumbers = generatorBean.generateRandomNumbers(10);
        Map<Integer, Integer> numberMap = new HashMap<>();

        for (int i = 0; i < randomNumbers.size(); i++) {
            numberMap.put(i + 1, randomNumbers.get(i));
        }

        // Отправляем карту в формате JSON
        resp.setContentType("application/json");
        Gson gson = new Gson(); // Создаем экземпляр Gson
        String jsonResponse = gson.toJson(numberMap); // Сериализуем карту в JSON
        resp.getWriter().write(jsonResponse); // Отправляем JSON в ответе
    }
}
