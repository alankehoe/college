	.data
x:	.double 10
y:	.double 1.2
z:	.double 1
a:	.double 0
b:	.double 0
err:	.double 0
dt:	.double 2
errcheck:	.double 0.0000001
mul:	.double .5

	.text

	l.d f0, x(r0)			; x value
	l.d f1, y(r0)			; y value
	l.d f2, z(r0)			; z value
	l.d f4, a(r0)			; a value
	l.d f5, b(r0)			; b value
	l.d f6, err(r0)			; err value will change
	l.d f7, dt(r0)			; for dividing by two use f15 instead
	l.d f8, errcheck(r0)		; error check value constant
	l.d f9, z(r0)			; comparing to 1
	l.d f10, a(r0)			; comparing to 0
	l.d f15, mul(r0)		; multiply by .5

while:
	c.eq.d f0, f9			;if x = 1 exit
	bc1t exit
	c.lt.d f10, f1			;if 0 < y exit
	bc1f exit
	c.le.d f9, f1			;if 1 <= y 
	bc1t if				;jmp if
	

else:
	add.d f4,f9,f0			;x = 1+x
	mul.d f4,f4,f15			;a = a/2
	j dowhile


if:
	sub.d f1,f1,f9			;y = y-1
	mul.d f2,f2,f0			;z = z*x
	;j while				;jmp back to while

	c.eq.d f0, f9			;if x = 1 exit
	bc1t exit
	c.lt.d f10, f1			;if 0 < y exit
	bc1f exit
	c.le.d f9, f1			;if 1 <= y 
	bc1t if				;jmp if
	bc1f else
	
	dowhile:
		add.d f5,f4,f10		;b = a + 0
		div.d f11,f0,f4		;f11 = x / a
		add.d f4,f4,f11		;a = a + f11
		add.d f20,f20,f20	;do nothing 3036 to 2211 raw stalls 
		mul.d f4,f4,f15		;a = a/2
		
		c.lt.d f5,f4		;b < a
		bc1f if2		;true jump if2
		bc1t else2		;false jump else2
	if2:
		sub.d f12,f4,f5		;f12 = a-b
		add.d f6,f12,f12
		;mul.d f6,f12,f15	;err = f12/a	err = f12*0.5 a is always 2
	else2:	
		sub.d f12,f5,f4		;f12 = b-a
		add.d f6,f12,f12
		;mul.d f6,f12,f15	;err = f12/a	err = f12*0.5 a is always 2

	c.lt.d f8,f6			;errcheck < err
	bc1t dowhile			;true jmp dowhile
	add.d f0,f4,f10			;x = a + 0
	mul.d f1,f1,f7			;y = y*2
	;j while				;jmp while

	c.eq.d f0, f9			;if x = 1 exit
	bc1t exit
	c.lt.d f10, f1			;if 0 < y exit
	bc1f exit
	c.le.d f9, f1			;if 1 <= y 
	bc1t if				;jmp if
	bc1f else
exit:	
	halt