package com.example.SpringDataMongoDb.controllers

import com.example.SpringDataMongoDb.model.Labortory
import com.example.SpringDataMongoDb.services.LabortoryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api")
class LabortoryController {

    var labortoryService:LabortoryService;
    @Autowired
    constructor( _labortoryService:LabortoryService){
        this.labortoryService = _labortoryService;
    }

    @GetMapping("/laborteries/list")
    fun index():ResponseEntity<Collection<Labortory>>{
        return labortoryService.listAllLaborteries()
    }


    @GetMapping("/laborteries/show/{id}")
    fun showProduct(@PathVariable id:Int):ResponseEntity<Optional<Labortory>>{
        return labortoryService.showLabortory(id)
    }




    @PostMapping ("/laborteries/add")
    fun saveLabortiry(@RequestBody labortory: Labortory): ResponseEntity<Labortory> {
        return labortoryService.addLabortory(labortory);
    }



    @DeleteMapping("/laborteries/delete/{id}")
    fun delete(@PathVariable id: Int): ResponseEntity<String> {
        return labortoryService.DeleteLabortory(id)

    }


    @PutMapping("/laborteries/update/{id}")
    fun updateProduct(@PathVariable id: Int, @RequestBody labortory:Labortory):ResponseEntity<Labortory>{
        return labortoryService.updateLabortory(id,labortory)

    }





}