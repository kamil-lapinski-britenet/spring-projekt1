package pl.britenet.campus.springprojekt1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.britenet.campus.database.object.Images;
import pl.britenet.campus.service.ImagesService;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/v1/image")
public class ImageController {
    @Autowired
    private final ImagesService imagesService;

    public ImageController(ImagesService imagesService) {
        this.imagesService = imagesService;
    }

    @GetMapping("/{id}")
    public Optional<Images> getImage(@PathVariable int id) {
        return this.imagesService.getImage(id);
    }

    @GetMapping
    public List<Images> getImages() {
        return this.imagesService.getImages();
    }

    @PostMapping("user")
    public void insertUserImage(@RequestBody Images images) {
        this.imagesService.insertUserImage(images);
    }

    @PostMapping("product")
    public void insertProductImage(@RequestBody Images t) {
        this.imagesService.insertProductImage(t);
    }

    @PutMapping
    public void updateImage(@RequestBody Images t) {
        this.imagesService.updateImage(t);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteImage(@PathVariable int id) {
        this.imagesService.deleteImage(id);
    }


}
