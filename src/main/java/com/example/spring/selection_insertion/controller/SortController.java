package com.example.spring.selection_insertion.controller;

import com.example.spring.selection_insertion.dto.ErrorResponse;
import com.example.spring.selection_insertion.service.SortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

        try{ if(request==null || request.getCadena().isBlank()){
            ErrorResponse error= new ErrorResponse();
            error.setError("La peticion es incorrecta");
            error.setDetail("Necesitamos que llenes los datos");
            return ResponseEntity.badRequest().body(error);
        }


            String[] partes= request.getCadena().split(",");
            int [] numeros = new int[partes.length];
            for (int i = 0; i < partes.length; i++) {
                try {
                    numeros[i] = Integer.parseInt(partes[i]);
                } catch (IllegalArgumentException e) {
                    ErrorResponse error= new ErrorResponse();
                    error.setDetail("Dato incorrecto tiene que ser numerico" + numeros[i]);
                    error.setError(e.getMessage());
                    return ResponseEntity.badRequest().body(error);
                }
            }
            return ResponseEntity.ok(service.sort(numeros));
        }catch (RuntimeException e){

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ERROR: "+e.getMessage());
        }
        catch (Exception e){
            ErrorResponse error = new ErrorResponse();
            error.setError("Error General");
            error.setDetail(e.getMessage());
            return ResponseEntity.internalServerError().body(error);
        }




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
