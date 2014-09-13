	.data
a:	.double 6
b:	.double 2
one:	.double 1
zero:	.double 0

	.text
	
	l.d f1,a(r0)
	l.d f2,b(r0)
	l.d f3,b(r0)
	l.d f4,zero(r0)
	l.d f5,zero(r0)
start:

while:
	c.eq.d f2,f4
	bc1t exit
	c.eq.d f5,f1
	bc1t exit
	
	add.d f5,f2,f2
	add.d f3,f3,f3
	j while
exit:
	halt
