package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.PhongBan;
import com.example.demo.Repository.IPhongbanrepository;

@Service
public class PBService {
    @Autowired
    private IPhongbanrepository Iphongbanrepository;

    public List<PhongBan> getAllphongban(){
        return Iphongbanrepository.findAll();
    }

    public PhongBan getphongbanbyid(String id){
        return Iphongbanrepository.findById(id).orElse(null);
    }

    public void addPhongban(PhongBan phongban){
        Iphongbanrepository.save(phongban);
    }

    public void deletePB(String id){
        Iphongbanrepository.deleteById(id);
    }

    public void updatePB(PhongBan phongban){
        Iphongbanrepository.save(phongban);
    }
}
