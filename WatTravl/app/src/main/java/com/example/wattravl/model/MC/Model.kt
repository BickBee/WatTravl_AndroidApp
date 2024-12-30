package com.example.wattravl.model.MC

import android.os.Build
import androidx.annotation.RequiresApi
import java.lang.IllegalArgumentException
import java.util.logging.Level
import java.util.logging.Logger

/*
import com.example.wattravl.model.MC
import com.example.wattravl.model.MC.buildGraphFloor2
import com.example.wattravl.model.MC.buildGraphFloor3
import com.example.wattravl.model.MC.buildGraphFloor4
import com.example.wattravl.model.MC.buildGraphFloor5
import com.example.wattravl.model.MC.buildGraphFloor6

 */

class Model {
    /*
    private val hallways = buildGraph()
     */

    private val hallwaysFloor1 = buildGraphFloor1()
    private val hallwaysFloor2 = buildGraphFloor2()
    private val hallwaysFloor3 = buildGraphFloor3()
    private val hallwaysFloor4 = buildGraphFloor4()
    private val hallwaysFloor5 = buildGraphFloor5()
    private val hallwaysFloor6 = buildGraphFloor6()

    private val hallways: MutableMap<Int, HallwayNode> = mutableMapOf<Int, HallwayNode>().apply {
        putAll(hallwaysFloor1)
        putAll(hallwaysFloor2)
        putAll(hallwaysFloor3)
        putAll(hallwaysFloor4)
        putAll(hallwaysFloor5)
        putAll(hallwaysFloor6)
    }
    private val classroomToHallwayMap = createClassroomToHallwayMap(hallways)

    @RequiresApi(Build.VERSION_CODES.N)
    fun getPath(start: Int, end: Int, useElevator: Boolean = true): List<HallwayNode> {
        val startClassroomId = start
        val endClassroomId = end

        // Find the corresponding hallway nodes for the start and end classrooms

        /*
        val startNodeId = classroomToHallwayMap[startClassroomId] ?: throw IllegalArgumentException("Classroom $startClassroomId does not exist in the map")
        val endNodeId = classroomToHallwayMap[endClassroomId] ?: throw IllegalArgumentException("Classroom $endClassroomId does not exist in the map")

        val startNode = hallways[startNodeId] ?: throw IllegalArgumentException("Hallway node $startNodeId does not exist")
        val endNode = hallways[endNodeId] ?: throw IllegalArgumentException("Hallway node $endNodeId does not exist")

        val distances = dijkstra(startNode)
        /*
        distances.forEach { (hallway, distance) ->
            println("Distance from ${startNode.nodeId} to ${hallway.nodeId}: ${distance.first}")
        }

         */

        return printPath(distances, startNode, endNode)

         */
        return dijkstra(startClassroomId, endClassroomId, hallways, classroomToHallwayMap, useElevator).flatten()
        /*
        val res = dijkstra(startClassroomId, endClassroomId, hallways, classroomToHallwayMap, useElevator).flatten()
        var resStr = ""
        res.forEach { resStr += it.nodeId.toString() + " " }
        Logger.getLogger("Brah").log(Level.INFO, resStr)
        return res

         */
    }

    fun getNodeId(roomId: Int): Int {
        // return classroomToHallwayMap[roomId] ?: throw IllegalArgumentException("Classroom $startClassroomId does not exist in the map")
        return classroomToHallwayMap[roomId]?.get(0) ?: throw IllegalArgumentException("Classroom $roomId does not exist")
    }

    fun isClassroom(roomId: Int): Boolean {
        return classroomToHallwayMap.containsKey(roomId)
    }

    companion object {
        private val instance: Model = Model()
        fun getInstance(): Model {
            return instance
        }

        fun convertCharRooms(id: String): Int {
            if (id.length == 5) {
                val lastDigit = id[4] - 'A' + 1
                return id.substring(0, 4).toInt() * 10 + lastDigit
            } else {
                return id.toInt()
            }
        }
    }
}