;Kyle Wolf
;Homwork 2

;PROBLEM 1
(define(diff x expr)
	(cond((or (number? expr) (symbol? expr))
              (if(eq? expr x) 1 0))

             ((eq? (car expr) '+)
             (list '+ (diff x (cadr expr)) (diff x (caddr expr))))

             ((eq? (car expr) '-)
             (list '- (diff x (cadr expr)) (diff x (caddr expr))))

             ((eq? (car expr) '*)
             (list '+ (list '* (cadr expr) (diff x (caddr expr))) (list'* (caddr expr) (diff x (cadr expr)))))

             ((eq? (car expr) '/)
             (list '/ (list '- (list '* (caddr expr) (diff x (cadr expr))) (list '* (cadr expr) (diff x (caddr expr)))) (* (caddr expr) (caddr expr))))
        )
)




;PROBLEM 2
;Initialize map
(define init_map '())
;Get size of map
(define(get_size the_map)
                (get_size_helper the_map 0))
(define (get_size_helper the_map c)
  (if(null? the_map) c
     (get_size_helper (cdr the_map) (+ c 1))))

;Insert into map, with helper function to check if key is already in map
(define (is_in the_map key)
  (cond [(null? the_map) #f]
        [(= key (car(car the_map))) #t]
        [ else (is_in (cdr the_map) key)]))

(define (insert_map the_map key value)
  (if (not(is_in the_map key)) (cons (list key value) the_map)
  (error "duplicate keys in map")))

;Get value for key
(define (get_val the_map key)
  (cond [(null? the_map) (error "key not in map")]
  [(= key (car(car the_map))) (cdr (car the_map))]
  [ else (get_val (cdr the_map) key)]))

;Remove key from map
(define (remove_key the_map key)
  (remove_key_helper the_map the_map key))
(define (remove_key_helper temp_map full_map key)
  (cond [(null? temp_map) (error "key not in map")]
  [(= key (car(car temp_map))) (remove (car temp_map) full_map)]
  [ else (remove_key_helper (cdr temp_map) full_map key)]))







