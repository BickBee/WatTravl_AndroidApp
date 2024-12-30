package com.example.wattravl.model.DC

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.wattravl.model.DC.buildGraphFloor1
import com.example.wattravl.model.DC.buildGraphFloor2
import com.example.wattravl.model.DC.buildGraphFloor3
import com.example.wattravl.model.MC.unit
import com.example.wattravl.model.MC.HallwayNode
import com.example.wattravl.model.MC.globalDistances

@RequiresApi(Build.VERSION_CODES.N)
fun dc_pathing():List<List<HallwayNode>> {
    val hallwaysFloor1 = buildGraphFloor1()
    val hallwaysFloor2 = buildGraphFloor2()
    val hallwaysFloor3 = buildGraphFloor3()

    // Combine all hallways into a single map
    val hallways: MutableMap<Int, HallwayNode> = mutableMapOf()
    hallways.putAll(hallwaysFloor1)
    hallways.putAll(hallwaysFloor2)
    hallways.putAll(hallwaysFloor3)

    // Create the classroom to hallway map
    val classroomToHallwayMap = createClassroomToHallwayMap(hallways)

    // Change these to the desired starting and ending classroom IDs
    val startClassroomId = 2643
    val enDClassroomId = 3853
    val useElevator = false

    return dijkstra(startClassroomId, enDClassroomId, hallways, classroomToHallwayMap, useElevator)

}
