package com.example.demo.service;

import com.example.demo.models.ClgNames;
import com.example.demo.repo.DatabaseSave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class ClgNameService {

    @Autowired
    private DatabaseSave ds;

    String line="";
    public void saveClgData() throws IOException {

        BufferedReader br=new BufferedReader(new FileReader("src/main/resources/gujarat.csv"));

        while((line=br.readLine())!=null){


            if (line.trim().equals("")) {
                // empty line
            } else {
                String[] data=line.split(",");
                ClgNames cn=new ClgNames();
                cn.setName(data[3]);
                cn.setAicteid(data[1]);
                cn.setAddress(data[0]);
                cn.setDistrict(data[2]);
                System.out.println("----------------------");
                System.out.println(data[0]);
                System.out.println(data[1]);
                System.out.println(data[2]);
                System.out.println(data[3]);

                System.out.println("----------------------");
                ds.save(cn);
            }


        }
    }
}
