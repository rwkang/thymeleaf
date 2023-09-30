/**
 * 날씨 크롤링
 * https://oranthy.tistory.com/m/313
 *
 * Weather API key
 * https://home.openweathermap.org/api_keys
 * 1fbfbf78015e00c092f0f0fcab9ff2da
 * 7eb63b98988614f92d303c1ca1db3330
 *
 *
 * @author by rwkang on 2023.09.28
 */

package shop.onekorea.thymeleaf.controller;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import shop.onekorea.thymeleaf.dto.FormDto;

//@RestController
@RequiredArgsConstructor
@RequestMapping("/crawling")
@Controller
public class CrawlingController {

    @GetMapping("/")
    public String home(HttpServletRequest request, HttpServletResponse response, Model model) {
        model.addAttribute("form", new FormDto());
        return "index";
    }

    @GetMapping("/weather")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "온도") String name, Model model) {
        // http://localhost:8888/crawling/weather?name=날씨 => 이렇게 콜하면, name 값이 "날씨"로 변경되어 뿌려진다.
        model.addAttribute("name", name);
        return "weather/weather";
    }

    @GetMapping("/bb")
    public String showForm(HttpServletRequest request, HttpServletResponse response, Model model) {
        model.addAttribute("form", new FormDto());
//        ModelAndView mav = new ModelAndView();
//        mav.addAttribute("mav", model);

//        model.setViewName("weather");

        return "weather";
    }

//    @PostMapping("/form")
//    public String form(@ModelAttribute("form") FormDto formDto) {
//        return "";
////        return "/create/weather";
//    }

}