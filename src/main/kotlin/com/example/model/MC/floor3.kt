package com.example.model.MC
import com.example.model.MC.unit

fun buildGraphFloor3(): Map<Int, HallwayNode> {
    println("Floor 3 classrooms created")

    // Create hallway nodes
    val hallways = createHallways3()

    println("Floor 3 hallways created")

    // Connect hallways
    connectHallways3(hallways)

    println("Floor 3 hallways connected")

    // Set distances between hallways in the global distances map
    setDistances3(hallways)

    println("Floor 3 distances set")

    // Connect classrooms to hallways
    connectClassroomsToHallways3(hallways)

    println("Floor 3 classrooms connected \n")

    


    return hallways
}

fun createHallways3(): Map<Int, HallwayNode> {
    return (301..335).associateWith { HallwayNode(nodeId = it) }
}


fun setDistances3(hallways: Map<Int, HallwayNode>) {
    globalDistances[hallways[301]!! to hallways[302]!!] = 1 * unit
    globalDistances[hallways[302]!! to hallways[301]!!] = 1 * unit

    globalDistances[hallways[302]!! to hallways[303]!!] = 3 * unit
    globalDistances[hallways[303]!! to hallways[302]!!] = 3 * unit

    globalDistances[hallways[303]!! to hallways[304]!!] = 3 * unit
    globalDistances[hallways[304]!! to hallways[303]!!] = 3 * unit

    globalDistances[hallways[304]!! to hallways[305]!!] = 3 * unit
    globalDistances[hallways[305]!! to hallways[304]!!] = 3 * unit

    globalDistances[hallways[305]!! to hallways[306]!!] = 0.5 * unit
    globalDistances[hallways[306]!! to hallways[305]!!] = 0.5 * unit

    globalDistances[hallways[306]!! to hallways[307]!!] = 2 * unit
    globalDistances[hallways[307]!! to hallways[306]!!] = 2 * unit

    globalDistances[hallways[304]!! to hallways[308]!!] = 0.5 * unit
    globalDistances[hallways[308]!! to hallways[304]!!] = 0.5 * unit

    globalDistances[hallways[305]!! to hallways[309]!!] = 1.5 * unit
    globalDistances[hallways[309]!! to hallways[305]!!] = 1.5 * unit

    globalDistances[hallways[302]!! to hallways[310]!!] = 3.5 * unit
    globalDistances[hallways[310]!! to hallways[302]!!] = 3.5 * unit

    globalDistances[hallways[308]!! to hallways[311]!!] = 3 * unit
    globalDistances[hallways[311]!! to hallways[308]!!] = 3 * unit

    globalDistances[hallways[309]!! to hallways[312]!!] = 1.5 * unit
    globalDistances[hallways[312]!! to hallways[309]!!] = 1.5 * unit

    globalDistances[hallways[312]!! to hallways[313]!!] = 1.5 * unit
    globalDistances[hallways[313]!! to hallways[312]!!] = 1.5 * unit

    globalDistances[hallways[310]!! to hallways[314]!!] = 3.5 * unit
    globalDistances[hallways[314]!! to hallways[310]!!] = 3.5 * unit

    globalDistances[hallways[311]!! to hallways[315]!!] = 3.5 * unit
    globalDistances[hallways[315]!! to hallways[311]!!] = 3.5 * unit

    globalDistances[hallways[313]!! to hallways[316]!!] = 1.5 * unit
    globalDistances[hallways[316]!! to hallways[313]!!] = 1.5 * unit

    globalDistances[hallways[315]!! to hallways[317]!!] = 1.75 * unit
    globalDistances[hallways[317]!! to hallways[315]!!] = 1.75 * unit

    globalDistances[hallways[316]!! to hallways[318]!!] = 1.5 * unit
    globalDistances[hallways[318]!! to hallways[316]!!] = 1.5 * unit

    globalDistances[hallways[314]!! to hallways[319]!!] = 3.5 * unit
    globalDistances[hallways[319]!! to hallways[314]!!] = 3.5 * unit

    globalDistances[hallways[319]!! to hallways[331]!!] = 4 * unit
    globalDistances[hallways[331]!! to hallways[319]!!] = 4 * unit

    globalDistances[hallways[317]!! to hallways[320]!!] = 1.75 * unit
    globalDistances[hallways[320]!! to hallways[317]!!] = 1.75 * unit

    globalDistances[hallways[318]!! to hallways[321]!!] = 1.5 * unit
    globalDistances[hallways[321]!! to hallways[318]!!] = 1.5 * unit

    globalDistances[hallways[321]!! to hallways[322]!!] = 1.5 * unit
    globalDistances[hallways[322]!! to hallways[321]!!] = 1.5 * unit

    globalDistances[hallways[320]!! to hallways[323]!!] = 1 * unit
    globalDistances[hallways[323]!! to hallways[320]!!] = 1 * unit

    globalDistances[hallways[322]!! to hallways[324]!!] = 1 * unit
    globalDistances[hallways[324]!! to hallways[322]!!] = 1* unit

    globalDistances[hallways[323]!! to hallways[325]!!] = 0.5 * unit
    globalDistances[hallways[325]!! to hallways[323]!!] = 0.5 * unit

    globalDistances[hallways[324]!! to hallways[326]!!] = 1.5 * unit
    globalDistances[hallways[326]!! to hallways[324]!!] = 1.5 * unit

    globalDistances[hallways[325]!! to hallways[334]!!] = 2 * unit
    globalDistances[hallways[334]!! to hallways[325]!!] = 2 * unit

    globalDistances[hallways[326]!! to hallways[335]!!] = 1.5 * unit
    globalDistances[hallways[335]!! to hallways[326]!!] = 1.5 * unit

    globalDistances[hallways[327]!! to hallways[328]!!] = 1 * unit
    globalDistances[hallways[328]!! to hallways[327]!!] = 1 * unit

    globalDistances[hallways[328]!! to hallways[329]!!] = 0.5 * unit
    globalDistances[hallways[329]!! to hallways[328]!!] = 0.5 * unit

    globalDistances[hallways[329]!! to hallways[330]!!] = 0.5 * unit
    globalDistances[hallways[330]!! to hallways[329]!!] = 0.5 * unit

    globalDistances[hallways[330]!! to hallways[331]!!] = 0.5 * unit
    globalDistances[hallways[331]!! to hallways[330]!!] = 0.5 * unit

    globalDistances[hallways[331]!! to hallways[332]!!] = 3 * unit
    globalDistances[hallways[332]!! to hallways[331]!!] = 3 * unit

    globalDistances[hallways[332]!! to hallways[333]!!] = 2 * unit
    globalDistances[hallways[333]!! to hallways[332]!!] = 2 * unit

    globalDistances[hallways[333]!! to hallways[334]!!] = 1 * unit
    globalDistances[hallways[334]!! to hallways[333]!!] = 1 * unit

    globalDistances[hallways[334]!! to hallways[335]!!] = 3 * unit
    globalDistances[hallways[335]!! to hallways[334]!!] = 3 * unit
}



