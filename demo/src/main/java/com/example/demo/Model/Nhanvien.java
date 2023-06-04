package com.example.demo.Model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "NV")
public  class Nhanvien {
    @Id
    @Column(name = "manv", length = 50, nullable = false, unique = true)
    @NotEmpty(message = "manv không được để trống")
    @Size(max = 50, message = "mavv không vượt quá 50 ký tự")
    private String id;

    @Column(name = "tennhanvien")
    @NotEmpty(message = "hoten không được để trống")

    @Size(max = 50, min = 1, message = "Title must be less tuan 50 characters")
    private String tennhanvien;

    @Column(name = "phai")
    @Size(max = 3, message = "Title must be less tuan 50 characters")
    private String phai;

    @Column(name = "noisinh")

    private String noisinh;
    @Column(name = "luong")
    private int luong;
    @ManyToOne
    @JoinColumn(name ="phongban_id")
    private PhongBan phongban;  


     
}
