package com.example.demo.Controller;

import java.util.List;

import org.hibernate.dialect.function.NvlCoalesceEmulation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Model.Nhanvien;
import com.example.demo.Repository.INhanvienRepository;
import com.example.demo.Service.NVService;
import com.example.demo.Service.PBService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/nhanvien")
public class NhanvienController {
    

    @Autowired
    private NVService nvService;

    @Autowired
    private PBService pbService;

    @GetMapping
    public String showAllBooks(Model model) {
        List<Nhanvien> nhanvien = nvService.getALLNhanvien();
        model.addAttribute("nhanvien", nhanvien);
        model.addAttribute("title", " nhan vien ");
        return "nhanvien/list";
    }


    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") String id) {
        nvService.deleteNV(id);
        return "redirect:/nhanvien";
    }

    
    @PostMapping("/add")
    public String addBook(@Valid @ModelAttribute("nhanvien") Nhanvien nhanvie, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("phongban", pbService.getAllphongban());
            model.addAttribute("nhanvien", nhanvie);
            model.addAttribute("title", "Add nahn vien");
            return "nhanvien/add";
        }

        nvService.addNhanvien(nhanvie);
        return "redirect:/nhanvien";
    }
    @GetMapping("/add")
    public String addBookForm(Model model) {
        model.addAttribute("nhanvien", new Nhanvien());
        model.addAttribute("phongban", pbService.getAllphongban());
        model.addAttribute("title", "add nhan vien");
        return "nhanvien/add";
    }
    @GetMapping("/edit/{id}")
    public String editBookForm(@PathVariable("id") String id, Model model) {
        model.addAttribute("title", "Edit nhan vien");
        model.addAttribute("phongban", pbService.getAllphongban());
        Nhanvien nhanviens = nvService.getnhanvienbyid(id);
        if (nhanviens != null) {
            model.addAttribute("nhanvien", nhanviens);
            return "nhanvien/edit";

        } else {
            return "not-found";
        }
    }

    @PostMapping("/edit/{id}")
    public String editBook( @PathVariable("id") String id,@Valid @ModelAttribute("nhanvien") Nhanvien nhanVien,BindingResult bindingResult,Model model) {
        if(bindingResult.hasErrors()){
            model.addAttribute("phongban", pbService.getAllphongban());
            model.addAttribute("nhanvien", nhanVien);
            model.addAttribute("title", "Edit nhanvien");
            return "nhanvien/edit";
        }
        nvService.updatenv(nhanVien);
        return "redirect:/nhanvien";
    }
    
    
}
