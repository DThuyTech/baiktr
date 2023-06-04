package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Nhanvien;

@Repository
public interface INhanvienRepository extends JpaRepository<Nhanvien,String> {
    
}
