package com.example.model.MC
import com.example.model.MC.unit

fun buildGraphFloor2(): Map<Int, HallwayNode> {
    println("Floor2 classrooms created")

    // Create hallway nodes
    val hallways = createHallways2()

    println("Floor 2 hallways created")

    // Connect hallways
    connectHallways2(hallways)

    println("Floor 2 hallways connected")

    // Set distances between hallways in the global distances map
    setDistances2(hallways)

    println("Floor 2 distances set")

    // Connect classrooms to hallways
    connectClassroomsToHallways2(hallways)

    println("Floor 2 classrooms connected \n")

    


    return hallways
}

fun createHallways2(): Map<Int, HallwayNode> {
    return (201..243).associateWith { HallwayNode(nodeId = it) }
}

fun connectClassroomsToHallways2(hallways: Map<Int, HallwayNode>) {
    hallways[202]?.classrooms?.add(2074) //staircase
    hallways[203]?.classrooms?.addAll(listOf(2039, 2077)) //2077 is a staircase 2039 is outside
    hallways[204]?.classrooms?.addAll(listOf(2040, 2078)) //2078 is an elevator
    hallways[205]?.classrooms?.addAll(listOf(2029, 2031))
    hallways[206]?.classrooms?.addAll(listOf(2034, 2036))
    hallways[207]?.classrooms?.addAll(listOf(2034, 2035, 20361))
    hallways[208]?.classrooms?.addAll(listOf(2086, 2037))
    hallways[209]?.classrooms?.addAll(listOf(2035, 2038))
    hallways[210]?.classrooms?.add(20371)
    hallways[211]?.classrooms?.add(2038)
    hallways[212]?.classrooms?.addAll(listOf(2042, 2041))
    hallways[213]?.classrooms?.addAll(listOf(2027, 2025))
    hallways[214]?.classrooms?.addAll(listOf(2044, 2045, 2018, 2047))
    hallways[215]?.classrooms?.addAll(listOf(2020, 2021, 2024, 2025))
    hallways[216]?.classrooms?.addAll(listOf(2048, 2050))
    hallways[217]?.classrooms?.addAll(listOf(2019, 2020))
    hallways[218]?.classrooms?.addAll(listOf(20181, 2015, 2017))
    hallways[219]?.classrooms?.addAll(listOf(20182, 2017, 2023))
    hallways[220]?.classrooms?.add(2054)
    hallways[221]?.classrooms?.addAll(listOf(2018, 2054))
    hallways[223]?.classrooms?.addAll(listOf(2052, 2053))
    hallways[223]?.classrooms?.add(2016)
    hallways[224]?.classrooms?.addAll(listOf(2055, 2056))
    hallways[225]?.classrooms?.addAll(listOf(2016, 2010))
    hallways[226]?.classrooms?.addAll(listOf(2014, 2015, 2009))
    hallways[227]?.classrooms?.add(2057)
    hallways[228]?.classrooms?.addAll(listOf(2008, 2009))
    hallways[229]?.classrooms?.addAll(listOf(2058, 2060))
    hallways[230]?.classrooms?.add(2007)
    hallways[231]?.classrooms?.addAll(listOf(2002, 2003, 2004, 2005, 2006))
    hallways[232]?.classrooms?.add(2059)
    hallways[233]?.classrooms?.addAll(listOf(2070, 2001)) //2070 is an elevaror
    hallways[234]?.classrooms?.add(2068)
    hallways[236]?.classrooms?.add(20011)
    hallways[237]?.classrooms?.add(2093)
    hallways[238]?.classrooms?.addAll(listOf(2063, 2066))
    hallways[239]?.classrooms?.addAll(listOf(2062, 2066))
    hallways[240]?.classrooms?.addAll(listOf(2062, 2085, 2061))
    hallways[241]?.classrooms?.addAll(listOf(2060, 2065))
    hallways[242]?.classrooms?.add(2065)
    hallways[243]?.classrooms?.addAll(listOf(2064, 2099)) //2099 are stairs
}


