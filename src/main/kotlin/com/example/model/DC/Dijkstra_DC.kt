package com.example.wattravl.model.DC

import android.os.Build
import java.util.PriorityQueue
import androidx.annotation.RequiresApi
import com.example.wattravl.model.MC.unit
import com.example.wattravl.model.MC.HallwayNode
import com.example.wattravl.model.MC.globalDistances
import java.util.logging.Level
import java.util.logging.Logger

private val logger = Logger.getLogger("Djikstra_DC")
val staircases = mapOf(
    1 to listOf(18411, 18412, 18521, 18421, 18422),
    2 to listOf(2809, 2807, 2829, 2805, 2827, 2810, 2828, 2808, 2806, 28411, 28412, 2804, 2803, 2802, 2801, 2811, 28363, 2812),
    3 to listOf(3809, 3807, 3805, 3806, 3808, 3810, 3803, 3804, 3802, 3801, 38364, 3811, 3812, 37017, 38363),
)

val elevators = mapOf(
    1 to listOf(1818),
    2 to listOf(2817, 2818),
    3 to listOf(3817, 3818),
)

val correspondTransition = mapOf(
    Pair(1818, 2) to 2818,
    Pair(1818, 3) to 3818,
    Pair(2818, 3) to 3818,
    Pair(2818, 1) to 1818,
    Pair(3818, 2) to 2818,
    Pair(3818, 1) to 1818,
    Pair(3817, 2) to 2817,
    Pair(2817, 3) to 3817,
//    Pair(1801, 2) to 2801, Pair(1801, 3) to 3801,
//    Pair(1802, 2) to 2802, Pair(1802, 3) to 3802,
//    Pair(1803, 2) to 2803, Pair(1803, 3) to 3803,
//    Pair(1804, 2) to 2804, Pair(1804, 3) to 3804,
//    Pair(2801, 1) to 1801,
    Pair(2801, 3) to 3801,
//    Pair(2802, 1) to 1802,
    Pair(2802, 3) to 3802,
//    Pair(2803, 1) to 1803,
    Pair(2803, 3) to 3803,
//    Pair(2804, 1) to 1804,
    Pair(2804, 3) to 3804,
//    Pair(3801, 1) to 1801,
    Pair(3801, 2) to 2801,
//    Pair(3802, 1) to 1802,
    Pair(3802, 2) to 2802,
//    Pair(3803, 1) to 1803,
    Pair(3803, 2) to 2803,
//    Pair(3804, 1) to 1804,
    Pair(3804, 2) to 2804,
    Pair(18411, 2) to 28411,
    Pair(18412, 2) to 28412,
    Pair(18421, 2) to 28401,
    Pair(18422, 2) to 28402,
    Pair(18521, 2) to 28521,
    Pair(28411, 1) to 18411,
    Pair(28412, 1) to 18412,
    Pair(28401, 1) to 18421,
    Pair(28402, 1) to 18422,
    Pair(28521, 1) to 18521,

    Pair(2809, 3) to 3809,
    Pair(2807, 3) to 3807,
    Pair(2805, 3) to 3805,
    Pair(2810, 3) to 3810,
    Pair(2808, 3) to 3808,
    Pair(2806, 3) to 3806,

    Pair(3809, 2) to 2809,
    Pair(3807, 2) to 2807,
    Pair(3805, 2) to 2805,
    Pair(3810, 2) to 2810,
    Pair(3808, 2) to 2808,
    Pair(3806, 2) to 2806
)


fun findFloor(number: Int): Int {
    val numberStr = number.toString()
    return numberStr[0].toString().toInt()
}

fun finDCorrespondingTransition(startingTransition: Int, endingFloor: Int, useElevator: Boolean): Int? {
    //val transitions = if (useElevator) elevators else staircases

//    // Find the index of the startingTransition in its corresponding floor list
//    val startFloorIndex = transitions.values.indexOfFirst { it.contains(startingTransition) }
//
//    // If the startingTransition is found in one of the floor lists
//    if (startFloorIndex != -1) {
//        // Get the list of transitions for the starting floor
//        val startTransitions = transitions[startFloorIndex + 1]
//
//        // Find the index of the startingTransition in its list
//        val transitionIndex = startTransitions?.indexOf(startingTransition)
//
//        // If the index is found
//        if (transitionIndex != -1) {
//            // Get the list of transitions for the ending floor
//            val endTransitions = transitions[endingFloor]
//
//            // Return the transition at the same index for the ending floor
//            return endTransitions?.get(transitionIndex!!)
//        }
//    }
//
//    // If the startingTransition is not found or index is invalid, return null
//    return null
   return correspondTransition.get(Pair(startingTransition, endingFloor))
}

