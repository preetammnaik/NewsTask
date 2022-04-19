package com.news.task.service;

import com.news.task.model.Picture;
import com.news.task.repository.PictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
@Service
public class PictureService {
    @Autowired
    private PictureRepository pictureRepository;

    public void savePictureToDB(String pictureName, MultipartFile file, String metadata, Long newsID){
        Picture picture = new Picture();
        String pictureData = StringUtils.cleanPath(file.getOriginalFilename());
        if(pictureData.contains(".."))
        {
            System.out.println("not a proper file name");
        }
        try {
            picture.setPictureData(Base64.getEncoder().encodeToString(file.getBytes() ));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        picture.setPictureName(pictureName);
        picture.setMetadata(metadata);
        picture.setNewsID(newsID);

        pictureRepository.save(picture);
    }

    public List<Picture> listAll(){
        return pictureRepository.findAll();
    }

    public Picture getbyID(Long id){
        return pictureRepository.findById(id).get();
    }



}