fun connectHallways2(hallways: Map<Int, HallwayNode>) {
   hallways[201]?.apply {
       south = hallways[202]
   }
  
   hallways[202]?.apply {
       north = hallways[201]
       south = hallways[205]
   }
   hallways[203]?.apply {
       south = hallways[212]
       east = hallways[204]
   }
   hallways[204]?.apply {
       west = hallways[203]
   }
   hallways[205]?.apply {
       east = hallways[206]
       north = hallways[202]
   }
   hallways[206]?.apply {
       west = hallways[205]
       east = hallways[207]
   }
   hallways[207]?.apply {
       west = hallways[206]
       east = hallways[208]
   }
   hallways[208]?.apply {
       west = hallways[207]
       south = hallways[209]
   }
   hallways[209]?.apply {
       west = hallways[208]
       east = hallways[210]
   }
   hallways[210]?.apply {
       west = hallways[209]
       east = hallways[211]
   }
   hallways[211]?.apply {
       west = hallways[210]
       east = hallways[212]
   }
   hallways[212]?.apply {
       west = hallways[211]
       north = hallways[203]
       south = hallways[214]
   }
   hallways[213]?.apply {
       north = hallways[205]
       south = hallways[215]
   }
   hallways[214]?.apply {
       north = hallways[212]
       south = hallways[216]
   }
   hallways[215]?.apply {
       north = hallways[213]
       south = hallways[217]
   }
   hallways[216]?.apply {
       north = hallways[214]
       south = hallways[222]
   }
   hallways[217]?.apply {
       north = hallways[215]
       east = hallways[218]
       south = hallways[223]
   }
   hallways[218]?.apply {
       west = hallways[217]
       east = hallways[219]
   }
   hallways[219]?.apply {
       west = hallways[218]
       east = hallways[220]
   }
   hallways[220]?.apply {
       west = hallways[219]
       east = hallways[221]
   }
   hallways[221]?.apply {
       west = hallways[220]
       east = hallways[222]
   }
   hallways[222]?.apply {
       north = hallways[216]
       south = hallways[224]
       west = hallways[221]
   }
   hallways[223]?.apply {
       north = hallways[217]
       south = hallways[225]
   }
   hallways[224]?.apply {
       north = hallways[222]
       south = hallways[227]
   }
   hallways[225]?.apply {
       north = hallways[223]
       south = hallways[228]
       east = hallways[226]
   }
   hallways[226]?.apply {
       west = hallways[225]
   }
   hallways[227]?.apply {
       north = hallways[224]
       south = hallways[229]
   }
   hallways[228]?.apply {
       north = hallways[225]
       south = hallways[230]
   }
   hallways[229]?.apply {
       north = hallways[227]
       south = hallways[232]
   }
   hallways[230]?.apply {
       north = hallways[228]
       south = hallways[235]
       east = hallways[231]
   }
   hallways[231]?.apply {
       west = hallways[230]
   }
   hallways[232]?.apply {
       north = hallways[229]
       south = hallways[243]
   }
   hallways[233]?.apply {
       east = hallways[234]
   }
   hallways[234]?.apply {
       west = hallways[233]
       east = hallways[235]
   }
   hallways[235]?.apply {
       north = hallways[230]
       south = hallways[236]
       west = hallways[234]
   }
   hallways[236]?.apply {
       north = hallways[235]
       east = hallways[237]
   }
   hallways[237]?.apply {
       west = hallways[236]
       east = hallways[238]
   }
   hallways[238]?.apply {
       west = hallways[237]
       east = hallways[239]
   }
   hallways[239]?.apply {
       west = hallways[238]
       east = hallways[240]
   }
   hallways[240]?.apply {
       west = hallways[239]
       east = hallways[240]
   }
   hallways[241]?.apply {
       west = hallways[240]
       east = hallways[242]
   }
   hallways[242]?.apply {
       west = hallways[241]
       east = hallways[243]
   }
   hallways[243]?.apply {
       north = hallways[232]
       west = hallways[242]
   }
}

