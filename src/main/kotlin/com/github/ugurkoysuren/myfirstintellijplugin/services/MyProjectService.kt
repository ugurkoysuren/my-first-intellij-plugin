package com.github.ugurkoysuren.myfirstintellijplugin.services

import com.github.ugurkoysuren.myfirstintellijplugin.MyBundle
import com.intellij.openapi.project.Project

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
