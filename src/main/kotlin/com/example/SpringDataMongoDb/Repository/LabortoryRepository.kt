package com.example.SpringDataMongoDb.Repository

import com.example.SpringDataMongoDb.model.Labortory
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface LabortoryRepository:MongoRepository<Labortory,Int> {
     fun findTopByOrderByIDDesc():Labortory

}