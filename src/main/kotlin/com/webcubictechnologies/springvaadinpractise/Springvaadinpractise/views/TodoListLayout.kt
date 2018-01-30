package com.webcubictechnologies.springvaadinpractise.Springvaadinpractise.views

import com.vaadin.spring.annotation.SpringComponent
import com.vaadin.ui.VerticalLayout
import com.webcubictechnologies.springvaadinpractise.Springvaadinpractise.models.Todo
import com.webcubictechnologies.springvaadinpractise.Springvaadinpractise.repository.TodoRepository
import org.springframework.beans.factory.annotation.Autowired
import javax.annotation.PostConstruct

@SpringComponent
class TodoListLayout : VerticalLayout() {

    @Autowired
    lateinit var todoRepository: TodoRepository

    @PostConstruct
    fun init() {
        update()
    }

    private fun update() {
        setTodos(todoRepository.findAll())
    }

    private fun setTodos(todos: List<Todo>) {
        removeAllComponents()
        todos.forEach {
            val todoListItemLayout = TodoListItemLayout(it)
            todoListItemLayout.bind()
            addComponent(todoListItemLayout)
        }
    }

    fun addTodos(todo: Todo) {
        todoRepository.save(todo)
        update()
    }
}