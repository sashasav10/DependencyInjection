package com.savelievoleksandr.dependencyinjection.api

import org.koin.dsl.module

val ModuleService = module {
    factory { APIService().start() }
}