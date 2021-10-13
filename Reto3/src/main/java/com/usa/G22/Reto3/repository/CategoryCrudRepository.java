/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.G22.Reto3.repository;



import com.usa.G22.Reto3.entities.Category;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author cktv
 */
public interface CategoryCrudRepository extends CrudRepository<Category, Integer>{
    
}
