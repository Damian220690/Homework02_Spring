package pl.coderslab.controllers;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Random;

@Controller
public class HelloController {

    @GetMapping("/workers")
    public String workersAction(Model model) throws IOException {
        String randomValue = getRandomValue();
        BufferedReader reader = getBufferedReader();

        String line;
        while ((line = reader.readLine()) != null) {
            String[] text = line.split(", ");
            if (text[0].equals(randomValue)) {
                model.addAttribute("randomValue", randomValue);
                model.addAttribute("worker", text[1]);
            }
        }
        return "workers";
    }

    public String getRandomValue() {
        Random random = new Random();
        int randomValue = random.nextInt(29) + 1;
        String value;
        if (randomValue < 10) {
            value = "0" + randomValue;
        } else {
            value = String.valueOf(randomValue);
        }
        return value;
    }

    public BufferedReader getBufferedReader() {
        ClassPathResource resource = new ClassPathResource("Workers.txt");
        InputStream inputStream = null;
        try {
            inputStream = resource.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(streamReader);
        return reader;
    }
}
