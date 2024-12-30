package com.example.model.MC

import java.util.PriorityQueue

val staircases = mapOf(
    1 to listOf(1099, 1106, 1096, 1091),
    2 to listOf(2077, 2099, 2074, 2068),
    3 to listOf(3091, 3095, 3089, 3080),
    4 to listOf(4111, 4122, 4108, 4101),
    5 to listOf(5808, 5813, 5806, 5801),
    6 to listOf(6808, 6813, 6806, 6801)
)

val elevators = mapOf(
    1 to listOf(1100, 1092),
    2 to listOf(2078, 2070),
    3 to listOf(3093, 3082),
    4 to listOf(4115, 4104),
    5 to listOf(5811, 5803),
    6 to listOf(6811, 6803)
)

fun findFloor(number: Int): Int {
    val numberStr = number.toString()
    return numberStr[0].toString().toInt()
}

fun findCorrespondingTransition(startingTransition: Int, endingFloor: Int, useElevator: Boolean): Int? {
    val transitions = if (useElevator) elevators else staircases

    // Find the index of the startingTransition in its corresponding floor list
    val startFloorIndex = transitions.values.indexOfFirst { it.contains(startingTransition) }
    
    // If the startingTransition is found in one of the floor lists
    if (startFloorIndex != -1) {
        // Get the list of transitions for the starting floor
        val startTransitions = transitions[startFloorIndex + 1]
        
        // Find the index of the startingTransition in its list
        val transitionIndex = startTransitions?.indexOf(startingTransition)
        
        // If the index is found
        if (transitionIndex != -1) {
            // Get the list of transitions for the ending floor
            val endTransitions = transitions[endingFloor]
            
            // Return the transition at the same index for the ending floor
            return endTransitions?.get(transitionIndex!!)
        }
    }
    
    // If the startingTransition is not found or index is invalid, return null
    return null
}

