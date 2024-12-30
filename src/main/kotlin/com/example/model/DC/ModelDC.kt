package com.example.wattravl.model.DC

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.wattravl.model.DC.buildGraphFloor1
import com.example.wattravl.model.DC.buildGraphFloor2
import com.example.wattravl.model.DC.buildGraphFloor3
import com.example.wattravl.model.MC.unit
import com.example.wattravl.model.MC.HallwayNode
import com.example.wattravl.model.MC.globalDistances
import java.util.logging.Logger
import java.util.logging.Level


class ModelDC {

    private val logger = Logger.getLogger("ModelDC")

    private val hallwaysFloor1 = buildGraphFloor1()
    private val hallwaysFloor2 = buildGraphFloor2()
    private val hallwaysFloor3 = buildGraphFloor3()

    // Combine all hallways into a single map
    private val hallways: MutableMap<Int, HallwayNode> = mutableMapOf<Int, HallwayNode>().apply {
        putAll(hallwaysFloor1)
        putAll(hallwaysFloor2)
        putAll(hallwaysFloor3)
    }



    private val classroomToHallwayMap = createClassroomToHallwayMap(hallways)

    @RequiresApi(Build.VERSION_CODES.N)
    fun getPath(start: Int, end: Int, useElevator: Boolean = true): List<HallwayNode> {
        logger.log(Level.INFO, hallways.toString())
        val startClassroomId = start
        val endClassroomId = end
        return dijkstra(startClassroomId, endClassroomId, hallways, classroomToHallwayMap, useElevator).flatten()
    }

    fun isClassroom(roomId: Int): Boolean {
        return classroomToHallwayMap.containsKey(roomId)
    }

    companion object {
        private val instance: ModelDC = ModelDC()
        fun getInstance(): ModelDC {
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