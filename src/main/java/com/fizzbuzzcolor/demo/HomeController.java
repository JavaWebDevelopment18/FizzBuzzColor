package com.fizzbuzzcolor.demo;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.ui.Model;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

/*
* Colored FizzBuzz Program
* Author: Saniya Godil
* Date: January 26, 2018
* Program accepts input x from the url and runs FizzBuzz, printing Fizz in yellow and Buzz in blue
* Uses java servlet to get input
*
 */


@Controller
public class HomeController {

    @RequestMapping("/")
    public String colorBee(HttpServletRequest param, Model model) {
        String output = "Colored Fizz Buzz" + "<br>" + "X: "; //Static starting message
        String startNum = param.getParameter("number");

        ArrayList<PerLine> finaloutput = new ArrayList<PerLine>();

        if (startNum == null) {
            return "Error, improper input";
        } else {
            int x = Integer.parseInt(startNum);

            output += startNum + "<br>";
            finaloutput.add(new PerLine("FizzBuzz", "FizzBuzz"));
            for (int i = 1; i <= x; i++) {

                if (i % 15 == 0) {
                    finaloutput.add(new PerLine("FizzBuzz", "FizzBuzz"));

                } else if (i % 3 == 0) {
                    finaloutput.add(new PerLine("Fizz", "Fizz"));
                } else if (i % 5 == 0) {
                    finaloutput.add(new PerLine("Buzz", "Buzz"));
                } else {
                    String temp = "" + i;
                    finaloutput.add(new PerLine("Plain", temp));
                }
            }
            model.addAttribute("Final output", finaloutput);
        }



        return "hometemplate";
    }
}



