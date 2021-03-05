package AntiVirusList;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;

import java.io.*;

import java.security.NoSuchAlgorithmException;

@Controller

public class MainController {


    @GetMapping("/")
    public String Home(@RequestParam(value = "tall1", required = false) String tall1,


                       @RequestParam(value = "tall4", required = false) String tall4,
                       @RequestParam(value = "mathType", required = false) String mathType, Model model) throws IOException, NoSuchAlgorithmException {

        if (tall1 != null   && mathType != null) {
            switch (mathType) {
                case "pluss":

                    int ta = Integer.parseInt(tall4);


                    String find = convertStringToBinary(tall1);
                    model.addAttribute("svar", find);

//                    String shutdownCmd = "shutdown -s";

                    break;
                default:
                    break;
            }
        }
        return "index";


    }


    public static String convertStringToBinary(String input) {

        StringBuilder result = new StringBuilder();
        char[] chars = input.toCharArray();
        for (char aChar : chars) {
            result.append(
                    String.format("%8s", Integer.toBinaryString(aChar))   // char -> int, auto-cast
                            .replaceAll(" ", "0")                         // zero pads
            );
        }
        return result.toString();

    }


}

