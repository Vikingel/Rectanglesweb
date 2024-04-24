package Vikingel.Rectanglesweb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController2 {
    //метод, который умеет выводить форму с кнопкой
      @GetMapping("/p")//цепляет функцию к адресу страницы на сайте
    //метод возвращает шаблон и принимает на вход 2 параметра из запроса
    public String sum(@RequestParam(name = "a", defaultValue = "0") String a,
                      @RequestParam(name = "b", defaultValue = "0") String b,
                      Model model/*дополнительный парметр - словарь для испоьзования в шаблоне*/) {
        try {
            int x = Integer.parseInt(a);
            int y = Integer.parseInt(b);
            model.addAttribute("perimeter", 2*x + 2*y);
            model.addAttribute("area", x*y);
        }
        catch (NumberFormatException e){
            model.addAttribute("errorMsg", "это было не число");
        }
        return "perimeter";
    }
}