;
; Calculate the dot product of two vectors
; d = x[0]*y[0]+x[1]*y[1]+.....x[9]*y[9]
;
; accumulate dot product in f0. Assume f0 is initially 0
;
; cycles=111
;


        .data
x:      .double 1,  2, 3, 4,  5,  6,  7,  8,  9,  10
y:      .double 2,  4, 6, 8, 10, 12, 14, 16, 18,  20
d:      .double 0.0
        .text
        dadd  r1,r0,r0    ; r1 = i



foo:    l.d   f1,x(r1)    ; get x[i]
        l.d   f2,y(r1)    ; get y[i]
	daddi r1,r1,8     ; increment i
	l.d   f4,x(r1)    ; get x[i]
        l.d   f5,y(r1)    ; get y[i]
	daddi r1,r1,8     ; increment i
	l.d   f7,x(r1)    ; get x[i]
        l.d   f8,y(r1)    ; get y[i]
	daddi r1,r1,8     ; increment i
	l.d   f10,x(r1)    ; get x[i]
        l.d   f11,y(r1)    ; get y[i]
	daddi r1,r1,8     ; increment i
	l.d   f13,x(r1)    ; get x[i]
        l.d   f14,y(r1)    ; get y[i]
	daddi r1,r1,8     ; increment i



        mul.d f3,f1,f2    ; calculate x[i]*y[i]
	mul.d f6,f4,f5    ; calculate x[i]*y[i]
	mul.d f9,f7,f8    ; calculate x[i]*y[i]
	mul.d f12,f10,f11    ; calculate x[i]*y[i]
	mul.d f15,f13,f14    ; calculate x[i]*y[i]



        add.d f0,f0,f3    ; add in to f0
	add.d f0,f0,f6    ; add in to f0
	add.d f0,f0,f9    ; add in to f0
	add.d f0,f0,f12    ; add in to f0
	add.d f0,f0,f15    ; add in to f0



    
        slti  r3,r1,80    ; check for finished the loop
        bnez  r3,foo
        s.d   f0,d(r0)    ; store dot product
        halt