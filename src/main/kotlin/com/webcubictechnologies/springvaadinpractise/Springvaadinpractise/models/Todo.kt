package com.webcubictechnologies.springvaadinpractise.Springvaadinpractise.models

import java.time.Instant
import java.util.*
import javax.persistence.*

@Entity
data class Todo(

        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = 0,

        val task: String = "",

        val done: Boolean = false,

        val createdOn: Date = Date.from(Instant.now()),

        @Column(unique = false, nullable = true)
        var completedOn: Date? = null
)