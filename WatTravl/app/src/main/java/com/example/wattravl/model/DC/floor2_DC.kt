package com.example.wattravl.model.DC
import com.example.wattravl.model.MC.unit
import com.example.wattravl.model.MC.HallwayNode
import com.example.wattravl.model.MC.globalDistances

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
    return (2010..2990).associateWith { HallwayNode(nodeId = it) }
}

fun connectClassroomsToHallways2(hallways: Map<Int, HallwayNode>) {
    hallways[2010]?.classrooms?.addAll(listOf(2643, 2641, 2639, 2638))  
    hallways[2020]?.classrooms?.addAll(listOf(2637, 2635, 2634)) 
    hallways[2030]?.classrooms?.addAll(listOf(2633, 2631, 2630)) 
    hallways[2040]?.classrooms?.addAll(listOf(2629, 2627, 2628, 2626)) 
    hallways[2050]?.classrooms?.addAll(listOf(2625, 2623, 2624, 2622)) 
    hallways[2060]?.classrooms?.addAll(listOf(2621, 2619, 2620, 2618)) 
    hallways[2070]?.classrooms?.addAll(listOf(2617, 2615)) 
    hallways[2080]?.classrooms?.add(2807) // stair
    hallways[2090]?.classrooms?.addAll(listOf(2613, 2611, 2610, 2608)) 
    hallways[2100]?.classrooms?.addAll(listOf(2609, 2607, 2606)) 
    hallways[2110]?.classrooms?.addAll(listOf(2605, 2602)) 
    hallways[2120]?.classrooms?.addAll(listOf(2601, 2603)) 
    hallways[2130]?.classrooms?.add(2809) // stair 
    hallways[2140]?.classrooms?.addAll(listOf(2599, 25991, 25992, 25993, 25994)) 
    hallways[2150]?.classrooms?.add(2592) 
    hallways[2160]?.classrooms?.add(2923) // washroom
    hallways[2170]?.classrooms?.add(2922) 
    hallways[2180]?.classrooms?.add(2807) // stair 
    hallways[2190]?.classrooms?.add(2829) // stair 
    hallways[2200]?.classrooms?.add(2805) // stair 
    //hallways[2210]?.classrooms?.addAll(listOf(2040, 2078)) 
    hallways[2220]?.classrooms?.add(28411) // stair 
    hallways[2230]?.classrooms?.addAll(listOf(2930, 2818)) // 2818 is elevator 
    //hallways[2240]?.classrooms?.addAll(listOf(2040, 2078)) 
    hallways[2250]?.classrooms?.add(28412) 
    hallways[2260]?.classrooms?.add(2931) // washrooom 
    hallways[2270]?.classrooms?.add(2802) // stair 
    //hallways[2280]?.classrooms?.addAll(listOf(2040, 2078)) 
    hallways[2290]?.classrooms?.addAll(listOf(2102, 2106, 2103, 2105)) 
    hallways[2300]?.classrooms?.addAll(listOf(2110, 2108, 2109, 2107)) 
    hallways[2310]?.classrooms?.addAll(listOf(2112, 2114, 2113, 2111)) 
    hallways[2320]?.classrooms?.addAll(listOf(2115, 2116, 2117, 2118)) 
    hallways[2330]?.classrooms?.addAll(listOf(2119, 2120, 2121, 2122)) 
    hallways[2340]?.classrooms?.addAll(listOf(2123, 2124, 2125, 2126)) 
    hallways[2350]?.classrooms?.addAll(listOf(2127, 2128, 2129, 2130)) 
    hallways[2360]?.classrooms?.addAll(listOf(2131, 2133, 21361, 21362)) 
    hallways[2370]?.classrooms?.add(2801) // stair 
    //hallways[2380]?.classrooms?.addAll(listOf(2040, 2078)) 
    hallways[2390]?.classrooms?.add(2136) 
    hallways[2400]?.classrooms?.add(28521) 
    hallways[2410]?.classrooms?.addAll(listOf(2584, 25841, 25842, 25843)) 
    hallways[2420]?.classrooms?.addAll(listOf(2582, 25821, 25822, 25823, 2581)) 
    hallways[2430]?.classrooms?.addAll(listOf(2580)) 
    hallways[2440]?.classrooms?.addAll(listOf(2568, 25681)) 
    hallways[2450]?.classrooms?.addAll(listOf(2568, 25681, 2569, 2567)) 
    hallways[2460]?.classrooms?.addAll(listOf(2569, 25691)) 
    hallways[2470]?.classrooms?.addAll(listOf(2560, 25601, 25602, 25603, 25604, 25605, 25606, 25607, 25608, 2561, 2564)) 
    hallways[2480]?.classrooms?.addAll(listOf(2555, 25551, 25552, 25553, 2554, 25541, 2557, 2558, 2559)) 
    hallways[2490]?.classrooms?.addAll(listOf(2550, 2553, 2551, 25511, 25512, 25513, 25514, 2564)) 
    hallways[2500]?.classrooms?.addAll(listOf(2548, 2546)) 
    hallways[2510]?.classrooms?.addAll(listOf(2542, 2544, 2555, 25551, 25552, 25553)) 
    hallways[2520]?.classrooms?.addAll(listOf(2305, 23051, 23052, 23053, 23054, 23055, 2306, 23061, 23062, 23063, 23064, 23065, 23066, 23067, 23068, 23069, 230610, 230611, 230612, 230613, 230614, 230615, 230616, 230617)) 
    hallways[2530]?.classrooms?.addAll(listOf(2305, 23051, 23052, 2306, 23061, 23062, 23063, 23064, 23065, 23066, 23067, 23068, 23069, 230610, 230611, 230612, 230613, 230614, 230615, 230616, 230617, 2304, 23041, 23042, 23043, 23044, 23045)) 
    hallways[2540]?.classrooms?.addAll(listOf(2327, 2325)) 
    hallways[2550]?.classrooms?.addAll(listOf(2321, 2323, 2305, 23051, 23052, 23053, 23054, 23055)) 
    hallways[2560]?.classrooms?.addAll(listOf(2317, 2319)) 
    hallways[2570]?.classrooms?.addAll(listOf(2310, 2311, 2313, 2314, 2315)) 
    hallways[2580]?.classrooms?.addAll(listOf(2597, 25971, 25972, 25973, 25974, 25975)) 
    hallways[2590]?.classrooms?.addAll(listOf(2827, 2531, 2523, 25231, 25232, 25233)) // 2827 is stair 
    hallways[2600]?.classrooms?.addAll(listOf(2020, 2921)) // 2921 is washroom
    //hallways[2610]?.classrooms?.addAll(listOf(2040, 2078)) 
    hallways[2620]?.classrooms?.add(2828) // stair 
    hallways[2630]?.classrooms?.add(2806) //stair
    //hallways[2640]?.classrooms?.addAll(listOf(2040, 2078)) 
    hallways[2650]?.classrooms?.add(28401) // stair 
    //hallways[2660]?.classrooms?.addAll(listOf(2040, 2078)) 
    hallways[2670]?.classrooms?.add(28402) // stair 
    hallways[2680]?.classrooms?.add(2933) // washroom 
    hallways[2690]?.classrooms?.add(2803) // stair 
    hallways[2700]?.classrooms?.addAll(listOf(2331, 2332, 2333, 2334)) 
    hallways[2710]?.classrooms?.addAll(listOf(2335, 2336, 2337, 2338)) 
    hallways[2720]?.classrooms?.addAll(listOf(2339, 2340, 2341, 2804)) // 2804 is stair
    hallways[2730]?.classrooms?.addAll(listOf(2343, 2344)) 
    hallways[2740]?.classrooms?.addAll(listOf(2539, 2538, 2536, 2810)) 
    hallways[2750]?.classrooms?.addAll(listOf(2532, 2534)) 
    hallways[2760]?.classrooms?.addAll(listOf(2528, 2530)) 
    hallways[2770]?.classrooms?.addAll(listOf(2524, 2526, 2531, 2523, 25231, 25232, 25233)) 
    hallways[2780]?.classrooms?.addAll(listOf(2520, 2522, 2521, 2519)) 
    hallways[2790]?.classrooms?.addAll(listOf(2516, 2518, 2517, 2515)) 
    hallways[2800]?.classrooms?.addAll(listOf(2512, 2514)) 
    hallways[2810]?.classrooms?.addAll(listOf(2510, 2508, 2509, 2810, 2808)) 
    hallways[2820]?.classrooms?.addAll(listOf(2504, 2505, 2506, 2507)) 
    hallways[2830]?.classrooms?.addAll(listOf(2501, 2502, 2503)) 
    //hallways[2840]?.classrooms?.addAll(listOf(2040, 2078)) 
    hallways[2850]?.classrooms?.addAll(listOf(2734, 2741, 2737)) 
    hallways[2860]?.classrooms?.addAll(listOf(2728, 2730, 2731, 2733)) 
    hallways[2870]?.classrooms?.addAll(listOf(2727, 2726, 2936)) // 2936 is washroom 
    hallways[2880]?.classrooms?.addAll(listOf(2742, 27421, 2812, 2817)) // 2817 is elevator, 2812 is stair
    //hallways[2890]?.classrooms?.addAll(listOf(2040, 2078)) 
    hallways[2900]?.classrooms?.addAll(listOf(2725, 28363, 2935)) //28363 is stair, 2935 is washroom
    hallways[2910]?.classrooms?.add(2811) // stair
    hallways[2920]?.classrooms?.add(2835) 
    hallways[2930]?.classrooms?.addAll(listOf(2724, 2720, 2717)) 
    hallways[2940]?.classrooms?.addAll(listOf(2713, 2715, 2716, 2718)) 
    hallways[2950]?.classrooms?.addAll(listOf(2709, 2711, 2712, 2714)) 
    hallways[2960]?.classrooms?.addAll(listOf(2705, 2707, 2708, 2710)) 
    hallways[2970]?.classrooms?.addAll(listOf(2702, 2703, 2704, 2811)) // 2811 is stair
}


