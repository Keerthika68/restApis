package com.RestApi.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/details")
public class DetailsController {

    @Autowired
    public DetailsRepositary repositary;

    @GetMapping
    public List<Details> getAllDetails(){
        return repositary.findAll();
    }
    @PostMapping
    public String saveDetail(@RequestBody Details details){
        repositary.save(details);
        return "Detail saved successfully....";
    }
    @PostMapping("/bulkDetails")
    public String saveAllDetails(@RequestBody List<Details> details){
        repositary.saveAll(details);
        return "All details saved successfully....";
    }
    @GetMapping("/{id}")
    public Optional<Details> getById(@PathVariable long id){
        return repositary.findById(id);
    }
    @PutMapping
    public String updateDetails(@RequestBody Details details){
        Optional<Details> exist = repositary.findById(details.getId());
        if(exist.isPresent()){
            repositary.save(details);
            return "Detail updated successfully";
        }
        return "Detail does not exist....";
    }
    @DeleteMapping("/{id}")
    public String delteDetail(@PathVariable long id){
        repositary.deleteById(id);
        return "Detail deleted successfully.....";
    }

}
