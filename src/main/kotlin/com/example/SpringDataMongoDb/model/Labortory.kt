package com.example.SpringDataMongoDb.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
class Labortory {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    var ID:Int;
    var name:String;
    var address:String;
    var phone:String;

    constructor(){
        ID = 1;
        this.name = "_name";
        this.address = "_address";
        this.phone = "_phone";
    }
    constructor(_name:String,_address:String,_phone:String){
        ID = 1;
        this.name = _name;
        this.address = _address;
        this.phone = _phone;
    }
}