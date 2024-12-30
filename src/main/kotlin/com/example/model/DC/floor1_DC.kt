package com.example.wattravl.model.DC
import com.example.wattravl.model.MC.unit
import com.example.wattravl.model.MC.HallwayNode
import com.example.wattravl.model.MC.globalDistances

fun buildGraphFloor1(): Map<Int, HallwayNode> {
    println("Floor 1 classrooms created")

    // Create hallway nodes
    val hallways = createHallways1()

    println("Floor 1 hallways created")

    // Connect hallways
    connectHallways1(hallways)

    println("Floor 1 hallways connected")

    // Set distances between hallways in the global distances map
    setDistances1(hallways)

    println("Floor1 distances set")

    // Connect classrooms to hallways
    connectClassroomsToHallways1(hallways)

    println("Floor1 classrooms connected \n")

    


    return hallways
}

fun createHallways1(): Map<Int, HallwayNode> {
    return (1010..1340).associateWith { HallwayNode(nodeId = it) }
}

fun connectHallways1(hallways: Map<Int, HallwayNode>) {
    hallways[1010]?.apply {
        east = hallways[1020]
        south = hallways[1230]
    }

    hallways[1020]?.apply {
        west = hallways[1010]
        east = hallways[1030]
    }

    hallways[1030]?.apply {
        west = hallways[1020]
        east = hallways[1040]
    }

    hallways[1040]?.apply {
        west = hallways[1030]
        east = hallways[1120]
        north = hallways[1050]
        south = hallways[1330]
    }

    hallways[1050]?.apply {
        north = hallways[1060]
        south = hallways[1040]
    }

    hallways[1060]?.apply {
        north = hallways[1070]
        south = hallways[1050]
    }

    hallways[1070]?.apply {
        north = hallways[1080]
        south = hallways[1060]
    }

    hallways[1080]?.apply {
        north = hallways[1090]
        south = hallways[1070]
    }

    hallways[1090]?.apply {
        north = hallways[1100]
        south = hallways[1080]
    }

    hallways[1100]?.apply {
        north = hallways[1110]
        south = hallways[1090]
    }

    hallways[1110]?.apply {
        south = hallways[1100]
    }

    hallways[1120]?.apply {
        west = hallways[1040]
        south = hallways[1130]
    }

    hallways[1130]?.apply {
        north = hallways[1120]
        south = hallways[1140]
    }

    hallways[1140]?.apply {
        north = hallways[1130]
        south = hallways[1150]
    }

    hallways[1150]?.apply {
        north = hallways[1140]
        south = hallways[1160]
    }

    hallways[1160]?.apply {
        north = hallways[1150]
        south = hallways[1170]
    }

    hallways[1170]?.apply {
        north = hallways[1160]
        south = hallways[1180]
    }

    hallways[1180]?.apply {
        north = hallways[1170]
        south = hallways[1190]
        west = hallways[1300]
    }

    hallways[1190]?.apply {
        north = hallways[1180]
        south = hallways[1200]
    }

    hallways[1200]?.apply {
        north = hallways[1190]
        south = hallways[1210]
    }

    hallways[1210]?.apply {
        north = hallways[1200]
        south = hallways[1220]
    }

    hallways[1220]?.apply {
        north = hallways[1210]
    }

    hallways[1230]?.apply {
        west = hallways[1240]
        north = hallways[1010]
    }

    hallways[1240]?.apply {
        east = hallways[1230]
        south = hallways[1250]
    }

    hallways[1250]?.apply {
        north = hallways[1240]
        south = hallways[1260]
    }

    hallways[1260]?.apply {
        north = hallways[1250]
        east = hallways[1270]
    }

    hallways[1270]?.apply {
        west = hallways[1260]
        east = hallways[1280]
    }

    hallways[1280]?.apply {
        west = hallways[1270]
        east = hallways[1290]
    }

    hallways[1290]?.apply {
        west = hallways[1280]
        east = hallways[1300]
    }

    hallways[1300]?.apply {
        north = hallways[1310]
        west = hallways[1290]
        east = hallways[1180]
    }

    hallways[1310]?.apply {
        north = hallways[1320]
        south = hallways[1300]
    }

    hallways[1320]?.apply {
        north = hallways[1330]
        south = hallways[1310]
    }

    hallways[1330]?.apply {
        north = hallways[1040]
        west = hallways[1340]
    }

    hallways[1340]?.apply {
        east = hallways[1330]
        north = hallways[1030]
    }
}


