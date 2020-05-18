package com.codeByKochs.RestDemo.service;

import com.codeByKochs.RestDemo.common.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST-controller used to answer GET/POST/UPDATE/DELETE calls to database
 *  uses DatabaseManager Bean to realize database changes
 * without further configuration base path is http://localhost/8080
 */

@RestController
public class AddressService {

    @Autowired
    private DatabaseManager databaseManager;

    @GetMapping("/greeting")
    public String greeting(){
        return "Hello World!";
    }

    @GetMapping("/api/addresses")
    public List<Address> getAddresses(){
        databaseManager.loadDataBase();
        return databaseManager.getAddresses();
    }

//    TODO post mapping (databaseManager.saveDatabase())
//    TODO update mapping (databaseManager.saveDatabase())
//    TODO delete (databaseManager.saveDatabase())
}
