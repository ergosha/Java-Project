package com.java_project.java_project.services;
import com.java_project.java_project.data.Worker;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Service
public class WorkerService {

    private List<Worker> workers = new ArrayList<>();

    //The methods of getting all workers, getting by id, adding a worker, updating a worker, deleting a worker
    public List<Worker> getAllWorkers() {
        return workers;
    }

    public Worker getWorkerById(int id) {
        for (Worker worker : workers) {
            if (worker.getId() == id) {
                return worker;
            }
        }
        return null;
    }

    public void addWorker(Worker worker) {
        workers.add(worker);
    }

    public void updateWorker(int id, Worker updatedWorker) {
        for (Worker worker : workers) {
            if (worker.getId() == id) {
            worker.setName(updatedWorker.getName());
            worker.setAge(updatedWorker.getAge());
            worker.setAddress(updatedWorker.getAddress());
            worker.setPhoneNumber(updatedWorker.getPhoneNumber());
            worker.setJobTitle(updatedWorker.getJobTitle());
            worker.setSalary(updatedWorker.getSalary());
            }
        }
    }

    public void deleteworker(int id) {
        workers.removeIf(worker -> worker.getId() == id);
    }

}
