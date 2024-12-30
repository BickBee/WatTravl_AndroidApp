package com.example.wattravl.model.DC
import com.example.wattravl.model.MC.unit
import com.example.wattravl.model.MC.HallwayNode
import com.example.wattravl.model.MC.globalDistances

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
    return (3010..3990).associateWith { HallwayNode(nodeId = it) }
}


fun setDistances3(hallways: Map<Int, HallwayNode>) {
    globalDistances[hallways[3010]!! to hallways[3020]!!] = 0.5 * unit
    globalDistances[hallways[3020]!! to hallways[3010]!!] = 0.5 * unit

    globalDistances[hallways[3020]!! to hallways[3030]!!] = 1 * unit
    globalDistances[hallways[3030]!! to hallways[3020]!!] = 1 * unit

    globalDistances[hallways[3030]!! to hallways[3040]!!] = 1 * unit
    globalDistances[hallways[3040]!! to hallways[3030]!!] = 1 * unit

    globalDistances[hallways[3040]!! to hallways[3050]!!] = 1 * unit
    globalDistances[hallways[3050]!! to hallways[3040]!!] = 1 * unit

    globalDistances[hallways[3050]!! to hallways[3060]!!] = 1 * unit
    globalDistances[hallways[3060]!! to hallways[3050]!!] = 1 * unit

    globalDistances[hallways[3060]!! to hallways[3070]!!] = 1 * unit
    globalDistances[hallways[3070]!! to hallways[3060]!!] = 1 * unit

    globalDistances[hallways[3070]!! to hallways[3080]!!] = 1.5 * unit
    globalDistances[hallways[3080]!! to hallways[3070]!!] = 1.5 * unit

    globalDistances[hallways[3080]!! to hallways[3150]!!] = 2.5 * unit
    globalDistances[hallways[3150]!! to hallways[3080]!!] = 2.5 * unit

    globalDistances[hallways[3090]!! to hallways[3010]!!] = 1 * unit
    globalDistances[hallways[3010]!! to hallways[3090]!!] = 1 * unit

    globalDistances[hallways[3090]!! to hallways[3100]!!] = 1 * unit
    globalDistances[hallways[3100]!! to hallways[3090]!!] = 1 * unit

    globalDistances[hallways[3100]!! to hallways[3110]!!] = 1 * unit
    globalDistances[hallways[3110]!! to hallways[3100]!!] = 1 * unit

    globalDistances[hallways[3110]!! to hallways[3120]!!] = 2 * unit
    globalDistances[hallways[3120]!! to hallways[3110]!!] = 2 * unit

    globalDistances[hallways[3120]!! to hallways[3360]!!] = 0.5 * unit
    globalDistances[hallways[3360]!! to hallways[3120]!!] = 0.5 * unit

    globalDistances[hallways[3120]!! to hallways[3130]!!] = 2 * unit
    globalDistances[hallways[3130]!! to hallways[3120]!!] = 2 * unit

    globalDistances[hallways[3130]!! to hallways[3140]!!] = 0.5 * unit
    globalDistances[hallways[3140]!! to hallways[3130]!!] = 0.5 * unit

    globalDistances[hallways[3140]!! to hallways[3400]!!] = 1 * unit
    globalDistances[hallways[3400]!! to hallways[3140]!!] = 1 * unit

    globalDistances[hallways[3140]!! to hallways[3150]!!] = 1 * unit
    globalDistances[hallways[3150]!! to hallways[3140]!!] = 1 * unit

    globalDistances[hallways[3150]!! to hallways[3160]!!] = 2.5 * unit
    globalDistances[hallways[3160]!! to hallways[3150]!!] = 2.5 * unit

    globalDistances[hallways[3160]!! to hallways[3170]!!] = 3 * unit
    globalDistances[hallways[3170]!! to hallways[3160]!!] = 3 * unit

    globalDistances[hallways[3170]!! to hallways[3180]!!] = 1.5 * unit
    globalDistances[hallways[3180]!! to hallways[3170]!!] = 1.5 * unit

    globalDistances[hallways[3180]!! to hallways[3440]!!] = 1 * unit
    globalDistances[hallways[3440]!! to hallways[3180]!!] = 1 * unit

    globalDistances[hallways[3180]!! to hallways[3190]!!] = 3 * unit
    globalDistances[hallways[3190]!! to hallways[3180]!!] = 3 * unit

    globalDistances[hallways[3190]!! to hallways[3200]!!] = 3 * unit
    globalDistances[hallways[3200]!! to hallways[3190]!!] = 3 * unit

    globalDistances[hallways[3200]!! to hallways[3210]!!] = 1.5 * unit
    globalDistances[hallways[3210]!! to hallways[3200]!!] = 1.5 * unit

    globalDistances[hallways[3210]!! to hallways[3220]!!] = 2.5 * unit
    globalDistances[hallways[3220]!! to hallways[3210]!!] = 2.5 * unit

    globalDistances[hallways[3220]!! to hallways[3230]!!] = 1.5 * unit
    globalDistances[hallways[3230]!! to hallways[3220]!!] = 1.5 * unit

    globalDistances[hallways[3230]!! to hallways[3240]!!] = 1 * unit
    globalDistances[hallways[3240]!! to hallways[3230]!!] = 1 * unit

    globalDistances[hallways[3240]!! to hallways[3250]!!] = 1 * unit
    globalDistances[hallways[3250]!! to hallways[3240]!!] = 1 * unit

    globalDistances[hallways[3250]!! to hallways[3260]!!] = 1 * unit
    globalDistances[hallways[3260]!! to hallways[3250]!!] = 1 * unit

    globalDistances[hallways[3260]!! to hallways[3270]!!] = 1 * unit
    globalDistances[hallways[3270]!! to hallways[3260]!!] = 1 * unit

    globalDistances[hallways[3270]!! to hallways[3280]!!] = 1 * unit
    globalDistances[hallways[3280]!! to hallways[3270]!!] = 1 * unit

    globalDistances[hallways[3280]!! to hallways[3290]!!] = 1 * unit
    globalDistances[hallways[3290]!! to hallways[3280]!!] = 1 * unit

    globalDistances[hallways[3290]!! to hallways[3300]!!] = 1 * unit
    globalDistances[hallways[3300]!! to hallways[3290]!!] = 1 * unit

    globalDistances[hallways[3300]!! to hallways[3310]!!] = 1 * unit
    globalDistances[hallways[3310]!! to hallways[3300]!!] = 1 * unit

    globalDistances[hallways[3310]!! to hallways[3320]!!] = 1 * unit
    globalDistances[hallways[3320]!! to hallways[3310]!!] = 1 * unit

    globalDistances[hallways[3320]!! to hallways[3330]!!] = 1 * unit
    globalDistances[hallways[3330]!! to hallways[3320]!!] = 1 * unit

    globalDistances[hallways[3330]!! to hallways[3340]!!] = 1 * unit
    globalDistances[hallways[3340]!! to hallways[3330]!!] = 1 * unit

    globalDistances[hallways[3340]!! to hallways[3350]!!] = 1 * unit
    globalDistances[hallways[3350]!! to hallways[3340]!!] = 1 * unit

    globalDistances[hallways[3350]!! to hallways[3980]!!] = 1 * unit
    globalDistances[hallways[3980]!! to hallways[3350]!!] = 1 * unit

    globalDistances[hallways[3360]!! to hallways[3370]!!] = 1.5 * unit
    globalDistances[hallways[3370]!! to hallways[3360]!!] = 1.5 * unit

    globalDistances[hallways[3370]!! to hallways[3380]!!] = 1 * unit
    globalDistances[hallways[3380]!! to hallways[3370]!!] = 1 * unit

    globalDistances[hallways[3380]!! to hallways[3390]!!] = 1.5 * unit
    globalDistances[hallways[3390]!! to hallways[3380]!!] = 1.5 * unit

    globalDistances[hallways[3390]!! to hallways[3530]!!] = 1.5 * unit
    globalDistances[hallways[3530]!! to hallways[3390]!!] = 1.5 * unit

    globalDistances[hallways[3400]!! to hallways[3410]!!] = 1 * unit
    globalDistances[hallways[3410]!! to hallways[3400]!!] = 1 * unit

    globalDistances[hallways[3410]!! to hallways[3420]!!] = 1.5 * unit
    globalDistances[hallways[3420]!! to hallways[3410]!!] = 1.5 * unit

    globalDistances[hallways[3420]!! to hallways[3430]!!] = 1 * unit
    globalDistances[hallways[3430]!! to hallways[3420]!!] = 1 * unit

    globalDistances[hallways[3430]!! to hallways[3540]!!] = 1 * unit
    globalDistances[hallways[3540]!! to hallways[3430]!!] = 1 * unit

    globalDistances[hallways[3440]!! to hallways[3450]!!] = 2 * unit
    globalDistances[hallways[3450]!! to hallways[3440]!!] = 2 * unit

    globalDistances[hallways[3450]!! to hallways[3590]!!] = 2.5 * unit
    globalDistances[hallways[3590]!! to hallways[3450]!!] = 2.5 * unit

    globalDistances[hallways[3460]!! to hallways[3470]!!] = 1 * unit
    globalDistances[hallways[3470]!! to hallways[3460]!!] = 1 * unit

    globalDistances[hallways[3470]!! to hallways[3480]!!] = 1 * unit
    globalDistances[hallways[3480]!! to hallways[3470]!!] = 1 * unit

    globalDistances[hallways[3480]!! to hallways[3490]!!] = 1 * unit
    globalDistances[hallways[3490]!! to hallways[3480]!!] = 1 * unit

    globalDistances[hallways[3490]!! to hallways[3640]!!] = 1 * unit
    globalDistances[hallways[3640]!! to hallways[3490]!!] = 1 * unit

    globalDistances[hallways[3500]!! to hallways[3510]!!] = 0.5 * unit
    globalDistances[hallways[3510]!! to hallways[3500]!!] = 0.5 * unit

    globalDistances[hallways[3510]!! to hallways[3520]!!] = 1.5 * unit
    globalDistances[hallways[3520]!! to hallways[3510]!!] = 1.5 * unit

    globalDistances[hallways[3520]!! to hallways[3530]!!] = 1 * unit
    globalDistances[hallways[3530]!! to hallways[3520]!!] = 1 * unit

    globalDistances[hallways[3530]!! to hallways[3540]!!] = 2 * unit
    globalDistances[hallways[3540]!! to hallways[3530]!!] = 2 * unit

    globalDistances[hallways[3540]!! to hallways[3550]!!] = 1 * unit
    globalDistances[hallways[3550]!! to hallways[3540]!!] = 1 * unit

    globalDistances[hallways[3550]!! to hallways[3560]!!] = 2 * unit
    globalDistances[hallways[3560]!! to hallways[3550]!!] = 2 * unit

    globalDistances[hallways[3560]!! to hallways[3570]!!] = 1 * unit
    globalDistances[hallways[3570]!! to hallways[3560]!!] = 1 * unit

    globalDistances[hallways[3570]!! to hallways[3580]!!] = 1 * unit
    globalDistances[hallways[3580]!! to hallways[3570]!!] = 1 * unit

    globalDistances[hallways[3580]!! to hallways[3590]!!] = 1 * unit
    globalDistances[hallways[3590]!! to hallways[3580]!!] = 1 * unit

    globalDistances[hallways[3590]!! to hallways[3600]!!] = 2 * unit
    globalDistances[hallways[3600]!! to hallways[3590]!!] = 2 * unit

    globalDistances[hallways[3600]!! to hallways[3610]!!] = 1.5 * unit
    globalDistances[hallways[3610]!! to hallways[3600]!!] = 1.5 * unit

    globalDistances[hallways[3610]!! to hallways[3620]!!] = 1 * unit
    globalDistances[hallways[3620]!! to hallways[3610]!!] = 1 * unit

    globalDistances[hallways[3620]!! to hallways[3630]!!] = 1.5 * unit
    globalDistances[hallways[3630]!! to hallways[3620]!!] = 1.5 * unit

    globalDistances[hallways[3630]!! to hallways[3640]!!] = 2 * unit
    globalDistances[hallways[3640]!! to hallways[3630]!!] = 2 * unit

    globalDistances[hallways[3640]!! to hallways[3650]!!] = 1.5 * unit
    globalDistances[hallways[3650]!! to hallways[3640]!!] = 1.5 * unit

    globalDistances[hallways[3650]!! to hallways[3660]!!] = 1 * unit
    globalDistances[hallways[3660]!! to hallways[3650]!!] = 1 * unit

    globalDistances[hallways[3660]!! to hallways[3670]!!] = 1 * unit
    globalDistances[hallways[3670]!! to hallways[3660]!!] = 1 * unit

    globalDistances[hallways[3670]!! to hallways[3680]!!] = 1 * unit
    globalDistances[hallways[3680]!! to hallways[3670]!!] = 1 * unit

    globalDistances[hallways[3680]!! to hallways[3690]!!] = 1 * unit
    globalDistances[hallways[3690]!! to hallways[3680]!!] = 1 * unit

    globalDistances[hallways[3700]!! to hallways[3710]!!] = 1.5 * unit
    globalDistances[hallways[3710]!! to hallways[3700]!!] = 1.5 * unit

    globalDistances[hallways[3710]!! to hallways[3720]!!] = 1.5 * unit
    globalDistances[hallways[3720]!! to hallways[3710]!!] = 1.5 * unit

    globalDistances[hallways[3720]!! to hallways[3730]!!] = 1 * unit
    globalDistances[hallways[3730]!! to hallways[3720]!!] = 1 * unit

    globalDistances[hallways[3730]!! to hallways[3740]!!] = 1 * unit
    globalDistances[hallways[3740]!! to hallways[3730]!!] = 1 * unit

    globalDistances[hallways[3740]!! to hallways[3750]!!] = 1 * unit
    globalDistances[hallways[3750]!! to hallways[3740]!!] = 1 * unit

    globalDistances[hallways[3750]!! to hallways[3760]!!] = 1 * unit
    globalDistances[hallways[3760]!! to hallways[3750]!!] = 1 * unit

    globalDistances[hallways[3760]!! to hallways[3770]!!] = 1 * unit
    globalDistances[hallways[3770]!! to hallways[3760]!!] = 1 * unit

    globalDistances[hallways[3770]!! to hallways[3780]!!] = 1 * unit
    globalDistances[hallways[3780]!! to hallways[3770]!!] = 1 * unit

    globalDistances[hallways[3780]!! to hallways[3790]!!] = 1.5 * unit
    globalDistances[hallways[3790]!! to hallways[3780]!!] = 1.5 * unit

    globalDistances[hallways[3800]!! to hallways[3810]!!] = 1.5 * unit
    globalDistances[hallways[3810]!! to hallways[3800]!!] = 1.5 * unit

    globalDistances[hallways[3810]!! to hallways[3820]!!] = 0.5 * unit
    globalDistances[hallways[3820]!! to hallways[3810]!!] = 0.5 * unit

    globalDistances[hallways[3820]!! to hallways[3830]!!] = 1 * unit
    globalDistances[hallways[3830]!! to hallways[3820]!!] = 1 * unit

    globalDistances[hallways[3830]!! to hallways[3840]!!] = 1 * unit
    globalDistances[hallways[3840]!! to hallways[3830]!!] = 1 * unit

    globalDistances[hallways[3840]!! to hallways[3850]!!] = 1.5 * unit
    globalDistances[hallways[3850]!! to hallways[3840]!!] = 1.5 * unit

    globalDistances[hallways[3850]!! to hallways[3880]!!] = 1.5 * unit
    globalDistances[hallways[3880]!! to hallways[3850]!!] = 1.5 * unit

    globalDistances[hallways[3860]!! to hallways[3870]!!] = 3 * unit
    globalDistances[hallways[3870]!! to hallways[3860]!!] = 3 * unit

    globalDistances[hallways[3880]!! to hallways[3500]!!] = 5 * unit
    globalDistances[hallways[3500]!! to hallways[3880]!!] = 5 * unit

    globalDistances[hallways[3880]!! to hallways[3970]!!] = 1 * unit
    globalDistances[hallways[3970]!! to hallways[3880]!!] = 1 * unit

    globalDistances[hallways[3890]!! to hallways[3860]!!] = 1 * unit
    globalDistances[hallways[3860]!! to hallways[3890]!!] = 1 * unit

    globalDistances[hallways[3890]!! to hallways[3900]!!] = 1 * unit
    globalDistances[hallways[3900]!! to hallways[3890]!!] = 1 * unit

    globalDistances[hallways[3900]!! to hallways[3910]!!] = 1 * unit
    globalDistances[hallways[3910]!! to hallways[3900]!!] = 1 * unit

    globalDistances[hallways[3910]!! to hallways[3920]!!] = 1 * unit
    globalDistances[hallways[3920]!! to hallways[3910]!!] = 1 * unit

    globalDistances[hallways[3920]!! to hallways[3930]!!] = 1 * unit
    globalDistances[hallways[3930]!! to hallways[3920]!!] = 1 * unit

    globalDistances[hallways[3930]!! to hallways[3940]!!] = 1 * unit
    globalDistances[hallways[3940]!! to hallways[3930]!!] = 1 * unit

    globalDistances[hallways[3940]!! to hallways[3950]!!] = 1 * unit
    globalDistances[hallways[3950]!! to hallways[3940]!!] = 1 * unit

    globalDistances[hallways[3950]!! to hallways[3960]!!] = 0.5 * unit
    globalDistances[hallways[3960]!! to hallways[3950]!!] = 0.5 * unit

    globalDistances[hallways[3960]!! to hallways[3970]!!] = 1 * unit
    globalDistances[hallways[3970]!! to hallways[3960]!!] = 1 * unit

    globalDistances[hallways[3970]!! to hallways[3880]!!] = 2 * unit
    globalDistances[hallways[3880]!! to hallways[3970]!!] = 2 * unit

    globalDistances[hallways[3980]!! to hallways[3350]!!] = 1 * unit
    globalDistances[hallways[3350]!! to hallways[3980]!!] = 1 * unit

    globalDistances[hallways[3980]!! to hallways[3990]!!] = 1 * unit
    globalDistances[hallways[3990]!! to hallways[3980]!!] = 1 * unit
}



