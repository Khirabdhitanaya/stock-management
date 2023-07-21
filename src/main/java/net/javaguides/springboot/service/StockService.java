package net.javaguides.springboot.service;

import net.javaguides.springboot.model.Stock;
import net.javaguides.springboot.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {
    @Autowired
    private StockRepository repo;

    public List<Stock> listAll() {
        return repo.findAll();
    }


    public void save(Stock std) {
        repo.save(std);
    }

    public Stock get(long id) {
        return repo.findById(id).get();
    }

    public void delete(long id) {
        repo.deleteById(id);
    }


    public StockService(StockRepository repo) {
        this.repo=repo;
    }

}
