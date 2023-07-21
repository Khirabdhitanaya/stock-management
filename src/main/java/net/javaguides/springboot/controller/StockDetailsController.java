package net.javaguides.springboot.controller;


import net.javaguides.springboot.model.Stock;
import net.javaguides.springboot.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class StockDetailsController {
    @Autowired
    private StockService service;
    @RequestMapping(value = "/stock-detail", method = RequestMethod.GET)
    public String viewHomePage(Model model) {
        List<Stock> liststock = service.listAll();
        for(Stock stock: liststock) {
            System.out.println(stock.getId() + ", " + stock.getStockname() + ", " + stock.getValue());
        }
        model.addAttribute("liststock", liststock);
        System.out.print("Get /");
        return "stock-details";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String add(Model model) {
       model.addAttribute("stock", new Stock());
        return "add-stock";
    }
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveStudent(@ModelAttribute("stock") Stock std) {
        service.save(std);
        System.out.println(std.getId() + ", " + std.getStockname() + ", " + std.getValue());
        return "redirect:/";
    }
    @RequestMapping("/edit/{id}")
    public ModelAndView showEditStudentPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("new");
        Stock std = service.get(id);
        mav.addObject("stock", std);
        return mav;

    }
    @RequestMapping("/delete/{id}")
    public String deletestock(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/";
    }
}

