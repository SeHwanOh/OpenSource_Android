package project.noticeworker.seoulnational

import project.noticeworker.soongsil.soongsilParser.*
import project.noticeworker.base.Depertment
import project.noticeworker.base.Major
import project.noticeworker.base.Organization
import project.noticeworker.seoulnational.snuParser.*

object SeoulNational : Organization() {
    val Depertments = ArrayList<Depertment>(
        listOf(
            Depertment("Humanities"),
            Depertment("Social"),
            Depertment("Science"),
            Depertment("Nursing"),
            Depertment("Cba"),
            Depertment("Engineer"),
            Depertment("cals"),
            Depertment("Art"),
            Depertment("edu"),
            Depertment("che"),
            Depertment("vet"),
            Depertment("snupharm"),
            Depertment("Music"),
            Depertment("Medicine")
        ))

    open fun getDeptList() : List<String>{
        return Depertments.map{t->t.DeptName}
    }
    open fun getMajorList(deptName : String) : List<String>? {
        for(department in Depertments){
            if(deptName == department.DeptName) {
                val tmp = department.majorList as ArrayList<Major>
                return tmp.map{ t -> t.kor }
            }
        }
        return null
    }

    fun loadMajor(deptName : String) {
        when (deptName) {
            "Human" -> {

            }
            "Social" -> {

            }
            "Science" -> {
                if(Depertments[2].getMajorCnt()==0) {
                    Depertments[2].addMajor(SNU_Math())
                    Depertments[2].addMajor(SNU_Physics())
                }
            }

        }

    }
}