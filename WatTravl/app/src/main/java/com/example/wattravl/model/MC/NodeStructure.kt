package com.example.wattravl.model.MC

val unit: Double = 1.0  // Example value for unit

data class HallwayNode(
    val nodeId: Int,                        // Identifier for the hallway node
    var north: HallwayNode? = null,         // North neighboring hallway node
    var south: HallwayNode? = null,         // South neighboring hallway node
    var east: HallwayNode? = null,          // East neighboring hallway node
    var west: HallwayNode? = null,          // West neighboring hallway node
    val classrooms: MutableList<Int> = mutableListOf()  // Connected classrooms
) {
    override fun hashCode(): Int {
        return nodeId
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is HallwayNode) return false
        return nodeId == other.nodeId
    }

    override fun toString(): String {
        return "HallwayNode(nodeId=$nodeId)"
    }
}

val globalDistances = mutableMapOf<Pair<HallwayNode, HallwayNode>, Double>()
