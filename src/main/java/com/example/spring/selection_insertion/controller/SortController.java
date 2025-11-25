package com.example.spring.selection_insertion.controller;

import com.example.spring.selection_insertion.service.SortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.spring.selection_insertion.dto.RequestCadena;

@RestController
@RequestMapping("/api/sort")
public class SortController {
      
       @Autowired
       SortService service;

    @PostMapping("/burbuja")
    public ResponseEntity<?> bubbleSort(@RequestBody RequestCadena request){

        
        String[] partes= request.getCadena().split(",");
        int [] numeros = new int[partes.length];
        for (int i = 0; i < partes.length; i++) {
            
            numeros[i] = Integer.parseInt(partes[i]);
        }
        return ResponseEntity.ok(service.sort(numeros));
    }


    @PostMapping("/selection")
    public int[] SelectionSort(@RequestBody RequestCadena request){

        String[] partes= request.getCadena().split(",");
        int [] numeros = new int[partes.length];
        for (int i = 0; i < partes.length; i++) {

            numeros[i] = Integer.parseInt(partes[i]);
        }
        return service.selectionSort(numeros);
    }

    @PostMapping("/insertion")
    public int[] insertionSort(@RequestBody RequestCadena request){

        String[] partes= request.getCadena().split(",");
        int [] numeros = new int[partes.length];
        for (int i = 0; i < partes.length; i++) {

            numeros[i] = Integer.parseInt(partes[i]);
        }
        return service.insertionSort(numeros);
    }


}
