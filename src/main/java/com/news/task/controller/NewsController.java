package com.news.task.controller;

import com.news.task.model.News;
import com.news.task.model.Picture;
import com.news.task.model.ReadStatus;
import com.news.task.service.NewsService;
import com.news.task.service.ReadStatusService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.text.DateFormat;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Controller
public class NewsController {
    @Autowired
    NewsService newsService;
    @Autowired
    ReadStatusService readStatusService;

    @RequestMapping("")
    public String view(){
        return "home";
    }
    @RequestMapping("/HomePage")
    public String viewHomePage(){
    return "HomePage";
}



@RequestMapping("/index")
public String indexPage(Model model){
    List<News> listNews = newsService.listAll();
    model.addAttribute("listNews",listNews);
        return "index";
}
@RequestMapping("/new")
    public String newNewsPage(Model model){
       News news = new News();
       model.addAttribute(news);
       return "new_news";
    }
@RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveNews(@ModelAttribute("news") News news) throws IOException {
    newsService.saveNews(news);
        return "redirect:/index";
    }


    @RequestMapping("edit/{newsID}")
    public ModelAndView showEditNewsPage(@PathVariable (name="newsID") Long newsID ){
        ModelAndView mav = new ModelAndView("edit_news");
        News news = newsService.getbyID(newsID);
        mav.addObject("news",news);
        return mav;

    }

    @RequestMapping("delete/{newsID}")
    public String deleteNewsPage(@PathVariable (name="newsID") Long newsID ){
        newsService.delete(newsID);
        return "redirect:/index";

    }
    @RequestMapping(value = "view/{newsID}")
    public String viewNewsPage(@PathVariable (name="newsID") Long newsID,Model model ){
        News news=  newsService.getbyID(newsID);
        model.addAttribute("news",news);
        ReadStatus readStatus = new ReadStatus();
        readStatus.setNewsID(newsID);
        readStatus.setStatus(true);
        readStatus.setReadDate(Date.valueOf(java.time.LocalDate.now()));
        readStatusService.setReadStaus(readStatus);
        return "singlenews";
    }


    @GetMapping("/403")
    public String error403(){
        return "403";
    }

}