fun connectClassroomsToHallways3(hallways: Map<Int, HallwayNode>) {
    hallways[301]?.classrooms?.addAll(listOf(30121, 3012, 3072, 3089))
    hallways[302]?.classrooms?.addAll(listOf(3011, 30901, 3009, 3071))
    hallways[303]?.classrooms?.addAll(listOf(3009, 3115))
    hallways[304]?.classrooms?.add(3115)
    hallways[305]?.classrooms?.addAll(listOf(30151, 3016, 3091))
    hallways[306]?.classrooms?.add(3091)
    hallways[307]?.classrooms?.addAll(listOf(3074, 3093, 30)) //3 is dc link, 3074 is bathroom, 3093 is elevator
    hallways[308]?.classrooms?.addAll(listOf(3017, 3018))
    hallways[309]?.classrooms?.addAll(listOf(3068, 3066, 3067, 3065))
    hallways[310]?.classrooms?.addAll(listOf(3010, 30091))
    hallways[311]?.classrooms?.addAll(listOf(3018, 3022, 3061, 3026))
    hallways[312]?.classrooms?.addAll(listOf(3062, 3064))
    hallways[313]?.classrooms?.addAll(listOf(3060, 3059, 3058))
    hallways[314]?.classrooms?.addAll(listOf(3008, 3007, 3006, 3005))
    hallways[315]?.classrooms?.addAll(listOf(3022, 3026, 3027))
    hallways[316]?.classrooms?.addAll(listOf(3055, 3054, 3053, 3056))
    hallways[317]?.classrooms?.addAll(listOf(3029, 3030))
    hallways[318]?.classrooms?.addAll(listOf(3051, 3052, 3050))
    hallways[319]?.classrooms?.addAll(listOf(3006, 3004, 3005, 3003))
    hallways[320]?.classrooms?.addAll(listOf(3031, 3033))
    hallways[321]?.classrooms?.addAll(listOf(3047, 3048, 3045, 3046))
    hallways[322]?.classrooms?.addAll(listOf(3044, 3043))
    hallways[323]?.classrooms?.addAll(listOf(3034, 3003))
    hallways[324]?.classrooms?.add(3041)
    hallways[325]?.classrooms?.addAll(listOf(3035, 3036, 3003))
    hallways[326]?.classrooms?.addAll(listOf(3035, 3036, 3038))
    hallways[327]?.classrooms?.addAll(listOf(3082, 3069)) //3082 is an elevator
    hallways[328]?.classrooms?.add(3080)
    hallways[329]?.classrooms?.add(30842)
    hallways[330]?.classrooms?.add(3070)
    hallways[331]?.classrooms?.add(3001)
    hallways[332]?.classrooms?.add(3001)
    hallways[333]?.classrooms?.add(3096)
    hallways[334]?.classrooms?.add(3002)
    hallways[335]?.classrooms?.addAll(listOf(3075, 3095, 3002))
}


