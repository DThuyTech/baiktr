package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Nhanvien;
import com.example.demo.Repository.INhanvienRepository;

@Service
public class NVService {
    @Autowired
    private INhanvienRepository iNhanvienRepository;

    public List<Nhanvien> getALLNhanvien(){
        return iNhanvienRepository.findAll();
    }

    public Nhanvien getnhanvienbyid(String id){
        return iNhanvienRepository.findById(id).orElse(null);    }

    public void addNhanvien(Nhanvien nv){
        iNhanvienRepository.save(nv);
    }

    public void deleteNV(String id){
        iNhanvienRepository.deleteById(id);
    }

    public void updatenv(Nhanvien nhanviens){
        iNhanvienRepository.save(nhanviens);
    }
}

