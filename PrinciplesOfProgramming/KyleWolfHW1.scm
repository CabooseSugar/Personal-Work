KYLE WOLF 
HOMEWORK 1

;PROBLEM 1

(define (GCD u v)
	(if (= v 0) u
		(GCD v (modulo u v)))
)

;test case
(gcd 5 10)


;PROBLEM 2 --------------------------------------------------------

(define(powerWork a b temp)
	(cond 
		[(and (= b 0) (= temp 1)) 1]
		[(= b 0) temp]
		[else (powerWork a (- b 1) (* temp a))]
	)
)

(define (power a b)
	(powerWork a b 1)
)

;test case
(power 2 3)
	

;PROBLEM 3 --------------------------------------------------------

(define (C n k)
	(cond
		[(= k 0) 1]
		[(= k n) 1]
		[else (+(C (- n 1) (- k 1)) (C (- n 1) k))]
         )
)

;test case
(C 10 5)


;PROBLEM 4 --------------------------------------------------------

(define(extract L n)
  (if (= n 1) (car L) (extract (cdr L) (- n 1)))
)

;test case
(extract '(2 3 4 5 6 7 8 9) 4)


;PROBLEM 5 --------------------------------------------------------

(define (greatestWork L temp)
     (if (null? L) temp
         (if (< temp (car L))  
             (greatestWork (cdr L) (car L))
             (greatestWork (cdr L) temp)
          )     
       )
)

(define (greatest L)
	(greatestWork L (car L))
)

;test case
(greatest '(1 5 4 3 9 3 2)) 


;PROBLEM 6 --------------------------------------------------------

(define (inter L1 L2)
	(if (null? L1) '()
		(if (contains L2 (car L1))
          		(cons (car L1) (inter (cdr L1) L2))
          		(inter (cdr L1) L2)))
)

(define (contains list x)
    (cond 
        ((null? list) #f)
        ((eq? (car list) x) #t)
        (else (contains (cdr list) x)))
)

;test case
(inter '(1 2 3 4 5 6) '(3 5 6 12)) 


;PROBLEM 7 --------------------------------------------------------

(define (lenWork L temp)
	(if (null? L) temp 
	(lenWork(cdr L) (+ temp 1)))
)

(define (len L)
	(lenWork L 0)
)

;test case
(len '(1 2 3 4 5 6 7))


;PROBLEM 8 --------------------------------------------------------

(define (twice func)
  (lambda (param) (func (func param)))
)

;test case
(define (square a)
  (* a a)
)

((twice square) 4)