fun connectHallways2(hallways: Map<Int, HallwayNode>) {
    hallways[2010]?.apply {
        east = hallways[2020]
        south = hallways[2130]
    }

    hallways[2020]?.apply {
        west = hallways[2010]
        east = hallways[2030]
    }

    hallways[2030]?.apply {
        west = hallways[2020]
        east = hallways[2040]
    }

    hallways[2040]?.apply {
        west = hallways[2030]
        east = hallways[2050]
    }

    hallways[2050]?.apply {
        west = hallways[2040]
        east = hallways[2060]
    }

    hallways[2060]?.apply {
        west = hallways[2050]
        east = hallways[2070]
    }

    hallways[2070]?.apply {
        west = hallways[2060]
        east = hallways[2080]
    }

    hallways[2080]?.apply {
        west = hallways[2070]
        east = hallways[2090]
        south = hallways[2180]
    }

    hallways[2090]?.apply {
        north = hallways[2080]
        south = hallways[2100]
    }

    hallways[2100]?.apply {
        west = hallways[2090]
        east = hallways[2110]
    }

    hallways[2110]?.apply {
        west = hallways[2100]
        east = hallways[2120]
    }

    hallways[2120]?.apply {
        west = hallways[2110]
    }

    hallways[2130]?.apply {
        north = hallways[2010]
        south = hallways[2140]
    }

    hallways[2140]?.apply {
        north = hallways[2130]
        east = hallways[2150]
    }

    hallways[2150]?.apply {
        west = hallways[2140]
        east = hallways[2160]
        south = hallways[2410]
    }

    hallways[2160]?.apply {
        west = hallways[2150]
        east = hallways[2170]
    }

    hallways[2170]?.apply {
        west = hallways[2160]
        east = hallways[2180]
        south = hallways[2440]
    }

    hallways[2180]?.apply {
        west = hallways[2170]
        east = hallways[2190]
    }

    hallways[2190]?.apply {
        west = hallways[2180]
        east = hallways[2200]
        south = hallways[2470]
    }

    hallways[2200]?.apply {
        west = hallways[2190]
        east = hallways[2220]
        south = hallways[2490]
    }

    hallways[2210]?.apply {
        west = hallways[2200]
        east = hallways[2220]
        south = hallways[2640]
    }

    hallways[2220]?.apply {
        west = hallways[2200]
        east = hallways[2220]
    }

    hallways[2230]?.apply {
        west = hallways[2220]
        east = hallways[2240]
    }

    hallways[2240]?.apply {
        west = hallways[2230]
        east = hallways[2250]
        south = hallways[2520]
    }

    hallways[2250]?.apply {
        west = hallways[2240]
        east = hallways[2260]
    }

    hallways[2260]?.apply {
        north = hallways[2270]
        south = hallways[2540]
    }

    hallways[2270]?.apply {
        north = hallways[2290]
        south = hallways[2260]
    }

    /*hallways[2280]?.apply {
        north = hallways[2270]
        south = hallways[2540]
    }*/

    hallways[2290]?.apply {
        north = hallways[2300]
        south = hallways[2270]
    }

    hallways[2300]?.apply {
        north = hallways[2310]
        south = hallways[2290]
    }

    hallways[2310]?.apply {
        north = hallways[2320]
        south = hallways[2300]
    }

    hallways[2320]?.apply {
        north = hallways[2330]
        south = hallways[2310]
    }

    hallways[2330]?.apply {
        north = hallways[2340]
        south = hallways[2320]
    }

    hallways[2340]?.apply {
        north = hallways[2350]
        south = hallways[2330]
    }

    hallways[2350]?.apply {
        north = hallways[2360]
        south = hallways[2340]
    }

    hallways[2360]?.apply {
        north = hallways[2370]
        south = hallways[2350]
    }

    hallways[2370]?.apply {
        north = hallways[2380]
        south = hallways[2360]
    }

    hallways[2380]?.apply {
        west = hallways[2390]
        south = hallways[2370]
    }

    hallways[2390]?.apply {
        north = hallways[2400]
        east = hallways[2380]
    }

    hallways[2400]?.apply {
        south = hallways[2390]
    }

    hallways[2410]?.apply {
        north = hallways[2150]
        south = hallways[2420]
    }

    hallways[2420]?.apply {
        north = hallways[2410]
        south = hallways[2430]
    }

    hallways[2430]?.apply {
        north = hallways[2420]
        south = hallways[2590]
    }

    hallways[2440]?.apply {
        north = hallways[2170]
        south = hallways[2450]
    }

    hallways[2450]?.apply {
        north = hallways[2440]
        south = hallways[2460]
    }

    hallways[2460]?.apply {
        north = hallways[2450]
        south = hallways[2600]
    }

    hallways[2470]?.apply {
        north = hallways[2190]
        south = hallways[2480]
    }

    hallways[2480]?.apply {
        north = hallways[2470]
        south = hallways[2620]
    }

    hallways[2490]?.apply {
        north = hallways[2200]
        south = hallways[2500]
    }

    hallways[2500]?.apply {
        north = hallways[2490]
        south = hallways[2510]
    }

    hallways[2510]?.apply {
        north = hallways[2500]
        south = hallways[2630]
    }

    hallways[2520]?.apply {
        north = hallways[2240]
        south = hallways[2530]
    }

    hallways[2530]?.apply {
        north = hallways[2520]
        south = hallways[2660]
    }

    hallways[2540]?.apply {
        north = hallways[2260]
        south = hallways[2550]
    }

    hallways[2550]?.apply {
        north = hallways[2540]
        south = hallways[2560]
    }

    hallways[2560]?.apply {
        north = hallways[2550]
        south = hallways[2570]
    }

    hallways[2570]?.apply {
        north = hallways[2560]
        south = hallways[2680]
    }

    hallways[2580]?.apply {
        west = hallways[2920]
        east = hallways[2590]
        south = hallways[2740]
    }

    hallways[2590]?.apply {
        north = hallways[2430]
        west = hallways[2580]
        east = hallways[2600]
    }

    hallways[2600]?.apply {
        north = hallways [2460]
        west = hallways[2590]
        east = hallways[2610]
    }

    hallways[2610]?.apply {
        south = hallways[2810]
        west = hallways[2600]
        east = hallways[2620]
    }

    hallways[2620]?.apply {
        north = hallways[2480]
        west = hallways[2610]
        east = hallways[2630]
    }

    hallways[2630]?.apply {
        north = hallways[2510]
        west = hallways[2620]
        east = hallways[2640]
    }

    hallways[2640]?.apply {
        north = hallways[2210]
        west = hallways[2630]
        east = hallways[2650]
    }

    hallways[2650]?.apply {
        west = hallways[2640]
        east = hallways[2660]
    }

    hallways[2660]?.apply {
        north = hallways[2530]
        west = hallways[2650]
        east = hallways[2670]
    }

    hallways[2670]?.apply {
        west = hallways[2660]
        east = hallways[2680]
    }

    hallways[2680]?.apply {
        west = hallways[2670]
        north = hallways[2570]
        south = hallways[2690]
    }

    hallways[2690]?.apply {
        north = hallways[2680]
        south = hallways[2700]
    }

    hallways[2700]?.apply {
        north = hallways[2690]
        south = hallways[2710]
    }

    hallways[2710]?.apply {
        north = hallways[2700]
        south = hallways[2720]
    }

    hallways[2720]?.apply {
        north = hallways[2710]
        south = hallways[2730]
    }

    hallways[2730]?.apply {
        north = hallways[2720]
    }

    hallways[2740]?.apply {
        north = hallways[2580]
        east = hallways[2750]
    }

    hallways[2750]?.apply {
        west = hallways[2740]
        east = hallways[2760]
    }

    hallways[2760]?.apply {
        west = hallways[2750]
        east = hallways[2770]
    }

    hallways[2770]?.apply {
        west = hallways[2760]
        east = hallways[2780]
    }

    hallways[2780]?.apply {
        west = hallways[2770]
        east = hallways[2790]
    }

    hallways[2790]?.apply {
        west = hallways[2780]
        east = hallways[2800]
    }

    hallways[2800]?.apply {
        west = hallways[2790]
        east = hallways[2810]
    }

    hallways[2810]?.apply {
        north = hallways[2610]
        west = hallways[2800]
        east = hallways[2820]
    }

    hallways[2820]?.apply {
        west = hallways[2810]
        east = hallways[2830]
    }

    hallways[2830]?.apply {
        west = hallways[2820]
    }

    hallways[2840]?.apply {
        east = hallways[2850]
        south = hallways[2890]
    }

    hallways[2850]?.apply {
        west = hallways[2840]
        east = hallways[2860]
    }

    hallways[2860]?.apply {
        west = hallways[2850]
        east = hallways[2870]
    }

    hallways[2870]?.apply {
        west = hallways[2860]
        south = hallways[2900]
    }

    hallways[2880]?.apply {
        east = hallways[2890]
        south = hallways[2930]
    }

    hallways[2890]?.apply {
        north = hallways[2840]
        west = hallways[2880]
        east = hallways[2900]
    }

    hallways[2900]?.apply {
        north = hallways[2870]
        west = hallways[2890]
        east = hallways[2910]
    }

    hallways[2910]?.apply {
        west = hallways[2900]
        east = hallways[2920]
        south = hallways[2970]
    }

    hallways[2920]?.apply {
        west = hallways[2910]
        east = hallways[2580]
    }

    hallways[2930]?.apply {
        east = hallways[2940]
        north = hallways[2880]
    }

    hallways[2940]?.apply {
        west = hallways[2930]
        east = hallways[2950]
    }

    hallways[2950]?.apply {
        west = hallways[2940]
        east = hallways[2960]
    }

    hallways[2960]?.apply {
        west = hallways[2950]
        east = hallways[2970]
    }

    hallways[2970]?.apply {
        west = hallways[2960]
        north = hallways[2910]
    }
}