fun connectClassroomsToHallways3(hallways: Map<Int, HallwayNode>) {
    hallways[3010]?.classrooms?.addAll(listOf(3631, 3629))
    hallways[3020]?.classrooms?.addAll(listOf(3626, 3627))
    hallways[3030]?.classrooms?.addAll(listOf(3622, 3624, 3625, 3623))
    hallways[3040]?.classrooms?.addAll(listOf(3618, 3620, 3619, 3621))
    hallways[3050]?.classrooms?.addAll(listOf(3614, 3616, 3615, 3617))
    hallways[3060]?.classrooms?.addAll(listOf(3612, 3608, 3611, 3613))
    hallways[3070]?.classrooms?.addAll(listOf(3608, 3606, 3607, 3609))
    hallways[3080]?.classrooms?.addAll(listOf(3601, 3602, 3603, 3605, 3807)) // 3807 is stair
    hallways[3090]?.classrooms?.add(3809) // stair
    hallways[3100]?.classrooms?.add(3586)
    hallways[3110]?.classrooms?.add(3587)
    //hallways[3120]?.classrooms?.addAll(listOf(3601, 3603))
    hallways[3130]?.classrooms?.add(3923) // washroom
    hallways[3140]?.classrooms?.add(3922)
    //hallways[3150]?.classrooms?.add(3592)
    hallways[3160]?.classrooms?.addAll(listOf(3594, 35941, 35942, 35491)) 
    hallways[3170]?.classrooms?.add(3805) // stair
    //hallways[3180]?.classrooms?.add(3807) // stair
    hallways[3190]?.classrooms?.addAll(listOf(3930, 39301, 3818, 3301, 33011, 33012, 33013, 33014, 33015)) // 3818 is elevator
    //hallways[3200]?.classrooms?.add(3805) // stair
    //hallways[3210]?.classrooms?.addAll(listOf(3040, 3078))
    hallways[3220]?.classrooms?.addAll(listOf(3934, 3931)) // 3934 is elevator, 3931 is washroom
    hallways[3230]?.classrooms?.add(3802) // stair 
    hallways[3240]?.classrooms?.addAll(listOf(3102, 3103, 3105, 3106))
    hallways[3250]?.classrooms?.addAll(listOf(3107, 3108, 3109, 3110))
    hallways[3260]?.classrooms?.addAll(listOf(3111, 3112, 3113, 3114))
    hallways[3270]?.classrooms?.addAll(listOf(3115, 3116, 3117, 3118))
    hallways[3280]?.classrooms?.addAll(listOf(3119, 3120, 3121, 3122))
    hallways[3290]?.classrooms?.addAll(listOf(3123, 3124, 3125))
    hallways[3300]?.classrooms?.addAll(listOf(3126, 3126, 3128, 3129))
    hallways[3310]?.classrooms?.addAll(listOf(3131, 3132, 3133, 3134))
    hallways[3320]?.classrooms?.addAll(listOf(3136, 3138, 3801)) // 3801 is stair
    hallways[3330]?.classrooms?.addAll(listOf(3139, 3140, 3141, 3142))
    hallways[3340]?.classrooms?.addAll(listOf(3140, 3144, 3145, 3146))
    hallways[3350]?.classrooms?.addAll(listOf(3147, 3150))
    hallways[3360]?.classrooms?.addAll(listOf(3582, 3580))
    hallways[3370]?.classrooms?.add(3578) 
    hallways[3380]?.classrooms?.addAll(listOf(3576, 3574, 3577, 35771, 35851, 35852, 35853, 35854, 35855))
    hallways[3390]?.classrooms?.add(3572)
    hallways[3400]?.classrooms?.addAll(listOf(3562, 3566))
    hallways[3410]?.classrooms?.addAll(listOf(3558, 3556, 3565))
    hallways[3420]?.classrooms?.addAll(listOf(3552, 3553, 3554))
    hallways[3430]?.classrooms?.addAll(listOf(35524, 3550, 3551))
    hallways[3440]?.classrooms?.addAll(listOf(3540, 35401, 35402, 35403, 35404, 35405, 35406, 35407))
    hallways[3450]?.classrooms?.addAll(listOf(3544))
    hallways[3460]?.classrooms?.add(3317)
    hallways[3470]?.classrooms?.addAll(listOf(3323, 3301, 33101, 33102, 33103, 33104, 33105))
    hallways[3480]?.classrooms?.addAll(listOf(3325, 3327))
    hallways[3490]?.classrooms?.addAll(listOf(3329, 3331))
    hallways[3500]?.classrooms?.addAll(listOf(3585, 35851, 35852, 35853, 35854))
    hallways[3510]?.classrooms?.addAll(listOf(3584, 35841, 35842, 35843))
    hallways[3520]?.classrooms?.add(3583)
    hallways[3530]?.classrooms?.addAll(listOf(3570, 3571))
    hallways[3540]?.classrooms?.addAll(listOf(3920, 3921)) // 3921 is washroom
    //hallways[3550]?.classrooms?.addAll(listOf(3321, 3323, 3305, 33051, 33052, 33053, 33054, 33055))
    hallways[3560]?.classrooms?.addAll(listOf(3549, 35491, 35492, 35493, 35494))
    hallways[3570]?.classrooms?.addAll(listOf(3548, 35483, 35486, 35488, 35491, 35492, 35494))
    hallways[3580]?.classrooms?.add(3806) // stair
    //hallways[3590]?.classrooms?.addAll(listOf(3827, 3531, 3523, 35231, 35232, 35233)) // 3827 is stair
    hallways[3600]?.classrooms?.add(3336)
    hallways[3610]?.classrooms?.addAll(listOf(3335, 33351))
    hallways[3620]?.classrooms?.addAll(listOf(3333, 33331, 33332, 33333, 33334, 33335, 33336, 33337, 33338, 333310))
    //hallways[3630]?.classrooms?.add(3806) // stair
    hallways[3640]?.classrooms?.addAll(listOf(3932, 3933)) // 3932 is washroom
    hallways[3650]?.classrooms?.addAll(listOf(3341, 3803)) // 3803 is stair
    hallways[3660]?.classrooms?.addAll(listOf(3342, 3343, 3344, 3345))
    hallways[3670]?.classrooms?.addAll(listOf(3346, 3347, 3348, 3349))
    hallways[3680]?.classrooms?.addAll(listOf(3350, 3351, 3353, 3804)) // 3804 is washroom
    hallways[3690]?.classrooms?.addAll(listOf(3354, 3355))
    hallways[3700]?.classrooms?.add(3810) // stair
    hallways[3710]?.classrooms?.addAll(listOf(3532, 3530, 3528))
    hallways[3720]?.classrooms?.addAll(listOf(3523, 3524, 3525, 35251, 3526)) 
    hallways[3730]?.classrooms?.addAll(listOf(3519, 3520, 3521, 3522))
    hallways[3740]?.classrooms?.addAll(listOf(3515, 3516, 3517, 3518))
    hallways[3750]?.classrooms?.addAll(listOf(3511, 3512, 3513, 3514))
    hallways[3760]?.classrooms?.addAll(listOf(3507, 3508, 3509, 3510))
    hallways[3770]?.classrooms?.addAll(listOf(3504, 3506))
    hallways[3780]?.classrooms?.addAll(listOf(3501, 3502))
    hallways[3790]?.classrooms?.add(3808) // stair
    hallways[3800]?.classrooms?.addAll(listOf(37017, 37015, 37018, 37014, 37013, 38381)) 
    hallways[3810]?.classrooms?.add(3709)
    hallways[3820]?.classrooms?.add(3707)
    hallways[3830]?.classrooms?.add(3705)
    hallways[3840]?.classrooms?.add(3702)
    hallways[3850]?.classrooms?.addAll(listOf(3701, 37011, 37012))
    hallways[3860]?.classrooms?.addAll(listOf(3817, 3711, 38364)) // 3817 is elevator, 38364 is stair
    hallways[3870]?.classrooms?.addAll(listOf(3838, 38363)) // 3836, 38363 is stair
    //hallways[3880]?.classrooms?.addAll(listOf(3742, 37421, 3812, 3817)) // 3817 is elevator, 3812 is stair
    hallways[3890]?.classrooms?.addAll(listOf(3812, 3078)) // 3812 is stair
    hallways[3900]?.classrooms?.addAll(listOf(3734, 3731)) 
    hallways[3910]?.classrooms?.addAll(listOf(3729, 3730)) 
    hallways[3920]?.classrooms?.addAll(listOf(3725, 3726)) 
    hallways[3930]?.classrooms?.addAll(listOf(3721, 3722))
    hallways[3940]?.classrooms?.addAll(listOf(3717, 3718))
    hallways[3950]?.classrooms?.addAll(listOf(3714, 3715, 3716))
    hallways[3960]?.classrooms?.add(3712)
    hallways[3970]?.classrooms?.add(3811) // stair
    hallways[3980]?.classrooms?.add(3149) 
    hallways[3990]?.classrooms?.add(3853) // bridge
}


