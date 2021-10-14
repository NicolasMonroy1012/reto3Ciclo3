/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.G22.Reto3.web;


import java.util.List;
import java.util.Optional;

import com.usa.G22.Reto3.entities.Skate;
import com.usa.G22.Reto3.services.SkateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/Skate")
public class SkateController {
    @Autowired
    private SkateService skateboardService;
    
    @GetMapping("/all")

    public List<Skate> getSkates(){
        return skateboardService.getAll();
    }
    
    @GetMapping("/{id}")

    public Optional<Skate> getSkate(@PathVariable("id") int skateboardId){
        return skateboardService.getSkateboard(skateboardId);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Skate save(@RequestBody Skate skateboard){
        return skateboardService.save(skateboard);
    }



    @PutMapping("/update")

    public Skate update(@RequestBody Skate skateboard){
        return skateboardService.update(skateboard);
    }
    
    @DeleteMapping("/{id}")

    public boolean delete(@PathVariable("id") int carId){
        return skateboardService.deleteSkateboard(carId);
    }
}