fun dijkstra(startClassroomId: Int, endClassroomId: Int, hallways: Map<Int, HallwayNode>, classroomToHallwayMap: Map<Int, List<Int>>, useElevator: Boolean): List<List<HallwayNode>>{
    var hallwayNodesList = mutableListOf<List<HallwayNode>>()
    val startNodeIds = classroomToHallwayMap[startClassroomId] ?: throw IllegalArgumentException("Classroom $startClassroomId does not exist in the map")
    val endNodeIds = classroomToHallwayMap[endClassroomId] ?: throw IllegalArgumentException("Classroom $endClassroomId does not exist in the map")
    val startingFloor = findFloor(startClassroomId)
    val endingFloor = findFloor(endClassroomId)
    val targetEndHallwayNodes = classroomToHallwayMap[endClassroomId] ?: throw IllegalArgumentException("End classroom ID $endClassroomId does not exist in the map")
    if (endingFloor != startingFloor) { //use stairs or elevator
        val floor = findFloor(startNodeIds[0])
        val transitions = if (useElevator || endingFloor - startingFloor > 1) {
            elevators[floor] ?: throw IllegalArgumentException("Elevators not found")
        } else {
            staircases[floor] ?: throw IllegalArgumentException("Staircases not found")
        }
        var minDistance = Double.MAX_VALUE
        var closestTransition: HallwayNode? = null
        var closestTransitionNum: Int? = null
        var closestStartNode: HallwayNode? = null
        var bestDistances: Map<HallwayNode, Pair<Double, HallwayNode?>>? = null
        
        for (startNodeId in startNodeIds) {
            val startNode = hallways[startNodeId] ?: throw IllegalArgumentException("Hallway node $startNodeId does not exist")
            val distances = dijkstraInternal(startNode, hallways)
            for (t in transitions) {
                val targetNode = classroomToHallwayMap[t]?.getOrNull(0)?.let { hallways[it] } //staircases only have one entrance
                val distanceToTarget = distances[targetNode]?.first ?: throw IllegalArgumentException("Distance to hallway node $targetNode not found")
                if (distanceToTarget < minDistance) {
                    minDistance = distanceToTarget
                    closestTransition = targetNode
                    closestStartNode = startNode
                    bestDistances = distances
                    closestTransitionNum = t
                }
            }
        }
        if (closestStartNode != null && closestTransition != null && closestTransitionNum != null && bestDistances != null) {
            var minDistance2 = Double.MAX_VALUE
            var closestEndNode2: HallwayNode? = null
            var closestStartNode2: HallwayNode? = null
            var bestDistances2: Map<HallwayNode, Pair<Double, HallwayNode?>>? = null
            hallwayNodesList.add(printPath(bestDistances, closestStartNode, closestTransition))
            val newStart: Int? = findCorrespondingTransition(closestTransitionNum, findFloor(endClassroomId), useElevator || endingFloor - startingFloor > 1)
            val newStartNodeNum: Int = classroomToHallwayMap[newStart]?.firstOrNull() ?: throw IllegalArgumentException("Hallway node $newStart does not exist")
            val newStartNode: HallwayNode = hallways[newStartNodeNum] ?: throw IllegalArgumentException("Hallway node $newStartNodeNum does not exist")
            val distances2: Map<HallwayNode, Pair<Double, HallwayNode?>> = dijkstraInternal(newStartNode, hallways)
            if (useElevator || endingFloor - startingFloor > 1) {
                println("take elevator ${closestTransitionNum} ...")
                println("get off elevator at ${newStart}...")
            }
            else {
                println("take staircase ${closestTransitionNum} ...")
                println("get off stairs at ${newStart}...")
            }
            for (targetEndHallwayNode in targetEndHallwayNodes) {
                val targetNode = hallways[targetEndHallwayNode]
                val distanceToTarget = distances2[targetNode]?.first ?: throw IllegalArgumentException("Distance to hallway node $targetNode not found")
                if (distanceToTarget < minDistance2) {
                    minDistance2 = distanceToTarget
                    closestEndNode2 = targetNode
                    closestStartNode2 = newStartNode
                    bestDistances2 = distances2
                }
            }
            if (closestStartNode2 != null && closestEndNode2 != null && bestDistances2 != null) {
                hallwayNodesList.add(printPath(bestDistances2, closestStartNode2, closestEndNode2))
            } else {
                println("No path found from start nodes to end nodes.")
            }
        } else {
            println("No path found from start nodes to end nodes.")
        }
    }
    else { // both nodes are on the same floor
        var minDistance = Double.MAX_VALUE
        var closestEndNode: HallwayNode? = null
        var closestStartNode: HallwayNode? = null
        var bestDistances: Map<HallwayNode, Pair<Double, HallwayNode?>>? = null

        for (startNodeId in startNodeIds) {
            val startNode = hallways[startNodeId] ?: throw IllegalArgumentException("Hallway node $startNodeId does not exist")
            val distances = dijkstraInternal(startNode, hallways)
            distances.forEach { (hallway, distance) ->
                println("Distance from ${startNode.nodeId} to ${hallway.nodeId}: ${distance.first}")
            }
            for (targetEndHallwayNode in targetEndHallwayNodes) {
                val targetNode = hallways[targetEndHallwayNode]
                val distanceToTarget = distances[targetNode]?.first ?: throw IllegalArgumentException("Distance to hallway node $targetNode not found")
                if (distanceToTarget < minDistance) {
                    minDistance = distanceToTarget
                    closestEndNode = targetNode
                    closestStartNode = startNode
                    bestDistances = distances
                }
            }
        }

        if (closestStartNode != null && closestEndNode != null && bestDistances != null) {
            println("Distance from start node to hallway node ${closestEndNode.nodeId}: $minDistance")
            hallwayNodesList.add(printPath(bestDistances, closestStartNode, closestEndNode))
        } else {
            println("No path found from start nodes to end nodes.")
        }
    }
    return hallwayNodesList
}

fun printPath(distances: Map<HallwayNode, Pair<Double, HallwayNode?>>, start: HallwayNode, end: HallwayNode): MutableList<HallwayNode> {
    val path = mutableListOf<HallwayNode>()
    var currentNode: HallwayNode? = end

    while (currentNode != null) {
        path.add(currentNode)
        currentNode = distances[currentNode]?.second
    }

    path.reverse()

    println("Path from ${start.nodeId} to ${end.nodeId}:")
    println(path.joinToString(" -> ") { it.nodeId.toString() })
    return path
}


fun dijkstraInternal(start: HallwayNode, hallways: Map<Int, HallwayNode>): Map<HallwayNode, Pair<Double, HallwayNode?>> {
    val distances = mutableMapOf<HallwayNode, Pair<Double, HallwayNode?>>().withDefault { Double.MAX_VALUE to null }
    val priorityQueue = PriorityQueue<Pair<HallwayNode, Double>>(compareBy { it.second })

    distances[start] = 0.0 to null
    priorityQueue.add(start to 0.0)

    while (priorityQueue.isNotEmpty()) {
        val (currentNode, currentDistance) = priorityQueue.poll()

        if (currentDistance > distances.getValue(currentNode).first) continue

        listOfNotNull(currentNode.north, currentNode.south, currentNode.east, currentNode.west).forEach { neighbor ->
            val distance = globalDistances[currentNode to neighbor] ?: return@forEach
            val newDistance = currentDistance + distance
            if (newDistance < distances.getValue(neighbor).first) {
                distances[neighbor] = newDistance to currentNode
                priorityQueue.add(neighbor to newDistance)
            }
        }
    }
    return distances
}