fun connectHallways3(hallways: Map<Int, HallwayNode>) {
    hallways[3010]?.apply {
        east = hallways[3020]
        south = hallways[3090]
    }
    hallways[3020]?.apply {
        west = hallways[3010]
        east = hallways[3030]
    }
    hallways[3030]?.apply {
        west = hallways[3020] 
        east = hallways[3040]
    }
    hallways[3040]?.apply {
        west = hallways[3030] 
        east = hallways[3050]
    }
    hallways[3050]?.apply {
        west = hallways[3040] 
        east = hallways[3060]
    }
    hallways[3060]?.apply {
        west = hallways[3050] 
        east = hallways[3070]
    }
    hallways[3070]?.apply {
        west = hallways[3060] 
        east = hallways[3080]
    }
    hallways[3080]?.apply {
        west = hallways[3070]
        south = hallways[3150]
    }
    hallways[3090]?.apply {
        north = hallways[3010]
        south = hallways[3100]
    }
    hallways[3100]?.apply {
        east = hallways[3110]
    }
    hallways[3110]?.apply {
        west = hallways[3100]
        east = hallways[3120]
    }
    hallways[3120]?.apply {
        west = hallways[3110]
        east = hallways[3130]
        south = hallways[3360]
    }
    hallways[3130]?.apply {
        west = hallways[3120]
        east = hallways[3140]
    }
    hallways[3140]?.apply {
        west = hallways[3130]
        east = hallways[3150]
        south = hallways[3400]
    }
    hallways[3150]?.apply {
        west = hallways[3140]
        east = hallways[3160]
    }
    hallways[3160]?.apply {
        west = hallways[3150]
        east = hallways[3170]
    }
    hallways[3170]?.apply {
        west = hallways[3160]
        east = hallways[3180]
    }
    hallways[3180]?.apply {
        west = hallways[3170]
        east = hallways[3190]
        south = hallways[3440]
    }
    hallways[3190]?.apply {
        west = hallways[3180]
        east = hallways[3200]
    }
    hallways[3200]?.apply {
        west = hallways[3190]
        east = hallways[3210]
    }
    hallways[3210]?.apply {
        west = hallways[3200]
        east = hallways[3220]
    }
    hallways[3220]?.apply {
        west = hallways[3210]
        north = hallways[3230]
        south = hallways[3460]
    }
    hallways[3230]?.apply {
        south = hallways[3220]
        north = hallways[3240]
    }

    hallways[3240]?.apply {
        south = hallways[3230]
        north = hallways[3250]
    }

    hallways[3250]?.apply {
        south = hallways[3240]
        north = hallways[3260]
    }

    hallways[3260]?.apply {
        south = hallways[3250]
        north = hallways[3270]
    }

    hallways[3270]?.apply {
        south = hallways[3260]
        north = hallways[3280]
    }

    hallways[3280]?.apply {
        south = hallways[3270]
        north = hallways[3290]
    }

    hallways[3290]?.apply {
        south = hallways[3280]
        north = hallways[3300]
    }

    hallways[3300]?.apply {
        south = hallways[3290]
        north = hallways[3310]
    }

    hallways[3310]?.apply {
        south = hallways[3300]
        north = hallways[3320]
    }

    hallways[3320]?.apply {
        south = hallways[3310]
        north = hallways[3330]
    }

    hallways[3330]?.apply {
        south = hallways[3320]
        north = hallways[3340]
    }

    hallways[3340]?.apply {
        south = hallways[3330]
        north = hallways[3350]
    }

    hallways[3350]?.apply {
        south = hallways[3340]
        north = hallways[3980]
    }

    hallways[3360]?.apply {
        south = hallways[3370]
        north = hallways[3120]
    }

    hallways[3370]?.apply {
        north = hallways[3360]
        south = hallways[3380]
    }

    hallways[3380]?.apply {
        north = hallways[3370]
        south = hallways[3390]
    }

    hallways[3390]?.apply {
        north = hallways[3380]
        south = hallways[3530]
    }
    hallways[3400]?.apply {
        south = hallways[3410]
        north = hallways[3140]
    }

    hallways[3410]?.apply {
        north = hallways[3400]
        south = hallways[3420]
    }

    hallways[3420]?.apply {
        north = hallways[3410]
        south = hallways[3430]
    }

    hallways[3430]?.apply {
        north = hallways[3420]
        south = hallways[3540]
    }
    hallways[3440]?.apply {
        south = hallways[3450]
        north = hallways[3180]
    }

    hallways[3450]?.apply {
        north = hallways[3440]
        south = hallways[3590]
    }
    hallways[3460]?.apply {
        south = hallways[3470]
        north = hallways[3220]
    }

    hallways[3470]?.apply {
        north = hallways[3460]
        south = hallways[3480]
    }

    hallways[3480]?.apply {
        north = hallways[3470]
        south = hallways[3490]
    }

    hallways[3490]?.apply {
        north = hallways[3480]
        south = hallways[3640]
    }
    hallways[3500]?.apply {
        east = hallways[3510]
        west = hallways[3880]
    }

    hallways[3510]?.apply {
        west = hallways[3500]
        east = hallways[3520]
    }

    hallways[3520]?.apply {
        west = hallways[3510]
        east = hallways[3530]
    }

    hallways[3530]?.apply {
        west = hallways[3520]
        east = hallways[3540]
    }

    hallways[3540]?.apply {
        west = hallways[3530]
        east = hallways[3550]
    }

    hallways[3550]?.apply {
        west = hallways[3540]
        east = hallways[3560]
    }

    hallways[3560]?.apply {
        west = hallways[3550]
        east = hallways[3570]
    }

    hallways[3570]?.apply {
        west = hallways[3560]
        east = hallways[3580]
    }

    hallways[3580]?.apply {
        west = hallways[3570]
        east = hallways[3590]
    }

    hallways[3590]?.apply {
        west = hallways[3580]
        east = hallways[3600]
    }

    hallways[3600]?.apply {
        west = hallways[3590]
        east = hallways[3610]
    }

    hallways[3610]?.apply {
        west = hallways[3600]
        east = hallways[3620]
    }

    hallways[3620]?.apply {
        west = hallways[3610]
        east = hallways[3630]
    }

    hallways[3630]?.apply {
        west = hallways[3620]
        east = hallways[3640]
    }

    hallways[3640]?.apply {
        west = hallways[3630]
        north = hallways[3490]
        south = hallways[3650]
    }
    hallways[3650]?.apply {
        north = hallways[3640]
        south = hallways[3660]
    }

    hallways[3660]?.apply {
        north = hallways[3650]
        south = hallways[3670]
    }

    hallways[3670]?.apply {
        north = hallways[3660]
        south = hallways[3680]
    }

    hallways[3680]?.apply {
        north = hallways[3670]
        south = hallways[3690]
    }
    hallways[3690]?.apply {
        north = hallways[3680]
    }
    hallways[3700]?.apply {
        north = hallways[3500]
        south = hallways[3710]
    }
    hallways[3710]?.apply {
        north = hallways[3700]
        east = hallways[3720]
    }
    hallways[3720]?.apply {
        west = hallways[3710]
        east = hallways[3730]
    }

    hallways[3730]?.apply {
        west = hallways[3720]
        east = hallways[3740]
    }

    hallways[3740]?.apply {
        west = hallways[3730]
        east = hallways[3750]
    }

    hallways[3750]?.apply {
        west = hallways[3740]
        east = hallways[3760]
    }

    hallways[3760]?.apply {
        west = hallways[3750]
        east = hallways[3770]
    }

    hallways[3770]?.apply {
        west = hallways[3760]
        east = hallways[3780]
    }

    hallways[3780]?.apply {
        west = hallways[3770]
        north = hallways[3790]
    }
    hallways[3790]?.apply {
        south = hallways[3780]
        north = hallways[3550]
    }
    hallways[3800]?.apply {
        east = hallways[3810]
        south = hallways[3860]
    }

    hallways[3810]?.apply {
        west = hallways[3800]
        east = hallways[3820]
    }

    hallways[3820]?.apply {
        west = hallways[3810]
        east = hallways[3830]
    }

    hallways[3830]?.apply {
        west = hallways[3820]
        east = hallways[3840]
    }

    hallways[3840]?.apply {
        west = hallways[3830]
        east = hallways[3850]
    }

    hallways[3850]?.apply {
        west = hallways[3840]
        south = hallways[3880]
    }
    hallways[3860]?.apply {
        north = hallways[3800]
        east = hallways[3870]
    }
    hallways[3870]?.apply {
        east = hallways[3880]
        west = hallways[3860]
    }
    hallways[3880]?.apply {
        north = hallways[3850]
        west = hallways[3870]
        east = hallways[3500]
        south = hallways[3970]
    }
    hallways[3890]?.apply {
        north = hallways[3860]
        south = hallways[3900]
    }
    hallways[3900]?.apply {
        east = hallways[3910]
        north = hallways[3890]
    }

    hallways[3910]?.apply {
        west = hallways[3900]
        east = hallways[3920]
    }

    hallways[3920]?.apply {
        west = hallways[3910]
        east = hallways[3930]
    }

    hallways[3930]?.apply {
        west = hallways[3920]
        east = hallways[3940]
    }

    hallways[3940]?.apply {
        west = hallways[3930]
        east = hallways[3950]
    }

    hallways[3950]?.apply {
        west = hallways[3940]
        east = hallways[3960]
    }

    hallways[3960]?.apply {
        west = hallways[3950]
        north = hallways[3970]
    }
    hallways[3970]?.apply {
        north = hallways[3880]
        south = hallways[3960]
    }
    hallways[3980]?.apply {
        west = hallways[3990]
        south = hallways[3350]
    }
    hallways[3990]?.apply { // bridge
        east = hallways[3980]
    }
}

fun createClassroomToHallwayMap(hallways: Map<Int, HallwayNode>): Map<Int, List<Int>> {
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


