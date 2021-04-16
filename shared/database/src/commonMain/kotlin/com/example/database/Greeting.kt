package com.example.database

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}