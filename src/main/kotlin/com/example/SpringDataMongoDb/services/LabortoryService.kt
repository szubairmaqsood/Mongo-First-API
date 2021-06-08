package com.example.SpringDataMongoDb.services

import com.example.SpringDataMongoDb.Repository.LabortoryRepository
import com.example.SpringDataMongoDb.model.Labortory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.util.*

@Service
class LabortoryService {
    var labortoryRepository:LabortoryRepository;

    @Autowired
    constructor(_labortoryRepository:LabortoryRepository){
         this.labortoryRepository = _labortoryRepository;
    }

    /* list all laborteries */

    fun listAllLaborteries():ResponseEntity<Collection<Labortory>>{
        return  ResponseEntity(labortoryRepository.findAll(),HttpStatus.OK)
    }

    /* Show a partcular labortory */

    fun showLabortory(id:Int): ResponseEntity<Optional<Labortory>> {
        var labortory:Optional<Labortory> = labortoryRepository.findById(id)
        if(labortory.isPresent){
            return  ResponseEntity(labortory,HttpStatus.OK)
        }else{
            return  ResponseEntity.notFound().build();
        }

    }

   /* For adding labrotory */
    fun addLabortory(labortory: Labortory):ResponseEntity<Labortory>
    {
        var maxID =1;
        var labortory1:Labortory? = null;

        if(labortoryRepository.count()>0) {
            labortory1 = labortoryRepository.findTopByOrderByIDDesc();
        }

        if(labortory1!=null) {
            maxID = labortory1.ID +1;
        }

        labortory.ID = maxID;
        labortoryRepository.save(labortory)
        return  ResponseEntity(labortory, HttpStatus.CREATED)

    }

   /* Delete by id */
    fun DeleteLabortory(id:Int): ResponseEntity<String> {
        var labortory:Optional<Labortory> = labortoryRepository.findById(id)
        if(labortory.isPresent){
            labortoryRepository.deleteById(id)
            return ResponseEntity("The product with id " + id.toString()  + " deleted successfully",HttpStatus.OK)
        }
        else{
            return ResponseEntity("The product with id " + id.toString()  + " does not exist",HttpStatus.NOT_FOUND)
        }
    }

    /* Updating a labortory*/
    fun updateLabortory(id:Int, labortory: Labortory):ResponseEntity<Labortory>{
        var _labortory:Optional<Labortory> =  labortoryRepository.findById(id);

        if(_labortory.isPresent) {
            var labortory1:Labortory    =_labortory.get()
            labortory1.name = labortory.name;
            labortory1.address = labortory.address;
            labortory1.phone = labortory.phone;
            labortoryRepository.save(labortory1)
            return ResponseEntity(labortory1,HttpStatus.OK)
        }
        else{
            return ResponseEntity.notFound().build()
        }
    }


}