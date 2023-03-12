package com.java_project.java_project.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.java_project.java_project.data.Worker;
import com.java_project.java_project.services.WorkerService;


@RestController
public class WorkerController {

    @Autowired
    private WorkerService workerService;

    Worker worker;

    @GetMapping("/workers")
    //getting all workers
    public List<Worker> getAllWorkers() {
        return workerService.getAllWorkers();
    }
    //getting worker by their id
    @GetMapping("/worker/{id}")
    public ResponseEntity<Worker> getWorkerById(@PathVariable("id") int id) {
        Worker worker = workerService.getWorkerById(id);
        if (worker != null) {
            return new ResponseEntity<>(worker, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    // adding a worker
    @PostMapping("/worker")
    public ResponseEntity<Worker> addWorker(@RequestBody Worker worker) {
        workerService.addWorker(worker);
        return new ResponseEntity<>(worker, HttpStatus.CREATED);
        
    }
    //updating workers data
    @PutMapping("/worker/{id}")
    public ResponseEntity<Worker> updateWorker(@PathVariable("id") int id, @RequestBody Worker updatedWorker) {
        Worker worker = workerService.getWorkerById(id);
        if (worker != null) {
            updatedWorker.setId(id);
            workerService.updateWorker(id, updatedWorker);
            return new ResponseEntity<>(updatedWorker, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    //deleting a worker
    @DeleteMapping("/worker/{id}")
    public ResponseEntity<Void> deleteWorker(@PathVariable("id") int id) {
        Worker worker = workerService.getWorkerById(id);
        if (worker != null) {
            workerService.deleteworker(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