fun setDistances2(hallways: Map<Int, HallwayNode>) {
    globalDistances[hallways[201]!! to hallways[202]!!] = 1.5 * unit
    globalDistances[hallways[202]!! to hallways[201]!!] = 1.5 * unit

    globalDistances[hallways[202]!! to hallways[205]!!] = 1.5 * unit
    globalDistances[hallways[205]!! to hallways[202]!!] = 1.5 * unit

    globalDistances[hallways[203]!! to hallways[212]!!] = 0.5 * unit
    globalDistances[hallways[212]!! to hallways[203]!!] = 0.5 * unit

    globalDistances[hallways[204]!! to hallways[203]!!] = 3 * unit
    globalDistances[hallways[203]!! to hallways[204]!!] = 3 * unit

    globalDistances[hallways[205]!! to hallways[206]!!] = 1.5 * unit
    globalDistances[hallways[206]!! to hallways[205]!!] = 1.5 * unit

    globalDistances[hallways[206]!! to hallways[207]!!] = 1.5 * unit
    globalDistances[hallways[207]!! to hallways[206]!!] = 1.5 * unit

    globalDistances[hallways[207]!! to hallways[208]!!] = 1.5 * unit
    globalDistances[hallways[208]!! to hallways[207]!!] = 1.5 * unit

    globalDistances[hallways[208]!! to hallways[209]!!] = 1.5 * unit
    globalDistances[hallways[209]!! to hallways[208]!!] = 1.5 * unit

    globalDistances[hallways[209]!! to hallways[210]!!] = 1.5 * unit
    globalDistances[hallways[210]!! to hallways[209]!!] = 1.5 * unit

    globalDistances[hallways[210]!! to hallways[211]!!] = 1.0 * unit
    globalDistances[hallways[211]!! to hallways[210]!!] = 1.0 * unit

    globalDistances[hallways[211]!! to hallways[212]!!] = 0.5 * unit
    globalDistances[hallways[212]!! to hallways[211]!!] = 0.5 * unit

    globalDistances[hallways[213]!! to hallways[205]!!] = 1.5 * unit
    globalDistances[hallways[205]!! to hallways[213]!!] = 1.5 * unit

    globalDistances[hallways[213]!! to hallways[215]!!] = 1.5 * unit
    globalDistances[hallways[215]!! to hallways[213]!!] = 1.5 * unit

    globalDistances[hallways[214]!! to hallways[212]!!] = 1.5 * unit
    globalDistances[hallways[212]!! to hallways[214]!!] = 1.5 * unit

    globalDistances[hallways[214]!! to hallways[216]!!] = 1.5 * unit
    globalDistances[hallways[216]!! to hallways[214]!!] = 1.5 * unit

    globalDistances[hallways[215]!! to hallways[217]!!] = 1.5 * unit
    globalDistances[hallways[217]!! to hallways[215]!!] = 1.5 * unit

    globalDistances[hallways[216]!! to hallways[222]!!] = 1.5 * unit
    globalDistances[hallways[222]!! to hallways[216]!!] = 1.5 * unit

    globalDistances[hallways[217]!! to hallways[218]!!] = 1 * unit
    globalDistances[hallways[218]!! to hallways[217]!!] = 1 * unit

    globalDistances[hallways[217]!! to hallways[223]!!] = 1.5 * unit
    globalDistances[hallways[223]!! to hallways[217]!!] = 1.5 * unit

    globalDistances[hallways[218]!! to hallways[219]!!] = 3 * unit
    globalDistances[hallways[219]!! to hallways[218]!!] = 3 * unit

    globalDistances[hallways[219]!! to hallways[220]!!] = 1.5 * unit
    globalDistances[hallways[220]!! to hallways[219]!!] = 1.5 * unit

    globalDistances[hallways[220]!! to hallways[221]!!] = 2 * unit
    globalDistances[hallways[221]!! to hallways[220]!!] = 2 * unit

    globalDistances[hallways[221]!! to hallways[222]!!] = 1.5 * unit
    globalDistances[hallways[222]!! to hallways[221]!!] = 1.5 * unit

    globalDistances[hallways[222]!! to hallways[224]!!] = 1.5 * unit
    globalDistances[hallways[224]!! to hallways[222]!!] = 1.5 * unit

    globalDistances[hallways[223]!! to hallways[225]!!] = 1.5 * unit
    globalDistances[hallways[225]!! to hallways[223]!!] = 1.5 * unit

    globalDistances[hallways[224]!! to hallways[227]!!] = 1.5 * unit
    globalDistances[hallways[227]!! to hallways[224]!!] = 1.5 * unit

    globalDistances[hallways[225]!! to hallways[226]!!] = 1 * unit
    globalDistances[hallways[226]!! to hallways[225]!!] = 1 * unit

    globalDistances[hallways[225]!! to hallways[228]!!] = 2 * unit
    globalDistances[hallways[228]!! to hallways[225]!!] = 2 * unit

    globalDistances[hallways[227]!! to hallways[229]!!] = 1.5 * unit
    globalDistances[hallways[229]!! to hallways[227]!!] = 1.5 * unit

    globalDistances[hallways[228]!! to hallways[230]!!] = 1.5 * unit
    globalDistances[hallways[230]!! to hallways[228]!!] = 1.5 * unit

    globalDistances[hallways[229]!! to hallways[232]!!] = 1.5 * unit
    globalDistances[hallways[232]!! to hallways[229]!!] = 1.5 * unit

    globalDistances[hallways[230]!! to hallways[231]!!] = 1 * unit
    globalDistances[hallways[231]!! to hallways[230]!!] = 1 * unit

    globalDistances[hallways[230]!! to hallways[235]!!] = 1 * unit
    globalDistances[hallways[235]!! to hallways[230]!!] = 1 * unit

    globalDistances[hallways[232]!! to hallways[243]!!] = 2.5 * unit
    globalDistances[hallways[243]!! to hallways[232]!!] = 2.5 * unit

    globalDistances[hallways[233]!! to hallways[234]!!] = 1.5 * unit
    globalDistances[hallways[234]!! to hallways[233]!!] = 1.5 * unit

    globalDistances[hallways[234]!! to hallways[235]!!] = 0.5  * unit
    globalDistances[hallways[235]!! to hallways[234]!!] = 0.5 * unit

    globalDistances[hallways[235]!! to hallways[236]!!] = 1.5 * unit
    globalDistances[hallways[236]!! to hallways[235]!!] = 1.5 * unit

    globalDistances[hallways[236]!! to hallways[237]!!] = 1 * unit
    globalDistances[hallways[237]!! to hallways[236]!!] = 1 * unit

    globalDistances[hallways[237]!! to hallways[238]!!] = 1.5 * unit
    globalDistances[hallways[238]!! to hallways[237]!!] = 1.5 * unit

    globalDistances[hallways[238]!! to hallways[239]!!] = 1.5 * unit
    globalDistances[hallways[239]!! to hallways[238]!!] = 1.5 * unit

    globalDistances[hallways[239]!! to hallways[240]!!] = 1.5 * unit
    globalDistances[hallways[240]!! to hallways[239]!!] = 1.5 * unit

    globalDistances[hallways[240]!! to hallways[241]!!] = 1.5 * unit
    globalDistances[hallways[241]!! to hallways[240]!!] = 1.5 * unit

    globalDistances[hallways[241]!! to hallways[242]!!] = 1.5 * unit
    globalDistances[hallways[242]!! to hallways[241]!!] = 1.5 * unit

    globalDistances[hallways[242]!! to hallways[243]!!] = 0.5 * unit
    globalDistances[hallways[243]!! to hallways[242]!!] = 0.5 * unit
}




fun createClassroomToHallwayMap2(hallways: Map<Int, HallwayNode>): Map<Int, List<Int>> {
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


