package main

import (
	"fmt"
	"math/rand"
	"sort"
	"time"
)

func main() {
	rand.Seed(time.Now().UnixNano())
	var totalLinearSum int = 0
	var totalBinarySum int = 0

	for n:= 0; n < 100; n++ {
		var temp [100]int
		for i := 0; i < 100; i++ {
			min := 1
			max := 1000
			temp[i] = rand.Intn(max-min+1) + min
		}
		sort.Ints(temp[:])
		List := temp


		min := 0
		max := 99
		var x int = List[rand.Intn(max-min+1)+min]

		totalLinearSum += linearSearch(List, x, 1)
		totalBinarySum += binarySearch(List, x, 1)
	}

	linearAverage := float32(totalLinearSum) / float32(100)
	binaryAverage := float32(totalBinarySum)/ float32(100)

	fmt.Println(linearAverage);
	fmt.Println(binaryAverage);

}

func linearSearchOrig(list [100]int, x int) int {
	for i := 0; i < 100; i++ {
		if x == list[i] {
			return i
		}
	}
	return -1
}

func linearSearch(list [100]int, x int, count int) int {
	for i := 0; i < 100; i++ {
		if x == list[i] {
			return count
		}
		count++

	}
	return count
}

func binarySearchOrig(list [100]int, x int) int {
	start := 0
	end := len(list) - 1

	for start <= end{
		mid := (start + end) / 2
		if list[mid] < x {
			start = mid + 1
		}else if list[mid] > x{
			end = mid - 1
		} else {
			return mid;
		}
	}

	if start == len(list) || list[start] != x {
		return -1
	}
	return start
}

func binarySearch(list [100]int, x int, count int) int {
	start := 0
	end := len(list) - 1

	for start <= end{
		mid := (start + end) / 2
		if list[mid] < x {
			start = mid + 1
		}else if list[mid] > x{
			end = mid - 1
		} else {
			return count;
		}
		count++;
	}

	if start == len(list) || list[start] != x {
		return count
	}
	return count
}