fun setDistances1(hallways: Map<Int, HallwayNode>) {
    globalDistances[hallways[1010]!! to hallways[1020]!!] = 1 * unit
    globalDistances[hallways[1020]!! to hallways[1010]!!] = 1 * unit

    globalDistances[hallways[1020]!! to hallways[1030]!!] = 3 * unit
    globalDistances[hallways[1030]!! to hallways[1020]!!] = 3 * unit

    globalDistances[hallways[1030]!! to hallways[1040]!!] = 1.5 * unit
    globalDistances[hallways[1040]!! to hallways[1030]!!] = 1.5 * unit

    globalDistances[hallways[1040]!! to hallways[1050]!!] = 1 * unit
    globalDistances[hallways[1050]!! to hallways[1040]!!] = 1 * unit

    globalDistances[hallways[1050]!! to hallways[1060]!!] = 1 * unit
    globalDistances[hallways[1060]!! to hallways[1050]!!] = 1 * unit

    globalDistances[hallways[1060]!! to hallways[1070]!!] = 1.5 * unit
    globalDistances[hallways[1070]!! to hallways[1060]!!] = 1.5 * unit

    globalDistances[hallways[1070]!! to hallways[1080]!!] = 2 * unit
    globalDistances[hallways[1080]!! to hallways[1070]!!] = 2 * unit

    globalDistances[hallways[1080]!! to hallways[1090]!!] = 2 * unit
    globalDistances[hallways[1090]!! to hallways[1080]!!] = 2 * unit

    globalDistances[hallways[1090]!! to hallways[1100]!!] = 2 * unit
    globalDistances[hallways[1100]!! to hallways[1090]!!] = 2 * unit

    globalDistances[hallways[1100]!! to hallways[1110]!!] = 2 * unit
    globalDistances[hallways[1110]!! to hallways[1100]!!] = 2 * unit

    globalDistances[hallways[1120]!! to hallways[1040]!!] = 1 * unit
    globalDistances[hallways[1040]!! to hallways[1120]!!] = 1 * unit

    globalDistances[hallways[1120]!! to hallways[1130]!!] = 1.5 * unit
    globalDistances[hallways[1130]!! to hallways[1120]!!] = 1.5 * unit

    globalDistances[hallways[1130]!! to hallways[1140]!!] = 1 * unit
    globalDistances[hallways[1140]!! to hallways[1130]!!] = 1 * unit

    globalDistances[hallways[1140]!! to hallways[1150]!!] = 1 * unit
    globalDistances[hallways[1150]!! to hallways[1140]!!] = 1 * unit

    globalDistances[hallways[1150]!! to hallways[1160]!!] = 1 * unit
    globalDistances[hallways[1160]!! to hallways[1150]!!] = 1 * unit

    globalDistances[hallways[1160]!! to hallways[1170]!!] = 1 * unit
    globalDistances[hallways[1170]!! to hallways[1160]!!] = 1 * unit

    globalDistances[hallways[1170]!! to hallways[1180]!!] = 1 * unit
    globalDistances[hallways[1180]!! to hallways[1170]!!] = 1 * unit

    globalDistances[hallways[1180]!! to hallways[1190]!!] = 1 * unit
    globalDistances[hallways[1190]!! to hallways[1180]!!] = 1 * unit

    globalDistances[hallways[1190]!! to hallways[1200]!!] = 1 * unit
    globalDistances[hallways[1200]!! to hallways[1190]!!] = 1 * unit

    globalDistances[hallways[1200]!! to hallways[1210]!!] = 1 * unit
    globalDistances[hallways[1210]!! to hallways[1200]!!] = 1 * unit

    globalDistances[hallways[1210]!! to hallways[1220]!!] = 1 * unit
    globalDistances[hallways[1220]!! to hallways[1210]!!] = 1 * unit

    globalDistances[hallways[1230]!! to hallways[1240]!!] = 1 * unit
    globalDistances[hallways[1240]!! to hallways[1230]!!] = 1 * unit

    globalDistances[hallways[1230]!! to hallways[1010]!!] = 2 * unit
    globalDistances[hallways[1010]!! to hallways[1230]!!] = 2 * unit

    globalDistances[hallways[1240]!! to hallways[1250]!!] = 4 * unit
    globalDistances[hallways[1250]!! to hallways[1240]!!] = 4 * unit

    globalDistances[hallways[1250]!! to hallways[1260]!!] = 1 * unit
    globalDistances[hallways[1260]!! to hallways[1250]!!] = 1 * unit

    globalDistances[hallways[1260]!! to hallways[1270]!!] = 2 * unit
    globalDistances[hallways[1270]!! to hallways[1260]!!] = 2 * unit

    globalDistances[hallways[1270]!! to hallways[1280]!!] = 2 * unit
    globalDistances[hallways[1280]!! to hallways[1270]!!] = 2 * unit

    globalDistances[hallways[1280]!! to hallways[1290]!!] = 1 * unit
    globalDistances[hallways[1290]!! to hallways[1280]!!] = 1 * unit

    globalDistances[hallways[1290]!! to hallways[1300]!!] = 1 * unit
    globalDistances[hallways[1300]!! to hallways[1290]!!] = 1 * unit

    globalDistances[hallways[1300]!! to hallways[1310]!!] = 2.5 * unit
    globalDistances[hallways[1310]!! to hallways[1300]!!] = 2.5 * unit

    globalDistances[hallways[1310]!! to hallways[1320]!!] = 1.5 * unit
    globalDistances[hallways[1320]!! to hallways[1310]!!] = 1.5 * unit

    globalDistances[hallways[1320]!! to hallways[1330]!!] = 1.5 * unit
    globalDistances[hallways[1330]!! to hallways[1320]!!] = 1.5 * unit

    globalDistances[hallways[1330]!! to hallways[1040]!!] = 1 * unit
    globalDistances[hallways[1040]!! to hallways[1330]!!] = 1 * unit

    globalDistances[hallways[1330]!! to hallways[1340]!!] = 1 * unit
    globalDistances[hallways[1340]!! to hallways[1330]!!] = 1 * unit

    globalDistances[hallways[1340]!! to hallways[1030]!!] = 1 * unit
    globalDistances[hallways[1030]!! to hallways[1340]!!] = 1 * unit
}

