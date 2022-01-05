/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projekakhirkelasc.projek.akhir.kelas.c;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ASUS
 */
@RestController
@RequestMapping(value = "/namapasien")
public class DatabaseController {
    
   @Autowired
    RepositoryPasien repositoryPasien;
            
    @PostMapping(value = "/addnamapasien")
    public Namapasien addnamapasien(@RequestBody Namapasien Param)
    {
        repositoryPasien.save(Param);
        return Param;
    }
    
    @GetMapping(value = "/allnamapasien")
    public List<Namapasien> allnamapasien()
    {
        return repositoryPasien.findAll();
    }
    
    @PutMapping(value = "/updatenamapasien")
    public Namapasien updatenamapasien(@RequestBody Namapasien Param)
    {
       return repositoryPasien.save(Param);
    }
    
    @DeleteMapping(value = "/hapusnamapasien")
    public List<Namapasien> hapusnamapasien(@RequestParam int id)
    {
        repositoryPasien.deleteById(id);
        List<Namapasien> Namapasienlist = repositoryPasien.findAll();
        return Namapasienlist;
    }
}
