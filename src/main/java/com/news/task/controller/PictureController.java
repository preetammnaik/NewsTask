package com.news.task.controller;


import com.news.task.model.News;
import com.news.task.model.Picture;
import com.news.task.service.NewsService;
import com.news.task.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
public class PictureController {
    @Autowired
    private PictureService pictureService;
    @Autowired
    private NewsService newsService;

    @RequestMapping(value = "/new_picture/{newsID}",method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN')")
    public String new_picture(Model model,@PathVariable (name="newsID") Long newsID){

        Picture picture = new Picture();
        picture.setNewsID(newsID);
        model.addAttribute(picture);
        return "new_picture";
    }

    @PostMapping("addPictures")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String savePicture( @RequestParam("pictureName") String pictureName,@RequestParam("pictureData") MultipartFile pictureData, @RequestParam("metadata") String metadata,Long newsID) {
        pictureService.savePictureToDB(pictureName,pictureData, metadata,newsID);
        return "pictureSucess";
    }

    @RequestMapping("/pictures")
    public void viewPicturesPage(Model model) {
      pictureService.listAll();
    }
}
