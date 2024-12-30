package com.example.model

import com.example.model.DC.dc_pathing
import com.example.model.MC.mc_pathing

fun main() {

    val startClassroomId = 1070
    val enDClassroomId = 2323
    val useElevator = false
    val startBuilding = "MC"
    val endBuilding = "DC"
    if (startBuilding == endBuilding) {
        if (startBuilding.equals("MC")) {
            mc_pathing(startClassroomId, enDClassroomId, useElevator)
        } else {
            dc_pathing(startClassroomId, enDClassroomId, useElevator)
        }
    } else {
        if (startBuilding.equals("MC")) {
            mc_pathing(startClassroomId, 30, useElevator) + dc_pathing(3853, enDClassroomId, useElevator)
        } else {
            dc_pathing(startClassroomId, 3853, useElevator) + mc_pathing(30, enDClassroomId, useElevator)
        }
    }
}
