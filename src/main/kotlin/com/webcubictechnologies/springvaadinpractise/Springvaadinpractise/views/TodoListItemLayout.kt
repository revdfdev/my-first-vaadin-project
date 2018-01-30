package com.webcubictechnologies.springvaadinpractise.Springvaadinpractise.views

import com.vaadin.data.Binder
import com.vaadin.event.MouseEvents
import com.vaadin.ui.*
import com.vaadin.ui.themes.ValoTheme
import com.webcubictechnologies.springvaadinpractise.Springvaadinpractise.models.Todo


class TodoListItemLayout(val todo: Todo) : HorizontalLayout() {

    val done = CheckBox()
    val task = TextField()

    init {
        task.addStyleName(ValoTheme.TEXTFIELD_BORDERLESS)
        addComponents(done)
        addComponentsAndExpand(task)
        done.isEnabled = true
        done.isResponsive = true
        done.isRequiredIndicatorVisible = true
        defaultComponentAlignment = Alignment.MIDDLE_LEFT
        val binder = Binder<Todo>(Todo::class.java)
        binder.bindInstanceFields(this)
        binder.bean = todo
    }

    fun bind() {
    }
}