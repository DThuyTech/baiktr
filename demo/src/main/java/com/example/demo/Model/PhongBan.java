package com.example.demo.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Table(name = "PB")
public class PhongBan{
    @Id
    @Column(name = "mapb", length = 50, nullable = false, unique = true)
    @NotEmpty(message = " không được để trống")
    @Size(max = 50, message = " không vượt quá 50 ký tự")
    private String map;
    @Column(name = "ten")
    @NotEmpty(message = " không được để trống")
    @Size(max = 50, min = 1, message = "Title must be less tuan 50 characters")
    private String ten;

}