fun connectClassroomsToHallways1(hallways: Map<Int, HallwayNode>) {
    hallways[1010]?.classrooms?.addAll(listOf(18411, 184110))  // 18411 is stair, 184110 is exit
    hallways[1020]?.classrooms?.addAll(listOf(1818, 18415, 13511, 1351, 13512, 13513, 13514, 13516, 13517)) // 1818 is elevator
    hallways[1030]?.classrooms?.addAll(listOf(18416, 18412, 13511, 1351, 13512, 13513, 13514, 13516, 13517)) // 18412 is stair 
    hallways[1040]?.classrooms?.add(18417)
    hallways[1050]?.classrooms?.addAll(listOf(18522, 1940)) 
    hallways[1060]?.classrooms?.addAll(listOf(1942, 1941, 19411)) 
    hallways[1070]?.classrooms?.addAll(listOf(19421, 1943, 19432, 1944, 1945)) 
    //hallways[1080]?.classrooms?.add(2807) // stair
    hallways[1090]?.classrooms?.add(1101)
    hallways[1100]?.classrooms?.add(18521) // stair
    //hallways[1110]?.classrooms?.addAll(listOf(2605, 2602)) 
    hallways[1120]?.classrooms?.addAll(listOf(1307, 1937)) 
    hallways[1130]?.classrooms?.addAll(listOf(1308, 1309)) 
    hallways[1140]?.classrooms?.addAll(listOf(1310, 1311)) 
    hallways[1150]?.classrooms?.addAll(listOf(1312, 1313))
    hallways[1160]?.classrooms?.addAll(listOf(1314, 1315, 1401, 1936))
    hallways[1170]?.classrooms?.addAll(listOf(1316, 1317))
    //hallways[1180]?.classrooms?.add(2807) // stair 
    hallways[1190]?.classrooms?.addAll(listOf(1330, 1331, 1332))
    hallways[1200]?.classrooms?.add(1334)  
    hallways[1210]?.classrooms?.addAll(listOf(1333, 1336, 1339)) 
    hallways[1220]?.classrooms?.addAll(listOf(1343, 1340)) 
    //hallways[1230]?.classrooms?.addAll(listOf(2930, 2818)) // 2818 is elevator 
    //hallways[1240]?.classrooms?.addAll(listOf(2040, 2078)) 
    hallways[1250]?.classrooms?.add(1820) // library
    hallways[1260]?.classrooms?.add(18427) // exit 
    hallways[1270]?.classrooms?.addAll(listOf(18421, 18425, 13505, 1350, 13501, 13502, 13503, 13504, 13506, 13507)) // 18421 is stair 
    //hallways[1280]?.classrooms?.addAll(listOf(2040, 2078)) 
    hallways[1290]?.classrooms?.addAll(listOf(18426, 1350, 13502, 13503, 13504, 13506, 13507)) 
    hallways[1300]?.classrooms?.add(18422) // stair
    //hallways[1310]?.classrooms?.addAll(listOf(2112, 2114, 2113, 2111)) 
    hallways[1320]?.classrooms?.addAll(listOf(1934, 1935, 1302)) // 1934, 1935 is washroom
    hallways[1330]?.classrooms?.add(1302) 
    hallways[1340]?.classrooms?.add(1303) 
}

fun createClassroomToHallwayMap1(hallways: Map<Int, HallwayNode>): Map<Int, List<Int>> {
    val map = mutableMapOf<Int, MutableList<Int>>()
    hallways.forEach { (hallwayId, hallway) ->
        hallway.classrooms.forEach { classroomId ->
            if (map.containsKey(classroomId)) {
                map[classroomId]?.add(hallwayId)
            } else {
                map[classroomId] = mutableListOf(hallwayId)
            }
        }
    }
    return map
}

