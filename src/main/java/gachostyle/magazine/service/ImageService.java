package gachostyle.magazine.service;

import gachostyle.magazine.models.Image;

import java.util.List;

public interface ImageService {
    List<Image> findAll();
    Image findById(Long id);
    Image create(Image image);
    Image edit(Image image);
    void deleteById(Long id);
}
