/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.todoapp.dao;

import com.todoapp.domain.Tarea;

import org.springframework.data.jpa.repository.JpaRepository;


public interface TareaDao extends JpaRepository<Tarea, Long> {

}