fun connectHallways3(hallways: Map<Int, HallwayNode>) {
    hallways[301]?.apply {
        south = hallways[302]

    }
    hallways[302]?.apply {
        north = hallways[301]
        east = hallways[303]
        south = hallways[310]
    }
    hallways[303]?.apply {
        east = hallways[304]
        west = hallways[302]
    }
    hallways[304]?.apply {
        east = hallways[303]
        west = hallways[305]
        south = hallways[308]
    }
    hallways[305]?.apply {
        south = hallways[309]
        east = hallways[304]
        west = hallways[306]
    }
    hallways[306]?.apply {
        east = hallways[305]
        west = hallways[307]
    }
    hallways[307]?.apply {
        west = hallways[306]
    }
    hallways[308]?.apply {
        north = hallways[304]
        south = hallways[311]
    }
    hallways[309]?.apply {
        north = hallways[305]
        south = hallways[312]
    }
    hallways[310]?.apply {
        north = hallways[302]
        south = hallways[314]
    }
    hallways[311]?.apply {
        north = hallways[308]
        south = hallways[315]
    }
    hallways[312]?.apply {
        north = hallways[309]
        south = hallways[313]
    }
    hallways[313]?.apply {
        north = hallways[312]
        south = hallways[316]
    }
    hallways[314]?.apply {
        north = hallways[310]
        south = hallways[319]
    }
    hallways[315]?.apply {
        north = hallways[311]
        south = hallways[317]
    }
    hallways[316]?.apply {
        north = hallways[313]
        south = hallways[318]
    }
    hallways[317]?.apply {
        north = hallways[315]
        south = hallways[320]
    }
    hallways[318]?.apply {
        north = hallways[316]
        south = hallways[321]
    }
    hallways[319]?.apply {
        north = hallways[314]
        south = hallways[331]
    }
    hallways[320]?.apply {
        north = hallways[317]
        south = hallways[323]
    }
    hallways[321]?.apply {
        north = hallways[318]
        south = hallways[322]
    }
    hallways[322]?.apply {
        north = hallways[321]
        south = hallways[324]
    }
    hallways[323]?.apply {
        north = hallways[320]
        south = hallways[325]
    }
    hallways[324]?.apply {
        north = hallways[322]
        south = hallways[326]
    }
    hallways[325]?.apply {
        north = hallways[323]
        south = hallways[334]
    }
    hallways[326]?.apply {
        north = hallways[324]
        south = hallways[335]
    }
    hallways[327]?.apply {
        east = hallways[328]
    }
    hallways[328]?.apply {
        west = hallways[327]
        east = hallways[329]
    }
    hallways[329]?.apply {
        east = hallways[328]
        west = hallways[330]
    }
    hallways[330]?.apply {
        east = hallways[331]
        west = hallways[329]
    }
    hallways[331]?.apply {
        north = hallways[319]
        east = hallways[332]
        west = hallways[330]
    }
    hallways[332]?.apply {
        east = hallways[333]
        west = hallways[331]
    }
    hallways[333]?.apply {
        east = hallways[334]
        west = hallways[332]
    }
    hallways[334]?.apply {
        north = hallways[325]
        east = hallways[335]
        west = hallways[333]
    }
    hallways[335]?.apply {
        north = hallways[326]
        west = hallways[334]
    }

}

fun createClassroomToHallwayMap3(hallways: Map<Int, HallwayNode>): Map<Int, List<Int>> {
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