fun mergeList(floor:Int): List<Int> {
    val staircase = staircases[floor]?: throw IllegalArgumentException("Staircases not found")
    val elevator =  elevators[floor] ?: throw IllegalArgumentException("Elevators not found")
    return staircase + elevator
}


@RequiresApi(Build.VERSION_CODES.N)
fun dijkstra(startClassroomId: Int, enDClassroomId: Int, hallways: Map<Int, HallwayNode>, classroomToHallwayMap: Map<Int, List<Int>>, useElevator: Boolean): List<List<HallwayNode>>{
    var hallwayNodesList = mutableListOf<List<HallwayNode>>()
    val startNodeIds = classroomToHallwayMap[startClassroomId] ?: throw IllegalArgumentException("Classroom $startClassroomId does not exist in the map")
    val endNodeIds = classroomToHallwayMap[enDClassroomId] ?: throw IllegalArgumentException("Classroom $enDClassroomId does not exist in the map")
    val startingFloor = findFloor(startClassroomId)
    val endingFloor = findFloor(enDClassroomId)
    val targetEndHallwayNodes = classroomToHallwayMap[enDClassroomId] ?: throw IllegalArgumentException("End classroom ID $enDClassroomId does not exist in the map")
    if (endingFloor != startingFloor) { //use stairs or elevator
        val floor = findFloor(startNodeIds[0])
        val transitions = if (useElevator || endingFloor - startingFloor > 1) {
            elevators[floor] ?: throw IllegalArgumentException("Elevators not found")
        } else {
            mergeList(floor) //staircases[floor]?: throw IllegalArgumentException("Staircases not found")
        }
        var minDistance = Double.MAX_VALUE
        var closestTransition: HallwayNode? = null
        var closestTransitionNum: Int? = null
        var closestStartNode: HallwayNode? = null
        var bestDistances: Map<HallwayNode, Pair<Double, HallwayNode?>>? = null

        
        for (startNodeId in startNodeIds) {
            val startNode = hallways[startNodeId] ?: throw IllegalArgumentException("Hallway node $startNodeId does not exist")
            val distances = dijkstraInternal(startNode, hallways)
            logger.log(Level.INFO, distances.toString())
            logger.log(Level.INFO, "Start: ${startNode}, hall: ${hallways}")
            for (t in transitions) {
                val targetNode = classroomToHallwayMap[t]?.getOrNull(0)?.let { hallways[it] } //staircases only have one entrance
                logger.log(Level.INFO, distances[targetNode].toString())
                for ((key, value) in distances) {
                    println("Key: $key, Value: $value")
                }
                val distanceToTarget = distances[targetNode]?.first ?: throw IllegalArgumentException("Distance to hallway node $targetNode not found${targetNode}")
                if (distanceToTarget < minDistance || finDCorrespondingTransition(t, findFloor(enDClassroomId), useElevator) != null) {
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
            val newStart: Int? = finDCorrespondingTransition(closestTransitionNum, findFloor(enDClassroomId), useElevator || endingFloor - startingFloor > 1)
            logger.log(Level.INFO, newStart.toString())
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


@RequiresApi(Build.VERSION_CODES.N)
fun dijkstraInternal(start: HallwayNode, hallways: Map<Int, HallwayNode>): Map<HallwayNode, Pair<Double, HallwayNode?>> {
    val distances = mutableMapOf<HallwayNode, Pair<Double, HallwayNode?>>().withDefault { Double.MAX_VALUE to null }
    val priorityQueue = PriorityQueue<Pair<HallwayNode, Double>>(compareBy { it.second })

    distances[start] = 0.0 to null
    priorityQueue.add(start to 0.0)

    while (priorityQueue.isNotEmpty()) {
        val (currentNode, currentDistance) = priorityQueue.poll()
        println(currentNode.nodeId)

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
