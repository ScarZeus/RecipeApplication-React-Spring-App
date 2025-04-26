package com.ScarZeus.recipe_backend.service;

import com.cloudinary.Cloudinary;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@Service
public class CloudinaryService {
    Dotenv dotenv = Dotenv.load();
    private Cloudinary cloudinary = new Cloudinary(dotenv.get("CLOUDINARY-URL"));

    public Map uploadImage(MultipartFile image) throws IOException {
        Map options = Map.of(image.getOriginalFilename(),true);
        Map uploadResult = cloudinary.uploader().upload(image,options);
        return uploadResult;
    }
}
