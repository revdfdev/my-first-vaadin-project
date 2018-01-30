package com.webcubictechnologies.springvaadinpractise.Springvaadinpractise.repository

import com.webcubictechnologies.springvaadinpractise.Springvaadinpractise.models.Todo
import org.springframework.data.jpa.repository.JpaRepository

interface TodoRepository: JpaRepository<Todo, Long> {

}