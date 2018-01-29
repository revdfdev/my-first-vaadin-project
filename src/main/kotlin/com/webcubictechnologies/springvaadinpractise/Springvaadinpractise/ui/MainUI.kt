package com.webcubictechnologies.springvaadinpractise.Springvaadinpractise.ui

import com.vaadin.icons.VaadinIcons
import com.vaadin.server.VaadinRequest
import com.vaadin.spring.annotation.SpringUI
import com.vaadin.ui.*
import com.vaadin.ui.themes.ValoTheme
import com.webcubictechnologies.springvaadinpractise.Springvaadinpractise.views.TodoListLayout
import org.springframework.beans.factory.annotation.Autowired

@SpringUI
class MainUI : UI() {

    var root: VerticalLayout? = null

    @Autowired
    lateinit var todoListLayout: TodoListLayout

    override fun init(request: VaadinRequest?) {
        setUpLayout()
        addHeader()
        addForm()
        addTodoList()
        addDeleteButton()
    }

    fun setUpLayout() {
        root = VerticalLayout()
        root?.defaultComponentAlignment = Alignment.MIDDLE_CENTER
        content = root

    }

    fun addHeader() {
        val label = Label("Text Todos")
        label.styleName = ValoTheme.LABEL_H1
        root?.addComponent(label)
    }

    fun addForm() {
        val forlayout = HorizontalLayout()
        forlayout.setWidth("80%")
        val field = TextField()
        val button = Button("Add")
        button.addStyleName(ValoTheme.BUTTON_PRIMARY)
        button.icon = VaadinIcons.PLUS
        forlayout.addComponentsAndExpand(field, button)
        root?.addComponent(forlayout)
    }

    fun addTodoList() {
        todoListLayout.setWidth("80%")
        root?.addComponent(todoListLayout)
    }

    fun addDeleteButton() {
        root?.addComponent(Button("Delete Completed"))
    }

}