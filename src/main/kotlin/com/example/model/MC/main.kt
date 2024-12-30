package com.example.model.MC

import com.example.model.MC.buildGraphFloor1
import com.example.model.MC.buildGraphFloor2
import com.example.model.MC.buildGraphFloor3
import com.example.model.MC.buildGraphFloor4
import com.example.model.MC.buildGraphFloor5
import com.example.model.MC.buildGraphFloor6

fun main() {
    val hallwaysFloor1 = buildGraphFloor1()
    val hallwaysFloor2 = buildGraphFloor2()
    val hallwaysFloor3 = buildGraphFloor3()
    val hallwaysFloor4 = buildGraphFloor4()
    val hallwaysFloor5 = buildGraphFloor5()
    val hallwaysFloor6 = buildGraphFloor6()

    // Combine all hallways into a single map
    val hallways: MutableMap<Int, HallwayNode> = mutableMapOf()
    hallways.putAll(hallwaysFloor1)
    hallways.putAll(hallwaysFloor2)
    hallways.putAll(hallwaysFloor3)
    hallways.putAll(hallwaysFloor4)
    hallways.putAll(hallwaysFloor5)
    hallways.putAll(hallwaysFloor6)

    // Create the classroom to hallway map
    val classroomToHallwayMap = createClassroomToHallwayMap(hallways)

    // Change these to the desired starting and ending classroom IDs
    val startClassroomId = 3035
    val endClassroomId = 3055
    val useElevator = false
    val toDC = true
    
    if (toDC == true) {
        if (startClassroomId.toString()[0].toString().toInt() == 3) {
            val nodeListMC = dijkstra(startClassroomId, 30, hallways, classroomToHallwayMap, useElevator)
            val dcNodes = listOf(2390, 2380, 2370, 2360, 2350, 2340)
            // Convert the list of IDs to a list of HallwayNode objects
            val hallwayNodesDC = dcNodes.map { HallwayNode(it) }
            val nodeList = nodeListMC + hallwayNodesDC
        }
    }
    else {
        val nodeList = dijkstra(startClassroomId, endClassroomId, hallways, classroomToHallwayMap, useElevator)
    }

    
}
