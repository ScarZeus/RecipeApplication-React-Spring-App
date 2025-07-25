package com.ScarZeus.recipe_backend.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.Map;

@Service
public class CloudinaryService {
    Dotenv dotenv = Dotenv.load();
    private Cloudinary cloudinary = new Cloudinary(dotenv.get("CLOUDINARY_URL"));

    public Map uploadImage(MultipartFile image){
        try {
            Map options = Map.of(image.getOriginalFilename(), true);
            Map uploadResult = cloudinary.uploader().upload(image, options);
            return uploadResult;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteImage(String publicId)  {
        try {
            Map params = ObjectUtils.emptyMap();
            cloudinary.uploader().destroy(publicId,params);
        }
       catch (IOException e){
            new RuntimeException(e+"No image was found");
       }
    }


}