fun setDistances2(hallways: Map<Int, HallwayNode>) {
    globalDistances[hallways[2010]!! to hallways[2020]!!] = 1.5 * unit
    globalDistances[hallways[2020]!! to hallways[2010]!!] = 1.5 * unit

    globalDistances[hallways[2020]!! to hallways[2030]!!] = 1 * unit
    globalDistances[hallways[2030]!! to hallways[2020]!!] = 1 * unit

    globalDistances[hallways[2030]!! to hallways[2040]!!] = 1 * unit
    globalDistances[hallways[2040]!! to hallways[2030]!!] = 1 * unit

    globalDistances[hallways[2040]!! to hallways[2050]!!] = 1 * unit
    globalDistances[hallways[2050]!! to hallways[2040]!!] = 1 * unit

    globalDistances[hallways[2050]!! to hallways[2060]!!] = 1 * unit
    globalDistances[hallways[2060]!! to hallways[2050]!!] = 1 * unit

    globalDistances[hallways[2060]!! to hallways[2070]!!] = 1 * unit
    globalDistances[hallways[2070]!! to hallways[2060]!!] = 1 * unit

    globalDistances[hallways[2070]!! to hallways[2080]!!] = 1 * unit
    globalDistances[hallways[2080]!! to hallways[2070]!!] = 1 * unit

    globalDistances[hallways[2080]!! to hallways[2090]!!] = 1 * unit
    globalDistances[hallways[2090]!! to hallways[2080]!!] = 1 * unit

    globalDistances[hallways[2080]!! to hallways[2180]!!] = 2.0 * unit
    globalDistances[hallways[2180]!! to hallways[2080]!!] = 2.0 * unit

    globalDistances[hallways[2090]!! to hallways[2100]!!] = 1 * unit
    globalDistances[hallways[2100]!! to hallways[2090]!!] = 1 * unit

    globalDistances[hallways[2100]!! to hallways[2110]!!] = 1 * unit
    globalDistances[hallways[2110]!! to hallways[2100]!!] = 1 * unit

    globalDistances[hallways[2110]!! to hallways[2120]!!] = 1 * unit
    globalDistances[hallways[2120]!! to hallways[2110]!!] = 1 * unit

    globalDistances[hallways[2130]!! to hallways[2010]!!] = 1.5 * unit
    globalDistances[hallways[2010]!! to hallways[2130]!!] = 1.5 * unit

    globalDistances[hallways[2130]!! to hallways[2140]!!] = 1.5 * unit
    globalDistances[hallways[2140]!! to hallways[2130]!!] = 1.5 * unit

    globalDistances[hallways[2140]!! to hallways[2150]!!] = 2.5 * unit
    globalDistances[hallways[2150]!! to hallways[2140]!!] = 2.5 * unit

    globalDistances[hallways[2150]!! to hallways[2160]!!] = 2.5 * unit
    globalDistances[hallways[2160]!! to hallways[2150]!!] = 2.5 * unit

    globalDistances[hallways[2150]!! to hallways[2410]!!] = 2.5 * unit
    globalDistances[hallways[2410]!! to hallways[2150]!!] = 2.5 * unit

    globalDistances[hallways[2160]!! to hallways[2170]!!] = 1 * unit
    globalDistances[hallways[2170]!! to hallways[2160]!!] = 1 * unit

    globalDistances[hallways[2170]!! to hallways[2180]!!] = 1 * unit
    globalDistances[hallways[2180]!! to hallways[2170]!!] = 1 * unit

    globalDistances[hallways[2170]!! to hallways[2440]!!] = 1 * unit
    globalDistances[hallways[2440]!! to hallways[2170]!!] = 1 * unit

    globalDistances[hallways[2180]!! to hallways[2190]!!] = 2 * unit
    globalDistances[hallways[2190]!! to hallways[2180]!!] = 2 * unit

    globalDistances[hallways[2180]!! to hallways[2470]!!] = 2 * unit
    globalDistances[hallways[2470]!! to hallways[2180]!!] = 2 * unit

    globalDistances[hallways[2190]!! to hallways[2200]!!] = 3 * unit
    globalDistances[hallways[2200]!! to hallways[2190]!!] = 3 * unit

    globalDistances[hallways[2190]!! to hallways[2470]!!] = 1.5 * unit
    globalDistances[hallways[2470]!! to hallways[2190]!!] = 1.5 * unit

    globalDistances[hallways[2200]!! to hallways[2220]!!] = 1 * unit
    globalDistances[hallways[2220]!! to hallways[2200]!!] = 1 * unit

    globalDistances[hallways[2200]!! to hallways[2490]!!] = 1.5 * unit
    globalDistances[hallways[2490]!! to hallways[2200]!!] = 1.5 * unit

    globalDistances[hallways[2210]!! to hallways[2220]!!] = 1.5 * unit
    globalDistances[hallways[2220]!! to hallways[2210]!!] = 1.5 * unit

    globalDistances[hallways[2220]!! to hallways[2230]!!] = 1 * unit
    globalDistances[hallways[2230]!! to hallways[2220]!!] = 1 * unit

    globalDistances[hallways[2230]!! to hallways[2240]!!] = 2 * unit
    globalDistances[hallways[2240]!! to hallways[2230]!!] = 2 * unit

    globalDistances[hallways[2240]!! to hallways[2250]!!] = 1.5 * unit
    globalDistances[hallways[2250]!! to hallways[2240]!!] = 1.5 * unit

    globalDistances[hallways[2240]!! to hallways[2520]!!] = 1 * unit
    globalDistances[hallways[2520]!! to hallways[2240]!!] = 1 * unit

    globalDistances[hallways[2250]!! to hallways[2260]!!] = 2.5 * unit
    globalDistances[hallways[2260]!! to hallways[2250]!!] = 2.5 * unit

    globalDistances[hallways[2260]!! to hallways[2270]!!] = 1.5 * unit
    globalDistances[hallways[2270]!! to hallways[2260]!!] = 1.5 * unit

    globalDistances[hallways[2260]!! to hallways[2540]!!] = 1.5 * unit
    globalDistances[hallways[2540]!! to hallways[2260]!!] = 1.5 * unit

    globalDistances[hallways[2270]!! to hallways[2290]!!] = 1 * unit
    globalDistances[hallways[2290]!! to hallways[2270]!!] = 1 * unit

    globalDistances[hallways[2290]!! to hallways[2300]!!] = 1 * unit
    globalDistances[hallways[2300]!! to hallways[2290]!!] = 1 * unit

    globalDistances[hallways[2300]!! to hallways[2310]!!] = 1 * unit
    globalDistances[hallways[2310]!! to hallways[2300]!!] = 1 * unit

    globalDistances[hallways[2310]!! to hallways[2320]!!] = 1 * unit
    globalDistances[hallways[2320]!! to hallways[2310]!!] = 1 * unit

    globalDistances[hallways[2320]!! to hallways[2330]!!] = 1 * unit
    globalDistances[hallways[2330]!! to hallways[2320]!!] = 1 * unit

    globalDistances[hallways[2330]!! to hallways[2340]!!] = 1 * unit
    globalDistances[hallways[2340]!! to hallways[2330]!!] = 1 * unit

    globalDistances[hallways[2340]!! to hallways[2350]!!] = 1 * unit
    globalDistances[hallways[2350]!! to hallways[2340]!!] = 1 * unit

    globalDistances[hallways[2350]!! to hallways[2360]!!] = 1 * unit
    globalDistances[hallways[2360]!! to hallways[2350]!!] = 1 * unit

    globalDistances[hallways[2360]!! to hallways[2370]!!] = 1 * unit
    globalDistances[hallways[2370]!! to hallways[2360]!!] = 1 * unit

    globalDistances[hallways[2370]!! to hallways[2380]!!] = 1 * unit
    globalDistances[hallways[2380]!! to hallways[2370]!!] = 1 * unit

    globalDistances[hallways[2380]!! to hallways[2390]!!] = 1 * unit
    globalDistances[hallways[2390]!! to hallways[2380]!!] = 1 * unit

    globalDistances[hallways[2390]!! to hallways[2400]!!] = 2 * unit
    globalDistances[hallways[2400]!! to hallways[2390]!!] = 2 * unit

    globalDistances[hallways[2410]!! to hallways[2420]!!] = 2 * unit
    globalDistances[hallways[2420]!! to hallways[2410]!!] = 2 * unit

    globalDistances[hallways[2420]!! to hallways[2430]!!] = 1 * unit
    globalDistances[hallways[2430]!! to hallways[2420]!!] = 1 * unit

    globalDistances[hallways[2430]!! to hallways[2590]!!] = 1 * unit
    globalDistances[hallways[2590]!! to hallways[2430]!!] = 1 * unit

    globalDistances[hallways[2440]!! to hallways[2450]!!] = 2.5 * unit
    globalDistances[hallways[2450]!! to hallways[2440]!!] = 2.5 * unit

    globalDistances[hallways[2450]!! to hallways[2460]!!] = 2.5 * unit
    globalDistances[hallways[2460]!! to hallways[2450]!!] = 2.5 * unit

    globalDistances[hallways[2460]!! to hallways[2600]!!] = 1 * unit
    globalDistances[hallways[2600]!! to hallways[2460]!!] = 1 * unit

    globalDistances[hallways[2470]!! to hallways[2480]!!] = 2.5 * unit
    globalDistances[hallways[2480]!! to hallways[2470]!!] = 2.5 * unit

    globalDistances[hallways[2480]!! to hallways[2620]!!] = 1.5 * unit
    globalDistances[hallways[2620]!! to hallways[2480]!!] = 1.5 * unit

    globalDistances[hallways[2490]!! to hallways[2500]!!] = 1.5 * unit
    globalDistances[hallways[2500]!! to hallways[2490]!!] = 1.5 * unit

    globalDistances[hallways[2500]!! to hallways[2510]!!] = 1.5 * unit
    globalDistances[hallways[2510]!! to hallways[2500]!!] = 1.5 * unit

    globalDistances[hallways[2510]!! to hallways[2630]!!] = 1.5 * unit
    globalDistances[hallways[2630]!! to hallways[2510]!!] = 1.5 * unit

    globalDistances[hallways[2520]!! to hallways[2530]!!] = 2.5 * unit
    globalDistances[hallways[2530]!! to hallways[2520]!!] = 2.5 * unit

    globalDistances[hallways[2530]!! to hallways[2660]!!] = 1.5 * unit
    globalDistances[hallways[2660]!! to hallways[2530]!!] = 1.5 * unit

    globalDistances[hallways[2540]!! to hallways[2550]!!] = 1 * unit
    globalDistances[hallways[2550]!! to hallways[2540]!!] = 1 * unit

    globalDistances[hallways[2550]!! to hallways[2560]!!] = 1 * unit
    globalDistances[hallways[2560]!! to hallways[2550]!!] = 1 * unit

    globalDistances[hallways[2560]!! to hallways[2570]!!] = 1 * unit
    globalDistances[hallways[2570]!! to hallways[2560]!!] = 1 * unit

    globalDistances[hallways[2570]!! to hallways[2680]!!] = 1.5 * unit
    globalDistances[hallways[2680]!! to hallways[2570]!!] = 1.5 * unit

    globalDistances[hallways[2580]!! to hallways[2590]!!] = 2 * unit
    globalDistances[hallways[2590]!! to hallways[2580]!!] = 2 * unit

    globalDistances[hallways[2580]!! to hallways[2740]!!] = 2 * unit
    globalDistances[hallways[2740]!! to hallways[2580]!!] = 2 * unit

    globalDistances[hallways[2580]!! to hallways[2590]!!] = 2.5 * unit
    globalDistances[hallways[2590]!! to hallways[2580]!!] = 2.5 * unit

    globalDistances[hallways[2590]!! to hallways[2600]!!] = 2.5 * unit
    globalDistances[hallways[2600]!! to hallways[2590]!!] = 2.5 * unit

    globalDistances[hallways[2600]!! to hallways[2610]!!] = 1 * unit
    globalDistances[hallways[2610]!! to hallways[2600]!!] = 1 * unit

    globalDistances[hallways[2610]!! to hallways[2620]!!] = 1.5 * unit
    globalDistances[hallways[2620]!! to hallways[2610]!!] = 1.5 * unit

    globalDistances[hallways[2610]!! to hallways[2810]!!] = 2 * unit
    globalDistances[hallways[2810]!! to hallways[2610]!!] = 2 * unit

    globalDistances[hallways[2620]!! to hallways[2630]!!] = 2.5 * unit
    globalDistances[hallways[2630]!! to hallways[2620]!!] = 2.5 * unit

    globalDistances[hallways[2630]!! to hallways[2640]!!] = 1.5 * unit
    globalDistances[hallways[2640]!! to hallways[2630]!!] = 1.5 * unit

    globalDistances[hallways[2640]!! to hallways[2650]!!] = 1.5 * unit
    globalDistances[hallways[2650]!! to hallways[2640]!!] = 1.5 * unit

    globalDistances[hallways[2650]!! to hallways[2660]!!] = 2.5 * unit
    globalDistances[hallways[2660]!! to hallways[2650]!!] = 2.5 * unit

    globalDistances[hallways[2660]!! to hallways[2670]!!] = 1.5 * unit
    globalDistances[hallways[2670]!! to hallways[2660]!!] = 1.5 * unit

    globalDistances[hallways[2670]!! to hallways[2680]!!] = 2 * unit
    globalDistances[hallways[2680]!! to hallways[2670]!!] = 2 * unit

    globalDistances[hallways[2680]!! to hallways[2690]!!] = 1.5 * unit
    globalDistances[hallways[2690]!! to hallways[2680]!!] = 1.5 * unit

    globalDistances[hallways[2690]!! to hallways[2700]!!] = 1 * unit
    globalDistances[hallways[2700]!! to hallways[2690]!!] = 1 * unit

    globalDistances[hallways[2700]!! to hallways[2710]!!] = 1 * unit
    globalDistances[hallways[2710]!! to hallways[2700]!!] = 1 * unit

    globalDistances[hallways[2710]!! to hallways[2720]!!] = 1 * unit
    globalDistances[hallways[2720]!! to hallways[2710]!!] = 1 * unit

    globalDistances[hallways[2720]!! to hallways[2730]!!] = 1 * unit
    globalDistances[hallways[2730]!! to hallways[2720]!!] = 1 * unit

    globalDistances[hallways[2740]!! to hallways[2750]!!] = 1.5 * unit
    globalDistances[hallways[2750]!! to hallways[2740]!!] = 1.5 * unit

    globalDistances[hallways[2750]!! to hallways[2760]!!] = 1 * unit
    globalDistances[hallways[2760]!! to hallways[2750]!!] = 1 * unit

    globalDistances[hallways[2760]!! to hallways[2770]!!] = 1 * unit
    globalDistances[hallways[2770]!! to hallways[2760]!!] = 1 * unit

    globalDistances[hallways[2770]!! to hallways[2780]!!] = 1 * unit
    globalDistances[hallways[2780]!! to hallways[2770]!!] = 1 * unit

    globalDistances[hallways[2780]!! to hallways[2790]!!] = 1 * unit
    globalDistances[hallways[2790]!! to hallways[2780]!!] = 1 * unit

    globalDistances[hallways[2790]!! to hallways[2800]!!] = 1 * unit
    globalDistances[hallways[2800]!! to hallways[2790]!!] = 1 * unit

    globalDistances[hallways[2800]!! to hallways[2810]!!] = 1 * unit
    globalDistances[hallways[2810]!! to hallways[2800]!!] = 1 * unit

    globalDistances[hallways[2810]!! to hallways[2820]!!] = 1 * unit
    globalDistances[hallways[2820]!! to hallways[2810]!!] = 1 * unit

    globalDistances[hallways[2820]!! to hallways[2830]!!] = 1 * unit
    globalDistances[hallways[2830]!! to hallways[2820]!!] = 1 * unit

    globalDistances[hallways[2840]!! to hallways[2850]!!] = 1 * unit
    globalDistances[hallways[2850]!! to hallways[2840]!!] = 1 * unit

    globalDistances[hallways[2840]!! to hallways[2890]!!] = 2 * unit
    globalDistances[hallways[2890]!! to hallways[2840]!!] = 2 * unit

    globalDistances[hallways[2850]!! to hallways[2860]!!] = 1 * unit
    globalDistances[hallways[2860]!! to hallways[2850]!!] = 1 * unit

    globalDistances[hallways[2860]!! to hallways[2870]!!] = 1 * unit
    globalDistances[hallways[2870]!! to hallways[2860]!!] = 1 * unit

    globalDistances[hallways[2870]!! to hallways[2900]!!] = 2 * unit
    globalDistances[hallways[2900]!! to hallways[2870]!!] = 2 * unit

    globalDistances[hallways[2880]!! to hallways[2890]!!] = 1 * unit
    globalDistances[hallways[2890]!! to hallways[2880]!!] = 1 * unit

    globalDistances[hallways[2880]!! to hallways[2930]!!] = 2 * unit
    globalDistances[hallways[2930]!! to hallways[2880]!!] = 2 * unit

    globalDistances[hallways[2890]!! to hallways[2900]!!] = 2.5 * unit
    globalDistances[hallways[2900]!! to hallways[2890]!!] = 2.5 * unit

    globalDistances[hallways[2900]!! to hallways[2910]!!] = 1 * unit
    globalDistances[hallways[2910]!! to hallways[2900]!!] = 1 * unit

    globalDistances[hallways[2910]!! to hallways[2920]!!] = 2.5 * unit
    globalDistances[hallways[2920]!! to hallways[2910]!!] = 2.5 * unit

    globalDistances[hallways[2920]!! to hallways[2580]!!] = 2.5 * unit
    globalDistances[hallways[2580]!! to hallways[2920]!!] = 2.5 * unit

    globalDistances[hallways[2930]!! to hallways[2940]!!] = 1.5 * unit
    globalDistances[hallways[2940]!! to hallways[2930]!!] = 1.5 * unit

    globalDistances[hallways[2930]!! to hallways[2880]!!] = 1 * unit
    globalDistances[hallways[2880]!! to hallways[2930]!!] = 1 * unit

    globalDistances[hallways[2940]!! to hallways[2950]!!] = 1 * unit
    globalDistances[hallways[2950]!! to hallways[2940]!!] = 1 * unit

    globalDistances[hallways[2950]!! to hallways[2960]!!] = 1 * unit
    globalDistances[hallways[2960]!! to hallways[2950]!!] = 1 * unit

    globalDistances[hallways[2960]!! to hallways[2970]!!] = 1 * unit
    globalDistances[hallways[2970]!! to hallways[2960]!!] = 1 * unit

    globalDistances[hallways[2970]!! to hallways[2910]!!] = 2 * unit
    globalDistances[hallways[2910]!! to hallways[2970]!!] = 2 * unit
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


