package com.kerwin.game

class ArrangementDemo {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val array = mutableListOf(1, 3, 4, 5, 2)

            val result = mutableListOf<List<Int>>()
            arrangement(0, array.size - 1, array, result)

            result.forEach {
                println(it)
            }
        }

        fun arrangement(begin : Int, end : Int, arr : MutableList<Int>, result : MutableList<List<Int>>) {
            if (begin == end) {
                return
            }
            val start = begin + 1
            for (i in start until end) {
                swap(begin, i, arr)
                result.add(arr.toList())
                swap(i, begin, arr)
            }
            arrangement(start, end, arr, result)
        }

        private fun swap(index : Int, replace : Int, arr : MutableList<Int>) {
            val tmp = arr[index]
            arr[index] = arr[replace]
            arr[replace] = tmp
        }
    }
}